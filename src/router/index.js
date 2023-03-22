import Vue from "vue";
import VueRouter from "vue-router";
import pathArr from '@/router/patharr.js' // 路由守卫

Vue.use(VueRouter);

const routes = [
  {
    path: "/login",
    name: "Login",
    component: () => import("../components/Login"),
    meta: {
      title: "登录",
    },
  },
  {
    path: "/",
    name: "Index",
    component: () => import("../components/home"),
    meta: {
      title: "首页",
      showNavMenu: true,
    },
  },
  {
    path: "/navmenu",
    name: "Navmenu",
    component: () => import("../components/NavMenu"),
  },
  {
    path: "/test",
    name: "Mytest",
    component: () => import("../components/test"),
    meta: {
      title: "测试用页面",
    },
  },
  {
    path: "/crm",
    name: "CustomManage",
    component: () => import("../components/crm"),
    meta: {
      title: "客户管理",
      showNavMenu: true,
    },
  },

];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

router.beforeEach((to, from, next) => {
  // 修改标题
  if (to.meta.title) {
    document.title = to.meta.title;
  }

  // 路由守卫
  if (pathArr.indexOf(to.path) !== -1) {
    const token = localStorage.getItem('token')
    if (token) {
      next()
    } else {
      next('/login')
    }
  } else {
    next()
  }
});
export default router