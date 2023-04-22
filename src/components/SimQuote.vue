<template>
    <avue-crud
            :data="data"
            :option="option"
            :search-show="false"
            :cell-class-name="addClass"
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
            label: "活动",
            prop: "Activity",
          },
          {
            label: "数字",
            prop: "Number",
          },
          {
            label: "制造者",
            prop: "CreatedBy",
          },
          {
            label: "创建于",
            prop: "CreatedOn",
          },
          {
            label: "项目",
            prop: "Project",
          },
          {
            label: "账户参考",
            prop: "CustomerRef",
          },
          {
            label: "模式",
            prop: "mode",
          },
          {
            label: "有效期至...",
            prop: "valid until",
          },
          {
            label: "顾客",
            prop: "Customer",
          },
          {
            label: "收货港",
            prop: "portofreceipt",
          },
          {
            label: "起源",
            prop: "Origin",
          },
          {
            label: "目的地",
            prop: "Destination",
          },
          {
            label: "运输天数",
            prop: "TransitDays",
          },
          {
            label: "承运人",
            prop: "CarrierBroken",
          },
          {
            label: "PCS",
            prop: "PCS",
          },
          {
            label: "体重(镑)",
            prop: "Weight",
          },
          {
            label: "VOL(FT3)",
            prop: "VOL(FT3)",
          },
          {
            label: "VOL WEIGHT(LB)",
            prop: "VOL WEIGHT(LB)",
          },
          {
            label: "收入",
            prop: "Income",
          },
          {
            label: "费用",
            prop: "Expense",
          },
          {
            label: "利润",
            prop: "Profit",
          },
          {
            label: "货币",
            prop: "Currency",
          },
          {
            label: "更新人",
            prop: "UpdatedBy",
          },
          {
            label: "更新时间",
            prop: "UpdateOn",
          },
          {
            label: "注释",
            prop: "Notes",
          },
        ],
      },
    };
  },

  mounted() {
    
  },

  methods: {
    
  },
};
</script>

<style lang="scss" scoped>
::v-deep .cell-color {
  color: #409eff !important;
  cursor: pointer;
}
</style>