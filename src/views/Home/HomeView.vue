<template>
<div>
  <CustomHeader
  @create-account="handleAccountCreate"
  @login="handleLogin"
  />
  <ContactView />
  <div class="flex justify-center py-10 bg-brand-gray">
    <p class="font-medium text-center text-gray-800">
      Feedbacker &copy;2022 Copyright
    </p>
  </div>
</div>
</template>
<script>
import { onMounted } from 'vue'
import { useRouter } from 'vue-router'
import ContactView from './ContactView.vue'
import CustomHeader from './CustomHeader.vue'
import useModal from '../../hooks/useModal'

export default {
  components: {
    ContactView,
    CustomHeader
  },
  data () {
    const router = useRouter()
    const modal = useModal()
    onMounted(() => {
      const token = window.localStorage.getItem('token')
      if (token) {
        router.push({ name: 'Feedback' })
      }
    })

    function handleLogin () {
      modal.open({
        component: 'ModalLogin'
      })
    }
    function handleAccountCreate () {
      modal.open({
        component: 'ModalCreateAccount'
      })
    }

    return {
      handleLogin,
      handleAccountCreate
    }
  }
}
</script>
