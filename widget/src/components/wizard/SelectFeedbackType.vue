<template>
  <div class="flex justify-between my-5 w-full">
    <button
    @click="() => handleSelect('ISSUE')"
    class="rounded-xl hover:bg-gray-200 bg-brand-gray flex flex-col justify-center items-center cursor-pointer p-3 w-28 focus:outline-none">
    <div class="w-12">
        <img class="w-full" src="../../assets/images/issue.png" alt="Problema">
    </div>
    <p class="font-medium mt-1 text-gray-800">
        Problema
    </p>
    </button>
      <button
    @click="() => handleSelect('IDEA')"
    class="rounded-xl hover:bg-gray-200 bg-brand-gray flex flex-col justify-center items-center cursor-pointer p-3 w-28 focus:outline-none">
    <div class="w-12">
        <img class="w-full" src="../../assets/images/lamp.png" alt="Ideia">
    </div>
    <p class="font-medium mt-1 text-gray-800">
        Ideia
    </p>
    </button>
      <button
    @click="() => handleSelect('OTHER')"
    class="rounded-xl hover:bg-gray-200 bg-brand-gray flex flex-col justify-center items-center cursor-pointer p-3 w-28 focus:outline-none">
    <div class="w-12">
        <img class="w-full" src="../../assets/images/fire.png" alt="Outro">
    </div>
    <p class="font-medium mt-1 text-gray-800">
        Outro
    </p>
    </button>
  </div>
</template>

<script lang="ts">
import { defineComponent, SetupContext } from '@vue/runtime-core'

interface SetupReturn {
  handleSelect(type: string): void;
}

export default defineComponent({
  setup (_, { emit }: SetupContext): SetupReturn {
    function handleSelect (type: string): void {
      emit('select-feedback-type', type)
      emit('next')
    }
    return {
      handleSelect
    }
  }
})
</script>
