<template>
    <div class="flex justify-center bg-brand-main w-full h-28">
        <CredencialHeader/>
    </div>
    <div class="flex flex-col items-center bg-brand-gray py-16">
        <h1 class="text-gray-800 font-black text-center text-4xl">
            Feedbacks
        </h1>
        <p class="text-gray-800 font-medium text-center text-lg">
          Detalhes de todos os feedbacks recebidos.
        </p>
    </div>
</template>
<script>
import CredencialHeader from '../Credencials/CredencialHeader.vue'
// import services from '../../services/feedbacks'

export default {
  components: {
    CredencialHeader
  },
  setup () {

  }
}

</script>
