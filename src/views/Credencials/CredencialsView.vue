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
</template>
<script>
import CredencialHeader from './CredencialHeader.vue'

export default {
  components: {
    CredencialHeader
  }
}
</script>
