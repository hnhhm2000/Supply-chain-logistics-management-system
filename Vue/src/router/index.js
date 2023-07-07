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
      title: "提货送货",
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
      title: "客户管理",
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
      title: "陆运",
      showNavMenu: true,
      showtopMenu: true
    },
  },
  {
    path: "/ocean",
    name: "Ocean",
    component: () => import("../views/Ocean"),
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
  {
    path: "/userinfo",
    name: "UserInfo",
    component: () => import("../pages/UserInfo"),
    meta: {
      title: "个人信息",
      showNavMenu: true,
      showtopMenu: true
    },
  },

  {
    path: "/setting",
    name: "Setting",
    component: () => import("../pages/Setting"),
    meta: {
      title: "系统设置",
      showNavMenu: true,
      showtopMenu: true
    },
  },

  {
    path: "/user",
    name: "UserManage",
    component: () => import("../pages/UserManage"),
    meta: {
      title: "用户管理",
      showNavMenu: true,
      showtopMenu: true
    },
  },

  // 添加
  {
    path: "/crm/add",
    name: "CrmAdd",
    component: () => import("../pages/add/crmadd"),
    meta: {
      title: "添加客户",
    },
  },

  {
    path: "/quote/add",
    name: "QuoteAdd",
    component: () => import("../pages/add/QuoteAdd"),
    meta: {
      title: "添加报价",
    },
  },

  {
    path: "/shippingorder/add",
    name: "ShippingOrderAdd",
    component: () => import("../pages/add/ShippingOrderAdd"),
    meta: {
      title: "添加装运单",
    },
  },

  {
    path: "/pickupdelivery/add",
    name: "PickupDeliveryAdd",
    component: () => import("../pages/add/PickupDeliveryAdd"),
    meta: {
      title: "添加提货送货",
    },
  },

  {
    path: "/receipt/add",
    name: "ReceiptAdd",
    component: () => import("../pages/add/ReceiptAdd"),
    meta: {
      title: "添加收据",
    },
  },

  {
    path: "/inventory/add",
    name: "InventoryAdd",
    component: () => import("../pages/add/InventoryAdd"),
    meta: {
      title: "添加提货送货",
    },
  },

  {
    path: "/release/add",
    name: "ReleaseAdd",
    component: () => import("../pages/add/ReleaseAdd"),
    meta: {
      title: "添加出库",
    },
  },

  {
    path: "/air/add",
    name: "AirAdd",
    component: () => import("../pages/add/AirAdd"),
    meta: {
      title: "添加空运",
    },
  },

  {
    path: "/ocean/add",
    name: "OceanAdd",
    component: () => import("../pages/add/OceanAdd"),
    meta: {
      title: "添加海运",
    },
  },

  {
    path: "/ground/add",
    name: "GroundAdd",
    component: () => import("../pages/add/GroundAdd"),
    meta: {
      title: "添加陆运",
    },
  },

  {
    path: "/invoice/add",
    name: "InvoiceAdd",
    component: () => import("../pages/add/InvoiceAdd"),
    meta: {
      title: "添加发票",
    },
  },

  // 详情
    {
    path: "/crm/detail/:id",
    name: "CrmDetail",
    component: () => import("../pages/detail/crmdetail"),
    meta: {
      title: "客户详情",
    },
  },

  {
    path: "/quote/detail/:id",
    name: "QuoteDetail",
    component: () => import("../pages/detail/QuoteDetail"),
    meta: {
      title: "报价详情",
    },
  },

  {
    path: "/shippingorder/detail/:id",
    name: "ShippingOrderDetail",
    component: () => import("../pages/detail/ShippingOrderDetail"),
    meta: {
      title: "装货单详情",
    },
  },

  {
    path: "/pickupdelivery/detail/:id",
    name: "PickupDelieryDetail",
    component: () => import("../pages/detail/PickupDeliveryDetail"),
    meta: {
      title: "提货送货详情",
    },
  },

  {
    path: "/receipt/detail/:id",
    name: "ReceiptDetail",
    component: () => import("../pages/detail/ReceiptDetail"),
    meta: {
      title: "收据详情",
    },
  },

  {
    path: "/Inventory/detail/:id",
    name: "InventoryDetail",
    component: () => import("../pages/detail/InventoryDetail"),
    meta: {
      title: "库存详情",
    },
  },

  {
    path: "/release/detail/:id",
    name: "ReleaseDetail",
    component: () => import("../pages/detail/ReleaseDetail"),
    meta: {
      title: "出库详情",
    },
  },

  {
    path: "/air/detail/:id",
    name: "ReleaseDetail",
    component: () => import("../pages/detail/AirDetail"),
    meta: {
      title: "空运详情",
    },
  },

  {
    path: "/ocean/detail/:id",
    name: "ReleaseDetail",
    component: () => import("../pages/detail/OceanDetail"),
    meta: {
      title: "海运详情",
    },
  },

  {
    path: "/ground/detail/:id",
    name: "ReleaseDetail",
    component: () => import("../pages/detail/GroundDetail"),
    meta: {
      title: "陆运详情",
    },
  },

  // 编辑
  {
    path: "/crm/edit/:id",
    name: "CrmEdit",
    component: () => import("../pages/edit/crmedit"),
    meta: {
      title: "客户编辑",
    },
  },

  {
    path: "/quote/edit/:id",
    name: "QuoteEdit",
    component: () => import("../pages/edit/QuoteEdit"),
    meta: {
      title: "报价编辑",
    },
  },

  {
    path: "/ShippingOrder/edit/:id",
    name: "ShipperEdit",
    component: () => import("../pages/edit/ShippingOrderEdit"),
    meta: {
      title: "装运单编辑",
    },
  },

  {
    path: "/pickupdelivery/edit/:id",
    name: "PickupDeliveryEdit",
    component: () => import("../pages/edit/PickupDeliveryEdit"),
    meta: {
      title: "提货送货编辑",
    },
  },

  {
    path: "/receipt/edit/:id",
    name: "ReceiptEdit",
    component: () => import("../pages/edit/ReceiptEdit"),
    meta: {
      title: "收据编辑",
    },
  },

  {
    path: "/inventory/edit/:id",
    name: "InventoryEdit",
    component: () => import("../pages/edit/InventoryEdit"),
    meta: {
      title: "库存编辑",
    },
  },

  {
    path: "/release/edit/:id",
    name: "ReleaseEdit",
    component: () => import("../pages/edit/ReleaseEdit"),
    meta: {
      title: "出库编辑",
    },
  },

  {
    path: "/air/edit/:id",
    name: "AirEdit",
    component: () => import("../pages/edit/AirEdit"),
    meta: {
      title: "空运编辑",
    },
  },

  {
    path: "/ocean/edit/:id",
    name: "OceanEdit",
    component: () => import("../pages/edit/OceanEdit"),
    meta: {
      title: "海运编辑",
    },
  },

  {
    path: "/ground/edit/:id",
    name: "GroundEdit",
    component: () => import("../pages/edit/GroundEdit"),
    meta: {
      title: "陆运编辑",
    },
  },

  {
    path: "/invoice/edit/:id",
    name: "InvoiceEdit",
    component: () => import("../pages/edit/InvoiceEdit"),
    meta: {
      title: "发票编辑",
    },
  },

  {
    path: "/bill/edit/:id",
    name: "BillEdit",
    component: () => import("../pages/edit/BillEdit"),
    meta: {
      title: "账单编辑",
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