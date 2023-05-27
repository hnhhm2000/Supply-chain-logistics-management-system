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
                    {{ receiptInfo.status }}
                  </div> 
                  </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="财务:"> 
                  <div class="context">
                    {{ receiptInfo.accounting }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="收据编号:"> 
                  <div class="context">
                    {{ receiptInfo.receiptNumber }}
                  </div>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <el-form-item label="开具时间:"> 
                  <div class="context">
                    {{ receiptInfo.kaiDate }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="托运人:"> 
                  <div class="context">
                    {{ receiptInfo.shipper }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="收货人:"> 
                  <div class="context">
                    {{ receiptInfo.consignee }}
                  </div>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="项目:"> 
                  <div class="context">
                    {{ receiptInfo.project }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="件数:"> 
                  <div class="context">
                    {{ receiptInfo.pcs }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="重量:"> 
                  <div class="context">
                    {{ receiptInfo.weight }}
                  </div>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="体积:"> 
                  <div class="context">
                    {{ receiptInfo.vol }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="注意事项:"> 
                  <div class="context">
                    {{ receiptInfo.notes }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="收入:"> 
                  <div class="context">
                    {{ receiptInfo.income }}
                  </div>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="支出:"> 
                  <div class="context">
                    {{ receiptInfo.expense }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="利润:"> 
                  <div class="context">
                    {{ receiptInfo.profit }}
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

        <div class="remark"></div>
      </el-card>

      <!-- 卡片四  -->
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
                    {{ receiptInfo.createBy }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="创建时间:"> 
                  <div class="context">
                    {{ receiptInfo.createTime }}
                  </div>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="更新人:"> 
                  <div class="context">
                    {{ receiptInfo.updateBy }}
                  </div>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="更新时间:"> 
                  <div class="context">
                    {{ receiptInfo.updateTime }}
                  </div>
                </el-form-item>
              </el-col>

              <el-col :span="8">
                <el-form-item label="收据ID:"> 
                  <div class="context">
                    {{ receiptInfo.id }}
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
        <el-button type="primary" @click="submit()"
          >保存提交</el-button
        >
        <el-button type="primary" plain @click="$router.back()">返回</el-button>
      </div>
    </footer>
  </div>
</template>
<script>
import { getReceiptDetail } from "@/api/Receipt";

export default {
  name: "ReceiptAdd",

  data() {
    return {
      receiptInfo: {
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
        updateTime: "",
        serviceType: "",
        commodity: "",
        issuingCompany: "",
        shipperAddress: "",
        consigneeAddress: "",
        remark: "",
      },
    };
  },

  mounted() {
    // 获取详情数据，将其填写到表单中
    let data = {};
    data.id = this.$route.params.id;
    getReceiptDetail(data).then((res) => {
      this.receiptInfo = res.data.data.receiptInfo;
      console.log(res);
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
