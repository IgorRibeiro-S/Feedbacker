import axios from 'axios'

const API_ENV = {
  production: '',
  local: 'https://backend-treinamento.vercel.app'
}

const httpClient = axios.create({
  baseURL: API_ENV.local
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

}
