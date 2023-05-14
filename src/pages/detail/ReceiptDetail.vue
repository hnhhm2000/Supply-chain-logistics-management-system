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
              
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="财务:">
               
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="收据编号:">
              
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <el-form-item label="开具时间:">
                 
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="托运人:">
               
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="收货人:">
                
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="项目:">
             
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="件数:">
                 
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="重量:">
              
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="体积:">
              
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="注意事项:">
                
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="收入:">
             
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="支出:">
               
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="利润:">
                 
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
        
        </div>
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
                
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="创建时间:">
               
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="更新人:">
              
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="更新时间:">
              
                </el-form-item>
              </el-col>

                 <el-col :span="8">
                <el-form-item label="收据ID:">
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
  name: "ReceiptAdd",

  data() {
    return {
    ReceiptID:"",
    Status:"",
    Accounting:"",
    Receipt:"",
    CreatedBy:"",
    CreatedOn:"",
    ReceiptTime:"",
    Shipper:"",
    Consignee:"",
    Project:"",
    PCS:"",
    Weight:"",
    VOL:"",
    // 注意事项
    Handing:"",
    Expense:"",
    Profit:"",
    UpdateOn:"",
    ServiceType:"",
    Commodity:"",
    IssuingCompany:"",
    ShipperAddress:"",
    ConsigneeAddress:"",
    Remarks:"",
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
