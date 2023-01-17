<template>
        <div class="flex items-center justify-between w-4/5 max-w-6xl py-10">
            <div class="w-28 lg:w-36">
                <img class="w-full" src="../../assets/logo_white.png" alt="logo">
            </div>
            <div class="flex">
                <ul class="flex list-none">
                <li
                @click="() => router.push({ name: 'Credencials' })"
                class="px-2 py-2 mr-2 font-bold text-white rounded-full cursor-pointer focus:outline-none">
                    Credenciais
                </li>
                <li
                @click="() => router.push({ name: 'Feedback' })"
                class="px-2 py-2 mr-2 font-bold text-white rounded-full cursor-pointer focus:outline-none">
                    Feedbacks
                </li>
                <li
                @click="handleLogout()"
                class="px-2 py-2 mr-2 font-bold bg-white text-brand-main rounded-full cursor-pointer focus:outline-none">
                    {{ logoutLabel }}
                </li>
            </ul>
            </div>
        </div>
</template>

<script>
import { computed } from '@vue/runtime-core'
import { useRouter } from 'vue-router'
export default {
  setup () {
    const router = useRouter()
    const store = 'Igor Ribeiro'
    const logoutLabel = computed(() => {
      if (!store) {
        return '...'
      }
      return `${store} (sair)`
    })

    function handleLogout () {
      window.localStorage.removeItem('token')
      router.push({ name: 'Home' })
    }

    return {
      router,
      logoutLabel,
      handleLogout
    }
  }
}
</script>
