<template>
  <div class="profile">
    <h1>User Profile</h1>

    <div v-if="user">
      <p><strong>Name:</strong> {{ user.name }}</p>
      <p><strong>Email:</strong> {{ user.email }}</p>

      <h2>Update Info</h2>
      <form @submit.prevent="updateProfile">
        <input v-model="form.name" type="text" placeholder="Name" />
        <input v-model="form.email" type="email" placeholder="Email" />
        <button type="submit">Save Changes</button>
      </form>
    </div>

    <div v-else>
      <p>You are not logged in. Please <router-link to="/login">Login</router-link>.</p>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'

const user = ref(null)
const form = ref({ name: '', email: '' })

onMounted(() => {
  // 🔗 BACKEND INTEGRATION: Fetch logged-in user from backend API
  // Example: GET http://localhost:8080/api/users/me
  const stored = localStorage.getItem('user')
  if (stored) {
    user.value = JSON.parse(stored)
    form.value = { ...user.value }
  }
})

async function updateProfile() {
  try {
    // 🔗 BACKEND INTEGRATION: Call Spring Boot API to update user
    // Example: PUT http://localhost:8080/api/users/{id}
    // Send form.value as JSON
    // const response = await fetch(`http://localhost:8080/api/users/${user.value.id}`, {
    //   method: 'PUT',
    //   headers: { 'Content-Type': 'application/json' },
    //   body: JSON.stringify(form.value)
    // })
    // const updatedUser = await response.json()
    // user.value = updatedUser
    // localStorage.setItem('user', JSON.stringify(updatedUser))

    alert('Profile update function (backend integration needed)')
  } catch (error) {
    console.error(error)
  }
}
</script>

<style scoped>
.profile {
  max-width: 600px;
  margin: 2rem auto;
  padding: 2rem;
  border-radius: 10px;
  background: #f9f9f9;
  box-shadow: 0 4px 10px rgba(0,0,0,0.1);
}

h1 {
  margin-bottom: 1rem;
  color: #222;
}

input {
  display: block;
  margin: 10px 0;
  padding: 8px;
  width: 100%;
}

button {
  background: #222;
  color: white;
  border: none;
  padding: 10px 15px;
  cursor: pointer;
  border-radius: 5px;
}

button:hover {
  background: #f5c518;
  color: black;
}
</style>
