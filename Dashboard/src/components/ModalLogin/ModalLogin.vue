<template>
  <div class="flex justify-between">
    <h1 class="text-4xl font-black text-gray-800">Entre na sua conta</h1>
    <button @click="close" class="text-4xl text-gray-600">&times;</button>
  </div>

  <div class="mt-16">
    <form @submit.prevent="handleSubmit">
      <label class="block">
        <span class="text-lg font-medium text-gray-800">E-mail</span>
        <input
          v-model="state.email.value"
          placeholder="email@example.com"
          :class="{ 'border-brand-danger': !!state.email.errorMessage }"
          class="block px-3 py-2 mt-1 text-lg bg-gray-100 border-2 border-transparent rounded"
          type="email"
        />
        <span
          class="block font-medium text-brand-danger"
          v-if="!!state.email.errorMessage"
        >
          {{ state.email.errorMessage }}
        </span>
      </label>

      <label class="block">
        <span class="text-lg font-medium text-gray-800">Senha</span>
        <input
          v-model="state.password.value"
          placeholder="Senha"
          :class="{ 'border-brand-danger': !!state.password.errorMessage }"
          class="block px-3 py-2 mt-1 text-lg bg-gray-100 border-2 border-transparent rounded"
          type="password"
        />
        <span
          v-if="!!state.password.errorMessage"
          class="block font-medium text-brand-danger"
        >
          {{ state.password.errorMessage }}
        </span>
      </label>
      <button
        :disabled="state.isLoading"
        type="submit"
        :class="{
          'opacity-50': state.isLoading,
        }"
        class="mt-10 px-14 py-2 text-2xl text-center text-white font-bold bg-brand-main rounded-full focus:outline-none transction-all duration-150"
      >
        <svg
          v-if="state.isLoading"
          class="motion-reduce:hidden animate-spin"
          width="22"
          height="30"
          viewBox="0 0 22 30"
          fill="none"
          xmlns="http://www.w3.org/2000/svg"
        >
          <path
            d="M11 6.81818V10.9091L16.5 5.45455L11 0V4.09091C4.9225 4.09091 0 8.97273 0 15C0 17.1409 0.6325 19.1318 1.705 20.8091L3.7125 18.8182C3.09375 17.6864 2.75 16.3773 2.75 15C2.75 10.4864 6.44875 6.81818 11 6.81818ZM20.295 9.19091L18.2875 11.1818C18.8925 12.3273 19.25 13.6227 19.25 15C19.25 19.5136 15.5512 23.1818 11 23.1818V19.0909L5.5 24.5455L11 30V25.9091C17.0775 25.9091 22 21.0273 22 15C22 12.8591 21.3675 10.8682 20.295 9.19091Z"
            fill="white"
          />
        </svg>
        <span v-else>Entrar</span>
      </button>
    </form>
  </div>
</template>

<script>
import { reactive } from '@vue/reactivity'
import useModal from '../../hooks/useModal'
import { useField } from 'vee-validate'
import {
  validateEmptyAndLength3,
  validateEmptyAndEmail
} from '../../utils/validators'
import services from '../../services/'
import { useRouter } from 'vue-router'
import { useToast } from 'vue-toastification'

export default {
  setup () {
    const modal = useModal()
    const router = useRouter()
    const toast = useToast()
    const { value: emailValue, errorMessage: emailErrorMessage } = useField(
      'email',
      validateEmptyAndEmail
    )
    const { value: passwordValue, errorMessage: passwordErrorMessage } =
      useField('password', validateEmptyAndLength3)
    const state = reactive({
      hasErrors: false,
      isLoading: false,
      email: {
        value: emailValue,
        errorMessage: emailErrorMessage
      },
      password: {
        value: passwordValue,
        errorMessage: passwordErrorMessage
      }
    })

    async function handleSubmit () {
      try {
        toast.clear()
        state.isLoading = true
        const { data, errors } = await services.auth.login({
          name: state.email.value,
          senha: state.password.value
        })

        if (!errors) {
          window.localStorage.setItem('token', data.token)
          state.isLoading = false
          toast.success('Login realizado com sucesso')
          router.push({ name: 'Feedback' })
          modal.close()
          return
        }
        if (errors.status === 404) {
          toast.error('E-mail não encontrado!')
        }
        if (errors.status === 403) {
          toast.error('E-mail não encontrado!')
        }
        if (errors.status === 401) {
          toast.error('E-mail/Senha inválidos!')
        }
        if (errors.status === 500) {
          toast.error('Erro inesperado! Aguarde um momento e tente novamente')
        }
        if (errors.status === 400) {
          toast.error('Ocorreu um erro ao fazer o Login')
        }

        state.isLoading = false
      } catch (error) {
        state.isLoading = false
        state.hasErrors = !!error
        toast.error('Ocorreu um erro ao fazer o Login')
      }
    }

    return {
      state,
      close: modal.close,
      handleSubmit
    }
  }
}
</script>
