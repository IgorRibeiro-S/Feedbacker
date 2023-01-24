<template>
  <div class="flex flex-col">
    <h1>
      Filtros
    </h1>
  </div>
</template>

<script>
import { reactive } from 'vue'
import services from '../../services'
// import userStore from '../../hooks/userStore'

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

function applyFiltersStructure (sumary) {
  return Object.keys(sumary).reduce((acc, cur) => {
    const currentFilter = {
      label: LABELS[cur],
      colors: COLORS[cur],
      amout: sumary[cur]
    }
    if (cur === 'all') {
      currentFilter.active = true
    } else {
      currentFilter.type = cur
    }

    return [...acc, currentFilter]
  }, [])
}

export default {
  async setup () {
    // const store = userStore('Global')
    const state = reactive({
      hasErrors: false,
      filters: [{
        label: null,
        amount: null
      }]
    })
    try {
      const { data } = await services.feedbacks.getSumary()
      state.filters = applyFiltersStructure(data)
    } catch (error) {
      state.hasErrors = !!error
      state.filters = applyFiltersStructure({ all: 0, issue: 0, ideia: 0, other: 0 })
    }

    function handleSelect ({ type }) {

    }
    return {
      state,
      handleSelect
    }
  }
}
</script>
