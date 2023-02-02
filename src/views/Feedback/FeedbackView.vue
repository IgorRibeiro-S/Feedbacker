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
      <div class="w-4/5 max-w-6xl py-10 grid grid-col-2 gap-2">
      <div>
        <h1 class="font-black text-3xl text-brand-darkgray">
          Listagem
          </h1>
          <suspense>
          <template #default>
            <FiltersView
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
           <LoadingFeedback v-if="state.isLoading"/>
          <FeedbackCard
          v-else
          v-for="(feedback, index) in state.feedbacks"
          :key="feedback.id"
          :is-opened="index === 0"
          :feedback="feedback"
          class="mb-8"
          />
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
      feedbacks: ['text'],
      isLoading: false
    })
    return {
      state
    }
  }
}

</script>
