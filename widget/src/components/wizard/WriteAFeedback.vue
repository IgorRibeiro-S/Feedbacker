<template>
  <div class="felx flex-col items-center justify-center w-full my-5">
    <textarea
      v-model="state.feedback"
      class="w-full rounded-lg border-2 border-gray-300 border-solid h-24 p-2 resize-none focus:outline-none">
    </textarea>
    <button
      :disabled="submitButtonIsDisabled"
      :class="{
        'opacity-50': state.isLoading,
        'opacity-50 bg-gray-100 text-gray-500': submitButtonIsDisabled,
        'bg-brand-main text-white': !submitButtonIsDisabled
      }"
      @click="submitAFeedback"
      class="
        rounded-lg font-black mt-3 flex flex-col
        justify-center items-center py-2 w-full cursor-pointer
        focus:outline-none transition-all duration-200
      ">
      <span v-if="state.isLoading">
        <svg
        width="8"
        height="11"
        viewBox="0 0 8 11"
        fill="none"
        xmlns="http://www.w3.org/2000/svg">
          <path d="M4 2.5V4L6 2L4 0V1.5C1.79 1.5 0 3.29 0 5.5C0 6.285 0.23 7.015 0.62 7.63L1.35 6.9C1.125 6.485 1 6.005 1 5.5C1 3.845 2.345 2.5 4 2.5ZM7.38 3.37L6.65 4.1C6.87 4.52 7 4.995 7 5.5C7 7.155 5.655 8.5 4 8.5V7L2 9L4 11V9.5C6.21 9.5 8 7.71 8 5.5C8 4.715 7.77 3.985 7.38 3.37Z" fill="white"/>
        </svg>
      </span>
      <template v-else>
        Enviar feedback
      </template>
    </button>
  </div>
</template>

<script lang="ts">
import { ComputedRef, computed, defineComponent, reactive } from 'vue'
import useNavigation from '../../hooks/navigation'
import { setMessage } from '../../store'
import useStore from '../../hooks/store'
import services from '../../services'

type Error = {
  error: Error
}
type State = {
  feedback: string;
  isLoading: boolean;
  hasError: Error | null;
}

interface SetupReturn {
  state: State;
  submitAFeedback(): Promise<void>;
  submitButtonIsDisabled: ComputedRef<boolean>;
}

export default defineComponent({
  setup (): SetupReturn {
    const store = useStore()
    const { setSuccessState, setErrorState } = useNavigation()
    const state = reactive<State>({
      feedback: '',
      isLoading: false,
      hasError: null
    })

    const submitButtonIsDisabled = computed<boolean>(() => {
      return !state.feedback.length
    })

    function handleError (error: Error) {
      state.hasError = error
      state.isLoading = false
      setErrorState()
    }

    async function submitAFeedback (): Promise<void> {
      setMessage(state.feedback)
      state.isLoading = true

      try {
        const response = await services.feedbacks.create({
          type: store.feedbackType,
          text: store.message,
          page: store.currentPage,
          apiKey: store.apiKey,
          device: window.navigator.userAgent,
          fingerprint: store.fingerprint,
          idUser: store.idUser,
          user: {
            id: store.idUser
          }
        })

        if (!response.errors) {
          setSuccessState()
        } else {
          setErrorState()
        }

        state.isLoading = false
      } catch (error) {
        // eslint-disable-next-line
        // @ts-ignore
        handleError(error)
      }
    }

    return {
      state,
      submitAFeedback,
      submitButtonIsDisabled
    }
  }
})
</script>
