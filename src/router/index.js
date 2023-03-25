import Vue from "vue";
import VueRouter from "vue-router";
import pathArr from '@/router/patharr.js' 

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
      showtopMenu: true
    },
  },
  {
    path: "/pickupdelivery",
    name: "PickupDelivery",
    component: () => import("../components/PickupDelivery"),
    meta: {
      title: "订单管理",
      showNavMenu: true,
      showtopMenu: true
    },
  },
  {
    path: "/test",
    name: "Mytest",
    component: () => import("../components/test"),
    meta: {
      title: "测试用页面",
      showNavMenu: true,
      showtopMenu: true
    },
  },
  {
    path: "/crm",
    name: "CustomManage",
    component: () => import("../components/crm"),
    meta: {
      title: "客户管理",
      showNavMenu: true,
      showtopMenu: true
    },
  },
  {
    path: "/shippingorder",
    name: "ShippingOrder",
    component: () => import("../components/shippingOrder"),
    meta: {
      title: "发货单",
      showNavMenu: true,
      showtopMenu: true
    },
  },
  {
    path: "/task",
    name: "Task",
    component: () => import("../components/task"),
    meta: {
      title: "任务管理",
      showNavMenu: true,
      showtopMenu: true
    },
  },
  {
    path: "/quote",
    name: "Quote",
    component: () => import("../components/Quote"),
    meta: {
      title: "报价管理",
      showNavMenu: true,
      showtopMenu: true
    },
  },
  {
    path: "/receipts",
    name: "Receipts",
    component: () => import("../components/Receipts"),
    meta: {
      title: "收据",
      showNavMenu: true,
      showtopMenu: true
    },
  },
  {
    path: "/release",
    name: "Release",
    component: () => import("../components/release"),
    meta: {
      title: "放货",
      showNavMenu: true,
      showtopMenu: true
    },
  },
  {
    path: "/inventory",
    name: "Inventory",
    component: () => import("../components/Inventory"),
    meta: {
      title: "库存",
      showNavMenu: true,
      showtopMenu: true
    },
  },
  {
    path: "/air",
    name: "Air",
    component: () => import("../components/air"),
    meta: {
      title: "空运",
      showNavMenu: true,
      showtopMenu: true
    },
  },
  {
    path: "/ground",
    name: "Ground",
    component: () => import("../components/ground"),
    meta: {
      title: "货运",
      showNavMenu: true,
      showtopMenu: true
    },
  },
  {
    path: "/shippment",
    name: "Shippment",
    component: () => import("../components/shippment"),
    meta: {
      title: "海运",
      showNavMenu: true,
      showtopMenu: true
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