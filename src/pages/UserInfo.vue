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
            <el-form-item class="input" label="姓名" prop="name">
              <el-input size="small" v-model="name"></el-input>
            </el-form-item>
            <el-form-item class="input" label="用户名" prop="username">
              <el-input size="small" v-model="username"></el-input>
            </el-form-item>
            <el-form-item class="input" label="手机号" prop="phone">
              <el-input size="small" v-model="phone"></el-input>
            </el-form-item>
            <el-form-item class="input" label="邮箱" prop="email">
              <el-input size="small" v-model="email"></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="submitForm('ruleForm')"
                >完成修改</el-button
              >
              <el-button @click="resetForm('ruleForm')">重置</el-button>
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
              <el-input size="small" v-model="rawpwd"></el-input>
            </el-form-item>
            <el-form-item class="input" label="新密码" prop="newpwd">
              <el-input size="small" v-model="newpwd"></el-input>
            </el-form-item>
            <el-form-item class="input" label="确认新密码" prop="newpwdsecond">
              <el-input size="small" v-model="newpwdsecond"></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="submitForm('ruleForm')"
                >完成修改</el-button
              >
              <el-button @click="resetForm('ruleForm')">重置</el-button>
            </el-form-item>
          </el-form>
        </el-tab-pane>
      </el-tabs>
    </main>
  </div>
</template>

<script>
export default {
  name: "UserInfo",

  data() {
    return {
      activeName: "first",
      labelPosition: "right",

      name: "",
      username: "",
      phone: "",
      email: "",

      rules: {
        name: [{ required: true, message: "请输入姓名", trigger: "blur" }],
        username: [
          { required: true, message: "请输入用户名", trigger: "blur" },
        ],
        phone: [{ required: true, message: "请输入手机号", trigger: "blur" }],
        email: [{ required: true, message: "请输入邮箱", trigger: "blur" }],
        rawpwd:[{ required: true, message:"请输入原密码",trigger:"blur"}],
        newpwd:[{required:true, message:"请输入新密码",
        trigger:"blur"}],
        newpwdsecond:[{required:true, message:"请确认新密码",
        trigger:"blur"}]
      },
    };
  },

  mounted() {},

  methods: {},
};
</script>

<style lang="scss" scoped>
.input {
  width: 30em;
}
</style>