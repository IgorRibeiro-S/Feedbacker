import { reactive } from 'vue'

const state = reactive({
    currentUser: {}
})

export function setCurrentUser(user){
    state.currentUser = user
}