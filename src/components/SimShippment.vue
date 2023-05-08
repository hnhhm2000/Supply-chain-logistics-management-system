<template>
  <avue-crud
    :data="data"
    :option="option"
    :cell-class-name="addClass"
    @cell-click="pageto"
    class="Mycrud"
  >
    <el-button
      slot="menuLeft"
      type="primary"
      icon="el-icon-plus"
      size="small"
      @click="rowadd"
      >新增</el-button
    >
  </avue-crud>
</template>

<script>
export default {
  name: "SimShippment",

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
            label: "会计",
            prop: "Accouting",
          },
          {
            label: "装运",
            prop: "Shipment",
          },
          {
            label: "类型",
            prop: "Type",
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
            label: "发货时间",
            prop: "Departure",
          },
          {
            label: "抵达时间",
            prop: "Arrival",
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
            label: "收入",
            prop: "Income",
          },
          {
            label: "支出",
            prop: "Expense",
          },
        ],
      },
       data: [{
          Status:'已下单',
          Accouting:'空/发票/账单',
          Shipment:'AIC000000001',
          Type:'空运',
          Shipper:'黄皓铭',
          Consignee:'黄皓铭',
          Departure:'2023-05-23',
          Arrival:'2023-05-24',
          Origin:'上海',
          Destination:'长沙',
          Income:'100',
          Expense:'100'
        }],
    };
  },
};
</script>

<style lang="scss" scoped>
</style>