<template>
  <header class="header">
    <div class="header-group">
      <div class="flex items-center justify-between py-10">
        <div class="w-28 lg:w-36">
          <img class="w-full" src="../../assets/logo_white.png" alt="logo">
        </div>
        <div class="flex">
          <button @click= "() => emit('create-account')" class="px-6 py-2 text-center text-white font-bold bg-brand-main rounded-full  focus:outline-none">Crie uma conta</button>
          <button @click= "() => emit('login')" class="px-6 py-2 text-center hover:bg-blue-50 text-brand-main font-bold bg-white rounded-full focus:outline-none">Entrar</button>
        </div>
        </div>
        <div class="flex flex-col mt-28 ">
          <h1 class="text-4xl text-white font-black">
            Tenha um feedback. <br>
            E faça seus clientes mais <br class="hidden lg:inline-block"> <!-- quebrar linha evitando estragar o layout em celular-->
            felizes!
          </h1>
          <p class="mt-2 text-white font-medium text-lg">
            Receba ideias, reclamações e feedbacks com um <br>
            simples widget na página.
          </p>
          <div>
            <button
            @click= "() => emit('create-account')"
            class="mt-10 px-6 py-2 text-center text-brand-main font-bold bg-white rounded-full focus:outline-none">Crie uma conta grátis</button>
          </div>
        </div>
    </div>
  </header>
</template>
<script>
export default {
  setup (_, { emit }) {
    return { emit }
  }
}
</script>

<style lang="postcss" scoped>
.header {
  @apply bg-brand-main w-full flex justify-center;
  height: 700px;
}
.header-group{
  @apply flex flex-col w-4/5 max-w-6xl;
}

@media (min-width: 640px){
  .header-group{
    background-image: url(../../assets/blue-baloon.png);
    background-size: 628px;
    background-position: 90% 100%;
    background-repeat: no-repeat;
  }
}
</style>
