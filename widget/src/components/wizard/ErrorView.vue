<template>
    <div
    class="flex flex-col items-center justify-between w-full my-5">
        <span>
           <svg
            width="60"
            height="60"
            viewBox="0 0 44 44" fill="none" xmlns="http://www.w3.org/2000/svg">
            <path d="M21.9999 0.333496C10.0399 0.333496 0.333252 10.0402 0.333252 22.0002C0.333252 33.9602 10.0399 43.6668 21.9999 43.6668C33.9599 43.6668 43.6666 33.9602 43.6666 22.0002C43.6666 10.0402 33.9599 0.333496 21.9999 0.333496ZM24.1666 32.8335H19.8333V28.5002H24.1666V32.8335ZM24.1666 24.1668H19.8333V11.1668H24.1666V24.1668Z" fill="#F88676"/>
            </svg>
        </span>
        <p class="text-center text-xl font-medium text-gray-800 w-full mt-2">
            Droga! Aconteceu algum erro.
        </p>
        <div class="flex justify-center mt-2 items-center w-full">
            <button @click="goBack" class="rounded-full font-regular text-sm flex flex-col justify-center bg-brand-gray items-center py-2 px-5 cursor-pointer focus:outline-none">
                Tente novamente
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
