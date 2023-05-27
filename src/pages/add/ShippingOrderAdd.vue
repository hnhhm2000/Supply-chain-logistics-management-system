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
                  <el-select
                    v-model="status"
                    placeholder="请选择"
                    style="width: 18.6em"
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
                    v-model="accouting"
                    size="small"
                    class="input"
                    disabled
                    placeholder="请输入内容"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="装运单编号:">
                  <el-input
                    v-model="shipperNumber"
                    size="small"
                    class="input"
                    placeholder="请输入内容"
                  ></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <el-form-item label="运输类型:">
                  <el-select
                    v-model="type"
                    placeholder="请选择"
                    style="width: 18.6em"
                    size="small"
                  >
                    <el-option
                      v-for="item in Types"
                      :key="item.value"
                      :label="item.label"
                      :value="item.value"
                    >
                    </el-option>
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="始发地:">
                  <el-input
                    v-model="origin"
                    size="small"
                    class="input"
                    placeholder="请输入内容"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="收货地:">
                  <el-input
                    v-model="determine"
                    size="small"
                    class="input"
                    placeholder="请输入内容"
                  ></el-input>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="发货日:">
                  <el-date-picker
                    v-model="departure"
                    type="date"
                    placeholder="选择日期"
                    size="small"
                    class="input"
                  >
                  </el-date-picker>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="收货日:">
                  <el-date-picker
                    v-model="arrival"
                    type="date"
                    placeholder="选择日期"
                    size="small"
                    class="input"
                  >
                  </el-date-picker>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="托运人:">
                  <el-input
                    v-model="shipper"
                    size="small"
                    class="input"
                    placeholder="请输入内容"
                  ></el-input>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="收货人:">
                  <el-input
                    v-model="consignee"
                    size="small"
                    class="input"
                    placeholder="请输入内容"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="件数:">
                  <el-input
                    v-model="pcs"
                    size="small"
                    class="input"
                    placeholder="请输入内容"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="重量:">
                  <el-input
                    v-model="weight"
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
                    v-model="vol"
                    size="small"
                    class="input"
                    placeholder="请输入内容"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="收入:">
                  <el-input
                    v-model="income"
                    size="small"
                    class="input"
                    placeholder="请输入内容"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="支出:">
                  <el-input
                    v-model="expense"
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
                    v-model="profit"
                    size="small"
                    class="input"
                    placeholder="请输入内容"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="收货人地址:">
                  <el-input
                    v-model="consigneeAddress"
                    size="small"
                    class="input"
                    placeholder="请输入内容"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="托运人地址:">
                  <el-input
                    v-model="shipperAddress"
                    size="small"
                    class="input"
                    placeholder="请输入内容"
                  ></el-input>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="承运人:">
                  <el-input
                    v-model="carrier"
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
          <span class="CardTitle">备注说明</span>
        </div>

        <div>
          <el-input
            type="textarea"
            :rows="4"
            placeholder="请输入内容"
            v-model="remark"
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
          <el-form ref="form" :model="form" :rules="rules" label-width="10em">
            <el-row>
              <el-col :span="8">
                <el-form-item label="创建人:">
                  <el-input
                    v-model="createBy"
                    size="small"
                    class="input"
                    placeholder="请输入内容"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="创建时间:">
                  <el-date-picker
                    v-model="createOn"
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
                    v-model="updateBy"
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
                  <el-date-picker
                    v-model="updatedOn"
                    type="datetime"
                    placeholder="选择日期"
                    size="small"
                    class="input"
                  >
                  </el-date-picker>
                </el-form-item>
              </el-col>

              <el-col :span="8">
                <el-form-item label="装运单ID:">
                  <el-input
                    v-model="shipmentOrderID"
                    size="small"
                    class="input"
                    disabled
                    placeholder=""
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
        <el-button type="primary" @click="submit()">保存提交</el-button>
        <el-button type="primary" plain @click="$router.back()">返回</el-button>
      </div>
    </footer>
  </div>
</template>
<script>
import { addShipmentOrder } from "@/api/ShippingOrder";
import { Message } from "element-ui";

export default {
  name: "ShippingOrderAdd",

  data() {
    return {
      remark: "",
      shipmentOrderID: "",
      status: "",
      accouting: "",
      shipmentOrders: "",
      createBy: "",
      createOn: "",
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

      Types: [
        {
          value: "选项1",
          label: "空运",
        },
        {
          value: "选项2",
          label: "陆运",
        },
        {
          value: "选项3",
          label: "海运",
        },
      ],

      StatusOp: [
        {
          value: "选项1",
          label: "已下单",
        },
        {
          value: "选项2",
          label: "提货中",
        },
        {
          value: "选项3",
          label: "已装货",
        },
        {
          value: "选项3",
          label: "运输中",
        },
        {
          value: "选项3",
          label: "发送账单",
        },
        {
          value: "选项3",
          label: "已完成",
        },
      ],
    };
  },

  methods: {
    // 提交添加
    submit() {
      let params = { ...this.$data };

      // 删除不需要提交的属性
      delete params.Types;
      delete params.StatusOp;

      addShipmentOrder(params)
        .then((res) => {
          if (res.data.code === 200) {
            // 成功消息
            Message({
              message: "添加成功",
              type: "success",
            });
            this.$router.push({ path: "/shippingorder" });
          } else {
            // 错误消息
            Message.error(`错误: ${res.message}`);
          }
        })
        .catch((err) => {
          // 请求失败的错误消息
          Message.error(`请求失败: ${err}`);
        });
    },

  },
};
</script>

<style lang="scss" scoped>
@import "../../assets/css/MainInformation.css";

.input {
  width: 20em;
}
</style>
