<template>
  <header class="header">
    <div class="flex flex-col w-4/5 max-w-6xl my-16">
      <div class="flex justify-between py-10">
        <div class="w-28 lg:w-36">
          <img class="w-full" src="'@/assets/logo_white.png" alt="logo">
        </div>

      </div>

    </div>
  </header>
</template>
<script>
export default {
  data () {
  }
}
</script>

<style lang="postcss" scoped>
.header {
  @apply bg-brand-main w-full flex justify-center;
  height: 700px;
}
</style>
