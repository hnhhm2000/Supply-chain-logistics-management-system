<template>
  <div class="bg">
    <!-- 主要内容 -->
    <main class="add-main">
      <!-- 卡片一  -->
      <el-card class="whiteCard">
        <div slot="header" class="clearfix">
          <span class="CardTitle">账户信息</span>
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
                <el-form-item label="账户名称:" prop="name">
                 
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="密码:" prop="password">
                  
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="角色:" prop="role">
                
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <el-form-item label="电子邮箱:" prop="email">
                
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="状态:" prop="isDisabled">
                 
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="联系人及电话:" prop="phone">
                 
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
                <el-form-item label="主要地址:" prop="address">
                 
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="账单地址:" prop="address">
                 
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="注册电话:" prop="phone">
                 
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <el-form-item label="省/市:" prop="province">
                  
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="开户银行:"  prop="salesAgency">
                 
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="银行账号:" prop="id">
                 
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

        <div class="remark">
        
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
                <el-form-item label="操作人:" prop="createBy">
                
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="付款方式:" prop="createBy">
               
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="销售代表:" prop="salesAgency">
                 
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <el-form-item label="更新时间:" prop="updateTime">
                 
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="邮编:" prop="zip">
                 
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="身份证号码:" prop="id">
                 
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
        <el-button
            type="primary"
            @click="
              $router.push({
                name: 'crmEdit',
                params: { id: $route.params.id },
              })
            "
            >编辑内容</el-button
          >
        <el-button type="primary" plain @click="$router.back()">返回</el-button>
      </div>
    </footer>
  </div>
</template>
<script>
// import axios from "axios";

export default {
  name: 'CrmDetail',

  data() {
    return {
      textarea: "",
      // 账户信息
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

    };
  },

  methods: {},
};
</script>

<style lang="scss" scoped>
@import "../../assets/css/addCommon.css";

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
