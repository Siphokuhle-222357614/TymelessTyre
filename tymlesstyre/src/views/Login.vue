<template>
  <div class="auth">
    <h1>Login</h1>
    <form @submit.prevent="login">
      <!-- Email input -->
      <input v-model="email" type="email" placeholder="Email" required />

      <!-- Password input -->
      <input v-model="password" type="password" placeholder="Password" required />

      <button type="submit">Login</button>
    </form>

    <!-- Link to register page -->
    <p>Don’t have an account?
      <router-link to="/register">Register here</router-link>
    </p>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'

const email = ref('')
const password = ref('')
const router = useRouter()

/**
 * LOGIN FUNCTION
 * Calls backend (Spring Boot) at: POST http://localhost:8080/api/user/login
 * Body: { email, password }
 * Returns: User object (from backend)
 */
async function login() {
  try {
    const response = await fetch('http://localhost:8080/api/user/login', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ email: email.value, password: password.value })
    })

    if (!response.ok) throw new Error('Login failed')

    const user = await response.json() // backend returns User object

    // ⚠️ Save user locally (no JWT, just user object)
    localStorage.setItem('user', JSON.stringify(user))

    alert(`Welcome back, ${user.firstName || 'User'}!`)
    router.push('/profile') // redirect after login
  } catch (error) {
    alert('Invalid credentials')
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
