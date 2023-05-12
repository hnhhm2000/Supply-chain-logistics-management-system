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
                <el-form-item label="编号:">
                
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="起飞日:">
               
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="始发地:">
                  <el-input v-model="Origin" size="small" class="input"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="目的地:">
               
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="客户:">
                 
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
                <el-form-item label="件数:">
                
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="重量:">
                
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
                 <el-col :span="8">
                <el-form-item label="承运人:">
              
                </el-form-item>
              </el-col>
            </el-row>

             <el-row>
              <el-col :span="8">
                <el-form-item label="项目:">
               
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="最大容量:">
                
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

        <div class="remark"></div>
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
                <el-form-item label="空运ID:">
                
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
              name: 'InventoryEdit',
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
// import axios from "axios";

export default {
  name: "AirDetail",

   data() {
    return {
      AirFreightID: "",
      Status: "",
      Accounting: "",
      // 空运编号
      Shipment: "",
      // 起飞日
      Departure: "",
      // 抵达日
      Arrival: "",
      Origin: "",
      Destination: "",
      Customer: "",
      Shipper: "",
      Consignee: "",
      PCS: "",
      Weight: "",
      Income: "",
      Expense: "",
      Profit: "",
      Carrier: "",
      Project: "",
      MaxPieces: "",
      remarks: "",
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
