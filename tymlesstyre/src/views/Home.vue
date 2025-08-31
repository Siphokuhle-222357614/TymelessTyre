<template>
  <section class="hero">
    <div class="container">
      <h1>Premium Tyres & Rims</h1>
      <p>Trusted performance, expert fitment, nationwide support.</p>
    </div>
  </section>

  <section class="container" style="padding:28px 0;">
    <h2 style="margin-bottom:16px;">Best Sellers</h2>
    <div class="grid">
      <div v-for="p in featured" :key="p.name" class="flip">
        <div class="flip-inner">
          <div class="flip-face">
            <img :src="p.image" alt="" class="card-img" />
            <div class="card-body">
              <strong>{{ p.name }}</strong>
              <div class="price" style="margin-top:6px">$ {{ p.price }}</div>
            </div>
          </div>
          <div class="flip-face flip-back">
            <div class="card-body">
              <div style="font-weight:700; margin-bottom:6px">{{ p.name }}</div>
              <div>Type: {{ p.type }}</div>
              <div>Size: {{ p.size }}</div>
              <div style="margin-top:10px">
                <router-link class="btn secondary" :to="p.link">See Details</router-link>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script setup>
import store from '../store';
import { tyres, rims } from '../data/products';

const featured = [
  { ...tyres[0], link: `/product/tyre/${tyres[0].id}` },
  { ...rims[0],  link: `/product/rim/${rims[0].id}`  },
  { ...tyres[1], link: `/product/tyre/${tyres[1].id}` },
];
</script>
