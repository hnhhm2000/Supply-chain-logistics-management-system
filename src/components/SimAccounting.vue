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
  name: "SimAccounting",

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
            label: "号码",
            prop: "Number",
          },
          {
            label: "类型",
            prop: "Type",
          },
          {
            label: "日期",
            prop: "Date",
          },
          {
            label: "发票人或卖方",
            prop: "BillorVendor",
          },
          {
            label: "到期时间",
            prop: "DueDate",
          },
          {
            label: "金额",
            prop: "Amount",
          },
        ],
      },
    };
  },

  mounted() {},

  methods: {},
};
</script>

<style lang="scss" scoped>
</style>