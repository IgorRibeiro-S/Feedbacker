<template>
    <div
    class="flex flex-col items-center justify-between w-full my-5">
        <span>
            <svg
            width="60"
            height="60"
            viewBox="0 0 43 43" fill="none" xmlns="http://www.w3.org/2000/svg">
            <path d="M21.5 0C9.632 0 0 9.632 0 21.5C0 33.368 9.632 43 21.5 43C33.368 43 43 33.368 43 21.5C43 9.632 33.368 0 21.5 0ZM17.2 32.25L6.45 21.5L9.4815 18.4685L17.2 26.1655L33.5185 9.847L36.55 12.9L17.2 32.25Z" fill="#63C3BE"/>
            </svg>
        </span>
        <p class="text-center text-xl font-medium text-gray-800 w-full mt-2">
            Obrigado! Recebemos o seu feedback.
        </p>
        <div class="flex justify-center mt-2 items-center w-full">
            <button @click="goBack" class="rounded-full font-regular text-sm flex flex-col justify-center bg-brand-gray items-center py-2 px-5 cursor-pointer focus:outline-none">
                Envie mais feedbacks
            </button>
        </div>
    </div>
</template>

<script lang ="ts">
import { defineComponent } from '@vue/runtime-core'
import { resetStore } from '../../store/index'

interface SetupReturn {
    goBack(): void;
}

export default defineComponent({
  setup (): SetupReturn {
    function goBack (): void {
      resetStore()
    }
    return {
      goBack
    }
  }
})
</script>
