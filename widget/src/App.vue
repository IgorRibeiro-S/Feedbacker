<template>
  <div class="w-full h-3/4 flex flex-col justify-center items-center bg-brand-main">
    <h1 class="text-6xl font-black text-white mb-3">Bem vindo ao Playground</h1>
    <h3 class="text-xl font-regular text-white">Este é o playgroud, use-o para testar o Widget</h3>
  </div>
    <div class="w-full h-3/4 flex flex-col justify-center items-center bg-brand-graydark">
    <h1 class="text-6xl font-black text-brand-gray mb-3">👌</h1>
  </div>
    <div class="w-full h-3/4 flex flex-col justify-center items-center bg-brand-main">
    <h1 class="text-6xl font-black text-brand-gray">🚀</h1>
  </div>
    <div class="w-full h-3/4 flex flex-col justify-center items-center bg-brand-graydark">
    <h1 class="text-6xl font-black text-brand-gray mb-3">👀</h1>
  </div>
  <widgetView/>
</template>
<script lang="ts">
import widgetView from './views/Widget/widgetView.vue'
export default {
  components: {
    widgetView
  }

}
</script>
