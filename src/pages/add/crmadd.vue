<template>
  <div class="bg">
    <!-- 主要内容 -->
    <main class="add-main">
         <!-- 卡片一  -->
          <el-card class="whiteCard">
            <div slot="header" class="clearfix">
              <span class="CardTitle">账户信息</span>
            </div>

            <div>
              <el-form label-width="10em">
                <el-row>
                  <el-col :span="8">
                    <el-form-item label="账户名称" prop="name">
                      <el-input
                        v-model="name"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">  
                    <el-form-item label="密码" prop="password">
                      <el-input
                        v-model="password"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="性别" prop="role">
                      <el-select
                        v-model="role"
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
                </el-row>
                <el-row>
                  <el-col :span="8">
                    <el-form-item label="电子邮箱" prop="email">
                      <el-input
                        v-model="email"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="状态">
                      <el-select
                        v-model="status"
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
                  <el-col :span="8">
                    <el-form-item label="角色" prop="role">
                      <el-select
                        v-model="role"
                        placeholder="请选择"
                        class="select"
                        size="small"
                      >
                        <el-option
                          v-for="item in Roles"
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
                        v-model="address"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="电话号码" prop="phone">
                      <el-input
                        v-model="phone"
                        size="small"
                        class="input"
                        :maxlength="11"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="城市" prop="salesAgency">
                      <el-input
                        v-model="salesAgency"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row>
                  <el-col :span="8">
                    <el-form-item label="国家" prop="id">
                      <el-input
                        v-model="country"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="省份" prop="province">
                      <el-input
                        v-model="province"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="邮编">
                      <el-input
                        v-model="updateTime"
                        size="small"
                        class="input"
                        :maxlength="11"
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
                v-model="textarea"
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
              <el-form label-width="10em">
                <el-row>
                  <el-col :span="8">
                    <el-form-item label="创建人" prop="createBy">
                      <el-input
                        v-model="createBy"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="创建时间" prop="createBy">
                      <el-date-picker
                        v-model="createdOn"
                        type="date"
                        placeholder="选择日期"
                        size="small"
                        class="input"
                      >
                      </el-date-picker>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="更新人" prop="salesAgency">
                      <el-input
                        v-model="salesAgency"
                        size="small"
                        class="input"
                      ></el-input>
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row>
                  <el-col :span="8">
                    <el-form-item label="更新时间">
                      <el-date-picker
                        v-model="updateOn"
                        type="date"
                        placeholder="选择日期"
                        size="small"
                        class="input"
                      >
                      </el-date-picker>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="客户ID" prop="id">
                      <el-input
                        v-model="id"
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
    </main>

    <!-- 底部栏 -->
    <footer class="btns">
      <div style="margin-top: 2em">
        <el-button type="primary" @click="submitForm('form')"
          >保存提交</el-button
        >
        <el-button type="primary" plain @click="$router.back()">返回</el-button>
      </div>
    </footer>
  </div>
</template>
<script>
// import axios from "axios";

export default {
  name: "CrmAdd",

  data() {
    return {
      textarea: "",
      // 账户信息
      name: "",
      password: "",
      role: "",
      email: "",
      isDisabled: "",
      // phone: "",

      // 纳税人信息
      address: "",
      city: "",
      phone: "",
      province: "",
      salesAgency: "",
      id: "",

      // 操作人信息
      isDeleted: "",
      createBy: "",
      createTime: "",
      // city: "",
      zip: "",
      // email: "",

      options: [
        {
          value: "选项1",
          label: "账户",
        },
        {
          value: "选项2",
          label: "托运人",
        },
        {
          value: "选项3",
          label: "收货人",
        },
        {
          value: "选项4",
          label: "承运人",
        },
      ],
    };
  },

  methods: {},
};
</script>

<style lang="scss" scoped>
@import "../../assets/css/MainInformation.css";

.input {
  width: 20em;
}


</style>
