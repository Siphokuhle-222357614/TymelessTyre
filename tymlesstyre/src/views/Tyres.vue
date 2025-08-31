<template>
  <section class="container" style="padding:28px 0;">
    <div style="display:flex; justify-content:space-between; align-items:center; margin-bottom:16px;">
      <h2>Tyres</h2>
      <div>
        <label style="margin-right:8px;">Sort by price:</label>
        <select v-model="sortOpt" @change="resort">
          <option value="">Default</option>
          <option value="asc">Low → High</option>
          <option value="desc">High → Low</option>
        </select>
      </div>
    </div>

    <div class="grid">
      <ProductCard v-for="t in list" :key="t.id" :item="t" itemKey="tyre" />
    </div>
  </section>
</template>

<script setup>
import { ref } from 'vue';
import { tyres } from '../data/products';
import ProductCard from '../components/ProductCard.vue';

const list = ref([...tyres]);
const sortOpt = ref('');

function resort(){
  if(sortOpt.value === 'asc') list.value.sort((a,b)=>a.price-b.price);
  else if(sortOpt.value === 'desc') list.value.sort((a,b)=>b.price-a.price);
  else list.value = [...tyres];
}
</script>
