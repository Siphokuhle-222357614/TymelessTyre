<template>
  <footer class="footer">
    <div class="container">
      <div>© {{year}} TymeLess Tyres — Safety • Performance • Service</div>
    </div>
  </footer>
</template>

<script setup>
const year = new Date().getFullYear();
</script>
