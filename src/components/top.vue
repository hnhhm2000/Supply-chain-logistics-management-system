<template>
  <div class="contain">
    <el-menu
      router
      :default-active="activeIndex"
      class="el-menu-demo"
      mode="horizontal"
      @select="handleSelect"
    >
      <el-menu-item route index="/" class="logo">
        <img src="../assets/img/logistics.png" alt="供应链物流管理系统" />
        <span class="title">供应链物流管理系统</span>
      </el-menu-item>

      <el-menu-item route index="/">首页</el-menu-item>
      <el-submenu index="2">
        <template slot="title">我的账户</template>
        <el-menu-item index="2-1">查看个人资料</el-menu-item>
        <el-menu-item index="2-2">修改密码</el-menu-item>
        <el-menu-item @click="reset" route index="./login">退出登录</el-menu-item>
      </el-submenu>
      <el-menu-item index="4"
        >
        <a href="mailto:986667872@qq.com" target="_blank">联系开发者</a>
          </el-menu-item>
    </el-menu>
  </div>
</template>

<script>
export default {
  name: "SystemTest",

  data() {
    return {
      activeIndex: "1",
      activeIndex2: "1",
    };
  },
  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    },
    reset() {
      localStorage.removeItem("token");
    }
  },
    computed: {
    showNavMenu() {
      return this.$route.meta.showNavMenu !== false;
    },
  },
};
</script>

<style lang="scss" scoped>
.logo {
  margin-right: 50em;
  margin-left: 10em;
}

.title {
  position: relative;
  left: 2em;
}
</style>
