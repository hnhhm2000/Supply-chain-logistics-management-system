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
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="收据编号:">
                  <el-input
                    v-model="receiptNumber"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <el-form-item label="开具时间:">
                  <el-date-picker
                    v-model="kaiTime"
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
                <el-form-item label="件数:">
                  <el-input v-model="pcs" size="small" class="input"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="重量:">
                  <el-input
                    v-model="weight"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="体积:">
                  <el-input v-model="vol" size="small" class="input"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="注意事项:">
                  <el-input
                    v-model="notes"
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
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="支出:">
                  <el-input
                    v-model="expense"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="利润:">
                  <el-input
                    v-model="profit"
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
                <el-form-item label="收据ID:">
                  <el-input
                    v-model="receiptID"
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
        <el-button type="primary" @click="submit()">保存提交</el-button>
        <el-button type="primary" plain @click="$router.back()">返回</el-button>
      </div>
    </footer>
  </div>
</template>
<script>
import { addReceiptData } from "@/api/Receipt";
import { Message } from "element-ui";

export default {
  name: "ReceiptAdd",

  data() {
    return {
      receiptID: "",
      status: "",
      accounting: "",
      receipt: "",
      createdBy: "",
      createTime: "",
      receiptTime: "",
      shipper: "",
      consignee: "",
      project: "",
      pcs: "",
      weight: "",
      vol: "",
      // 注意事项
      notes: "",
      expense: "",
      profit: "",
      updateBy:"",
      updateTime: "",
      serviceType: "",
      commodity: "",
      issuingCompany: "",
      shipperAddress: "",
      consigneeAddress: "",
      remark: "",

      StatusOp: [
        {
          value: "测量中",
          label: "测量中",
        },
        {
          value: "文件处理中",
          label: "文件处理中",
        },
        {
          value: "拍照扫描中",
          label: "拍照扫描中",
        },
        {
          value: "已抵达",
          label: "已抵达",
        },
        {
          value: "分配中",
          label: "分配中",
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

      addReceiptData(params)
        .then((res) => {
          console.log(res.data.code);
          if (res.data.code === 200) {
            // 成功消息
            Message({
              message: "添加成功",
              type: "success",
            });
            this.$router.push({ path: "/receipts" });
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
