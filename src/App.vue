<template>
<div>
  <modal-factory/>
  <router-view/>
</div>
</template>
<script>
import ModalFactory from './components/ModalFactory/ModalFactory.vue'

export default {
  components: { ModalFactory }
}
</script>
