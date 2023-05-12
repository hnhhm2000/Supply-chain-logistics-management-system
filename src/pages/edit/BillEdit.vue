<template>
  <div class="bg">
    <!-- 主要内容 -->
    <main class="add-main">
      <el-tabs v-model="activeName" type="card">
        <el-tab-pane label="发票资料" name="first">
         <!-- 卡片一  -->
      <el-card class="whiteCard">
        <div slot="header" class="clearfix">
          <span class="CardTitle">主要信息</span>
        </div>

        <div>
          <el-form ref="form" :model="form" :rules="rules" label-width="10em">
            <el-row>
              <el-col :span="8">
                <el-form-item label="号码:">
                  <el-input
                    v-model="Number"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="类型:">
                  <el-input
                    v-model="Type"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="关联模块:">
                  <el-input
                    v-model="Module"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="项目:">
                  <el-input
                    v-model="Project"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="日期:">
                  <el-input
                    v-model="Date"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="供应商:">
                  <el-input
                    v-model="Vendor"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="截止日期:">
                  <el-input
                    v-model="DueDate"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="总额:">
                  <el-input
                    v-model="TotalAmount"
                    size="small"
                    class="input"
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
          <span class="CardTitle">备注说明</span>
        </div>

        <div class="remark"></div>
      </el-card>

      <!-- 卡片三  -->
      <el-card class="whiteCard">
        <div slot="header" class="clearfix">
          <span class="CardTitle">其他</span>
        </div>

        <div>
          <el-form ref="form" :model="form" :rules="rules" label-width="10em">
            <el-row>
              <el-col :span="8">
                <el-form-item label="创建人:">
                  <el-input
                    v-model="CreatedBy"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="创建时间:">
                  <el-input
                    v-model="CreatedOn"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="更新人:">
                  <el-input
                    v-model="UpdateBy"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="更新时间:">
                  <el-input
                    v-model="UpdateOn"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>

              <el-col :span="8">
                <el-form-item label="账单ID:">
                  <el-input
                    v-model="AirID"
                    disabled
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-form>
        </div>
      </el-card>
        </el-tab-pane>
        <!-- 报价 -->
        <el-tab-pane label="报价" name="second">
          <SimQuote></SimQuote>
        </el-tab-pane>
        <!-- 库存 -->
        <el-tab-pane label="库存" name="third">
          <SimInventory></SimInventory>
        </el-tab-pane>
        <!-- 运输 -->
        <el-tab-pane label="运输" name="fourth">
          <SimShippment></SimShippment>
        </el-tab-pane>
        <!-- 财务相关 -->
        <el-tab-pane label="财务相关" name="fifth">
          <SimAccounting></SimAccounting>
        </el-tab-pane>
      </el-tabs>
    </main>

    <!-- 底部栏 -->
    <footer class="btns">
      <div style="margin-top: 2em">
        <el-button type="primary" @click="submitForm('form')"
          >保存提交</el-button
        >
        <el-button type="primary" plain @click="$router.push({ path: '/bill' })"
          >返回</el-button
        >
      </div>
    </footer>
  </div>
</template>
<script>
export default {
  name: "BillEdit",

  data() {
    return {
      InvoiceID: "",
      Number: "",
      CreatedBy: "",
      CreatedOn: "",
      Type: "",
      // 管理模块
      Module: "",
      Project: "",
      Date: "",
      // 供应商
      Vendor: "",
      DueDate: "",
      TotalAmount: "",
      Remarks: "",
    };
  },

  methods: {},
};
</script>

<style lang="scss" scoped>
@import "../../assets/css/MainInformation.css";

.input {
  width: 19em;
}
</style>
