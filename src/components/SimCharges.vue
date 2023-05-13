<template>
  <avue-crud :data="data" :option="option" :cell-class-name="addClass">

    <el-button
      slot="menuLeft"
      type="primary"
      icon="el-icon-plus"
      size="small"
      @click="rowadd"
      >新增</el-button
    >

     <el-button
      slot="menuLeft"
      type="primary"
      icon="el-icon-plus"
      size="small"
      @click="invoiceadd"
      >生成发票</el-button
    >
     
      <!-- 自定义编辑 -->
     <template slot="editdialog" >
          <el-button type="text" @click="delSelection">
            删除选中行
          </el-button>
        </template>
  </avue-crud>
</template>

<script>
export default {
  name: "SimCharges",

  data() {
    return {
      data: [
        {
          Status: "待定中",
          Description: "运输电子产品的相关费用",
          QTY: 10,
          UNIT: "公斤",
          Rate: 5.0,
          Income: 50.0,
          Profit: 20.0,
          BillTo: "发送给A",
          QtyExpense: 10.0,
          RateExpense: 5.0,
        },
        {
          Status: "已开票",
          Description: "进口钢材的相关费用",
          QTY: 20,
          UNIT: "公斤",
          Rate: 8.0,
          Income: 160.0,
          Profit: 80.0,
          BillTo: "发送给B",
          QtyExpense: 20.0,
          RateExpense: 10.0,
        },
        {
          Status: "已取消",
          Description: "运输电子产品的相关费用",
          QTY: 5,
          UNIT: "公斤",
          Rate: 12.0,
          Income: 60.0,
          Profit: 30.0,
          BillTo: "发送给C",
          QtyExpense: 5.0,
          RateExpense: 6.0,
        },
      ],
      option: {
        searchShow: false,
        excelBtn: true,
        addBtn: false,
        selection: true,
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
            label: "价格",
            prop: "Rate",
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
            label: "数量费用",
            prop: "QtyExpense",
          },
          {
            label: "费率费用",
            prop: "RateExpense",
          },
        ],
      },
    };
  },

  methods: {
    refreshChange() {
      this.$message.success("刷新回调");
    },
    rowSave(form, done, loading) {
      form.id = new Date().getTime();
      setTimeout(() => {
        loading();
      }, 1000);
      setTimeout(() => {
        this.$message.success("新增数据" + JSON.stringify(form));
        done(form);
      }, 2000);
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
    rowUpdate(form, index, done, loading) {
      setTimeout(() => {
        loading();
      }, 1000);
      setTimeout(() => {
        this.$message.success(
          "编辑数据" + JSON.stringify(form) + "数据序号" + index
        );
        done(form);
      }, 2000);
    },
  },
};
</script>

<style lang="scss" scoped>
::v-deep .cell-color {
  color: #409eff !important;
  cursor: pointer;
}


// 删掉上方的提示
::v-deep .el-tag {
    display: none;
}
</style>
