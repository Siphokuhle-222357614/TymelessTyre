import api from './apiClient'

export const fetchProducts = (params = {}) => {
  // params: { type: 'rims'|'tyres', page, size, q }
  return api.get('/products', { params })
}

export const fetchProduct = (id) => api.get(`/products/${id}`)

export const fetchReviews = (productId) => api.get(`/products/${productId}/reviews`)

export const postReview = (productId, data) => api.post(`/products/${productId}/reviews`, data)
