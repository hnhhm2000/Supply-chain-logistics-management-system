<template>
  <avue-crud
    :data="data"
    :option="option"
    :cell-class-name="addClass"
    @refresh-change="refreshChange"
    @row-save="rowSave"
    @row-update="rowUpdate"
    @row-del="rowDel"
  >
  </avue-crud>
</template>

<script>
import {
  addSimInventoryData,
  updateSimInventoryData,
  deleteSimInventoryData,
} from "../api/Crm";

export default {
  name: "SimInventory",
  props: ["inventoryData"],

  watch: {
    // 获取父组件传递过来的数据
    inventoryData: {
      immediate: true,
      handler(newValue) {
        this.data = newValue;
        console.log(newValue);
      },
    },
  },

  data() {
    return {
      option: {
        searchShow: false,
        searchBtn: false,
        excelBtn: false,
        refreshBtn: false,
        columnBtn: false,
        column: [
          {
            label: "收据编号",
            prop: "receiptNumber",
          },
          {
            label: "托运人",
            prop: "shipper",
          },
          {
            label: "件数",
            prop: "pcs",
          },
          {
            label: "描述",
            prop: "description",
          },
          {
            label: "尺寸 ",
            prop: "dIM",
          },
          {
            label: "重量（斤）",
            prop: "weight",
          },
          {
            label: "体积（立方米）",
            prop: "vol",
          },
        ],
      },
      data: [],
    };
  },

      methods: {
    refreshChange() {
      this.$message.success("刷新回调");
    },

    // 新增数据
    rowSave(form, done) {
      form.inventoryId = this.inventoryId;
      this.$emit("update-data");

      addSimInventoryData(form).then(() => {
        this.$message({
          type: "success",
          message: "新增成功!",
        });
        done();
      });
    },

    // 删除数据
    rowDel(row, done) {
      this.$confirm("此操作将永久删除该文件, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          let params = {};
          params.inventoryId = row.id;

          deleteSimInventoryData(params).then(() => {
            this.$message({
              type: "success",
              message: "删除成功!",
            });
            this.$emit("update-data");
            done();
          });
        })
        .catch(() => {});
    },

    // 修改数据
    rowUpdate(row, form, done) {
      updateSimInventoryData(row).then(() => {
        this.$emit("update-data");

        this.$message({
          type: "success",
          message: "编辑成功!",
        });
        done(form);
      });
    },
  },
};
</script>

<style lang="scss" scoped>
</style>