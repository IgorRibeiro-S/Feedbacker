const defaultPagination = {
  limit: 5,
  offset: 0
}

export default httpClient => ({
  getMe: async () => {
    const response = await httpClient.get('/user/me')
    return {
      data: response.data
    }
  },
  generateApiKey: async () => {
    const response = await httpClient.post('/user/me/apikey')
    return {
      data: response.data
    }
  },
  getAll: async ({ type, limit, offset } = defaultPagination) => {
    const query = { limit, offset }
    if (type) {
      query.type = type
      const response = await httpClient.get('/feedbacks/type', { params: query })
    }
    const response = await httpClient.get('/feedbacks')
    return {
      data: response.data
    }
  },
  getSumary: async () => {
    const response = await httpClient.get('/feedbacks/summary')
    return {
      data: response.data
    }
  }
})
