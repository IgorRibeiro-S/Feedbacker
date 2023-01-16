// import router from '../router'
import axios from 'axios'
import AuthService from './auth'
import UserService from './users'

const API_ENV = {
  production: '',
  local: 'http://localhost:3000'
}

const httpClient = axios.create({
  baseURL: API_ENV.local
})

httpClient.interceptors.request.use(config => {
  const token = window.localStorage.getItem('token')

  if (token) {
    config.headers.common.Authorization = `Bearer ${token}`
  }
  return config
})

httpClient.interceptors.response.use((response) => response, (error) => {
  const canThrowAnError = error.request.status === 0 ||
  error.request.status === 500

  if (canThrowAnError) {
    throw new Error(error.message)
  }
  if (error.response.status === 401) {
    console.log('erro token')
  }
  return error
})
export default {
  auth: AuthService(httpClient),
  users: UserService(httpClient)
}
