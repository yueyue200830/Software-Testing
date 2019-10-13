import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router'
import ElementUI from 'element-ui'
import axios from 'axios'
import 'element-ui/lib/theme-chalk/index.css'

Vue.config.productionTip = false

Vue.use(VueRouter);
Vue.use(ElementUI);
Vue.prototype.$http = axios

new Vue({
  render: h => h(App),
}).$mount('#app')
