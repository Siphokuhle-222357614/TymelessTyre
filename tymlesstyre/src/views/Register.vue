<template>
  <div class="auth">
    <h1>Register</h1>
    <form @submit.prevent="register">
      <input v-model="name" type="text" placeholder="Full Name" required />
      <input v-model="email" type="email" placeholder="Email" required />
      <input v-model="password" type="password" placeholder="Password" required />
      <button type="submit">Register</button>
    </form>
    <p>Already have an account? <router-link to="/login">Login here</router-link></p>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'

const name = ref('')
const email = ref('')
const password = ref('')
const router = useRouter()

async function register() {
  try {
    // 🔗 BACKEND INTEGRATION: Create new user
    // Example: POST http://localhost:8080/api/auth/register
    // Body: { name, email, password }
    // Returns: { id, name, email }

    // const response = await fetch('http://localhost:8080/api/auth/register', {
    //   method: 'POST',
    //   headers: { 'Content-Type': 'application/json' },
    //   body: JSON.stringify({ name: name.value, email: email.value, password: password.value })
    // })
    // if (!response.ok) throw new Error('Registration failed')
    // const data = await response.json()

    alert('Registration successful (backend integration needed)')
    router.push('/login') // redirect to login page
  } catch (error) {
    alert('Failed to register user')
  }
}
</script>

<style scoped>
.auth {
  max-width: 400px;
  margin: 3rem auto;
  padding: 2rem;
  background: #f9f9f9;
  border-radius: 8px;
  box-shadow: 0 4px 10px rgba(0,0,0,0.1);
  text-align: center;
}
input {
  display: block;
  margin: 10px auto;
  padding: 10px;
  width: 100%;
}
button {
  margin-top: 1rem;
  background: #222;
  color: white;
  border: none;
  padding: 10px 15px;
  border-radius: 5px;
  cursor: pointer;
}
button:hover {
  background: #f5c518;
  color: black;
}
</style>
