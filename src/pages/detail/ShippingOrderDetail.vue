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
                  <div class="context">
                    {{ shipmentOrderInfo.status }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="财务:">
                  <div class="context">
                    {{ shipmentOrderInfo.accounting }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="装运单编号:">
                  <div class="context">
                    {{ shipmentOrderInfo.shipmentOrderNumber }}
                  </div>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <el-form-item label="运输类型:" prop="phone">
                  <div class="context">
                    {{ shipmentOrderInfo.type }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="始发地:">
                  <div class="context">
                    {{ shipmentOrderInfo.origin }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="收货地:">
                  <div class="context">
                    {{ shipmentOrderInfo.determine }}
                  </div>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="发货日:">
                  <div class="context">
                    {{ shipmentOrderInfo.departure }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="收货日:">
                  <div class="context">
                    {{ shipmentOrderInfo.arrival }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="托运人:">
                  <div class="context">
                    {{ shipmentOrderInfo.shipper }}
                  </div>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="收货人:">
                  <div class="context">
                    {{ shipmentOrderInfo.consignee }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="件数:">
                  <div class="context">
                    {{ shipmentOrderInfo.pcs }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="重量:">
                  <div class="context">
                    {{ shipmentOrderInfo.weight }}
                  </div>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="体积:">
                  <div class="context">
                    {{ shipmentOrderInfo.vol }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="收入:">
                  <div class="context">
                    {{ shipmentOrderInfo.income }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="支出:">
                  <div class="context">
                    {{ shipmentOrderInfo.expense }}
                  </div>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="利润:">
                  <div class="context">
                    {{ shipmentOrderInfo.profit }}
                  </div>
                </el-form-item>
              </el-col>
               <el-col :span="8">
                <el-form-item label="收货人地址:">
                  <div class="context">
                    {{ shipmentOrderInfo.consignee }}
                  </div>
                </el-form-item>
              </el-col>
            
              <el-col :span="8">
                <el-form-item label="托运人地址:">
                  <div class="context">
                    {{ shipmentOrderInfo.shipperAddress }}
                  </div>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
               <el-col :span="8">
                <el-form-item label="承运人:">
                  <div class="context">
                    {{ shipmentOrderInfo.carrier }}
                  </div>
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

        <div class="remark">
          {{ shipmentOrderInfo.remark }}
        </div>
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
                  <div class="context">
                    {{ shipmentOrderInfo.createBy }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="创建时间:">
                  <div class="context">
                    {{ shipmentOrderInfo.createTime }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="更新人:">
                  <div class="context">
                    {{ shipmentOrderInfo.updateBy }}
                  </div>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <el-form-item label="更新时间:">
                  <div class="context">
                    {{ shipmentOrderInfo.updateTime }}
                  </div>
                </el-form-item>
              </el-col>

              <el-col :span="8">
                <el-form-item label="装运单ID:">
                  <div class="context">
                    {{ shipmentOrderInfo.id }}
                  </div>
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
              name: 'ShipperEdit',
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
import { getShipmentOrderDetails } from "@/api/ShippingOrder";

export default {
  name: "ShippingOrderDetail",

  data() {
    return {
      shipmentOrderInfo: {
        remark: "",
        shipmentOrderID: "",
        status: "",
        accouting: "",
        shipmentOrders: "",
        createBy: "",
        createTime: "",
        type: "",
        departure: "",
        arrival: "",
        shipper: "",
        consignee: "",
        pcs: "",
        weight: "",
        vol: "",
        income: "",
        expense: "",
        profit: "",
        updateTime: "",
        origin: "",
        // 收货地
        determine: "",
        // 订购日
        orderDate: "",
        carrier: "",
        consigneeAddress: "",
        shipperAddress: "",
        updatedOn: "",
        updateBy: "",
        shipperNumber: "",
      },
    };
  },

  mounted() {
    // 获取详情数据，将其填写到表单中
    let data = {};
    data.id = this.$route.params.id;
    getShipmentOrderDetails(data).then((res) => {
      this.shipmentOrderInfo = res.data.data.shipmentOrderInfo;
      console.log(res);
    });
  },

  methods: {},
};
</script>

<style lang="scss" scoped>
@import "../../assets/css/MainInformation.css";
</style>
