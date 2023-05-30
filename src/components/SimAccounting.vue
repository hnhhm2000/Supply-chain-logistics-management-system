<template>
  <avue-crud
    :data="data"
    :option="option"
    :cell-class-name="addClass"
  >
  
  </avue-crud>
</template>

<script>
export default {
  name: "SimAccounting",

  data() {
    return {
      option: {
        searchShow: false,
        searchBtn: false,
        excelBtn: false,
        addBtn: false,
        refreshBtn: false,
        columnBtn: false,
        column: [
          {
            label: "状态",
            prop: "Status",
          },
          {
            label: "号码",
            prop: "Number",
          },
          {
            label: "类型",
            prop: "Type",
          },
          {
            label: "创造日期",
            prop: "Date",
          },
          {
            label: "收票人或供应商",
            prop: "BillToOrVendor",
          },
          {
            label: "截止时间",
            prop: "DueDate",
          },
          {
            label: "金额",
            prop: "Amount",
          },
        ],
      },
      data: [
        {
          Status: "已开票",
          Number: "INV0000003",
          Type: "发票",
          Date: "2023-05-02",
          BillToOrVendor: "黄皓铭",
          DueDate: "2023-05-17",
          Amount: "100",
        },
      ],
    };
  },
};
</script>

<style lang="scss" scoped>
</style>