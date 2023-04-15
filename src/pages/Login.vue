<template>
  <div class="main">
    <el-card class="Login">
      <h1 class="font">登录</h1>

      <el-form
        ref="form"
        :model="form"
        :rules="rules"
        label-width="80px"
        style="margin-right: 1.5em; height: 9.5em"
      >
        <el-form-item label="用户名" prop="username">
          <el-input
            v-model="form.username"
            placeholder="请输入用户名"
          ></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input
            v-model="form.password"
            placeholder="请输入密码"
            type="password"
          ></el-input>
        </el-form-item>
        <el-form-item>
          <el-checkbox class="rememberme" v-model="form.remember"
            >记住我</el-checkbox
          >
        </el-form-item>
        <el-form-item>
          <el-button class="submit" type="primary" @click="login"
            >登录</el-button
          >
        </el-form-item>
      </el-form>

      <footer>
        <p style="margin-left: 0.6em">如忘记密码，请联系管理员</p>
      </footer>
    </el-card>
    <el-message ref="message" />
  </div>
</template>

<script>
import { Message } from "element-ui";

export default {
  name: "SystemLogin",

  data() {
    return {
      form: {
        username: "",
        password: "",
        remember: false,
      },

      rules: {
        username: [
          { required: true, message: "请输入用户名", trigger: "blur" },
        ],
        password: [{ required: true, message: "请输入密码", trigger: "blur" }],
      },
    };
  },

  mounted() {
    this.restoreUserInfo();
  },

  methods: {
    login() {
      if (this.form.username === "admin" && this.form.password === "123456") {
        // 登录成功
        // 1. 存储 token 与账号密码
        localStorage.setItem("token", "Bearer xxxx");

        if (this.form.remember) {
          // 如果勾选了“记住我”，则保存用户名和密码
          localStorage.setItem("username", this.form.username);
          localStorage.setItem("password", this.form.password);
        } else {
          // 否则清除保存的用户名和密码
          localStorage.removeItem("username");
          localStorage.removeItem("password");
        }

        // 2. 跳转到后台主页
        this.$router.push("/");
        Message.success("登录成功");
      } else {
        // 登录失败
        localStorage.removeItem("token");
        Message.error("账号或密码错误，请联系管理员");
      }
    },

    restoreUserInfo() {
      // 尝试从 localStorage 中获取保存的用户名和密码
      const username = localStorage.getItem("username");
      const password = localStorage.getItem("password");
      if (username && password) {
        // 如果获取到了，则填充到表单中
        this.form.username = username;
        this.form.password = password;
        this.form.remember = true;
      }
    },
  },
};
</script>

<style scoped>
.main {
  background: url("../assets/img/background.jpg");
  background-size: 100% 100%;
  background-position: center;
  background-repeat: no-repeat;
  position: fixed;
  top: 0;
  left: 0;
  bottom: 0;
  right: 0;
  z-index: -1;
  display: flex;
  justify-content: center;
  align-items: center;
}

.Login {
  max-width: 22em;
  max-height: 18em;
  position: relative;
  z-index: 1;
  background: rgba(255, 255, 255, 0.9);
  border-radius: 4px;
  text-align: center;
  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
}

.font {
  font-size: 24px;
  font-weight: 500;
  text-align: center;
}

.submit {
  padding: 0.5em 1em;
  position: relative;
  left: 5.3em;
  bottom: 4.5em;
  border-radius: 6px;
}

.rememberme {
  margin-right: 10em;
}
</style>
