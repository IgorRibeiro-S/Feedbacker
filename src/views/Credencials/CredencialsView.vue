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
            <div class="flex py-3 pl-5 pr-20 mt-2 bg-brand-gray rounded-md w-1/2">
                <span id="apikey" >
                    7a286812-946f-4766-947f-36611f29dc7b
                </span>
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
            <p class="mt-5 font-regular text-lg text-gray-800">
              Coloque o script abaixo no seu site para começar a receber feedbacks
            </p>
            <div class="flex py-3 pl-5 pr-20 mt-2 bg-brand-gray rounded-md w-2/3">
              <div class="overflow-x-scroll">
              <pre>&lt;script src="https://igorribeiro-s-feedbacker-widget.netlify.app?api_key=7a286812-946f-4766-947f-36611f29dc7b"&gt;&lt;script&gt;</pre>
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
import { useToast } from 'vue-toastification'
export default {
  components: {
    CredencialHeader
  },
  setup () {
    const toast = useToast()
    async function handleCopy () {
      toast.clear()
      try {
        await navigator.clipboard.writeText(document.getElementById('apikey').innerHTML)
        toast.success('Copiado!')
      } catch (error) {
        console.log(error)
      }
    }

    return { handleCopy }
  }
}
</script>
