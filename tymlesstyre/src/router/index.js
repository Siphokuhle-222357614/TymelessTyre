import { createRouter, createWebHistory } from 'vue-router';

import Home from '../views/Home.vue';
import Login from "../views/Login.vue";
import Register from "../views/Register.vue";
import Profile from '../views/Profile.vue';
import Tyres from '../views/Tyres.vue';
import Rims from '../views/Rims.vue';
import Services from '../views/Services.vue';
import StoreLocator from '../views/StoreLocator.vue';
import Contact from '../views/Contact.vue';
import Cart from '../views/Cart.vue';
import ProductDetail from '../views/ProductDetail.vue';

const routes = [
  { path: '/', name: 'Home', component: Home },
  { path: "/", component: Home },
  { path: "/login", component: Login },
  { path: "/register", component: Register },
  { path: '/profile', component: Profile },
  { path: "/tyres", component: () => import("../views/Tyres.vue") },
  { path: '/tyres', name: 'Tyres', component: Tyres },
  { path: '/rims', name: 'Rims', component: Rims },
  { path: '/services', name: 'Services', component: Services },
  { path: '/stores', name: 'StoreLocator', component: StoreLocator },
  { path: '/contact', name: 'Contact', component: Contact },
  { path: '/cart', name: 'Cart', component: Cart },
  // :type is "tyre" or "rim", :id is product id
  { path: '/product/:type/:id', name: 'ProductDetail', component: ProductDetail, props: true },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
  scrollBehavior() { return { top: 0 }; }
});

export default router;
