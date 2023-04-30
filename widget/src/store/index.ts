import { reactive, readonly } from 'vue'

export type StoreState = {
  currentComponent: string,
  feedbackType: string,
  message: string,
  apiKey: string,
  fingerprint: string,
  currentPage: string,
  idUser: string,
  user: {
    id: string
  }
}

const initialState: StoreState = {
  currentComponent: 'SelectFeedbackType',
  feedbackType: '',
  message: '',
  apiKey: '',
  fingerprint: '',
  currentPage: '',
  idUser: '',
  user: {
    id: ''
  }
}

const state = reactive<StoreState>({
  ...initialState
})

export function setCurrentComponent (component: string): void {
  state.currentComponent = component
}

export function setFeedbackType (feedback: string): void {
  state.feedbackType = feedback
}

export function setMessage (message: string): void {
  state.message = message
}

export function setApiKey (api: string): void {
  state.apiKey = api
}

export function setIdUser (id: string): void {
  state.idUser = id
}

export function setUser (id: string): void {
  state.user = {
    id: id
  }
}

export function setFingerPrint (fingerprint: string): void {
  state.fingerprint = fingerprint
}

export function setCurrentPage (page: string): void {
  state.currentPage = page
}

export function resetStore (): void {
  setCurrentComponent(initialState.currentComponent)
  setMessage(initialState.message)
  setApiKey(initialState.apiKey)
  setCurrentPage(initialState.currentPage)
  setFeedbackType(initialState.feedbackType)
  setFingerPrint(initialState.fingerprint)
  setIdUser(initialState.idUser)
  setUser(initialState.user.id)
}

export default readonly(state)
