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
    <div class="flex justify-center w-full pb-20">
      <div class="w-4/5 max-w-6xl py-10 grid grid-col-2 gap-2">
      <div>
        <h1 class="font-black text-3xl text-brand-darkgray">
          Listagem
          </h1>
          <suspense>
          <template #default>
            <FiltersView
              class="mt-8 animate__animated animate__fadeIn animate__faster"
            />
          </template>
          <template #fallback>
            <h3 class="mt-3 text-lg text-brand-darkgray font-medium">
              loading ...
            </h3>
          </template>
        </suspense>
      </div>
      <div class="px-10 pt-20 col-span-3"></div>
      </div>
    </div>
</template>
<script>
import CredencialHeader from '../Credencials/CredencialHeader.vue'
import FiltersView from './FiltersView.vue'

export default {
  components: {
    CredencialHeader,
    FiltersView
  },
  setup () {

  }
}

</script>
