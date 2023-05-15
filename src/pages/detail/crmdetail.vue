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
                <el-form-item label="账户名称:" prop="name">
                  <div class="context">
                    {{ userData.accountName }}
                  </div>
                </el-form-item>
              </el-col>

              <el-col :span="8">
                <el-form-item label="性别:">
                  <div class="context">
                    {{ userData.sex }}
                  </div>
                </el-form-item>
              </el-col>

              <el-col :span="8">
                <el-form-item label="角色:" prop="phone">
                  <div class="context">
                    {{ userData.roles }}
                  </div>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <el-form-item label="电子邮箱:" prop="email">
                  <div class="context">
                    {{ userData.email }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="状态:" prop="isDisabled">
                  <div class="context">
                    {{ userData.status }}
                  </div>
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
                <el-form-item label="主要地址:" prop="address">
                  <div class="context">
                    {{ userData.address }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="电话号码:" prop="address">
                  <div class="context">
                    {{ userData.phoneNumber }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="城市:" prop="phone">
                  <div class="context">
                    {{ userData.accountName }}
                  </div>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <el-form-item label="国家:" prop="province">
                  <div class="context">
                    {{ userData.country }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="省份:" prop="salesAgency">
                  <div class="context">
                    {{ userData.province }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="邮编:" prop="id">
                  <div class="context">
                    {{ userData.zip }}
                  </div>
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

        <div class="remark">
          {{ userData.remarks }}
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
                <el-form-item label="创建人:" prop="createBy">
                  <div class="context">
                    {{ userData.createBy }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="创建时间:" prop="createBy">
                  <div class="context">
                    {{ userData.createTime }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="更新人:" prop="salesAgency">
                  <div class="context">
                    {{ userData.updateBy }}
                  </div>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <el-form-item label="更新时间:" prop="updateTime">
                  <div class="context">
                    {{ userData.updateTime }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="客户ID:" prop="zip">
                  <div class="context">
                    {{ userData.id }}
                  </div>
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
        <el-button
          type="primary"
          @click="
            $router.push({
              name: 'CrmEdit',
              params: { id: $route.params.id },
            })
          "
          >编辑内容</el-button
        >
        <el-button type="primary" plain @click="$router.push({ path: '/crm' })"
          >返回</el-button
        >
      </div>
    </footer>
  </div>
</template>
<script>
import { getUserDetail } from "@/api/Crm";

export default {
  name: "CrmDetail",

  data() {
    return {
      userData: {
        accountName: "",
        sex: "",
        password: "",
        roles: "",
        status: "",
        email: "",
        address: "",
        country: "",
        city: "",
        phone: "",
        province: "",
        id: "",
        createBy: "",
        createTime: "",
        updateBy: "",
        updateTime: "",
        zip: "",
        remark: "",
      },
    };
  },

  mounted() {
    let data = {};
    data.id = this.$route.params.id;
    getUserDetail(data).then((res) => {
      this.userData = res.data.data.userInfo;
    });
  },

  methods: {},
};
</script>

<style lang="scss" scoped>
@import "../../assets/css/MainInformation.css";
</style>
