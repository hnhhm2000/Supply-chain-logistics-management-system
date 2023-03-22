<template>
  <el-menu
    router
    default-active="2"
    class="el-menu-vertical-demo"
    @open="handleOpen"
    @close="handleClose"
    v-if="showNavMenu"
  >
    <el-menu-item route index="/">
      <i class="el-icon-menu"></i>
      <span slot="title">首页</span>
    </el-menu-item>
    <el-menu-item route index="#">
      <i class="el-icon-menu"></i>
      <span slot="title">订单管理</span>
    </el-menu-item>
    <el-menu-item route index="./crm">
      <i class="el-icon-document"></i>
      <span slot="title">客户管理</span>
    </el-menu-item>
    <el-menu-item route index="4">
      <i class="el-icon-setting"></i>
      <span slot="title">订单管理</span>
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

<style lang="scss" scoped></style>
