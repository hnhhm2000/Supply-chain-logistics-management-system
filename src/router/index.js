import Vue from "vue";
import VueRouter from "vue-router";
import pathArr from '@/router/patharr.js' 

Vue.use(VueRouter);

const routes = [
  {
    path: "/login",
    name: "Login",
    component: () => import("../pages/Login"),
    meta: {
      title: "登录",
    },
  },
  {
    path: "/",
    name: "Index",
    component: () => import("../views/home"),
    meta: {
      title: "首页",
      showNavMenu: true,
      showtopMenu: true
    },
  },
  {
    path: "/pickupdelivery",
    name: "PickupDelivery",
    component: () => import("../views/PickupDelivery"),
    meta: {
      title: "订单管理",
      showNavMenu: true,
      showtopMenu: true
    },
  },
  {
    path: "/test",
    name: "Mytest",
    component: () => import("../views/test"),
    meta: {
      title: "测试用页面",
      showNavMenu: true,
      showtopMenu: true
    },
  },
  {
    path: "/crm",
    name: "CustomManage",
    component: () => import("../views/crm"),
    meta: {
      title: "账户管理",
      showNavMenu: true,
      showtopMenu: true
    },
  },
  {
    path: "/shippingorder",
    name: "ShippingOrder",
    component: () => import("../views/shippingOrder"),
    meta: {
      title: "装运单",
      showNavMenu: true,
      showtopMenu: true
    },
  },
  {
    path: "/task",
    name: "Task",
    component: () => import("../views/task"),
    meta: {
      title: "任务管理",
      showNavMenu: true,
      showtopMenu: true
    },
  },
  {
    path: "/quote",
    name: "Quote",
    component: () => import("../views/Quote"),
    meta: {
      title: "报价管理",
      showNavMenu: true,
      showtopMenu: true
    },
  },
  {
    path: "/receipts",
    name: "Receipts",
    component: () => import("../views/Receipts"),
    meta: {
      title: "收据",
      showNavMenu: true,
      showtopMenu: true
    },
  },
  {
    path: "/release",
    name: "Release",
    component: () => import("../views/release"),
    meta: {
      title: "放货",
      showNavMenu: true,
      showtopMenu: true
    },
  },
  {
    path: "/inventory",
    name: "Inventory",
    component: () => import("../views/Inventory"),
    meta: {
      title: "库存",
      showNavMenu: true,
      showtopMenu: true
    },
  },
  {
    path: "/air",
    name: "Air",
    component: () => import("../views/air"),
    meta: {
      title: "空运",
      showNavMenu: true,
      showtopMenu: true
    },
  },
  {
    path: "/ground",
    name: "Ground",
    component: () => import("../views/ground"),
    meta: {
      title: "货运",
      showNavMenu: true,
      showtopMenu: true
    },
  },
  // {
  //   path: "/shippment",
  //   name: "Shippment",
  //   component: () => import("../views/shippment"),
  //   meta: {
  //     title: "海运",
  //     showNavMenu: true,
  //     showtopMenu: true
  //   },
  // },
  {
    path: "/oceanimport",
    name: "OceanImport",
    component: () => import("../views/Import"),
    meta: {
      title: "海运",
      showNavMenu: true,
      showtopMenu: true
    },
  },
  {
    path: "/oceanexport",
    name: "OceanExport",
    component: () => import("../views/Export"),
    meta: {
      title: "海运",
      showNavMenu: true,
      showtopMenu: true
    },
  },
  {
    path: "/invoices",
    name: "Invoices",
    component: () => import("../views/Invoices"),
    meta: {
      title: "发票",
      showNavMenu: true,
      showtopMenu: true
    },
  },
  {
    path: "/bills",
    name: "Bills",
    component: () => import("../views/Bills"),
    meta: {
      title: "账单",
      showNavMenu: true,
      showtopMenu: true
    },
  },
  // 添加
  {
    path: "/crm/add",
    name: "crmAdd",
    component: () => import("../pages/add/crmadd"),
    meta: {
      title: "添加账户",
    },
  },

  // 详情
    {
    path: "/crm/detail/:id",
    name: "crmDetail",
    component: () => import("../pages/detail/crmdetail"),
    meta: {
      title: "账户详情",
    },
  },

  // 编辑
  {
    path: "/crm/edit/:id",
    name: "crmEdit",
    component: () => import("../pages/edit/crmedit"),
    meta: {
      title: "账户编辑",
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