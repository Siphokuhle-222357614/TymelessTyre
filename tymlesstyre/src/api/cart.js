import api from './apiClient'

export const syncCart = (cartItems) => api.post('/cart/sync', { items: cartItems })
export const fetchCart = () => api.get('/cart')
