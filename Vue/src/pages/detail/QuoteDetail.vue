<template>
  <div class="bg">
    <!-- 主要内容 -->
    <main class="add-main">
      <!-- 卡片一  -->
      <el-card class="whiteCard">
        <div slot="header" class="clearfix">
          <span class="CardTitle">主要信息</span>
        </div>

        <div>
          <el-form
            ref="formCustomers"
            :model="Customers"
            
            label-width="10em"
          >
            <el-row>
              <el-col :span="8">
                <el-form-item label="状态:"> </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="活动:"> </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="报价编号:"> </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <el-form-item label="项目:"> </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="运输方式:" prop="isDisabled">
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="创建日期:" prop="phone"> </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="截止日期:"> </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="客户:"> </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="托运人:"> </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="始发地:"> </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="目的地:"> </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="承运人:"> </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="报价者:"> </el-form-item>
              </el-col>
            </el-row>
          </el-form>
        </div>
      </el-card>

      <!-- 卡片二  -->
      <el-card class="whiteCard">
        <div slot="header" class="clearfix">
          <span class="CardTitle">货物相关</span>
        </div>

        <div>
          <el-form
            ref="formTaxpayers"
            :model="Taxpayers"
            
            label-width="10em"
          >
            <el-row>
              <el-col :span="8">
                <el-form-item label="客户地址:"> </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="货物描述:"> </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="始发地:"> </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="目的地:"> </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="运输方式:"> </el-form-item>
              </el-col>

              <el-col :span="8">
                <el-form-item label="付款方式:"> </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="运输天数:"> </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="个数/件数:"> </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="重量:"> </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="体积:"> </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="收入:"> </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="支出:"> </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="利润:"> </el-form-item>
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

        <div class="remarks">
        
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
            
            label-width="10em"
          >
            <el-row>
              <el-col :span="8">
                <el-form-item label="创建人:" prop="createBy"> </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="创建时间:" prop="createBy"> </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="更新人:" prop="salesAgency">
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <el-form-item label="更新时间:" prop="updateTime">
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="报价ID:" prop="zip"> </el-form-item>
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
              name: 'CrmEdit',
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
  name: "CrmDetail",

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
@import "../../assets/css/MainInformation.css";


</style>
