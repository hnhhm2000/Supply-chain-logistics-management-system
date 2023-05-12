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
                <el-form-item label="状态:">
                  <el-input
                    v-model="Status"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="财务:">
                  <el-input
                    v-model="Accounting"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="海运编号:">
                  <el-input
                    v-model="ShipmentNumber"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="启航日:">
                  <el-input
                    v-model="Departure"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="抵达日:">
                  <el-input
                    v-model="Arrival"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="收货港:">
                  <el-input
                    v-model="PortOfReceipt"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="发货港:">
                  <el-input
                    v-model="PortOfOrigin"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="收货日:">
                  <el-input
                    v-model="PlaceOfDate"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="收货地点:">
                  <el-input
                    v-model="PlaceOfDelivery"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="托运人:">
                  <el-input
                    v-model="Shipper"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="收货人:">
                  <el-input
                    v-model="Consignee"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="件数:">
                  <el-input v-model="PCS" size="small" class="input"></el-input>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="重量:">
                  <el-input
                    v-model="Weight"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="收入:">
                  <el-input
                    v-model="Income"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="支出:">
                  <el-input
                    v-model="Expense"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="利润:">
                  <el-input
                    v-model="Profit"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="装载日期:">
                  <el-input
                    v-model="LoadingDate"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="备注:">
                  <el-input
                    v-model="Remark"
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
                <el-form-item label="承运人:">
                  <el-input
                    v-model="Carrier"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="商品名:">
                  <el-input
                    v-model="Commodity"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
            </el-row>

             <el-row>
              <el-col :span="8">
                <el-form-item label="最大容量:">
                  <el-input
                    v-model="MaxPieces"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="客户:">
                  <el-input
                    v-model="Customer"
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
                <el-form-item label="海运ID:">
                  <el-input
                    v-model="OceanID"
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
        <el-button type="primary" plain @click="$router.push({ path: '/crm' })"
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
