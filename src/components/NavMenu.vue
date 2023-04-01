<template>
  <el-menu
    router
    default-active="2"
    class="el-menu-vertical-demo menu"
    @open="handleOpen"
    @close="handleClose"
    v-if="showNavMenu"
  >
    <el-menu-item route index="/">
      <i class="el-icon-menu"></i>
      <span slot="title">首页</span>
    </el-menu-item>
    <el-menu-item route index="./PickupDelivery">
      <i class="el-icon-menu"></i>
      <span slot="title">提货送货</span>
    </el-menu-item>
    <el-menu-item route index="./crm">
      <i class="el-icon-document"></i>
      <span slot="title">客户管理</span>
    </el-menu-item>
    
     <el-submenu index="1">
       
       <template slot="title">
        <img src="../assets/img/warehouse.png" class="NavMenu-icon">
        <span>库存管理</span>
        </template>

        <el-menu-item-group>
         
          <el-menu-item route index="./receipts">收据</el-menu-item>
          <el-menu-item route index="./inventory">库存</el-menu-item>
          <el-menu-item route index="./release">出库</el-menu-item>
        </el-menu-item-group>

    </el-submenu>
      <el-menu-item route index="./PickupDelivery">
      <img src="../assets/img/Delivery.png" class="NavMenu-icon">
      <span slot="title">运输管理</span>
    </el-menu-item>
     <el-menu-item route index="./quote">
      <img src="../assets/img/Quotes.png" class="NavMenu-icon">
      <span slot="title">报价管理</span>
    </el-menu-item>
     <el-menu-item route index="./task">
      <img class="NavMenu-icon" src="../assets/img/task.png">
      <span slot="title">任务管理</span>
    </el-menu-item>
     <el-menu-item route index="./shippingorder">
      <img class="NavMenu-icon" src="../assets/img/shippingorder.png">
      <span slot="title">发货单</span>
    </el-menu-item>
     <el-menu-item route index="./quote">
      <img class="NavMenu-icon" src="../assets/img/release.png">
      <span slot="title">报价</span>
    </el-menu-item>
     <el-menu-item route index="./air">
      <img class="NavMenu-icon" src="../assets/img/Air.png">
      <span slot="title">空运</span>
    </el-menu-item>
     <el-menu-item route index="./ground">
      <img class="NavMenu-icon" src="../assets/img/ground.png">
      <span slot="title">陆运</span>
    </el-menu-item>
     <el-submenu index="2">
      <template slot="title">
        <img src="../assets/img/ocean.png" class="NavMenu-icon">
        <span>海运</span>
        </template>

        <el-menu-item-group>
         
          <el-menu-item route index="./oceanimport">进口</el-menu-item>
          <el-menu-item route index="./oceanexport">出口</el-menu-item>
         
        </el-menu-item-group>
        </el-submenu>
     <!-- <el-menu-item route index="./ocean">
      <img class="NavMenu-icon" >
      <span slot="title">海运</span>
    </el-menu-item> -->
      <el-submenu index="3">
      <template slot="title">
        <img src="../assets/img/statistics.png" class="NavMenu-icon">
        <span slot="title">财务管理</span>
        </template>

        <el-menu-item-group>
         
          <el-menu-item route index="./invoices">发票</el-menu-item>
          <el-menu-item route index="./bills">账单</el-menu-item>
         
        </el-menu-item-group>
        </el-submenu>
     <!-- <el-menu-item route index="./Accounting">
      <img class="NavMenu-icon" src="../assets/img/statistics.png">
      <span slot="title">财务管理</span>
    </el-menu-item> -->
     <el-menu-item route index="4">
      <img class="NavMenu-icon" src="../assets/img/feedback.png">
      <span slot="title">反馈</span>
    </el-menu-item>
  </el-menu>
</template>

<script>
export default {
  name: "SystemLayout",

  data() {
    return {};
  },

  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    },
  },

  computed: {
    showNavMenu() {
      return this.$route.meta.showNavMenu !== false;
    },
  },
};
</script>

<style lang="scss" scoped>
// 让我们赶走难看的滚动条
.menu {
  overflow: auto;
  padding-right: 100em;
}
</style>
