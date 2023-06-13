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
                  <div class="context">
                    {{ releaseInfo.status }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="财务:">
                  <div class="context">
                    {{ releaseInfo.accounting }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="编号:">
                  <div class="context">
                    {{ releaseInfo.releaseNumber }}
                  </div>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="发往:">
                  <div class="context">
                    {{ releaseInfo.releaseTo }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="件数:">
                  <div class="context">
                    {{ releaseInfo.pcs }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="重量:">
                  <div class="context">
                    {{ releaseInfo.weight }}
                  </div>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="体积:">
                  <div class="context">
                    {{ releaseInfo.vol }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="收入:">
                  <div class="context">
                    {{ releaseInfo.income }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="支出:">
                  <div class="context">
                    {{ releaseInfo.expense }}
                  </div>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="利润:">
                  <div class="context">
                    {{ releaseInfo.profit }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="出库时间:">
                  <div class="context">
                    {{ releaseInfo.dateTimeOut }}
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
          <span class="CardTitle">备注说明</span>
        </div>

        <div class="context">
          {{ releaseInfo.remarks }}
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
                  <div class="context">
                    {{ releaseInfo.createBy }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="创建时间:">
                  <div class="context">
                    {{ releaseInfo.createTime }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="更新人:">
                  <div class="context">
                    {{ releaseInfo.createBy }}
                  </div>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="更新时间:">
                  <div class="context">
                    {{ releaseInfo.createTime }}
                  </div>
                </el-form-item>
              </el-col>

              <el-col :span="8">
                <el-form-item label="库存ID:">
                  <div class="context">
                    {{ releaseInfo.id }}
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
              name: 'releaseEdit',
              params: { id: $route.params.id },
            })
          "
          >编辑内容</el-button
        >
        <el-button type="primary" plain @click="$router.back()">返回</el-button>
      </div>
    </footer>
  </div>
</template>
<script>
import { getReleaseDetail } from "@/api/Release";

export default {
  name: "ReleaseDetail",

  data() {
    return {
      releaseInfo: {
        outboundID: "",
        status: "",
        accounting: "",
        releaseNumber: "",
        createdBy: "",
        createTime: "",
        dateTimeOut: "",
        releaseTo: "",
        pcs: "",
        weight: "",
        vol: "",
        income: "",
        expense: "",
        profit: "",
        updateBy: "",
        updateTime: "",
        commodity: "",
        address: "",
        carrier: "",
        remarks: "",
      },
    };
  },

  mounted() {
    // 获取详情数据，将其填写到表单中
    let data = {};
    data.id = this.$route.params.id;
    getReleaseDetail(data).then((res) => {
      this.releaseInfo = res.data.data.releaseInfo;
    });
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
