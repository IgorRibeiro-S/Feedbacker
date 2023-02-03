<template>
  <div
  @click="handleToggle"
  class="flex flex-col bg-gray-200 rounded px-8 py-6 cursor-pointer ">
  <div
    class="flex justify-between items-center w-full mb-8">
    <BadgeFeedback :type="feedback.type"/>
  <span class="font-regular text-brand-graydark">
    {{ feedback.createdAt }}
  </span>
  <h1>Lorem ipsum dolor sit amet consectetur adipisicing elit. Placeat, eligendi? Praesentium distinctio nam facilis odio architecto voluptatum! Dolorem expedita similique provident, suscipit quam, doloribus exercitationem repellat in fugiat ipsa modi.</h1>
  </div>
  </div>
</template>

<script>
import BadgeFeedback from './BadgeFeedback'
export default {
  props: {
    feedback: { type: Object, require: true }
  },
  components: {
    BadgeFeedback
  },

  setup () {
    function handleToggle () {

    }
    return {
      handleToggle
    }
  }
}
</script>
