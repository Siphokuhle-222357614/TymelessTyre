<template>
  <section class="container" style="padding:28px 0;">
    <div class="card" style="overflow:hidden;">
      <div style="display:flex; gap:20px; flex-wrap:wrap;">
        <img :src="product.image" :alt="product.name" class="card-img" style="max-width:420px; flex:1 1 380px;" />
        <div class="card-body" style="flex:1 1 320px;">
          <h2 style="margin-top:0;">{{ product.name }}</h2>
          <div style="color:var(--muted)">Type: {{ product.type }} • Size: {{ product.size }}</div>
          <div class="price" style="font-size:24px; margin:12px 0;">$ {{ product.price }}</div>

          <div style="display:flex; gap:8px;">
            <button class="btn" @click="addToCart">Add to Cart</button>
            <router-link class="btn secondary" to="/cart">Go to Cart</router-link>
          </div>
        </div>
      </div>
    </div>

    <div style="margin-top:24px;" class="card">
      <div class="card-body">
        <h3 style="margin-top:0;">Reviews</h3>
        <div v-if="reviews.length === 0" style="color:var(--muted)">No reviews yet. Be the first!</div>
        <div v-else style="display:grid; gap:12px; margin-bottom:16px;">
          <div v-for="(rv, idx) in reviews" :key="idx" style="border-bottom:1px solid #eef2f9; padding-bottom:8px;">
            <strong>{{ rv.author }}</strong> • ⭐ {{ rv.rating }} <br />
            <span>{{ rv.text }}</span>
          </div>
        </div>

        <form class="form" @submit.prevent="submitReview" style="margin-top:8px;">
          <div style="display:grid; gap:10px;">
            <input class="input" v-model="author" type="text" placeholder="Your name" required />
            <select class="input" v-model.number="rating" required>
              <option disabled value="">Rating</option>
              <option v-for="n in 5" :key="n" :value="n">{{ n }}</option>
            </select>
            <textarea class="input" v-model="text" rows="3" placeholder="Write your review..." required></textarea>
            <button class="btn" type="submit">Submit Review</button>
          </div>
        </form>
      </div>
    </div>
  </section>
</template>

<script setup>
import { computed, ref } from 'vue';
import { byKey } from '../data/products';
import store from '../store';

const props = defineProps({ type: String, id: String });
const pid = Number(props.id);
const list = byKey(props.type);
const product = list.find(p => p.id === pid) || { name:'Not found', price:0, image:'' };

const reviews = computed(() => store.getReviews(props.type, pid));
const author = ref('');
const rating = ref('');
const text = ref('');

function addToCart(){ store.addToCart(props.type, pid, 1); }
function submitReview(){
  store.addReview(props.type, pid, { author: author.value, rating: rating.value, text: text.value });
  author.value=''; rating.value=''; text.value='';
}
</script>
