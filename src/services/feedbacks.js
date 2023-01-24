export default httpClient => ({
    getAll: async ({ type, limit, offset } = defaultPagination) => {
      const query  = { limit, offset }
      if (type) {
        query.type = type
      }
      const response = await httpClient.get('/feedbacks', { params: query })
      return {
        data: response.data
      }
    },
  
    getSumary: async () => {
      const response = await httpClient.get('/feedbacks/sumary')
        return {
          data: response.data
      }
    }
  })
  const defaultPagination = {
    limit: 5,
    offset: 0
  }
  
  