<template>
  
</template>

<script>
import { reactive } from 'vue'
import feedbacks from '../../services/feedbacks'
import userStore from '../../hooks/userStore'

const LABELS = {
  all: 'Todos',
  issue: 'Problemas',
  idea: 'Ideias',
  other: 'Outros'
}

const COLORS = {
  all: 'brand-info',
  issue: 'brand-danger',
  idea: 'brand-warn',
  other: 'brand-graydark'
}
export default {
  setup () {
    const store = userStore('Global')
    const state = reactive({
        hasErrors: false,
        filters: [{
            label: null,
            amount: null
    }]
})
  try {
    const { data } = feedbacks.getSumary()
  } catch (error) {
      state.hasErrors = !!error
  }}
}
</script>
