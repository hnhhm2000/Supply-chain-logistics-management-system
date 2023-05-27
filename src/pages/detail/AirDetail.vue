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
                  <div class="context">
                    {{ airInfo.status }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="财务:">
                  <div class="context">
                    {{ airInfo.accounting }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="编号:">
                  <div class="context">
                    {{ airInfo.airNumber }}
                  </div>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="起飞日:">
                  <div class="context">
                    {{ airInfo.arrival }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="始发地:">
                  <div class="context">
                    {{ airInfo.departure }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="目的地:">
                  <div class="context">
                    {{ airInfo.destination }}
                  </div>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="客户:">
                  <div class="context">
                    {{ airInfo.customer }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="托运人:">
                  <div class="context">
                    {{ airInfo.shipper }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="收货人:">
                  <div class="context">
                    {{ airInfo.consignee }}
                  </div>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="件数:">
                  <div class="context">
                    {{ airInfo.pcs }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="重量:">
                  <div class="context">
                    {{ airInfo.weight }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="收入:">
                  <div class="context">
                    {{ airInfo.income }}
                  </div>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="支出:">
                  <div class="context">
                    {{ airInfo.expense }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="利润:">
                  <div class="context">
                    {{ airInfo.profit }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="承运人:">
                  <div class="context">
                    {{ airInfo.carrier }}
                  </div>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="项目:">
                  <div class="context">
                    {{ airInfo.project }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="最大容量:">
                  <div class="context">
                    {{ airInfo.maxPieces }}
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

        <div class="remark">
          {{ airInfo.remarks }}
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
                  <div class="context">
                    {{ airInfo.createBy }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="创建时间:">
                  <div class="context">
                    {{ airInfo.createTime }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="更新人:">
                  <div class="context">
                    {{ airInfo.updatedTime }}
                  </div>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="更新时间:">
                  <div class="context">
                    {{ airInfo.createTime }}
                  </div>
                </el-form-item>
              </el-col>

              <el-col :span="8">
                <el-form-item label="空运ID:">
                  <div class="context">
                    {{ airInfo.id }}
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
              name: 'AirEdit',
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
import { getAirDetail } from "@/api/Air";

export default {
  name: "AirDetail",

  data() {
    return {
      airInfo: {
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
    };
  },

  mounted() {
    // 获取详情数据，将其填写到表单中
    let data = {};
    data.id = this.$route.params.id;
    getAirDetail(data).then((res) => {
      this.airInfo = res.data.data.airInfo;
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
