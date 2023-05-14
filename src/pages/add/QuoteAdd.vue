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
                <el-form-item label="状态:">
                  <el-input
                    v-model="Status"
                     size="small"
                    class="input"
                    placeholder="请输入内容"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="活动:">
                  <el-input
                    v-model="Activity"
                     size="small"
                    class="input"
                    placeholder="请输入内容"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="报价编号:">
                  <el-input
                    v-model="QuoteNumber"
                     size="small"
                    class="input"
                    placeholder="请输入内容"
                  ></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <el-form-item label="商业项目:">
                  <el-input
                    v-model="Project"
                     size="small"
                    class="input"
                    placeholder="请输入内容"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="报价者:">
                  <el-input
                    v-model="IssuingCompanyName"
                     size="small"
                    class="input"
                    placeholder="请输入内容"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="创建日期:" prop="phone">
                  <el-input
                    v-model="CreatedDate"
                     size="small"
                    class="input"
                    placeholder="请输入内容"
                  ></el-input>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="截止日期:">
                  <el-input
                    v-model="UntilDate"
                     size="small"
                    class="input"
                    placeholder="请输入内容"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="客户:">
                  <el-input
                    v-model="Customer"
                     size="small"
                    class="input"
                    placeholder="请输入内容"
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
              <span class="CardTitle">货物相关</span>
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
                    <el-form-item label="客户地址:">
                      <el-input
                        v-model="CustomerAddress"
                        size="small"
                        class="input"
                        placeholder="请输入内容"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="货物描述:">
                      <el-input
                        v-model="DescriptionOfGoods"
                        size="small"
                        class="input"
                        placeholder="请输入内容"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="始发地:">
                      <el-input
                        v-model="input"
                        size="small"
                        class="input"
                        placeholder="请输入内容"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                </el-row>

                <el-row>
                  <el-col :span="8">
                    <el-form-item label="目的地:">
                      <el-input
                        v-model="Origin"
                        size="small"
                        class="input"
                        placeholder="请输入内容"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="运输方式:">
                      <el-input
                        v-model="Mode"
                        size="small"
                        class="input"
                        placeholder="请输入内容"
                      ></el-input>
                    </el-form-item>
                  </el-col>

                  <el-col :span="8">
                    <el-form-item label="付款方式:">
                      <el-input
                        v-model="PaymentTerm"
                        size="small"
                        class="input"
                        placeholder="请输入内容"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                </el-row>

                <el-row>
                  <el-col :span="8">
                    <el-form-item label="运输天数:">
                      <el-input
                        v-model="TransitDays"
                        size="small"
                        class="input"
                        placeholder="请输入内容"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="个数/件数:">
                      <el-input
                        v-model="PCS"
                        size="small"
                        class="input"
                        placeholder="请输入内容"
                      ></el-input
                    ></el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="重量:">
                      <el-input
                        v-model="Weight"
                        size="small"
                        class="input"
                        placeholder="请输入内容"
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
                        placeholder="请输入内容"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="收入:">
                      <el-input
                        v-model="Income"
                        size="small"
                        class="input"
                        placeholder="请输入内容"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="支出:">
                      <el-input
                        v-model="Expense"
                        size="small"
                        class="input"
                        placeholder="请输入内容"
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
                        placeholder="请输入内容"
                      ></el-input>
                    </el-form-item>
                  </el-col>

                  <el-col :span="8">
                    <el-form-item label="托运人:">
                      <el-input
                        v-model="Shipper"
                        size="small"
                        class="input"
                        placeholder="请输入内容"
                      ></el-input>
                    </el-form-item>
                  </el-col>

                  <el-col :span="8">
                    <el-form-item label="承运人:">
                      <el-input
                        v-model="Carrier"
                        size="small"
                        class="input"
                        placeholder="请输入内容"
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
                maxlength="600"
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
          <el-form ref="form" :model="form" :rules="rules" label-width="10em">
            <el-row>
              <el-col :span="8">
                <el-form-item label="创建人:">
                  <el-input
                    v-model="CreatedBy"
                    size="small"
                    class="input"
                    placeholder="请输入内容"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="创建时间:">
                  <el-input
                    v-model="CreatedOn"
                    size="small"
                    class="input"
                    placeholder="请输入内容"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="更新人:">
                  <el-input
                    v-model="UpdatedBy"
                    size="small"
                    class="input"
                    placeholder="请输入内容"
                  ></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <el-form-item label="更新时间:">
                  <el-input
                    v-model="UpdatedOn"
                    size="small"
                    class="input"
                    placeholder="请输入内容"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="空运ID:">
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
      Status: "",
      Activity: "",
      QuoteNumber: "",
      Project: "",
      Mode: "",
      CreatedDate: "",
      UntilDate: "",
      Customer: "",
      Shipper: "",
      Origin: "",
      Destination: "",
      Carrier: "",
      IssuingCompanyName: "",
      CustomerAddress: "",
      DescriptionOfGoods: "",
      PCS: "",
      Weight: "",
      VOL: "",
      Income: "",
      Expense: "",
      Profit: "",
      Remarks: "",
      CreatedBy: "",
      CreatedOn: "",
      UpdatedBy: "",
      UpdatedOn: "",
      PaymentTerm: "",
      TransitDays: "",
      PickupAddress: "",
      DeliverAddress: "",

      options: [
        {
          value: "选项1",
          label: "账户",
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
@import "../../assets/css/MainInformation.css";

.input {
  width: 20em;
}
</style>
