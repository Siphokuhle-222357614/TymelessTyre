<template>
  <section class="container" style="padding:28px 0;">
    <h2>Contact Us</h2>
    <form class="form" @submit.prevent="submit">
      <div style="display:grid; gap:10px;">
        <input class="input" v-model="name" placeholder="Your name" required />
        <input class="input" v-model="email" type="email" placeholder="Email" required />
        <textarea class="input" v-model="msg" rows="4" placeholder="Message" required></textarea>
        <button class="btn" type="submit">Send</button>
      </div>
    </form>
  </section>
</template>

<script setup>
import { ref } from 'vue';
const name = ref(''); const email = ref(''); const msg = ref('');
function submit(){ alert(`Thanks ${name.value}! We’ll reply to ${email.value}.`); name.value=email.value=msg.value=''; }
</script>
