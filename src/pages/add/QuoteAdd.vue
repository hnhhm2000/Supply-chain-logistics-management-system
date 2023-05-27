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
          <el-form ref="form" :rules="rules" label-width="10em">
            <el-row>
              <el-col :span="8">
                <el-form-item label="状态:">
                  <el-select
                    v-model="status"
                    placeholder="请选择"
                    style="width: 18.6em"
                    size="small"
                  >
                    <el-option
                      v-for="item in statusOp"
                      :key="item.value"
                      :label="item.label"
                      :value="item.value"
                    >
                    </el-option>
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="引用:">
                  <el-input
                    v-model="reference"
                    size="small"
                    class="input"
                    placeholder="请输入内容"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="报价编号:">
                  <el-input
                    v-model="quoteNumber"
                    size="small"
                    class="input"
                    placeholder="请输入内容"
                  ></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <el-form-item label="项目:">
                  <el-input
                    v-model="project"
                    size="small"
                    class="input"
                    placeholder="请输入内容"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="报价者:">
                  <el-input
                    v-model="quoter"
                    size="small"
                    class="input"
                    placeholder="请输入内容"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="创建日期:" prop="phone">
                  <el-date-picker
                    v-model="createdDate"
                    type="date"
                    placeholder="选择日期"
                    size="small"
                    class="input"
                  >
                  </el-date-picker>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="截止日期:">
                  <el-date-picker
                    v-model="untilDate"
                    type="date"
                    placeholder="选择日期"
                    size="small"
                    class="input"
                  >
                  </el-date-picker>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="客户:">
                  <el-input
                    v-model="customer"
                    size="small"
                    class="input"
                    placeholder="请输入内容"
                  ></el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-form>
        </div>
      </el-card>

      <!-- 卡片二  -->
      <el-card class="whiteCard">
        <div slot="header" class="clearfix">
          <span class="CardTitle">货物相关</span>
        </div>

        <div>
          <el-form ref="form" :rules="rules" label-width="10em">
            <el-row>
              <el-col :span="8">
                <el-form-item label="客户地址:">
                  <el-input
                    v-model="customerAddress"
                    size="small"
                    class="input"
                    placeholder="请输入内容"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="货物描述:">
                  <el-input
                    v-model="descriptionOfGoods"
                    size="small"
                    class="input"
                    placeholder="请输入内容"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="始发地:">
                  <el-input
                    v-model="origin"
                    size="small"
                    class="input"
                    placeholder="请输入内容"
                  ></el-input>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="目的地:">
                  <el-input
                    v-model="destination"
                    size="small"
                    class="input"
                    placeholder="请输入内容"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="运输方式:">
                  <el-input
                    v-model="mode"
                    size="small"
                    class="input"
                    placeholder="请输入内容"
                  ></el-input>
                </el-form-item>
              </el-col>

              <el-col :span="8">
                <el-form-item label="付款方式:">
                  <el-input
                    v-model="paymentTerm"
                    size="small"
                    class="input"
                    placeholder="请输入内容"
                  ></el-input>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="运输天数:">
                  <el-input
                    v-model="transitDays"
                    size="small"
                    class="input"
                    placeholder="请输入内容"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="个数/件数:">
                  <el-input
                    v-model="pcs"
                    size="small"
                    class="input"
                    placeholder="请输入内容"
                  ></el-input
                ></el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="重量:">
                  <el-input
                    v-model="weight"
                    size="small"
                    class="input"
                    placeholder="请输入内容"
                  ></el-input>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="体积:">
                  <el-input
                    v-model="vol"
                    size="small"
                    class="input"
                    placeholder="请输入内容"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="收入:">
                  <el-input
                    v-model="income"
                    size="small"
                    class="input"
                    placeholder="请输入内容"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="支出:">
                  <el-input
                    v-model="expense"
                    size="small"
                    class="input"
                    placeholder="请输入内容"
                  ></el-input>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="8">
                <el-form-item label="利润:">
                  <el-input
                    v-model="profit"
                    size="small"
                    class="input"
                    placeholder="请输入内容"
                  ></el-input>
                </el-form-item>
              </el-col>

              <el-col :span="8">
                <el-form-item label="托运人:">
                  <el-input
                    v-model="shipper"
                    size="small"
                    class="input"
                    placeholder="请输入内容"
                  ></el-input>
                </el-form-item>
              </el-col>

              <el-col :span="8">
                <el-form-item label="承运人:">
                  <el-input
                    v-model="carrier"
                    size="small"
                    class="input"
                    placeholder="请输入内容"
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
          <el-form ref="form" :rules="rules" label-width="10em">
            <el-row>
              <el-col :span="8">
                <el-form-item label="创建人:">
                  <el-input
                    v-model="createdBy"
                    size="small"
                    class="input"
                    placeholder="请输入内容"
                  ></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="创建时间:">
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
                <el-form-item label="更新人:">
                  <el-input
                    v-model="updateBy"
                    size="small"
                    class="input"
                    placeholder="请输入内容"
                  ></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <el-form-item label="更新时间:">
                  <el-date-picker
                    v-model="updatedOn"
                    type="date"
                    placeholder="选择日期"
                    size="small"
                    class="input"
                  >
                  </el-date-picker>
                </el-form-item>
              </el-col>

              <el-col :span="8">
                <el-form-item label="报价ID:">
                  <el-input
                    v-model="quoteId"
                    disabled
                    size="small"
                    class="input"
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
        <el-button type="primary" @click="submit()"
          >保存提交</el-button
        >
        <el-button type="primary" plain @click="$router.push({path: '/quote'})">返回</el-button>
      </div>
    </footer>
  </div>
</template>
<script>
import { addQuoteData } from "@/api/Quote";
import { Message } from 'element-ui'

export default {
  name: "QuoteAdd",

  data() {
    return {
      quoteId:"",
      status: "",
      reference: "",
      quoteNumber: "",
      project: "",
      quoter: "",
      createdDate: "",
      untilDate: "",
      customer: "",
      shipper: "",
      origin: "",
      destination: "",
      carrier: "",
      customerAddress: "",
      descriptionOfGoods: "",
      mode:"",
      pcs: "",
      weight: "",
      vol: "",
      income: "",
      expense: "",
      profit: "",
      remark: "",
      createdBy: "",
      createTime: "",
      updateBy: "",
      updatedOn: "",
      paymentTerm: "",
      transitDays: "",

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

      statusOp: [
        {
          value: "请求中",
          label: "请求中",
        },
        {
          value: "定价中",
          label: "定价中",
        },
        {
          value: "正在修改",
          label: "正在修改",
        },
        {
          value: "已发送",
          label: "已发送",
        },
        {
          value: "已批准",
          label: "已批准",
        },
        {
          value: "已取消",
          label: "已取消",
        },
        {
          value: "已完成",
          label: "已完成",
        },
      ],
    };
  },

   methods: {
    // 提交添加
    submit() {
    let params = {...this.$data};
    delete params.options;
    delete params.StatusOp;
    
    addQuoteData(params).then((res) => {
      console.log(res.data.code)
      if(res.data.code === 200) {
        // 成功消息
        Message({
          message: '添加成功',
          type: 'success'
        });
        this.$router.push({ path:'/quote' })
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
