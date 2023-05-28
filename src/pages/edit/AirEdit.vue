<template>
  <div class="bg">
    <!-- 主要内容 -->
    <main class="add-main">
      <el-tabs v-model="activeName" type="card">
        <el-tab-pane label="主要信息" name="first">
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
                        v-model="airInfo.status"
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
                        v-model="airInfo.accounting"
                        size="small"
                        class="input"
                        disabled
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="编号:">
                      <el-input
                        v-model="airInfo.airNumber"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                </el-row>

                <el-row>
                  <el-col :span="8">
                    <el-form-item label="起飞日:">
                      <el-date-picker
                        v-model="airInfo.departure"
                        type="date"
                        placeholder="选择日期"
                        size="small"
                        class="input"
                      >
                      </el-date-picker>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="抵达日:">
                      <el-date-picker
                        v-model="airInfo.arrival"
                        type="date"
                        placeholder="选择日期"
                        size="small"
                        class="input"
                      >
                      </el-date-picker>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="始发地:">
                      <el-input
                        v-model="airInfo.origin"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                </el-row>

                <el-row>
                  <el-col :span="8">
                    <el-form-item label="目的地:">
                      <el-input
                        v-model="airInfo.destination"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="客户:">
                      <el-input
                        v-model="airInfo.customer"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="托运人:">
                      <el-input
                        v-model="airInfo.shipper"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                </el-row>

                <el-row>
                  <el-col :span="8">
                    <el-form-item label="收货人:">
                      <el-input
                        v-model="airInfo.consignee"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="件数:">
                      <el-input
                        v-model="airInfo.pcs"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="重量:">
                      <el-input
                        v-model="airInfo.weight"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row>
                  <el-col :span="8">
                    <el-form-item label="收入:">
                      <el-input
                        v-model="airInfo.income"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="支出:">
                      <el-input
                        v-model="airInfo.expense"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="利润:">
                      <el-input
                        v-model="airInfo.profit"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                </el-row>

                <el-row>
                  <el-col :span="8">
                    <el-form-item label="承运人:">
                      <el-input
                        v-model="airInfo.carrier"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="项目:">
                      <el-input
                        v-model="airInfo.project"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="最大容量:">
                      <el-input
                        v-model="airInfo.maxPieces"
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
                v-model="airInfo.remarks"
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
                
                label-width="10em"
              >
                <el-row>
                  <el-col :span="8">
                    <el-form-item label="创建人:">
                      <el-input
                        v-model="airInfo.createBy"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="创建时间:">
                      <el-date-picker
                        v-model="airInfo.createTime"
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
                        v-model="airInfo.updateBy"
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
                        v-model="airInfo.updateTime"
                        type="datetime"
                        placeholder="选择日期"
                        size="small"
                        class="input"
                      >
                      </el-date-picker>
                    </el-form-item>
                  </el-col>

                  <el-col :span="8">
                    <el-form-item label="空运ID:">
                      <el-input
                        v-model="airInfo.id"
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
        <el-button type="primary" plain @click="$router.push({ path: '/air' })"
          >返回</el-button
        >
      </div>
    </footer>
  </div>
</template>
<script>
import { updateAirData, getAirDetail } from "@/api/Air";

export default {
  name: "AirEdit",

  data() {
    return {
      activeName: "first",
      airInfo: {
        id:"",
        status: "",
        accounting: "",
        // 空运编号
        airNumber: "",
        // 起飞日
        departure: "",
        // 抵达日
        arrival: "",
        origin: "",
        destination: "",
        customer: "",
        shipper: "",
        consignee: "",
        pcs: "",
        weight: "",
        income: "",
        expense: "",
        profit: "",
        carrier: "",
        project: "",
        maxPieces: "",
        createBy: "",
        createTime: "",
        updateBy: "",
        updateTime: "",
        remarks: "",
      },

      StatusOp: [
        {
          value: "装载中",
          label: "装载中",
        },
        {
          value: "运输中",
          label: "运输中",
        },
        {
          value: "已抵达海关",
          label: "已抵达海关",
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
      data = this.airInfo;

      // 格式化创建日期/更新日期数据
      data.createTime = this.formatDate(data.createTime);
      data.updateTime = this.formatDate(data.updateTime);

      updateAirData(data).then((res) => {
        if (res.data.code === 200) {
          this.$message.success("编辑成功");
          this.$router.push({ path: "/air" });
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
    getAirDetail(data).then((res) => {
      this.airInfo = res.data.data.airInfo;
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
