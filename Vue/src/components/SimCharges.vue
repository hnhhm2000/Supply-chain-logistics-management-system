<template>
  <avue-crud :data="data" :option="option" :cell-class-name="addClass">
    <!-- 新增按钮 -->
    <template slot="menuLeft">
      <el-button
        type="primary"
        icon="el-icon-plus"
        size="small"
        @click="addDialog = true"
        >新增
      </el-button>

      <!-- 增加dialog -->
      <el-dialog
        title="增加收费"
        :visible.sync="addDialog"
        width="65%"
        :before-close="handleClose"
        :modal="false"
      >
        <el-form :model="form">
          <el-row>
            <el-col :offset="1" :span="6">
              <el-form-item label="服务" :label-width="formLabelWidth">
                <el-input v-model="Service" autocomplete="off"></el-input>
              </el-form-item>
            </el-col>

            <el-col :offset="1" :span="16">
              <el-form-item label="服务描述" :label-width="formLabelWidth">
                <el-input v-model="Description" autocomplete="off"></el-input>
              </el-form-item>
            </el-col>
          </el-row>

          <el-tabs v-model="activeName" class="eltabs">
            <!-- 收入tab -->
            <el-tab-pane label="收入" name="first">
              <el-row>
                <el-col :span="6">
                  <el-form-item label="数量" :label-width="formLabelWidth">
                    <el-input
                      v-model="financeService.incomeQuantity"
                      autocomplete="off"
                      size="small"
                    ></el-input>
                  </el-form-item>
                </el-col>

                <el-col :span="6">
                  <el-form-item label="单位" :label-width="formLabelWidth">
                    <el-input
                      v-model="financeService.incomeUnits"
                      autocomplete="off"
                      size="small"
                    ></el-input>
                  </el-form-item>
                </el-col>

                <el-col :span="6">
                  <el-form-item label="单价" :label-width="formLabelWidth">
                    <el-input
                      v-model="financeService.incomePrice"
                      autocomplete="off"
                      size="small"
                    ></el-input>
                  </el-form-item>
                </el-col>

                <el-col :span="6">
                  <el-form-item label="总价" :label-width="formLabelWidth">
                    <el-input
                      v-model="financeService.incomeAmount"
                      autocomplete="off"
                      size="small"
                    ></el-input>
                  </el-form-item>
                </el-col>
              </el-row>

              <el-row>
                <el-col :span="6">
                  <el-form-item label="引用" :label-width="formLabelWidth">
                    <el-input
                      v-model="financeService.incomeReference"
                      autocomplete="off"
                      size="small"
                    ></el-input>
                  </el-form-item>
                </el-col>

                <el-col :span="6">
                  <el-form-item label="收票人" :label-width="formLabelWidth">
                    <el-input
                      v-model="financeService.incomeBillToName"
                      autocomplete="off"
                      size="small"
                    ></el-input>
                  </el-form-item>
                </el-col>

                <el-col :span="6">
                  <el-form-item label="是否付款" label-width="80px">
                    <el-select
                      v-model="financeService.incomepayment"
                      placeholder="请选择"
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

              <el-form-item label="备注" :label-width="formLabelWidth">
                <div class="remarks">
                  <el-input
                    type="textarea"
                    :rows="4"
                    placeholder="请输入内容"
                    v-model="financeService.incomeremarks"
                  >
                  </el-input>
                </div>
              </el-form-item>
            </el-tab-pane>

            <!-- 支出tab -->
            <el-tab-pane label="支出" name="second">
              <el-row>
                <el-col :span="6">
                  <el-form-item label="数量" :label-width="formLabelWidth">
                    <el-input
                      v-model="financeService.expenseQuantity"
                      autocomplete="off"
                      size="small"
                    ></el-input>
                  </el-form-item>
                </el-col>

                <el-col :span="6">
                  <el-form-item label="单位" :label-width="formLabelWidth">
                    <el-input
                      v-model="financeService.expenseUnits"
                      autocomplete="off"
                      size="small"
                    ></el-input>
                  </el-form-item>
                </el-col>

                <el-col :span="6">
                  <el-form-item label="单价" :label-width="formLabelWidth">
                    <el-input
                      v-model="financeService.expensePrice"
                      autocomplete="off"
                      size="small"
                    ></el-input>
                  </el-form-item>
                </el-col>

                <el-col :span="6">
                  <el-form-item label="总价" :label-width="formLabelWidth">
                    <el-input
                      v-model="financeService.expenseAmount"
                      autocomplete="off"
                      size="small"
                    ></el-input>
                  </el-form-item>
                </el-col>
              </el-row>

              <el-row>
                <el-col :span="6">
                  <el-form-item label="引用" :label-width="formLabelWidth">
                    <el-input
                      v-model="financeService.expenseReference"
                      autocomplete="off"
                      size="small"
                    ></el-input>
                  </el-form-item>
                </el-col>

                <el-col :span="6">
                  <el-form-item label="供应商" :label-width="formLabelWidth">
                    <el-input
                      v-model="financeService.expenseBillToName"
                      autocomplete="off"
                      size="small"
                    ></el-input>
                  </el-form-item>
                </el-col>

                <el-col :span="6">
                  <el-form-item label="是否付款" label-width="80px">
                    <el-select
                      v-model="financeService.expensepayment"
                      placeholder="请选择"
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

              <el-form-item label="备注" :label-width="formLabelWidth">
                <div class="remarks">
                  <el-input
                    type="textarea"
                    :rows="4"
                    placeholder="请输入内容"
                    v-model="financeService.expenseremarks"
                  >
                  </el-input>
                </div>
              </el-form-item>
            </el-tab-pane>
          </el-tabs>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="addDialog = false">取 消</el-button>
          <el-button type="primary" @click="addDialog = false">确 定</el-button>
        </span>
      </el-dialog>
    </template>

    <!-- 生成财务数据 -->
    <el-dropdown slot="menuLeft">
      <el-button type="primary" size="small">
        生成财务数据<i class="el-icon-arrow-down el-icon--right"></i>
      </el-button>
      <el-dropdown-menu slot="dropdown">
        <el-dropdown-item @click="invoiceAdd">生成发票</el-dropdown-item>
        <el-dropdown-item @click="billAdd">生成账单</el-dropdown-item>
      </el-dropdown-menu>
    </el-dropdown>

    <!-- 自定义编辑 -->
    <template slot-scope="{ type, size }" slot="menu">
      <el-button
        icon="el-icon-edit"
        class="editbtn"
        :size="size"
        :type="type"
        @click="editDialog = true"
        >编辑</el-button
      >

      <el-dialog
        title="编辑"
        :visible.sync="editDialog"
        width="30%"
        :before-close="handleClose"
        :modal="false"
      >
        <span>这是编辑</span>
        <span slot="footer" class="dialog-footer">
          <el-button @click="editDialog = false">取 消</el-button>
          <el-button type="primary" @click="editDialog = false"
            >确 定</el-button
          >
        </span>
      </el-dialog>
    </template>
  </avue-crud>
</template>

<script>
export default {
  name: "SimCharges",

  data() {
    return {
      addDialog: false,
      editDialog: false,
      activeName: "first",
      formLabelWidth: "70px",

      financeService: {
        service: "",
        serviceDescription: "",
        incomeQuantity: "",
        expenseQuantity: "",
        incomeUnits: "",
        expenseUnits: "",
        incomePrice: "",
        expensePrice: "",
        incometotal: "",
        expensetotal:"",
        billToName: "",
        vendor: "",
        incomeReference: "",
        expenseReference: "",
        incomePayment: "",
        expensePayment: "",
        incomeRemarks: "",
        expenseRemarks: "",
      },

      options: [
        {
          value: "已付款",
          label: "已付款",
        },
        {
          value: "未付款",
          label: "未付款",
        },
      ],

      data: [
        {
          Status: "待定中",
          Description: "运输电子产品的相关费用",
          QTY: 10,
          UNIT: "公斤",
          Price: 5.0,
          Income: 50.0,
          Profit: 20.0,
          BillTo: "发送给A",
          QtyExpense: 10.0,
          PriceExpense: 5.0,
        },
        {
          Status: "已开票",
          Description: "进口钢材的相关费用",
          QTY: 20,
          UNIT: "公斤",
          Price: 8.0,
          Income: 160.0,
          Profit: 80.0,
          BillTo: "发送给B",
          QtyExpense: 20.0,
          PriceExpense: 10.0,
        },
        {
          Status: "已取消",
          Description: "运输电子产品的相关费用",
          QTY: 5,
          UNIT: "公斤",
          Price: 12.0,
          Income: 60.0,
          Profit: 30.0,
          BillTo: "发送给C",
          QtyExpense: 5.0,
          PriceExpense: 6.0,
        },
      ],
      option: {
        searchShow: false,
        excelBtn: true,
        addBtn: false,
        selection: true,
        editBtn: false,
        column: [
          {
            label: "状态",
            prop: "Status",
          },
          {
            label: "描述",
            prop: "Description",
            width: 250,
          },
          {
            label: "数量",
            prop: "QTY",
          },
          {
            label: "单位",
            prop: "UNIT",
          },
          {
            label: "单价",
            prop: "price",
          },
          {
            label: "收入",
            prop: "Income",
          },
          {
            label: "利润",
            prop: "Profit",
          },
          {
            label: "发送给",
            prop: "BillTo",
          },
          {
            label: "总价",
            prop: "total",
          },
        ],
      },
    };
  },

  methods: {
    refreshChange() {
      this.$message.success("刷新回调");
    },

    rowDel(form, index, done) {
      this.$confirm("此操作将永久删除该文件, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          done(form);
          this.$message({
            type: "success",
            message: "删除成功!",
          });
        })
        .catch(() => {});
    },
  },
};
</script>

<style lang="scss" scoped>
::v-deep .cell-color {
  color: #409eff !important;
  cursor: pointer;
}

.eltabs {
  margin: 0 2.2em 0 3em;
}

// 删掉上方的提示
::v-deep .el-tag {
  display: none;
}
</style>
