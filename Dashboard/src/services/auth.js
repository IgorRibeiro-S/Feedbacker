export default httpClient => ({
  register: async ({ name, email, password, roles }) => {
    const response = await httpClient.post('/auth/register', {
      name,
      email,
      password,
      roles
    })
    let errors = null
    if (!response.data) {
      errors = {
        status: response.request.status,
        statusText: response.request.statusText
      }
    }
    return {
      data: response.data,
      errors
    }
  },
  login: async ({ name, senha }) => {
    const response = await httpClient.post('/auth/login', {
      name,
      senha
    })
    let errors = null
    if (!response.data) {
      errors = {
        status: response.request.status,
        statusText: response.request.statusText
      }
    }
    return {
      data: response.data,
      errors
    }
  }
})
