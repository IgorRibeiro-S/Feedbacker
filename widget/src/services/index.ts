import axios from 'axios'
import FeedbacksService from './feedbacks'

const API_ENVS = {
  production: '',
  development: '',
  local: 'https://feedbacker.herokuapp.com'
}

const httpClient = axios.create({
  // eslint-disable-next-line
  // @ts-ignore
  baseURL: API_ENVS[process.env.NODE_ENV] || API_ENVS.local
})

httpClient.interceptors.response.use((response) => {
  return response
}, (error) => {
  const canThrowAnError = error.request.status === 0 ||
  error.request.status === 500

  if (canThrowAnError) {
    throw new Error(error.message)
  }
  return error
})
export default {
  feedbacks: FeedbacksService(httpClient)
}
