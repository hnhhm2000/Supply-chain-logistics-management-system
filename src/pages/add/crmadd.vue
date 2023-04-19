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
                <el-form-item label="客户名称" prop="name">
                  <el-input
                    v-model="name"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="密码" prop="password">
                  <el-input
                    v-model="password"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="角色" prop="role">
                  <el-select v-model="role" placeholder="请选择" class="select">
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
                <el-form-item label="电子邮箱" prop="email">
                  <el-input
                    v-model="email"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="状态" prop="isDisabled">
                  <el-input
                    v-model="isDisabled"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="联系人及电话" prop="phone">
                  <el-input
                    v-model="phone"
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
                <el-form-item label="主要地址" prop="address">
                  <el-input
                    v-model="address"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="账单地址" prop="address">
                  <el-input
                    v-model="address"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="注册电话" prop="phone">
                  <el-input
                    v-model="phone"
                    size="small"
                    class="input"
                    :maxlength="11"
                  ></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <el-form-item label="省/市" prop="province">
                  <div class="flex">
                    <el-select
                      v-model="province"
                      multiple
                      placeholder="请选择"
                      style="width: 10em"
                    >
                      <el-option
                        v-for="item in provinces"
                        :key="item.value"
                        :label="item.label"
                        :value="item.value"
                      >
                      </el-option>
                    </el-select>
                     
                    <el-select
                      v-model="city"
                      multiple
                      collapse-tags
                      style="margin-left: 20px; width: 10em"
                      placeholder="请选择"
                    >
                      <el-option
                        v-for="item in cities"
                        :key="item.value"
                        :label="item.label"
                        :value="item.value"
                      >
                      </el-option>
                    </el-select>
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="开户银行" prop="salesAgency">
                  <el-input
                    v-model="salesAgency"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="银行账号" prop="id">
                  <el-input v-model="id" size="small" class="input"></el-input>
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
            v-model="remark"
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
                <el-form-item label="操作人" prop="createBy">
                  <el-input
                    v-model="createBy"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="付款方式" prop="createBy">
                  <el-input
                    v-model="createBy"
                    size="small"
                    class="input"
                    :maxlength="11"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="销售代表" prop="salesAgency">
                  <el-input
                    v-model="salesAgency"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <el-form-item label="更新时间" prop="updateTime">
                  <el-input
                    v-model="updateTime"
                    size="small"
                    class="input"
                    :maxlength="11"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="邮编" prop="zip">
                  <el-input v-model="zip" size="small" class="input"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="身份证号码" prop="id">
                  <el-input v-model="id" size="small" class="input"></el-input>
                </el-form-item>
              </el-col>
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
      name: "",
      password: "",
      role: "",
      email: "",
      isDisabled: "",
      // phone: "",

      // 纳税人信息
      address: "",
      city: "",
      phone: "",
      province: "",
      salesAgency: "",
      id: "",

      // 操作人信息
      isDeleted: "",
      createBy: "",
      createTime: "",
      // city: "",
      zip: "",
      // email: "",

      options: [
        {
          value: "选项1",
          label: "客户",
        },
        {
          value: "选项2",
          label: "托运人",
        },
        {
          value: "选项3",
          label: "收货人",
        },
        {
          value: "选项4",
          label: "承运人",
        },
      ],
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
