import api from './apiClient'

export const login = (payload) => api.post('/user/login', payload)
export const register = (payload) => api.post('/user/register', payload)
//export const me = () => api.get('/auth/me')
