<template>
<div>
  <modal-factory/>
  <router-view/>
</div>
</template>
<script>
import ModalFactory from './components/ModalFactory/ModalFactory.vue'
import { useRouter, useRoute } from 'vue-router'
import { watch } from 'vue'
import services from './services'
import { setCurrentUser } from './store/users'

export default {
  components: { ModalFactory },
  setup () {
    const router = useRouter()
    const route = useRoute()

    watch(() => route.path, async () => {
      if (route.meta.hasAuth) {
        const token = window.localStorage.getItem('token')

        if (!token) {
          router.push({ name: 'Home' })
          return
        }
        const { data } = await services.users.getMe()
        setCurrentUser(data)
      }
    })
  }
}
</script>
