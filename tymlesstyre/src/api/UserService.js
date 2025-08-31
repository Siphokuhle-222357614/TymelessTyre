import apiClient from './apiClient';

class UserService {
  // No changes needed here, as the URLs are relative
  getAll() {
    return apiClient.get('/getAll');
  }

  read(id) {
    return apiClient.get(`/read/${id}`);
  }

  create(user) {
    return apiClient.post('/create', user);
  }

  update(user) {
    return apiClient.post('/update', user);
  }

  delete(id) {
    return apiClient.delete(`/delete/${id}`);
  }
}
export default new UserService();