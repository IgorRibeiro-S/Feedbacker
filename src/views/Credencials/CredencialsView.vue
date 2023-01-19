<template>
    <div class="flex justify-center bg-brand-main w-full h-28">
        <CredencialHeader/>
    </div>
    <div class="flex flex-col items-center bg-brand-gray py-16">
        <h1 class="text-gray-800 font-black text-center text-4xl">
            Credenciais
        </h1>
        <p class="text-gray-800 font-medium text-center text-lg">
            Guia de instalação e geração de suas credenciais
        </p>
    </div>
    <div class="flex justify-center h-full w-full">
        <div class="flex flex-col w-4/5 max-w-6xl py-10">
            <h1 class="text-brand-gray-800 font-black text-4xl">
                Instalação e configuração
            </h1>
            <p class="mt-10 font-regular text-lg text-gray-800 ">
                Este aqui é a sua chave de api
            </p>
            <content-loader
            v-if="store.Global.isLoading || state.isLoading"
            class="rounded"
            width="600px"
            height="50px"
            />
            <div
             v-else
             class="flex py-3 pl-5 mt-2 justify-beteween items-center bg-brand-gray rounded-md w-full lg:w-1/2">
                <span>
                    {{ store.User.currentUser.apiKey }}
                </span>
                <div class="flex ml-28 mr-5">
                  <span>
                  <svg
                @click="handleCopy()" class="cursor-pointer"
                width="28" height="28"
                viewBox="0 0 19 22"
                fill="none"
                xmlns="http://www.w3.org/2000/svg">
                <path
                d="M14 0H2C0.9 0 0 0.9 0 2V16H2V2H14V0ZM13 4L19 10V20C19 21.1 18.1 22 17 22H5.99C4.89 22 4 21.1 4 20L4.01 6C4.01 4.9 4.9 4 6 4H13ZM12 11H17.5L12 5.5V11Z"
                fill="#A9A9A9"/>
                </svg>
                </span>
                <span>
                  <svg class="ml-4 cursor-pointer"
                  width="28"
                  height="28"
                  viewBox="0 0 17 23"
                  fill="none" xmlns="http://www.w3.org/2000/svg">
                  <path
                  d="M8.5 5.22727V8.36364L12.75 4.18182L8.5 0V3.13636C3.80375 3.13636 0 6.87909 0 11.5C0 13.1414 0.48875 14.6677 1.3175 15.9536L2.86875 14.4273C2.39062 13.5595 2.125 12.5559 2.125 11.5C2.125 8.03955 4.98313 5.22727 8.5 5.22727ZM15.6825 7.04636L14.1312 8.57273C14.5987 9.45091 14.875 10.4441 14.875 11.5C14.875 14.9605 12.0169 17.7727 8.5 17.7727V14.6364L4.25 18.8182L8.5 23V19.8636C13.1962 19.8636 17 16.1209 17 11.5C17 9.85864 16.5112 8.33227 15.6825 7.04636Z"
                  fill="#A9A9A9"/>
                  </svg>
                </span>
                </div>
            </div>
            <p class="mt-5 font-regular text-lg text-gray-800">
              Coloque o script abaixo no seu site para começar a receber feedbacks
            </p>
            <content-loader
            v-if="store.Global.isLoading || state.isLoading"
            class="rounded"
            width="600px"
            height="50px"
            />
            <div
            v-else
            class="flex py-3 pl-5 pr-20 mt-2 bg-brand-gray rounded-md w-full lg:w-2/3">
              <div class="overflow-x-scroll">
              <pre>&lt;script src="https://igorribeiro-s-feedbacker-widget.netlify.app?api_key={{ store.User.currentUser.apiKey }}"&gt;&lt;script&gt;</pre>
            </div>
            <span>
              <svg
                @click="handleCopy()" class="ml-20 mr-5 cursor-pointer"
                width="28" height="28"
                viewBox="0 0 19 22"
                fill="none"
                xmlns="http://www.w3.org/2000/svg">
                <path
                d="M14 0H2C0.9 0 0 0.9 0 2V16H2V2H14V0ZM13 4L19 10V20C19 21.1 18.1 22 17 22H5.99C4.89 22 4 21.1 4 20L4.01 6C4.01 4.9 4.9 4 6 4H13ZM12 11H17.5L12 5.5V11Z"
                fill="#A9A9A9"/>
                </svg>
            </span>
            </div>
        </div>
    </div>
</template>
<script>
import CredencialHeader from './CredencialHeader.vue'
import ContentLoader from '../../components/ContentLoader/ContentLoad.vue'
import { useToast } from 'vue-toastification'
import useStore from '../../hooks/userStore'
import { reactive } from '@vue/reactivity'
export default {
  components: {
    CredencialHeader,
    ContentLoader
  },
  setup () {
    const toast = useToast()
    const store = useStore()
    const state = reactive({
      isLoading: false
    })
    async function handleCopy () {
      toast.clear()
      try {
        await navigator.clipboard.writeText(store.User.currentUser.apiKey)
        toast.success('Copiado!')
      } catch (error) {
        console.log(error)
      }
    }

    return {
      handleCopy,
      store,
      state
    }
  }
}
</script>
