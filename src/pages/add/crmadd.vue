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
                    v-model="accountName"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
              </el-col>
              <el-col :span="8">
                <el-form-item label="性别">
                  <el-select
                    v-model="sex"
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
                    v-model="role"
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
                    style="width:18.6em"
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
                <el-form-item label="城市">
                  <el-input
                    v-model="city"
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
                  <el-input v-model="zip" size="small" class="input"></el-input>
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
            v-model="remark"
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
                <el-form-item label="创建人">
                  <el-input
                    v-model="createBy"
                    size="small"
                    class="input"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="创建时间">
                  <el-date-picker
                    v-model="createTime"
                    type="date"
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
                    v-model="updateBy"
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
                    v-model="updateTime"
                    type="date"
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
        <el-button type="primary" @click="submit()">保存提交</el-button>
        <el-button type="primary" plain @click="$router.push({ path: '/crm' })"
          >返回</el-button
        >
      </div>
    </footer>
  </div>
</template>
<script>
import { addUserData } from "@/api/Crm";
import { Message } from 'element-ui'

export default {
  name: "CrmAdd",

  data() {
    return {
      accountName: "",
      sex: "",
      password: "",
      role: "",
      status: "",
      email: "",
      address: "",
      country: "",
      city: "",
      phone: "",
      province: "",
      salesAgency: "",
      id: "",
      createBy: "",
      createTime: "",
      updateBy: "",
      updateTime: "",
      zip: "",
      remark: "",

      // 角色的选项
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
          value: "不活跃1",
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
    // 提交添加
    submit() {
    let params = {...this.$data};
    delete params.options;
    delete params.Sexs;
    delete params.StatusOp;
    
    addUserData(params).then((res) => {
      console.log(res.data.code)
      if(res.data.code === 200) {
        // 成功消息
        Message({
          message: '添加成功',
          type: 'success'
        });
        this.$router.push({ path:'/crm' })
      } else {
        // 错误消息
        Message.error(`错误: ${res.message}`);
      }
    }).catch(err => {
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
