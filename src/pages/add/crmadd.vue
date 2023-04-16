<template>
  <div class="bg">
    <!-- 主要内容 -->
    <main class="add-main">
      <!-- 卡片一  -->
      <el-card class="whiteCard">
        <div slot="header" class="clearfix">
          <span class="CardTitle">客户信息</span>
        </div>

        <div>
          <el-form
            ref="formCustomers"
            :model="Customers"
            :rules="rules"
            label-width="10em"
          >
            <el-row>
              <el-col :span="8">
                <el-form-item label="客户名称" prop="CustomerName">
                  <el-input
                    v-model="CustomerName"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="密码" prop="certiType">
                  <el-input
                    v-model="certiType"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="角色" prop="certiCode">
                  <el-select v-model="roles" placeholder="请选择">
                    <el-option
                      v-for="item in options"
                      :key="item.value"
                      :label="item.label"
                      :value="item.value"
                    >
                    </el-option>
                  </el-select>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <el-form-item label="电子邮箱" prop="certiAddress">
                  <el-input
                    v-model="certiAddress"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="状态" prop="groupId">
                  <el-input
                    v-model="groupId"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="联系人及电话" prop="phoneCode">
                  <el-input
                    v-model="phoneCode"
                    size="small"
                    class="input"
                    :maxlength="11"
                  ></el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-form>
        </div>
      </el-card>

      <!-- 卡片二  -->
      <el-card class="whiteCard">
        <div slot="header" class="clearfix">
          <span class="CardTitle">地址信息</span>
        </div>

        <div>
          <el-form
            ref="formTaxpayers"
            :model="Taxpayers"
            :rules="rules"
            label-width="10em"
          >
            <el-row>
              <el-col :span="8">
                <el-form-item label="主要地址" prop="taxpayerNumber">
                  <el-input
                    v-model="taxpayerNumber"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="账单地址" prop="unitName">
                  <el-input
                    v-model="unitName"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="注册电话" prop="registerPhone">
                  <el-input
                    v-model="registerPhone"
                    size="small"
                    class="input"
                    :maxlength="11"
                  ></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <el-form-item label="省/市" prop="registerAddress">
                  <el-input
                    v-model="registerAddress"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="开户银行" prop="bankOpening">
                  <el-input
                    v-model="bankOpening"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="银行账号" prop="bankAccount">
                  <el-input
                    v-model="bankAccount"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-form>
        </div>
      </el-card>

      <!-- 卡片三  -->
      <el-card class="whiteCard">
        <div slot="header" class="clearfix">
          <span class="CardTitle">备注说明</span>
        </div>

        <div>
          <el-input
            type="textarea"
            :rows="4"
            placeholder="请输入内容"
            v-model="textarea"
            size="medium"
            class="textarea"
            maxlength="1024"
            show-word-limit
          >
          </el-input>
        </div>
      </el-card>

      <!-- 卡片四  -->
      <el-card class="whiteCard">
        <div slot="header" class="clearfix">
          <span class="CardTitle">其他</span>
        </div>

        <div>
          <el-form
            ref="formOperator"
            :model="Operator"
            :rules="rules"
            label-width="10em"
          >
            <el-row>
              <el-col :span="8">
                <el-form-item label="状态" prop="createUserName">
                  <el-input
                    v-model="createUserName"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="付款方式" prop="createUserPhone">
                  <el-input
                    v-model="createUserPhone"
                    size="small"
                    class="input"
                    :maxlength="11"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="销售代表" prop="createUserTime">
                  <el-input
                    v-model="createUserTime"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <el-form-item label="所属地市" prop="cityName">
                  <el-input
                    v-model="cityName"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="邮编" prop="createDeptName">
                  <el-input
                    v-model="createDeptName"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="身份证号码" prop="createUserEmail">
                  <el-input
                    v-model="createUserEmail"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="操作人" prop="createUserName">
                  <el-input
                    v-model="createUserName"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="更新时间" prop="createUserPhone">
                  <el-input
                    v-model="createUserPhone"
                    size="small"
                    class="input"
                    :maxlength="11"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8"> </el-col>
            </el-row>
          </el-form>
        </div>
      </el-card>
    </main>

    <!-- 底部栏 -->
    <footer class="btns">
      <div style="margin-top: 2em">
        <el-button type="primary" @click="submitForm('form')"
          >保存提交</el-button
        >
        <el-button type="primary" plain @click="$router.back()">返回</el-button>
      </div>
    </footer>
  </div>
</template>

<script>
// import axios from "axios";

export default {
  name: "CrmAdd",

  data() {
    return {
      textarea: "",
      // 客户信息
      CustomerName: "",
      certiType: "",
      certiCode: "",
      roles: "",
      groupId: "",
      phoneCode: "",

      // 纳税人信息
      taxpayerNumber: "",
      unitName: "",
      registerPhone: "",
      registerAddress: "",
      bankOpening: "",
      bankAccount: "",

      // 操作人信息
      createUserName: "",
      createUserPhone: "",
      createUserTime: "",
      cityName: "",
      createDeptName: "",
      createUserEmail: "",

      // rules: {
      //   CustomerName: [
      //     { required: true, message: "客户名不能为空", trigger: "blur" },
      //   ],
      //   certiType: [
      //     { required: true, message: "证件类型不能为空", trigger: "blur" },
      //   ],
      //   certiCode: [
      //     { required: true, message: "证件号码不能为空", trigger: "blur" },
      //     { pattern: /^\d+$/, message: "只能输入数字" },
      //   ],
      //   certiAddress: [
      //     { required: true, message: "证件地址不能为空", trigger: "blur" },
      //   ],
      //   groupId: [
      //     { required: true, message: "集团编码不能为空", trigger: "blur" },
      //     { pattern: /^\d+$/, message: "只能输入数字" },
      //   ],
      //   phoneCode: [
      //     { required: true, message: "联系人及电话不能为空", trigger: "blur" },
      //     { pattern: /^\d{1,11}$/, message: "只能输入不超过11位的数字" },
      //   ],
      //   taxpayerNumber: [
      //     { required: true, message: "纳税人识别号不能为空", trigger: "blur" },
      //   ],
      //   unitName: [
      //     { required: true, message: "单位名称不能为空", trigger: "blur" },
      //   ],
      //   registerPhone: [
      //     { required: true, message: "注册电话不能为空", trigger: "blur" },
      //     { pattern: /^\d{1,11}$/, message: "只能输入不超过11位的数字" },
      //   ],
      //   registerAddress: [
      //     { required: true, message: "注册地址不能为空", trigger: "blur" },
      //   ],
      //   bankOpening: [
      //     { required: true, message: "开户银行不能为空", trigger: "blur" },
      //   ],
      //   bankAccount: [
      //     { required: true, message: "银行账号不能为空", trigger: "blur" },
      //   ],
      //   createUserName: [
      //     { required: true, message: "申请人不能为空", trigger: "blur" },
      //   ],
      //   createUserPhone: [
      //     { required: true, message: "申请人电话不能为空", trigger: "blur" },
      //     { pattern: /^\d{1,11}$/, message: "只能输入不超过11位的数字" },
      //   ],
      //   createUserTime: [
      //     { required: true, message: "申请时间不能为空", trigger: "blur" },
      //     {
      //       pattern: /^\d{4}-\d{2}-\d{2}$/,
      //       message: "日期格式必须为YYYY-MM-DD",
      //     },
      //   ],
      //   cityName: [
      //     { required: true, message: "所属地市不能为空", trigger: "blur" },
      //   ],
      //   createDeptName: [
      //     { required: true, message: "申请部门不能为空", trigger: "blur" },
      //   ],
      //   createUserEmail: [
      //     { required: true, message: "邮箱不能为空", trigger: "blur" },
      //     {
      //       pattern: /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/,
      //       message: "请输入有效的邮箱地址",
      //     },
      //   ],
      // },
    };
  },

  methods: {},
};
</script>

<style lang="scss" scoped>
@import "../../assets/css/addCommon.css";

.input {
  width: 20em;
}

.btns {
  display: flex;
  min-height: 100px;
  margin: 2em 1em 0 1em;
  background: white;
  position: relative;
  justify-content: space-evenly;
}

::v-deep .el-form {
  position: relative;
  right: 2.5em;
}
</style>
