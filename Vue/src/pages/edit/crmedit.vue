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
              <el-form label-width="10em">
                <el-row>
                  <el-col :span="8">
                    <el-form-item label="账户名称" prop="name">
                      <el-input
                        v-model="userData.accountName"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>

                  <el-col :span="8">
                    <el-form-item label="性别">
                      <el-select
                        v-model="userData.sex"
                        placeholder="请选择"
                        class="select"
                        size="small"
                      >
                        <el-option
                          v-for="item in Sexs"
                          :key="item.value"
                          :label="item.label"
                          :value="item.value"
                        >
                        </el-option>
                      </el-select>
                    </el-form-item>
                  </el-col>

                  <el-col :span="8">
                    <el-form-item label="角色" prop="role">
                      <el-select
                        v-model="userData.roles"
                        placeholder="请选择"
                        class="select"
                        size="small"
                      >
                        <el-option
                          v-for="item in options"
                          :key="item.value"
                          :label="item.label"
                          :value="item.value"
                        >
                        </el-option>
                      </el-select>
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row>
                  <el-col :span="8">
                    <el-form-item label="电子邮箱" prop="email">
                      <el-input
                        v-model="userData.email"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="状态">
                      <el-select
                        v-model="userData.status"
                        placeholder="请选择"
                        class="select"
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
                </el-row>
              </el-form>
            </div>
          </el-card>

          <!-- 卡片二  -->
          <el-card class="whiteCard">
            <div slot="header" class="clearfix">
              <span class="CardTitle">地址信息</span>
            </div>

            <div>
              <el-form label-width="10em">
                <el-row>
                  <el-col :span="8">
                    <el-form-item label="主要地址" prop="address">
                      <el-input
                        v-model="userData.address"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="电话号码" prop="phoneNumber">
                      <el-input
                        v-model="userData.phoneNumber"
                        size="small"
                        class="input"
                        :maxlength="11"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="城市">
                      <el-input
                        v-model="userData.city"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row>
                  <el-col :span="8">
                    <el-form-item label="国家">
                      <el-input
                        v-model="userData.country"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="省份" prop="province">
                      <el-input
                        v-model="userData.province"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="邮编">
                      <el-input
                        v-model="userData.zip"
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
                v-model="userData.remarks"
                :maxlength="600"
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
              <el-form label-width="10em">
                <el-row>
                  <el-col :span="8">
                    <el-form-item label="创建人">
                      <el-input
                        v-model="userData.createBy"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="创建时间">
                      <el-date-picker
                        v-model="userData.createTime"
                        type="datetime"
                        placeholder="选择日期"
                        size="small"
                        class="input"
                      >
                      </el-date-picker>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="更新人">
                      <el-input
                        v-model="userData.updateBy"
                        size="small"
                        class="input"
                        disabled
                      ></el-input>
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row>
                  <el-col :span="8">
                    <el-form-item label="更新时间">
                      <el-date-picker
                        v-model="userData.updateTime"
                        type="datetime"
                        placeholder="选择日期"
                        size="small"
                        class="input"
                        disabled
                      >
                      </el-date-picker>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="客户ID" prop="id">
                      <el-input
                        v-model="userData.id"
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

          <!-- 底部栏 -->
          <footer class="btns">
            <div style="margin-top: 2em">
              <el-button type="primary" @click="submit">保存提交</el-button>
              <el-button
                type="primary"
                plain
                @click="$router.push({ path: '/crm' })"
                >返回</el-button
              >
            </div>
          </footer>
        </el-tab-pane>

        <!-- 报价 -->
        <el-tab-pane label="报价" name="second">
          <SimQuote
            :quoteData="quoteData"
            @update-data="fetchData()"
          ></SimQuote>
        </el-tab-pane>
        <!-- 库存 -->
        <el-tab-pane label="库存" name="third">
          <SimInventory
            :inventoryData="inventoryData"
            @update-data="fetchData()"
          ></SimInventory>
        </el-tab-pane>
        <!-- 运输 -->
        <el-tab-pane label="运输" name="fourth">
          <SimShippment></SimShippment>
        </el-tab-pane>
        <!-- 财务相关 -->
        <el-tab-pane label="财务相关" name="fifth">
          <SimAccounting></SimAccounting>
        </el-tab-pane>
      </el-tabs>
    </main>
  </div>
</template>
<script>
import {
  updateUserData,
  getUserDetail,
  getQuoteData,
  getInventoryData,
} from "@/api/Crm";

export default {
  name: "CrmEdit",

  data() {
    return {
      activeName: "first",

      userData: {
        accountName: "",
        sex: "",
        password: "",
        role: "",
        status: "",
        email: "",
        address: "",
        country: "",
        city: "",
        phoneNumber: "",
        province: "",
        id: "",
        createBy: "",
        createTime: "",
        updateBy: "",
        updateTime: "",
        zip: "",
        remarks: "",
      },

      quoteData: [],
      inventory: [],

      // 角色的选项
      options: [
        {
          value: "客户",
          label: "客户",
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

      // 性别的选项
      Sexs: [
        {
          value: "男",
          label: "男",
        },
        {
          value: "女",
          label: "女",
        },
      ],

      // 状态的选项
      StatusOp: [
        {
          value: "活跃",
          label: "活跃",
        },
        {
          value: "不活跃",
          label: "不活跃",
        },
        {
          value: "挂起",
          label: "挂起",
        },
      ],
    };
  },

  methods: {
    // 提交编辑，根据id进行编辑
    submit() {
      let data = {};
      data = this.userData;
      data.id = this.$route.params.id;
      data.createTime = this.formatDate(data.createTime);
      updateUserData(data).then((res) => {
        if (res.data.code === 200) {
          this.$message.success("编辑成功");
          this.$router.push({ path: "/crm" });
        }
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

    fetchData() {
      // 获取id
      let data = {};
      data.id = this.$route.params.id;
      data.userId = this.$route.params.id;
      data.inventoryId = this.$route.params.id;

      // 打开页面时，显示所有已有数据
      getUserDetail(data).then((res) => {
        this.userData = res.data.data.userInfo;
      });

      // 获取报价关联数据
      getQuoteData(data).then((res) => {
        this.quoteData = res.data.data.quoteList;
      });

      // 获取库存关联数据
      getInventoryData(data).then((res) => {
        this.inventoryData = res.data.data.inventoryData;
        console.log(this.inventoryData);
      });
    },
  },
  created() {
    this.fetchData();
  },
};
</script>

<style lang="scss" scoped>
@import "../../assets/css/MainInformation.css";

.input {
  width: 19em;
}
</style>
