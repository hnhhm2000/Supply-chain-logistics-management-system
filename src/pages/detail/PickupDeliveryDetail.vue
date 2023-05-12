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
                <el-form-item label="状态:"> </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="财务:"> </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="货物编号:"> </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <el-form-item label="提单:"> </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="提货日期:"> </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="发货日期:"> </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="托运人:"> </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="收货人:"> </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="提货人:"> </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="送货人:"> </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="承运人:"> </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="客户:"> </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="件数:"> </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="价格:"> </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="重量:"> </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="体积:"> </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="收入:"> </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="支出:"> </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="利润:"> </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="创造者:"> </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="创造时间:"> </el-form-item>
              </el-col>
            </el-row>
          </el-form>
        </div>
      </el-card>

      <!-- 卡片二  -->
      <el-card class="whiteCard">
        <div slot="header" class="clearfix">
          <span class="CardTitle">详细信息</span>
        </div>

        <div>
          <el-form ref="form" :model="form" :rules="rules" label-width="10em">
            <el-row>
              <el-col :span="8">
                <el-form-item label="发出公司:" prop="address"> </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="托运人地址:" prop="address">
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="收货人地址:" prop="address">
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <el-form-item label="运输方式:" prop="province"> </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="商品名称:" prop="salesAgency">
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="注意事项:" prop="id"> </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="运输方式:" prop="province"> </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="商品名称:" prop="salesAgency">
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="注意事项:" prop="id"> </el-form-item>
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
                <el-form-item label="创建人:"> </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="创建时间:"> </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="更新人:"> </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <el-form-item label="更新时间:"> </el-form-item>
              </el-col>

              <el-col :span="8">
                <el-form-item label="提货送货ID:"> </el-form-item>
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
        <el-button type="primary" plain @click="$router.back()">返回</el-button>
      </div>
    </footer>
  </div>
</template>
<script>
export default {
  name: "PickuoDeliveryDetail",

  data() {
    return {};
  },

  methods: {},
};
</script>

<style lang="scss" scoped>
@import "../../assets/css/MainInformation.css";
</style>
