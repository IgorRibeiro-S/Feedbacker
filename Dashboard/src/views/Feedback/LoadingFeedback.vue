<template>
  <content-load
  class="flex flex-col items-center rounded"
  width="100%"
  height="300px"
  >
    <content-load
    class="mt-3 rounded"
    width="90%"
    height="90px"
    animationDuration="2s"
    />
    <content-load
    class="mt-3 rounded"
    width="80%"
    height="50px"
    animationDuration="2.3s"
    />

    <content-load
    class="mt-3 rounded"
    width="80%"
    height="50px"
    animationDuration="2.7s"
    />

     <content-load
    class="mt-3 rounded"
    width="80%"
    height="50px"
    animationDuration="2.9s"
    />
  </content-load>
</template>

<script>
import ContentLoad from '../../components/ContentLoader/ContentLoad.vue'
export default {
  components: { ContentLoad }
}
</script>
