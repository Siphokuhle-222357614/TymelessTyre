<template>
  <div>
    <Navbar />
    <router-view />
    <SiteFooter />
  </div>
</template>

<script setup>
import Navbar from './components/Navbar.vue';
import SiteFooter from './components/SiteFooter.vue';
</script>
