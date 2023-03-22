import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui';
import router from './router'
import NavMenu from "./components/NavMenu.vue"
import TopMenu from "./components/test"
import Avue from '@smallwei/avue'
import './assets/css/main.css'
import '@smallwei/avue/lib/index.css';
import 'element-ui/lib/theme-chalk/index.css';

Vue.config.productionTip = false

Vue.use(ElementUI);
Vue.use(Avue);
Vue.component('NavMenu', NavMenu)
Vue.component('TopMenu', TopMenu)

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
