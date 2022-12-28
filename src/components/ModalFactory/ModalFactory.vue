<template>
  <teleport to="body">
    <div v-if="state.isActive" class="fixed top-0 left-0 z-50 flex items-center justify-center w-full h-full bg-black bg-opacity-50" @click="handleModalToogle({ status: false})">
        <div class="mt-10 fixed">
            <div class="flex flex-col overflow-hidden bg-white rounded-lg animate__animated animate__fadeInDown animate__faster">
                <div class="flex flex-col px-12 py-10 bg-white">
                    <component :is="state.component"/>
                </div>
            </div>
        </div>
    </div>

    </teleport>
</template>

<script>
import { reactive } from '@vue/reactivity'

const DEFAULT_WIDTH = 'w-3/4 lg:w-1/3'
export default {
    data () {
        const state = reactive({
            isActive: false,
            component: {},
            props: {},
            widht: DEFAULT_WIDTH
        })

        function handleModalToogle ({ status }) {

        }
    }
}
</script>

<style>

</style>