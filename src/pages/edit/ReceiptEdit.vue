<template>
  <div class="bg">
    <!-- 主要内容 -->
    <main class="add-main">
      <el-tabs v-model="activeName" type="card">
        <el-tab-pane label="主要资料" name="first">
          <!-- 卡片一  -->
          <el-card class="whiteCard">
            <div slot="header" class="clearfix">
              <span class="CardTitle">主要信息</span>
            </div>

            <div>
              <el-form
                ref="form"
                :model="form"
                :rules="rules"
                label-width="10em"
              >
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
                        v-model="Accouting"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="收据编号:">
                      <el-input
                        v-model="Receipt"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row>
                  <el-col :span="8">
                    <el-form-item label="开具时间:">
                      <el-input
                        v-model="ReceiptTime"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
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
                    <el-form-item label="件数:">
                      <el-input
                        v-model="PCS"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="重量:">
                      <el-input
                        v-model="Weight"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                </el-row>

                <el-row>
                  <el-col :span="8">
                    <el-form-item label="体积:">
                      <el-input
                        v-model="VOL"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="注意事项:">
                      <el-input
                        v-model="Handing"
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
                </el-row>

                <el-row>
                  <el-col :span="8">
                    <el-form-item label="支出:">
                      <el-input
                        v-model="Expense"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="利润:">
                      <el-input
                        v-model="Profit"
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

             <div>
              <el-input
                type="textarea"
                :rows="4"
                placeholder="请输入内容"
                v-model="textarea"
                maxlength="600"
                show-word-limit
              >
              </el-input>
            </div>
          </el-card>

          <!-- 卡片三  -->
          <el-card class="whiteCard">
            <div slot="header" class="clearfix">
              <span class="CardTitle">其他</span>
            </div>

            <div>
              <el-form
                ref="form"
                :model="form"
                :rules="rules"
                label-width="10em"
              >
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
                    <el-form-item label="收据ID:">
                      <el-input
                        v-model="ReceiptID"
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
         <!-- 商品库存 -->
        <el-tab-pane label="商品" name="second">
          <sim-quote></sim-quote>
        </el-tab-pane>
        <!-- 费用明细 -->
        <el-tab-pane label="费用明细" name="third">
          <sim-charges></sim-charges>
        </el-tab-pane>
        <!-- 任务 -->
        <el-tab-pane label="任务" name="fourth">
          <sim-task></sim-task>
        </el-tab-pane>
      </el-tabs>
    </main>

    <!-- 底部栏 -->
    <footer class="btns">
      <div style="margin-top: 2em">
        <el-button type="primary" @click="submitForm('form')"
          >保存提交</el-button
        >
        <el-button type="primary" plain @click="$router.push({ path: '/receipt' })"
          >返回</el-button
        >
      </div>
    </footer>
  </div>
</template>
<script>
export default {
  name: "ReceiptEdit",

  data() {
    return {
      activeName:"first",
      ReceiptID: "",
      Status: "",
      Accounting: "",
      Receipt: "",
      CreatedBy: "",
      CreatedOn: "",
      ReceiptTime: "",
      Shipper: "",
      Consignee: "",
      Project: "",
      PCS: "",
      Weight: "",
      VOL: "",
      // 注意事项
      Handing: "",
      Expense: "",
      Profit: "",
      UpdateOn: "",
      ServiceType: "",
      Commodity: "",
      IssuingCompany: "",
      ShipperAddress: "",
      ConsigneeAddress: "",
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
