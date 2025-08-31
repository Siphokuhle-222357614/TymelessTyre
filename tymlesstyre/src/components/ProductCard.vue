<template>
  <div class="card">
    <img :src="item.image" :alt="item.name" class="card-img" />
    <div class="card-body">
      <div style="display:flex; justify-content:space-between; align-items:center;">
        <strong>{{ item.name }}</strong>
        <span class="price">$ {{ item.price }}</span>
      </div>
      <div style="color:var(--muted); font-size:14px; margin-top:6px;">
        {{ item.type }} • {{ item.size }}
      </div>

      <div style="display:flex; gap:8px; margin-top:12px;">
        <button class="btn" @click="add()">Add to Cart</button>
        <router-link class="btn secondary" :to="detailLink">Details</router-link>
      </div>
    </div>
  </div>
</template>

<script setup>
import store from '../store';
const props = defineProps({
  item: { type: Object, required: true },
  itemKey: { type: String, required: true } // 'tyre' or 'rim'
});
const detailLink = computed(() => `/product/${props.itemKey}/${props.item.id}`);
function add(){ store.addToCart(props.itemKey, props.item.id, 1); }
import { computed } from 'vue';
</script>
