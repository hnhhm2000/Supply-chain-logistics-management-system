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
          <el-form ref="form" :model="form"  label-width="10em">
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
                    v-model="accounting"
                    size="small"
                    class="input"
                    disabled
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="海运编号:">
                  <el-input
                    v-model="oceanNumber"
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
                <el-form-item label="抵达日:">
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
                <el-form-item label="收货港:">
                  <el-input
                    v-model="destination"
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
                    v-model="origin"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="收货日:"> 
                  <el-date-picker
                  v-model="placeOfDate"
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
                    v-model="customer"
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
                    v-model="shipper"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="收货人:">
                  <el-input
                    v-model="consignee"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="件数:">
                  <el-input v-model="pcs" size="small" class="input"></el-input>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="重量:">
                  <el-input
                    v-model="weight"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="收入:">
                  <el-input
                    v-model="income"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="支出:">
                  <el-input
                    v-model="expense"
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
                    v-model="profit"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="装载日期:">
                  <el-date-picker
                    v-model="loadingDate"
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
                    v-model="maxPieces"
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
                    v-model="project"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="承运人:">
                  <el-input
                    v-model="carrier"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="商品名:">
                  <el-input
                    v-model="commodity"
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
            v-model="remarks"
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
          <el-form ref="form" :model="form"  label-width="10em">
            <el-row>
              <el-col :span="8">
                <el-form-item label="创建人:">
                  <el-input
                    v-model="createBy"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="创建时间:">
                  <el-date-picker
                    v-model="createTime"
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
                  ></el-input>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="更新时间:">
                  <el-date-picker
                    v-model="updateTime"
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
                    v-model="id"
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
        <el-button type="primary" @click="submit()"
          >保存提交</el-button
        >
        <el-button type="primary" plain @click="$router.back()">返回</el-button>
      </div>
    </footer>
  </div>
</template>
<script>
import { addOceanData } from "@/api/Ocean";
import { Message } from "element-ui";

export default {
  name: "OceanAdd",

  data() {
    return {
      status: "",
      accouting: "",
      oceanNumber: "",
      departure: "",
      arrival: "",
      destination:"",
      origin: "",
      placeOfDate: "",  
      shipper: "",
      customer:"",
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
      createBy: "",
      createTime: "",
      updateBy: "",
      updateTime: "",

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
    // 提交添加
    submit() {
      let params = { ...this.$data };
      delete params.StatusOp;

      // 格式化创建日期/更新日期数据
      params.createTime = this.formatDate(params.createTime);
      params.updateTime = this.formatDate(params.updateTime);

      addOceanData(params)
        .then((res) => {
          console.log(res.data.code);
          if (res.data.code === 200) {
            // 成功消息
            Message({
              message: "添加成功",
              type: "success",
            });
            this.$router.push({ path: "/ocean" });
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

    // 格式化时间
    formatDate(dateString) {
      if (dateString !== "") {
        const date = new Date(dateString);
        const year = date.getFullYear();
        const month = String(date.getMonth() + 1).padStart(2, "0");
        const day = String(date.getDate()).padStart(2, "0");
        const hours = String(date.getHours()).padStart(2, "0");
        const minutes = String(date.getMinutes()).padStart(2, "0");
        const seconds = String(date.getSeconds()).padStart(2, "0");

        return `${year}-${month}-${day} ${hours}:${minutes}:${seconds}`;
      } else {
        return "";
      }
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
