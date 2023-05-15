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
          <el-form ref="form" :model="form" :rules="rules" label-width="10em">
            <el-row>
              <el-col :span="8">
                <el-form-item label="状态:"> </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="财务:"> </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="海运编号:"> </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="启航日:"> </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="抵达日:"> </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="收货港:"> </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="发货港:"> </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="收货日:"> </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="收货地点:"> </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="托运人:"> </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="收货人:"> </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="件数:"> </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="重量:"> </el-form-item>
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
              <el-col :span="8">
                <el-form-item label="装载日期:"> </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="备注:"> </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="项目:"> </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="承运人:"> </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="商品名:"> </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="最大容量:"> </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="客户:"> </el-form-item>
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

        <div></div>
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
                <el-form-item label="创建人:"> </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="创建时间:"> </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="更新人:"> </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="更新时间:"> </el-form-item>
              </el-col>

              <el-col :span="8">
                <el-form-item label="海运ID:"> </el-form-item>
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
  name: "BillAdd",

  data() {
    return {
      InvoiceID: "",
      Number: "",
      CreatedBy: "",
      createTime: "",
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
</style>
