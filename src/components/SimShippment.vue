<template>
<avue-crud
            :data="data"
            :option="option"
            :cell-class-name="addClass"
            @cell-click="pageto"
            class="Mycrud"
          >
            
              <el-button slot="menuLeft"
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
  name: 'SimShippment',

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
            label: "发货地",
            prop: "Departure",
          },
          {
            label: "目的地",
            prop: "Arrival",
          },
            {
            label: "原产地",
            prop: "Origin",
          },
            {
            label: "收入",
            prop: "Income",
          },
            {
            label: "费用",
            prop: "Expense",
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

</style>