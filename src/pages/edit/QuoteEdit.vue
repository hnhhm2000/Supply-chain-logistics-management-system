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
              <el-form ref="form"  label-width="10em">
                <el-row>
                  <el-col :span="8">
                    <el-form-item label="状态:">
                      <el-select
                        v-model="quoteData.status"
                        placeholder="请选择"
                        style="width: 17.6em"
                        size="small"
                      >
                        <el-option
                          v-for="item in statusOp"
                          :key="item.value"
                          :label="item.label"
                          :value="item.value"
                        >
                        </el-option>
                      </el-select>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="引用:">
                      <el-input
                        v-model="quoteData.reference"
                        disabled
                        size="small"
                        class="input"
                        placeholder="请输入内容"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="报价编号:">
                      <el-input
                        v-model="quoteData.quoteNumber"
                        size="small"
                        class="input"
                        placeholder="请输入内容"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row>
                  <el-col :span="8">
                    <el-form-item label="项目:">
                      <el-input
                        v-model="quoteData.project"
                        size="small"
                        class="input"
                        placeholder="请输入内容"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="报价者:">
                      <el-input
                        v-model="quoteData.quoter"
                        size="small"
                        class="input"
                        placeholder="请输入内容"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="创建日期:" prop="phone">
                      <el-date-picker
                        v-model="quoteData.createdDate"
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
                    <el-form-item label="截止日期:">
                      <el-date-picker
                        v-model="quoteData.untilDate"
                        type="date"
                        placeholder="选择日期"
                        size="small"
                        class="input"
                      >
                      </el-date-picker>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="客户:">
                      <el-input
                        v-model="quoteData.customer"
                        size="small"
                        class="input"
                        @input="getcrm('客户')"
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
              <el-form ref="form"  label-width="10em">
                <el-row>
                  <el-col :span="8">
                    <el-form-item label="客户地址:">
                      <el-input
                        v-model="quoteData.customerAddress"
                        size="small"
                        class="input"
                        placeholder="请输入内容"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="货物描述:">
                      <el-input
                        v-model="quoteData.descriptionOfGoods"
                        size="small"
                        class="input"
                        placeholder="请输入内容"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="始发地:">
                      <el-input
                        v-model="quoteData.origin"
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
                        v-model="quoteData.destination"
                        size="small"
                        class="input"
                        placeholder="请输入内容"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="运输方式:">
                      <el-input
                        v-model="quoteData.mode"
                        size="small"
                        class="input"
                        placeholder="请输入内容"
                      ></el-input>
                    </el-form-item>
                  </el-col>

                  <el-col :span="8">
                    <el-form-item label="付款方式:">
                      <el-input
                        v-model="quoteData.paymentTerm"
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
                        v-model="quoteData.transitDays"
                        size="small"
                        class="input"
                        placeholder="请输入内容"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="个数/件数:">
                      <el-input
                        v-model="quoteData.pcs"
                        size="small"
                        class="input"
                        placeholder="请输入内容"
                      ></el-input
                    ></el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="重量:">
                      <el-input
                        v-model="quoteData.weight"
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
                        v-model="quoteData.vol"
                        size="small"
                        class="input"
                        placeholder="请输入内容"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="收入:">
                      <el-input
                        v-model="quoteData.income"
                        size="small"
                        class="input"
                        placeholder="请输入内容"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="支出:">
                      <el-input
                        v-model="quoteData.expense"
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
                        v-model="quoteData.profit"
                        size="small"
                        class="input"
                        placeholder="请输入内容"
                      ></el-input>
                    </el-form-item>
                  </el-col>

                  <el-col :span="8">
                    <el-form-item label="托运人:">
                      <el-input
                        v-model="quoteData.shipper"
                        size="small"
                        class="input"
                        placeholder="请输入内容"
                      ></el-input>
                    </el-form-item>
                  </el-col>

                  <el-col :span="8">
                    <el-form-item label="承运人:">
                      <el-input
                        v-model="quoteData.carrier"
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
                v-model="quoteData.remarks"
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
              <el-form ref="form"  label-width="10em">
                <el-row>
                  <el-col :span="8">
                    <el-form-item label="创建人:">
                      <el-input
                        v-model="quoteData.createBy"
                        size="small"
                        class="input"
                        placeholder="请输入内容"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="创建时间:">
                      <el-date-picker
                        v-model="quoteData.createTime"
                        type="date"
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
                        v-model="quoteData.updateBy"
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
                        v-model="quoteData.updateTime"
                        type="date"
                        placeholder="选择日期"
                        size="small"
                        class="input"
                      >
                      </el-date-picker>
                    </el-form-item>
                  </el-col>

                  <el-col :span="8">
                    <el-form-item label="报价ID:">
                      <el-input
                        v-model="quoteData.quoteId"
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
        <el-button type="primary" @click="submit()">保存提交</el-button>
        <el-button
          type="primary"
          plain
          @click="$router.push({ path: '/quote' })"
          >返回</el-button
        >
      </div>
    </footer>
  </div>
</template>
<script>
import { editQuoteData, getQuoteDetail } from "@/api/Quote";
import { getUserListByRole } from "@/api/api";
export default {
  name: "QuoteEdit",

  data() {
    return {
      activeName: "first",
      quoteData: {
        quoteId: "",
        status: "",
        reference: "",
        quoteNumber: "",
        project: "",
        quoter: "",
        createdDate: "",
        untilDate: "",
        customer: "",
        shipper: "",
        origin: "",
        destination: "",
        carrier: "",
        customerAddress: "",
        descriptionOfGoods: "",
        mode: "",
        pcs: "",
        weight: "",
        vol: "",
        income: "",
        expense: "",
        profit: "",
        remarks: "",
        createdBy: "",
        createTime: "",
        updateBy: "",
        updatedOn: "",
        paymentTerm: "",
        transitDays: "",
      },

      options: [
        {
          value: "账户",
          label: "账户",
        },
        {
          value: "托运人",
          label: "托运人",
        },
        {
          value: "收货人",
          label: "收货人",
        },
        {
          value: "承运人",
          label: "承运人",
        },
      ],

      statusOp: [
        {
          value: "请求中",
          label: "请求中",
        },
        {
          value: "定价中",
          label: "定价中",
        },
        {
          value: "正在修改",
          label: "正在修改",
        },
        {
          value: "已发送",
          label: "已发送",
        },
        {
          value: "已批准",
          label: "已批准",
        },
        {
          value: "已取消",
          label: "已取消",
        },
        {
          value: "已完成",
          label: "已完成",
        },
      ],
    };
  },

  methods: {
    // 提交编辑，根据id进行编辑
    submit() {
      let data = {};
      data = this.quoteData;
      data.id = this.$route.params.id;
      editQuoteData(data).then((res) => {
        if (res.data.code === 200) {
          this.$message.success("编辑成功");
          this.$router.push({ path: "/quote" });
        }
      });
    },

    // 从客户关系管理中查找客户
    getcrm(data) {
      let params = {}
      params.role = data
      getUserListByRole(params).then((res) => {
        console.log(res);  
      })
    },
  },

  created() {
    let data = {};
    data.id = this.$route.params.id;
    getQuoteDetail(data).then((res) => {
      console.log(res);
      this.quoteData = res.data.data.quoteInfo;
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
