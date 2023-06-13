import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui';
import router from './router'
import Avue from '@smallwei/avue'
import NavMenu from "./components/NavMenu.vue"
import TopMenu from "./components/TopMenu.vue"
// 编辑里的表格组件
import SimQuote from "./components/SimQuote.vue"
import SimAccounting from "./components/SimAccounting.vue"
import SimInventory from "./components/SimInventory.vue"
import SimShippment from "./components/SimShippment.vue"
import SimTask from "./components/SimTask.vue"
import SimCharges from "./components/SimCharges.vue"
import SimCommodity from "./components/Commodity.vue"
import './assets/css/main.css'
import '@smallwei/avue/lib/index.css';
import 'element-ui/lib/theme-chalk/index.css';



Vue.config.productionTip = false

Vue.use(ElementUI);
Vue.use(Avue);

Vue.component('NavMenu', NavMenu) // 导入侧边栏
Vue.component('TopMenu', TopMenu) // 导入头部栏
Vue.component('SimQuote', SimQuote) 
Vue.component('SimAccounting', SimAccounting) 
Vue.component('SimInventory', SimInventory) 
Vue.component('SimShippment', SimShippment) 
Vue.component('SimTask', SimTask) 
Vue.component('SimCharges', SimCharges) 
Vue.component('SimCommodity', SimCommodity) 


new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
