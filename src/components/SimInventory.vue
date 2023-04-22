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
  name: 'SimInventory',

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
            label: "货物",
            prop: "Cargo",
          },
          {
            label: "收据",
            prop: "reference",
          },
          {
            label: "收据状态",
            prop: "number",
          },
          {
            label: "装运单",
            prop: "containers",
          },
          {
            label: "装运单状态",
            prop: "createby",
          },
          {
            label: "目的地 ",
            prop: "priority",
          },
            {
            label: "托运人",
            prop: "createtime",
          },
          {
            label: "收货人",
            prop: "outtime",
          },
          {
            label: "代理",
            prop: "timeout",
          },
           {
            label: "PCS",
            prop: "releaseto",
          },
           {
            label: "类型",
            prop: "releaseto",
          },
           {
            label: "项目代码",
            prop: "releaseto",
          },
           {
            label: "描述",
            prop: "releaseto",
          },
          {
            label: "货物尺寸",
            prop: "releaseto",
          },
          {
            label: "重量",
            prop: "releaseto",
          },
          {
            label: "体积(立方英尺)",
            prop: "releaseto",
          },
          {
            label: "体积重量",
            prop: "releaseto",
          },
          {
            label: "条形码",
            prop: "releaseto",
          },
            {
            label: "位置",
            prop: "releaseto",
          },
            {
            label: "收货日期",
            prop: "releaseto",
          },
            {
            label: "货物跟踪",
            prop: "releaseto",
          },
            {
            label: "订单号",
            prop: "releaseto",
          },
            {
            label: "采购订单",
            prop: "releaseto",
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