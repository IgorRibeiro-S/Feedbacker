<template>
  <div
  @click="handleToggle"
  class="flex flex-col bg-gray-200 rounded-lg px-8 py-6 cursor-pointer ">
  <div
    class="flex justify-between items-center w-full mb-8">
    <BadgeFeedback :type="feedback.type"/>
  <span class="font-regular text-brand-graydark">
    {{ feedback.createdAt }}
  </span>
  </div>
  <div class="text-lg text-gray-800 font-regular">
    {{ feedback.text }}
    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Laboriosam ex eos deserunt sit, fuga eum animi accusamus corrupti possimus maxime in suscipit repellat officia. Aliquid odio eum perferendis neque sapiente?</p>
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
