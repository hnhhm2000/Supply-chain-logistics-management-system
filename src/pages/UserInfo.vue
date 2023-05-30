<template>
  <div>
    <NavMenu class="sidebar"></NavMenu>
    <TopMenu class="topmenu"></TopMenu>

    <main>
      <el-tabs v-model="activeName" @tab-click="handleClick">
        <el-tab-pane label="个人信息" name="first">
          <el-form
            :label-position="labelPosition"
            label-width="80px"
            :rules="rules"
            :model="formLabelAlign"
          >
            <el-form-item class="input" label="id：">
              <el-input
                size="small"
                v-model="userInfo.id"
                disabled
                v-if="editable"
              ></el-input>
              <div v-else class="context">{{ userInfo.id }}</div>
            </el-form-item>
            <el-form-item class="input" label="用户名：" prop="accountName">
              <el-input
                size="small"
                v-model="userInfo.accountName"
                v-if="editable"
              ></el-input>
              <div v-else class="context">{{ userInfo.accountName }}</div>
            </el-form-item>
            <el-form-item class="input" label="手机号：" prop="phoneNumber">
              <el-input
                size="small"
                v-model="userInfo.phoneNumber"
                v-if="editable"
              ></el-input>
              <div v-else class="context">{{ userInfo.phoneNumber }}</div>
            </el-form-item>
            <el-form-item class="input" label="邮箱：" prop="email">
              <el-input
                size="small"
                v-model="userInfo.email"
                v-if="editable"
              ></el-input>
              <div v-else class="context">{{ userInfo.email }}</div>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="submit()" v-if="editable"
                >完成修改</el-button
              >
              <el-button @click="toggleEditable" type="primary" v-else
                >编辑</el-button
              >
              <el-button @click="resetForm()">重置</el-button>
            </el-form-item>
          </el-form>
        </el-tab-pane>
        <el-tab-pane label="修改密码" name="second">
          <el-form
            :label-position="labelPosition"
            label-width="100px"
            :rules="rules"
            :model="formLabelAlign"
          >
            <el-form-item class="input" label="原密码" prop="rawpwd">
              <el-input
                size="small"
                v-model="rawpwd"
                type="password"
              ></el-input>
            </el-form-item>
            <el-form-item class="input" label="新密码" prop="newpwd">
              <el-input
                size="small"
                v-model="newpwd"
                type="password"
              ></el-input>
            </el-form-item>
            <el-form-item class="input" label="确认新密码" prop="newpwdsecond">
              <el-input
                size="small"
                v-model="newpwdsecond"
                type="password"
              ></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="submit()">完成修改</el-button>

              <el-button @click="resetpwd()">重置</el-button>
            </el-form-item>
          </el-form>
        </el-tab-pane>
      </el-tabs>
    </main>
  </div>
</template>

<script>
import { getUserInfo } from "@/api/User";

export default {
  name: "UserInfo",

  data() {
    return {
      activeName: "first",
      labelPosition: "right",
      editable: false,

      userInfo: {
        id: "",
        accountName: "",
        phoneNumber: "",
        email: "",
      },

      rawpwd: "",
      newpwd: "",
      newpwdsecond: "",

      rules: {
        accountName: [
          { required: true, message: "请输入用户名", trigger: "blur" },
        ],
        phoneNumber: [
          { required: true, message: "请输入手机号", trigger: "blur" },
        ],
        email: [{ required: true, message: "请输入邮箱", trigger: "blur" }],
        rawpwd: [{ required: true, message: "请输入原密码", trigger: "blur" }],
        newpwd: [{ required: true, message: "请输入新密码", trigger: "blur" }],
        newpwdsecond: [
          { required: true, message: "请确认新密码", trigger: "blur" },
        ],
      },
    };
  },

  methods: {
    // 控制是否编辑
    toggleEditable() {
      this.editable = !this.editable;
    },
    // 清空个人资料编辑
    resetForm() {
      this.name = "";
      this.accountName = "";
      this.phoneNumber = "";
      this.email = "";
      this.rawpwd = "";
      this.newpwd = "";
      this.newpwdsecond = "";
    },
    // 清空密码编辑
    resetpwd() {
      this.rawpwd = "";
      this.newpwd = "";
      this.newpwdsecond = "";
    },
  },

  created() {
    // 获取token
    let token = localStorage.getItem("token");

    // 根据token获取个人资料
    getUserInfo(token).then((res) => {
      this.userInfo = res.data.data.userInfo;
    });
  },
};
</script>

<style lang="scss" scoped>

.context {
  float: left;
}

.input {
  width: 30em;
}
</style>
