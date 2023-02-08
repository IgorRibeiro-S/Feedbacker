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
import { defineComponent, reactive } from 'vue'
import Box from './BoxView.vue'
import StandbyView from './StandbyView.vue'

type State = {
    component: string;
}

type SetupReturn = {
    state: State;
    handleCloseBox(): void;
    handleOpenBox(): void;
}

export default defineComponent({
  components: {
    Box,
    StandbyView
  },
  setup (): SetupReturn {
    const state = reactive<State>({
      component: 'StandbyView'
    })

    function handleCloseBox (): void {
      state.component = 'StandbyView'
    }

    function handleOpenBox (): void {
      state.component = 'Box'
    }
    return {
      state,
      handleCloseBox,
      handleOpenBox
    }
  }

})
</script>
