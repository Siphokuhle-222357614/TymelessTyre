import { reactive, computed, watch } from 'vue';
import { tyres, rims, byKey } from './data/products';

const state = reactive({
  cart: [], // { key:'tyre'|'rim', id, name, price, qty, image }
  reviews: {}, // { "<key>:<id>": [ { author, rating, text, date } ] }
});

// ---- persistence ----
const LS_CART = 'tyreapp_cart_v1';
const LS_REVIEWS = 'tyreapp_reviews_v1';

try {
  const c = JSON.parse(localStorage.getItem(LS_CART) || '[]');
  const r = JSON.parse(localStorage.getItem(LS_REVIEWS) || '{}');
  state.cart = Array.isArray(c) ? c : [];
  state.reviews = r && typeof r === 'object' ? r : {};
} catch (_) {}

watch(() => state.cart, v => localStorage.setItem(LS_CART, JSON.stringify(v)), { deep: true });
watch(() => state.reviews, v => localStorage.setItem(LS_REVIEWS, JSON.stringify(v)), { deep: true });

// ---- getters ----
const cartCount = computed(() => state.cart.reduce((n, i) => n + i.qty, 0));
const cartTotal = computed(() => state.cart.reduce((sum, i) => sum + i.price * i.qty, 0));

// ---- actions ----
function addToCart(itemKey, id, qty = 1){
  const data = byKey(itemKey).find(p => p.id === id);
  if(!data) return;
  const idx = state.cart.findIndex(i => i.key === itemKey && i.id === id);
  if(idx >= 0) state.cart[idx].qty += qty;
  else state.cart.push({ key:itemKey, id, name:data.name, price:data.price, image:data.image, qty });
}
function removeFromCart(itemKey, id){
  state.cart = state.cart.filter(i => !(i.key === itemKey && i.id === id));
}
function updateQty(itemKey, id, qty){
  const it = state.cart.find(i => i.key === itemKey && i.id === id);
  if(!it) return;
  it.qty = Math.max(1, qty|0);
}
function clearCart(){ state.cart = []; }

function keyFor(itemKey, id){ return `${itemKey}:${id}`; }
function getReviews(itemKey, id){
  return state.reviews[keyFor(itemKey, id)] || [];
}
function addReview(itemKey, id, review){
  const k = keyFor(itemKey, id);
  if(!state.reviews[k]) state.reviews[k] = [];
  state.reviews[k].push({ ...review, date: new Date().toISOString() });
}

export default {
  state,
  cartCount, cartTotal,
  addToCart, removeFromCart, updateQty, clearCart,
  getReviews, addReview,
  tyres, rims,
};
