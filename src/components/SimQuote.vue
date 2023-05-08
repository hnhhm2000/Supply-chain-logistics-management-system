<template>
    <avue-crud
            :data="data"
            :option="option"
            :cell-class-name="addClass"
          >
            <el-button
              slot="menuLeft"
              type="primary"
              icon="el-icon-plus"
              size="small"
              @click="rowadd"
              >新增</el-button>
          </avue-crud>
</template>

<script>
export default {
  name: 'SimQuote',

  data() {
    return {
      option: {
        searchShow: false,
        searchBtn:false,
        excelBtn:false,
        addBtn: false,
        refreshBtn:false,
        columnBtn:false,
        column: [
          {
            label: "状态",
            prop: "Status",
          },
          {
            label: "报价编号",
            prop: "Number",
          },
          {
            label: "托运人",
            prop: "Shipper",
          },
          {
            label: "收货人",
            prop: "Consignee",
          },
          {
            label: "始发地",
            prop: "Origin",
          },
          {
            label: "目的地",
            prop: "Destination",
          },
          {
            label: "目的",
            prop: "Income",
          },
          {
            label: "支出",
            prop: "Expense",
          },
        ],
      },
       data: [
        {
          id: 1,
          Status: "已完成",
          Number: "QUO00000001",
          Shipper: "黄皓铭",
          Consignee: "收货人",
          Origin: "上海",
          Destination: "长沙",
          Income: "100",
          Expense: "100",
        },
      ],
    };
  },
};
</script>

<style lang="scss" scoped>
::v-deep .cell-color {
  color: #409eff !important;
  cursor: pointer;
}
</style>