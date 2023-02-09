<template>
  <div class="box animate__animated animate_fadeInUp animate__faster">

  </div>
</template>
<script lang="ts">
import { defineComponent, computed, ComputedRef, SetupContext } from 'vue'
// eslint-disable-next-line
// @ts-ignore
import { brand } from '@/../palette'
import useStore from '../../hooks/store'

interface SetupReturn {
  emit: SetupContext['emit'];
  canGoBack: ComputedRef<boolean>;
  label: ComputedRef<string>;
  canShowAdditionalControlAndInfo: ComputedRef<boolean>;
  brandColors: Record<string, string>;
}

export default defineComponent({
  emit: ['close-box'],
  setup (_, { emit }: SetupContext) : SetupReturn {
    const store = useStore()

    const label = computed<string>(() => {
      if (store.feedbackType === 'ISSUE') {
        return 'Reporte um problema'
      }
      if (store.feedbackType === 'IDEA') {
        return 'Nos fale a sua ideia'
      }
      if (store.feedbackType === 'OTHER') {
        return 'Abra sua mente'
      }

      return 'O que você tem em mente'
    })
    const canGoBack = computed<boolean>(() => {
      return store.currentComponent === 'SelectFeedbackType'
    })
    const canShowAdditionalControlAndInfo = computed<boolean>(() => {
      return store.currentComponent !== 'Sucess' && store.currentComponent !== 'Error'
    })
    return {
      emit,
      canGoBack,
      brandColors: brand,
      canShowAdditionalControlAndInfo,
      label
    }
  }
})
</script>
<style lang="postcss" scoped>
.box {
  @apply fixed z-50 bottom-0 right-0 mb-5 mr-5 bg-white rounded-xl py-5 px-5 flex items-center shadow-xl select-none hover:bg-deeppink-400 flex-col;
  width: 400px;
}
</style>
