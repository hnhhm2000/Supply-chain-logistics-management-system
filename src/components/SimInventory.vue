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
            label: "收据编号",
            prop: "Receipt",
          },
          {
            label: "托运人",
            prop: "Shipper",
          },
          {
            label: "件数",
            prop: "PCS",
          },
          {
            label: "描述",
            prop: "Description",
          },
          {
            label: "尺寸 ",
            prop: "DIM",
          },
            {
            label: "重量（斤）",
            prop: "Weight",
          },
          {
            label: "体积（立方米）",
            prop: "VOL",
          },
        ],
      },
      data:[{
        Receipt:'WRI0000006',
        Shipper:'黄皓铭',
        Consignee:'黄皓铭',
        PCS:'件数',
        Description:'商品描述',
        DIM:'55.91 x 55.12 x 57.09',
        Weight:'10',
        VOL:'10'
      }]
    };
  },
};
</script>

<style lang="scss" scoped>

</style>