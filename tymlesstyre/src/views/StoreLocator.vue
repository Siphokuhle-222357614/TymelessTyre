<template>
  <section class="container" style="padding:28px 0;">
    <h2>Store Locator</h2>
    <div class="form" style="margin: 14px 0;">
      <input class="input" v-model="q" placeholder="Search city or suburb..." />
    </div>
    <div class="grid">
      <div v-for="s in filtered" :key="s.id" class="card">
        <div class="card-body">
          <strong>{{ s.name }}</strong>
          <div style="color:var(--muted);">{{ s.address }}</div>
          <div>{{ s.city }}</div>
          <div style="margin-top:8px;">☎ {{ s.phone }}</div>
        </div>
      </div>
    </div>
  </section>
</template>

<script setup>
import { ref, computed } from 'vue';
const stores = [
  { id:1, name:'TymeLess Tyres – CBD', address:'123 Main Rd', city:'Johannesburg', phone:'+27 11 000 0000' },
  { id:2, name:'TymeLess Tyres – North', address:'45 Oak St', city:'Pretoria', phone:'+27 12 000 0000' },
  { id:3, name:'TymeLess Tyres – Coast', address:'88 Beach Ave', city:'Durban', phone:'+27 31 000 0000' },
];
const q = ref('');
const filtered = computed(() => {
  const v = q.value.toLowerCase().trim();
  if(!v) return stores;
  return stores.filter(s =>
    s.name.toLowerCase().includes(v) ||
    s.city.toLowerCase().includes(v) ||
    s.address.toLowerCase().includes(v)
  );
});
</script>
