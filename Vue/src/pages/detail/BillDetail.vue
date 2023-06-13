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
                <el-form-item label="号码:">
                 
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="类型:">
               
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="关联模块:">
                
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="项目:">
                
              </el-col>
              <el-col :span="8">
                <el-form-item label="日期:">
                
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="供应商:">
                 
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="截止日期:">
              
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="总额:">
                 
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

        <div class="remarks">
        
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
                <el-form-item label="账单ID:">
                
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
  name: "BillDetail",

  data() {
    return {
    InvoiceID:"",
    Number:"",
    CreatedBy:"",
    createTime:"",
    Type:"",
    // 管理模块
    Module:"",
    Project:"",
    Date:"",
    // 供应商
    Vendor:"",
    DueDate:"",
    TotalAmount:"",
    remarks:"",
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
