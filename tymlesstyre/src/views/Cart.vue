<template>
  <section class="container" style="padding:28px 0;">
    <h2>Cart</h2>

    <div v-if="items.length === 0" class="card"><div class="card-body">Your cart is empty.</div></div>

    <div v-else class="card">
      <table class="table">
        <thead>
          <tr>
            <th>Product</th><th>Type</th><th>Price</th><th>Qty</th><th>Subtotal</th><th></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="it in items" :key="`${it.key}:${it.id}`">
            <td>{{ it.name }}</td>
            <td>{{ it.key }}</td>
            <td>$ {{ it.price }}</td>
            <td>
              <input type="number" min="1" :value="it.qty" @input="onQty(it, $event.target.value)" style="width:70px;" />
            </td>
            <td>$ {{ (it.price * it.qty).toFixed(2) }}</td>
            <td><button class="btn link" @click="remove(it)">Remove</button></td>
          </tr>
        </tbody>
      </table>

      <div style="display:flex; justify-content:flex-end; padding:14px;">
        <div style="font-weight:800; font-size:18px;">Total: $ {{ total.toFixed(2) }}</div>
      </div>

      <div style="display:flex; gap:8px; justify-content:flex-end; padding:0 14px 14px;">
        <button class="btn" @click="checkout">Checkout</button>
        <button class="btn secondary" @click="clear">Clear Cart</button>
      </div>
    </div>
  </section>
</template>

<script setup>
import store from '../store';
import { computed } from 'vue';
const items = store.state.cart;
const total = computed(() => store.cartTotal.value);

function onQty(it, v){ store.updateQty(it.key, it.id, Number(v)); }
function remove(it){ store.removeFromCart(it.key, it.id); }
function clear(){ store.clearCart(); }
function checkout(){ alert('Checkout flow goes here (integrate with your backend).'); }
</script>
