<template>
  <div
  @click="handleToggle"
  class="flex flex-col bg-gray-200 rounded-lg px-8 py-6 cursor-pointer ">
  <div
    class="flex justify-between items-center w-full mb-8">
    <BadgeFeedback :type="feedback.type"/>
    <span class="font-regular text-brand-graydark">
    {{ getDiffTimeBetweenCurrentDate(feedback.createdAt) }}
    </span>
  </div>
  <div
    class="text-lg text-gray-800 font-regular">
    {{ feedback.text }}
  </div>
  <div
    :class="{animate__fadeOutUp: state.isClosing
    }"
    class="flex mt-8 animate__animated animate__fadeInDown animate__faster"
    v-if="state.isOpen"
  >
      <div class="flex flex-col w-1/2">
        <div class="flex flex-col mb-3">
          <span class="font-bold text-gray-400 uppercase select-none">Página</span>
          <span class="font-medium text-gray-700">{{ feedback.page }}</span>
        </div>
        <div class="flex flex-col">
          <span class="font-bold text-gray-400 uppercase select-none">Dispositivo</span>
          <span class="font-medium text-gray-700">{{ feedback.device }}</span>
        </div>
      </div>

      <div class="flex flex-col w-1/2">
        <div class="flex flex-col">
          <span class="font-bold text-gray-400 uppercase select-none">Usuário</span>
          <span class="font-medium text-gray-700">{{ feedback.fingerprint }}</span>
        </div>
      </div>
    </div>
    <div class="flex justify-end mt-8" v-if="!state.isOpen">
      <span>
        <svg
          width="24"
          height="24"
          viewBox="0 0 17 10"
          fill="none"
          xmlns="http://www.w3.org/2000/svg">
          <path d="M1.9975 0L8.5 6.18084L15.0025 0L17 1.90283L8.5 10L0 1.90283L1.9975 0Z" fill="#7E7E7E"/>
        </svg>
      </span>
    </div>
  </div>
</template>

<script>
import BadgeFeedback from './BadgeFeedback'
import { getDiffTimeBetweenCurrentDate } from '../../utils/date'
import { reactive } from '@vue/reactivity'
import { wait } from '../../utils/timeout'
export default {
  props: {
    isOpened: { type: Boolean, default: false },
    feedback: { type: Object, require: true }
  },
  components: {
    BadgeFeedback
  },

  setup (props) {
    const state = reactive({
      isOpen: props.isOpened,
      isClosing: !props.isOpened
    })
    async function handleToggle () {
      state.isClosing = true
      await wait(250)
      state.isOpen = !state.isOpen
      state.isClosing = false
    }
    return {
      handleToggle,
      getDiffTimeBetweenCurrentDate,
      state
    }
  }
}
</script>
