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
                
                label-width="10em"
              >
                <el-row>
                  <el-col :span="8">
                    <el-form-item label="状态:">
                      <el-select
                        v-model="pickupDeliveryInfo.status"
                        placeholder="请选择"
                        style="width: 17.6em"
                        size="small"
                      >
                        <el-option
                          v-for="item in StatusOp"
                          :key="item.value"
                          :label="item.label"
                          :value="item.value"
                        >
                        </el-option>
                      </el-select>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="财务:">
                      <el-input
                        v-model="pickupDeliveryInfo.accounting"
                        size="small"
                        class="input"
                        disabled
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="编号:">
                      <el-input
                        v-model="pickupDeliveryInfo.pickupDeliveryNumber"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row>
                  <el-col :span="8">
                    <el-form-item label="提货日期:">
                      <el-date-picker
                        v-model="pickupDeliveryInfo.pickupDate"
                        type="date"
                        placeholder="选择日期"
                        size="small"
                        class="input"
                      >
                      </el-date-picker>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="发货日期:">
                      <el-date-picker
                        v-model="pickupDeliveryInfo.deliveryDate"
                        type="date"
                        placeholder="选择日期"
                        size="small"
                        class="input"
                      >
                      </el-date-picker>
                    </el-form-item>
                  </el-col>

                  <el-col :span="8">
                    <el-form-item label="利润:">
                      <el-input
                        v-model="pickupDeliveryInfo.profit"
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
                        v-model="pickupDeliveryInfo.shipper"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="收货人:">
                      <el-input
                        v-model="pickupDeliveryInfo.consignee"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="提货人:">
                      <el-input
                        v-model="pickupDeliveryInfo.pickupFrom"
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
                        v-model="pickupDeliveryInfo.deliveryTo"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="承运人:">
                      <el-input
                        v-model="pickupDeliveryInfo.carrier"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="客户:">
                      <el-input
                        v-model="pickupDeliveryInfo.customer"
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
                        v-model="pickupDeliveryInfo.pcs"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="价格:">
                      <el-input
                        v-model="pickupDeliveryInfo.price"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="重量:">
                      <el-input
                        v-model="pickupDeliveryInfo.weight"
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
                        v-model="pickupDeliveryInfo.vol"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="收入:">
                      <el-input
                        v-model="pickupDeliveryInfo.income"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="支出:">
                      <el-input
                        v-model="pickupDeliveryInfo.expense"
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
                
                label-width="10em"
              >
                <el-row>
                  <el-col :span="8">
                    <el-form-item label="发出公司:" prop="address">
                      <el-input
                        v-model="pickupDeliveryInfo.issuingCompanyName"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="托运人地址:" prop="address">
                      <el-input
                        v-model="pickupDeliveryInfo.shipperAddress"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="收货人地址:" prop="address">
                      <el-input
                        v-model="pickupDeliveryInfo.consigneeAddress"
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
                        v-model="pickupDeliveryInfo.type"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="商品名称:" prop="salesAgency">
                      <el-input
                        v-model="pickupDeliveryInfo.commodity"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="注意事项:" prop="id">
                      <el-input
                        v-model="pickupDeliveryInfo.notes"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                </el-row>

                <el-row>
                  <el-col :span="8">
                    <el-form-item label="货物描述:" prop="province">
                      <el-input
                        v-model="pickupDeliveryInfo.description"
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

            <div>
              <el-input
                type="textarea"
                :rows="4"
                placeholder="请输入内容"
                v-model="pickupDeliveryInfo.remarks"
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
              <el-form
                ref="form"
                :model="form"
                
                label-width="10em"
              >
                <el-row>
                  <el-col :span="8">
                    <el-form-item label="创建人:">
                      <el-input
                        v-model="pickupDeliveryInfo.createBy"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="创建时间:">
                      <el-date-picker
                        v-model="pickupDeliveryInfo.createTime"
                        type="datetime"
                        placeholder="选择日期"
                        size="small"
                        class="input"
                      >
                      </el-date-picker>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="更新人:">
                      <el-input
                        v-model="pickupDeliveryInfo.updateBy"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                </el-row>

                <el-row>
                  <el-col :span="8">
                    <el-form-item label="更新时间:">
                      <el-date-picker
                        v-model="pickupDeliveryInfo.updateTime"
                        type="datetime"
                        placeholder="选择日期"
                        size="small"
                        class="input"
                      >
                      </el-date-picker>
                    </el-form-item>
                  </el-col>

                  <el-col :span="8">
                    <el-form-item label="预计到达时间:">
                      <el-date-picker
                        v-model="pickupDeliveryInfo.eta"
                        type="date"
                        placeholder="选择日期"
                        size="small"
                        class="input"
                      >
                      </el-date-picker>
                    </el-form-item>
                  </el-col>

                  <el-col :span="8">
                    <el-form-item label="预计发货时间:">
                      <el-date-picker
                        v-model="pickupDeliveryInfo.etd"
                        type="date"
                        placeholder="选择日期"
                        size="small"
                        class="input"
                      >
                      </el-date-picker>
                    </el-form-item>
                  </el-col>
                </el-row>

                <el-row>
                  <el-col :span="8">
                    <el-form-item label="货物签收时间:">
                      <el-date-picker
                        v-model="pickupDeliveryInfo.podDate"
                        type="date"
                        placeholder="选择日期"
                        size="small"
                        class="input"
                      >
                      </el-date-picker>
                    </el-form-item>
                  </el-col>

                  <el-col :span="8">
                    <el-form-item label="提货送货ID:">
                      <el-input
                        v-model="pickupDeliveryInfo.id"
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
        <el-button type="primary" @click="submit()">保存提交</el-button>
        <el-button
          type="primary"
          plain
          @click="$router.push({ path: '/pickupdelivery' })"
          >返回</el-button
        >
      </div>
    </footer>
  </div>
</template>
<script>
import {
  updatePickupDeliveryData,
  getPickupDeliveryDetail,
} from "@/api/PickupDelivery";

export default {
  name: "PickupDeliveryEdit",

  data() {
    return {
      activeName: "first",

      pickupDeliveryInfo: {
       
      },

       StatusOp: [
          {
            value: "请求中",
            label: "请求中",
          },
          {
            value: "请求中",
            label: "正在调度",
          },
          {
            value: "暂停中",
            label: "暂停中",
          },
          {
            value: "已提货",
            label: "已提货",
          },
          {
            value: "运输中",
            label: "运输中",
          },
          {
            value: "晚点",
            label: "晚点",
          },
          {
            value: "已收货",
            label: "已收货",
          },
          {
            value: "完成",
            label: "完成",
          },
        ],
    };
  },

  methods: {
    // 提交编辑，根据id进行编辑
    submit() {
      let data = {};
      data = this.pickupDeliveryInfo;
      
      // 格式化创建日期/更新日期数据
      data.createTime = this.formatDate(data.createTime);
      data.updateTime = this.formatDate(data.updateTime);

      updatePickupDeliveryData(data).then((res) => {
        if (res.data.code === 200) {
          this.$message.success("编辑成功");
          this.$router.push({ path: "/pickupdelivery" });
        }
      });
    },

     // 格式化时间
    formatDate(dateString) {
      const date = new Date(dateString);
      const year = date.getFullYear();
      const month = String(date.getMonth() + 1).padStart(2, "0");
      const day = String(date.getDate()).padStart(2, "0");
      const hours = String(date.getHours()).padStart(2, "0");
      const minutes = String(date.getMinutes()).padStart(2, "0");
      const seconds = String(date.getSeconds()).padStart(2, "0");

      return `${year}-${month}-${day} ${hours}:${minutes}:${seconds}`;
    },
    
  },

  // 打开页面时，显示所有已有数据
  created() {
    let data = {};
    data.id = this.$route.params.id;
    getPickupDeliveryDetail(data).then((res) => {
      this.pickupDeliveryInfo = res.data.data.pickupDeliveryInfo;
    });
  },
};
</script>

<style lang="scss" scoped>
@import "../../assets/css/MainInformation.css";

.input {
  width: 19em;
}
</style>
