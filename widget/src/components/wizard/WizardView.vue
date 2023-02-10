<template>
    <component
    :is="store.currentComponent"
    @select-feedback-type="handleSelectFeedbackType"
    @next="next"
    />
</template>

<script lang="ts">
import { setFeedbackType, StoreState } from '@/store'
import SelectFeedbackType from './SelectFeedbackType.vue'
import WriteAFeedback from './WriteAFeedback.vue'
import { defineComponent } from '@vue/runtime-core'
import useStore from '../../hooks/store'
import useNavigation from '../../hooks/navigation'

interface SetupReturn {
  store: StoreState;
  next(): void;
  handleSelectFeedbackType(type: string): void;
}

export default defineComponent({
  components: {
    SelectFeedbackType,
    WriteAFeedback
  },
  setup (): SetupReturn {
    const store = useStore()
    const { next } = useNavigation()

    function handleSelectFeedbackType (type: string): void {
      setFeedbackType(type)
    }

    return {
      store,
      handleSelectFeedbackType,
      next
    }
  }
})
</script>
