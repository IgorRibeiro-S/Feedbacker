<template>
  <div class="flex justify-between">
    <h1 class="text-4xl font-black text-gray-800" > Entre na sua conta</h1>
    <button @click="close" class="text-4xl text-gray-600">
      &times;
    </button>
  </div>

  <div class="mt-16">
    <form @submit.prevent= "handleSubmit">
      <label class="block">
        <span class="text-lg font-medium text-gray-800">E-mail</span>
        <input
         v-model= "state.email.value"
         placeholder="email@example.com"
         :class="{'border-brand-danger': !!state.email.errorMessage}"
         class="block px-6 py-3 mt-1 text-lg bg-gray-100 border-2 border-transparent rounded"
         type="email">
        <span
          class="block font-medium text-brand-danger"
          v-if= "!!state.email.errorMessage">
          {{ state.email.errorMessage }}
        </span>
      </label>

      <label class="block" >
      <span class="text-lg font-medium text-gray-800">Senha</span>
        <input
         v-model= "state.password.value"
         placeholder="Senha"
         :class="{'border-brand-danger': !!state.password.errorMessage}"
         class="block px-6 py-2 mt-1 text-lg bg-gray-100 border-2 border-transparent rounded "
         type="password">
        <span
          v-if= "!!state.password.errorMessage"
          class="block font-medium text-brand-danger">
          {{ state.password.errorMessage }}
        </span>
      </label>
    <button
      :disabled="state.isLoading"
      type="submit"
      :class="{
        'opacity-50': state.isLoading
      }"
      class="mt-10 px-14 py-2 text-2xl text-center text-white font-bold bg-brand-main rounded-full focus:outline-none transction-all duration-150"
    >Entrar

    </button>

    </form>
  </div>
</template>

<script>
import { reactive } from '@vue/reactivity'
import useModal from '../../hooks/useModal'
import { useField } from 'vee-validate'
import { validateEmptyAndLength3, validateEmptyAndEmail } from '../../utils/validate'

export default {
  setup () {
    const modal = useModal()

    const {
      value: emailValue,
      errorMessage: emailErrorMessage
    } = useField('email', validateEmptyAndEmail)
    const {
      value: passwordValue,
      errorMessage: passwordErrorMessage
    } = useField('password', validateEmptyAndLength3)
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

    function handleSubmit () {
      alert('Entrou')
    }

    return {
      state,
      close: modal.close,
      handleSubmit
    }
  }
}
</script>
