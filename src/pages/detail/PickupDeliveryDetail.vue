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
                    {{ pickupDeliveryInfo.status }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="财务:">
                  <div class="context">
                    {{ pickupDeliveryInfo.accounting }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="编号:">
                  <div class="context">
                    {{ pickupDeliveryInfo.pickupDeliveryNumber }}
                  </div>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <el-form-item label="提货日期:">
                  <div class="context">
                    {{ pickupDeliveryInfo.pickupDate }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="发货日期:">
                  <div class="context">
                    {{ pickupDeliveryInfo.deliveryDate }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="利润:">
                  <div class="context">
                    {{ pickupDeliveryInfo.profit }}
                  </div>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="托运人:">
                  <div class="context">
                    {{ pickupDeliveryInfo.shipper }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="收货人:">
                  <div class="context">
                    {{ pickupDeliveryInfo.consignee }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="提货人:">
                  <div class="context">
                    {{ pickupDeliveryInfo.pickupFrom }}
                  </div>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="送货人:">
                  <div class="context">
                    {{ pickupDeliveryInfo.deliveryTo }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="承运人:">
                  <div class="context">
                    {{ pickupDeliveryInfo.carrier }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="客户:">
                  <div class="context">
                    {{ pickupDeliveryInfo.customer }}
                  </div>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="件数:">
                  <div class="context">
                    {{ pickupDeliveryInfo.pcs }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="价格:">
                  <div class="context">
                    {{ pickupDeliveryInfo.price }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="重量:">
                  <div class="context">
                    {{ pickupDeliveryInfo.weight }}
                  </div>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="体积:">
                  <div class="context">
                    {{ pickupDeliveryInfo.vol }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="收入:">
                  <div class="context">
                    {{ pickupDeliveryInfo.income }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="支出:">
                  <div class="context">
                    {{ pickupDeliveryInfo.expense }}
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
          <span class="CardTitle">详细信息</span>
        </div>

        <div>
          <el-form ref="form" :model="form" :rules="rules" label-width="10em">
            <el-row>
              <el-col :span="8">
                <el-form-item label="发出公司:" prop="address">
                  <div class="context">
                    {{ pickupDeliveryInfo.issuingCompanyName }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="托运人地址:" prop="address">
                  <div class="context">
                    {{ pickupDeliveryInfo.shipperAddress }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="收货人地址:" prop="address">
                  <div class="context">
                    {{ pickupDeliveryInfo.consigneeAddress }}
                  </div>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <el-form-item label="运输方式:" prop="province">
                  <div class="context">
                    {{ pickupDeliveryInfo.type }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="商品名称:" prop="salesAgency">
                  <div class="context">
                    {{ pickupDeliveryInfo.commodity }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="注意事项:" prop="id">
                  <div class="context">
                    {{ pickupDeliveryInfo.notes }}
                  </div>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="货物概述:" prop="province">
                  <div class="context">
                    {{ pickupDeliveryInfo.description }}
                  </div>
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

        <div class="context">
          {{ pickupDeliveryInfo.remark }}
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
                  <div class="context">
                    {{ pickupDeliveryInfo.createBy }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="创建时间:">
                  <div class="context">
                    {{ pickupDeliveryInfo.createTime }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="更新人:">
                  <div class="context">
                    {{ pickupDeliveryInfo.updateBy }}
                  </div>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="更新时间:">
                  <div class="context">
                    {{ pickupDeliveryInfo.updateTime }}
                  </div>
                </el-form-item>
              </el-col>

              <el-col :span="8">
                <el-form-item label="预计到达时间:">
                  <div class="context">
                    {{ pickupDeliveryInfo.eta }}
                  </div>
                </el-form-item>
              </el-col>

              <el-col :span="8">
                <el-form-item label="预计发货时间:">
                  <div class="context">
                    {{ pickupDeliveryInfo.etd }}
                  </div>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="货物签收时间:">
                  <div class="context">
                    {{ pickupDeliveryInfo.podDate}}
                  </div>
                </el-form-item>
              </el-col>

              <el-col :span="8">
                <el-form-item label="提货送货ID:">
                  <div class="context">
                    {{ pickupDeliveryInfo.id }}
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
              name: 'PickupDeliveryEdit',
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
import { getPickupDeliveryDetail } from "@/api/PickupDelivery";

export default {
  name: "PickuoDeliveryDetail",

  data() {
    return {
      pickupDeliveryInfo: {},
    };
  },

  methods: {},

  mounted() {
    // 获取详情数据，将其填写到表单中
    let data = {};
    data.id = this.$route.params.id;
    getPickupDeliveryDetail(data).then((res) => {
      this.pickupDeliveryInfo = res.data.data.pickupDeliveryInfo;
      console.log(res);
    });
  },
};
</script>

<style lang="scss" scoped>
@import "../../assets/css/MainInformation.css";
</style>
