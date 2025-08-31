<template>
  <div class="navbar">
    <div class="container navbar-inner">
      <div class="brand">TymelessTyres</div>
      <nav class="navlinks">
        <router-link to="/">Home</router-link>
        <router-link to="/tyres">Tyres</router-link>
        <router-link to="/rims">Rims</router-link>
        <router-link to="/services">Services</router-link>
        <router-link to="/stores">Store Locator</router-link>
        <router-link to="/contact">Contact Us</router-link>
        <router-link to="/cart" title="Cart"> 🛒 <span>{{ count }}</span></router-link>

        <!-- 🔗 Auth integration -->
        <template v-if="user">
          <router-link to="/profile">Hi, {{ user.name || user.email }}</router-link>
          <button class="logout-btn" @click="logout">Logout</button>
        </template>
        <template v-else>
          <router-link to="/login">Sign In</router-link>
          <router-link to="/register">Sign Up</router-link>
        </template>
      </nav>
    </div>
  </div>
</template>

<script setup>
import { computed, ref, onMounted } from 'vue'
import store from '../store'

const count = computed(() => store.cartCount.value)
const user = ref(null)

onMounted(() => {
  const storedUser = localStorage.getItem('user')
  if (storedUser) {
    user.value = JSON.parse(storedUser)
  }
})

function logout() {
  // 🔗 BACKEND INTEGRATION: Optionally tell backend to invalidate JWT
  // Example: POST http://localhost:8080/api/auth/logout
  localStorage.removeItem('token')
  localStorage.removeItem('user')
  user.value = null
}
</script>


<style scoped>
.navbar {
  background: #222;
  padding: 1rem 0;
  color: white;
}

.navbar-inner {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.brand {
  font-size: 1.5rem;
  font-weight: bold;
  color: #f5c518;
}

.navlinks {
  display: flex;
  gap: 1.5rem;
  align-items: center;
}

.navlinks a {
  color: white;
  text-decoration: none;
  transition: color 0.3s;
}

.navlinks a:hover {
  color: #f5c518;
}

.profile {
  font-weight: bold;
  margin-right: 1rem;
}

.logout-btn {
  background: #e63946;
  border: none;
  padding: 6px 12px;
  border-radius: 5px;
  color: white;
  cursor: pointer;
}

.logout-btn:hover {
  background: #c1121f;
}
</style>
