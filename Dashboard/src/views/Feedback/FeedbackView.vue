<template>
    <div class="flex justify-center bg-brand-main w-full h-28">
        <CredencialHeader/>
    </div>
    <div class="flex flex-col items-center bg-brand-gray py-16">
        <h1 class="text-gray-800 font-black text-center text-4xl">
            Feedbacks
        </h1>
        <p class="text-gray-800 font-medium text-center text-lg">
          Detalhes de todos os feedbacks recebidos.
        </p>
    </div>
    <div class="flex justify-center w-full pb-20">
      <div class="w-4/5 max-w-6xl py-10 grid grid-cols-4 gap-2">
      <div>
        <h1 class="font-black text-3xl text-brand-darkgray">
          Listagem
          </h1>
          <suspense>
          <template #default>
            <FiltersView
              @select="ChangeFeedbackType"
              class="mt-8 animate__animated animate__fadeIn animate__faster"
            />
          </template>
          <template #fallback>
            <LoadingFeedback class="mt-8"/>
          </template>
        </suspense>
      </div>
      <div class="px-10 pt-20 col-span-3">
          <p
          v-if="state.hasError"
          class="text-lg text-center text-gray-800 font-regular">
          Ocorreu um erro ao carregar os feedbacks😥
          </p>
          <p
          v-if="!state.feedbacks.length && !state.isLoading"
          class="text-lg text-center text-gray-800 font-regular">
          Nenhum registro de feedback 😉
          </p>
           <LoadingFeedback v-if="state.isLoading || state.isLoadingFeedbacks"/>
          <FeedbackCard
          v-else
          v-for="(feedback, index) in state.feedbacks"
          :key="feedback.id"
          :is-opened="index === 0"
          :feedback="feedback"
          class="mb-8"
          />
          <LoadingFeedback v-if="state.isLoadingMoreFeedbacks"/>
      </div>
      </div>
    </div>
</template>
<script>
import { reactive } from '@vue/reactivity'
import CredencialHeader from '../Credencials/CredencialHeader.vue'
import FiltersView from './FiltersView.vue'
import LoadingFeedback from './LoadingFeedback.vue'
import FeedbackCard from './FeedbackCard'
import services from '../../services'
import { onMounted, onUnmounted } from '@vue/runtime-core'

export default {
  components: {
    CredencialHeader,
    FiltersView,
    LoadingFeedback,
    FeedbackCard
  },
  setup () {
    const state = reactive({
      hasError: false,
      feedbacks: [],
      currentFeedbackType: '',
      pagination: {
        limit: 5,
        offset: 0,
        total: 0
      },
      isLoading: false,
      isLoadingFeedbacks: false,
      isLoadingMoreFeedbacks: false
    })
    onMounted(() => {
      fecthFeedbacks()
      window.addEventListener('scroll', handleScroll, false)
    })

    onUnmounted(() => {
      window.removeEventListener('scroll', handleScroll, false)
    })

    async function ChangeFeedbackType (type) {
      try {
        state.isLoadingFeedbacks = true
        state.pagination.limit = 5
        state.pagination.offset = 0
        state.currentFeedbackType = type
        const { data } = await services.users.getAll({
          type: state.currentFeedbackType, ...state.pagination
        })
        state.feedbacks = data.results
        state.pagination = data.pagination
        state.isLoadingFeedbacks = false
      } catch (error) {
        handleErrors(error)
      }
    }
    function handleErrors (error) {
      state.isLoadingFeedbacks = false
      state.isLoading = false
      state.isLoadingMoreFeedbacks = false
      state.hasError = !!error
    }

    async function handleScroll () {
      const isBottomOfWindow = Math.ceil(
        document.documentElement.scrollTop + window.innerHeight
      ) >= document.documentElement.scrollHeight

      // eslint-disable-next-line
      if (state.isLoading || state.isLoadingMoreFeedbacks) return
      if (isBottomOfWindow) return
      // eslint-disable-next-line
      if (state.feedbacks.length >= state.pagination.total) return
      try {
        state.isLoadingMoreFeedbacks = true
        const { data } = await services.users.getAll({
          ...state.pagination,
          type: state.currentFeedbackType,
          offset: (state.pagination.offset + 5)
        })
        if (data.results.length) {
          state.feedbacks.push(...data.results)
        }

        state.isLoadingMoreFeedbacks = false
        state.pagination = data.pagination
      } catch (error) {
        state.isLoadingMoreFeedbacks = false
        handleErrors(error)
      }
    }
    async function fecthFeedbacks () {
      try {
        state.isLoading = true
        const { data } = await services.users.getAll({
          ...state.pagination,
          type: state.currentFeedbackType
        })

        state.feedbacks = data.results
        state.pagination = data.pagination
        state.isLoading = false
      } catch (error) {
        handleErrors(error)
      }
    }

    return {
      state,
      fecthFeedbacks,
      ChangeFeedbackType
    }
  }
}

</script>
