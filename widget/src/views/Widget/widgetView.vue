<template>
  <teleport to="body">
    <component
      @open-box="handleOpenBox"
      @close-box="handleCloseBox"
      :is="state.component"
    />
  </teleport>
</template>

<script lang="ts">
import { defineComponent, reactive, watch } from 'vue'
import StandbyView from './StandbyView.vue'
import BoxView from './BoxView.vue'
import useIframeControl from '../../hooks/iframe'
import useStore from '../../hooks/store'
type State = {
  component: string;
}
interface SetupReturn {
  state: State;
  handleOpenBox(): void;
  handleCloseBox(): void;
}
export default defineComponent({
  components: { StandbyView, BoxView },
  setup (): SetupReturn {
    const store = useStore()
    const iframe = useIframeControl()
    const state = reactive<State>({
      component: 'StandbyView'
    })
    watch(() => store.currentComponent, () => {
      iframe.updateCoreValuesOnStore()
    })
    function handleOpenBox (): void {
      iframe.notifyOpen()
      state.component = 'BoxView'
    }
    function handleCloseBox (): void {
      iframe.notifyClose()
      state.component = 'StandbyView'
    }
    return {
      state,
      handleOpenBox,
      handleCloseBox
    }
  }
})
</script>
