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
                <el-form-item label="货物编号:">
                <el-input
                    v-model="Number"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <el-form-item label="提单:">
                  <el-input
                    v-model="BillOfLading"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="提货日期:">
                 <el-input
                    v-model="PickupFrom"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="发货日期:">
                  <el-input
                    v-model="DeliveryDate"
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
                <el-form-item label="提货人:">
                <el-input
                    v-model="PickupFrom"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="送货人:">
                <el-input
                    v-model="DeliveryTo"
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
                <el-form-item label="客户:">
                   <el-input
                    v-model="Customers"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
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
                <el-form-item label="价格:">
                   <el-input
                    v-model="Value"
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
                <el-form-item label="创造者:">
                 <el-input
                    v-model="CreatedBy"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="创造时间:">
                 <el-input
                    v-model="CreatedOn"
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
          <span class="CardTitle">详细信息</span>
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
                <el-form-item label="发出公司:" prop="address">
                  <el-input
                    v-model="IssuingCompanyName"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="托运人地址:" prop="address">
                  <el-input
                    v-model="ShipperAddresse"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="收货人地址:" prop="address">
                  <el-input
                    v-model="ConsigneeAddress"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <el-form-item label="运输方式:" prop="province">
                   <el-input
                    v-model="Type"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="商品名称:"  prop="salesAgency">
                  <el-input
                    v-model="Commodity"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="注意事项:" prop="id">
                  <el-input
                    v-model="Notes"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="24">
                <el-form-item label="货物描述:" prop="province">
                   <el-input
                    v-model="Description"
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

        <div class="remark"></div>
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
                    v-model="name"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="创建时间:">
                 <el-input
                    v-model="name"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="更新人:">
                 <el-input
                    v-model="name"
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
                    v-model="name"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>

              <el-col :span="8">
                <el-form-item label="预计到达时间:">
                 <el-input
                    v-model="ETA"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>

                <el-col :span="8">
                <el-form-item label="预计发货时间:">
                 <el-input
                    v-model="ETD"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="货物签收时间:">
                 <el-input
                    v-model="PodDate"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>

                <el-col :span="8">
                <el-form-item label="提货送货ID:">
                 <el-input
                    v-model="name"
                    size="small"
                    class="input"
                    disabled
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
  name: "ShippingOrderAdd",

  data() {
    return {
     Status:"",
     Accouting:"",
     Number:"",
     BillOfLading:"",
     PickupDate:"",
     DeliveryDate:"",
     Shipper:"",
     Consignee:"",
     PickupFrom:"",
     DeliveryTo:"",
     Carrier:"",
     PCS:"",
     Value:"",
     Income:"",
     Expense:"",
     Profit:"",
     CreatedBy:"",
     CreatedOn:"",
     UpdatedBy:"",
     UpdatedOn:"",
     // 预计到达时间
     ETA:"",
     // 预计发货时间
     ETD:"",
     // 货物签收时间
     PodDate:"",
     Remarks:"",
     // 发出公司名称
     IssuingCompanyName:"",
     ShipperAddress:"",
     ConsigneeAddress:"",
     Type:"",
     Commodity:"",
     // 注意事项
     Notes:"",
     Description:""
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
