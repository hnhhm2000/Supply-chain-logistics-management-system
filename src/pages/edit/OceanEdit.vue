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
                        v-model="oceanInfo.status"
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
                        v-model="oceanInfo.accounting"
                        size="small"
                        class="input"
                        disabled
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="海运编号:">
                      <el-input
                        v-model="oceanInfo.oceanNumber"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                </el-row>

                <el-row>
                  <el-col :span="8">
                    <el-form-item label="启航日:">
                      <el-date-picker
                        v-model="oceanInfo.departure"
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
                        v-model="oceanInfo.arrival"
                        type="date"
                        placeholder="选择日期"
                        size="small"
                        class="input"
                      >
                      </el-date-picker>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="收货港:">
                      <el-input
                        v-model="oceanInfo.destination"
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
                        v-model="oceanInfo.origin"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="收货日:">
                      <el-date-picker
                        v-model="oceanInfo.placeOfDate"
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
                        v-model="oceanInfo.customer"
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
                        v-model="oceanInfo.shipper"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="收货人:">
                      <el-input
                        v-model="oceanInfo.consignee"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="件数:">
                      <el-input
                        v-model="oceanInfo.pcs"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                </el-row>

                <el-row>
                  <el-col :span="8">
                    <el-form-item label="重量:">
                      <el-input
                        v-model="oceanInfo.weight"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="收入:">
                      <el-input
                        v-model="oceanInfo.income"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="支出:">
                      <el-input
                        v-model="oceanInfo.expense"
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
                        v-model="oceanInfo.profit"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="装载日期:">
                      <el-date-picker
                        v-model="oceanInfo.loadingDate"
                        type="date"
                        placeholder="选择日期"
                        size="small"
                        class="input"
                      >
                      </el-date-picker>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="最大容量:">
                      <el-input
                        v-model="oceanInfo.maxPieces"
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
                        v-model="oceanInfo.project"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="承运人:">
                      <el-input
                        v-model="oceanInfo.carrier"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="商品名:">
                      <el-input
                        v-model="oceanInfo.commodity"
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
                v-model="oceanInfo.remarks"
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
                        v-model="oceanInfo.createBy"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="创建时间:">
                      <el-date-picker
                        v-model="oceanInfo.createTime"
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
                        v-model="oceanInfo.updateBy"
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
                        v-model="oceanInfo.updateTime"
                        type="datetime"
                        placeholder="选择日期"
                        size="small"
                        class="input"
                      >
                      </el-date-picker>
                    </el-form-item>
                  </el-col>

                  <el-col :span="8">
                    <el-form-item label="海运ID:">
                      <el-input
                        v-model="oceanInfo.id"
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
          @click="$router.push({ path: '/ocean' })"
          >返回</el-button
        >
      </div>
    </footer>
  </div>
</template>
<script>
import { updateOceanData, getOceanDetail } from "@/api/Ocean";

export default {
  name: "OceanEdit",

  data() {
    return {
      activeName: "first",
      oceanInfo: {
        status: "",
        accouting: "",
        oceanNumber: "",
        departure: "",
        arrival: "",
        receipt: "",
        origin: "",
        placeOfDate: "",
        shipper: "",
        consignee: "",
        pcs: "",
        weight: "",
        income: "",
        expense: "",
        profit: "",
        loadingDate: "",
        project: "",
        carrier: "",
        commodity: "",
        maxPieces: "",
        remarks: "",
        CreatedBy: "",
        createTime: "",
        updateBy: "",
        UpdatedOn: "",
      },

      StatusOp: [
        {
          value: "预约中",
          label: "预约中",
        },
        {
          value: "准备装载",
          label: "准备装载",
        },
        {
          value: "文件处理中",
          label: "文件处理中",
        },
        {
          value: "装载中",
          label: "装载中",
        },
        {
          value: "发送账单中",
          label: "发送账单中",
        },
        {
          value: "运输途中",
          label: "运输途中",
        },
        {
          value: "已抵达目的地",
          label: "已抵达目的地",
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
      data = this.oceanInfo;

      // 格式化创建日期/更新日期数据
      data.createTime = this.formatDate(data.createTime);
      data.updateTime = this.formatDate(data.updateTime);

      updateOceanData(data).then((res) => {
        if (res.data.code === 200) {
          this.$message.success("编辑成功");
          this.$router.push({ path: "/ocean" });
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
    getOceanDetail(data).then((res) => {
      this.oceanInfo = res.data.data.oceanInfo;
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
