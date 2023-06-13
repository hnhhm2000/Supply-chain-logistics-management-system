<template>
  <avue-crud
    :data="data"
    :option="option"
    :cell-class-name="addClass"
    @refresh-change="refreshChange"
    @row-save="rowSave"
    @row-update="rowUpdate"
    @row-del="rowDel"
    v-model="data"
  >
    <!-- 状态选择框 -->
    <template slot-scope="" slot="statusForm">
      <el-select v-model="data.status" placeholder="请选择 状态">
        <el-option
          v-for="item in statusOp"
          :key="item.value"
          :label="item.label"
          :value="item.value"
        >
        </el-option>
      </el-select>
    </template>
  </avue-crud>
</template>

<script>
import {
  addSimQuoteData,
  updateSimQuoteData,
  deleteSimQuoteData,
} from "../api/Crm";

export default {
  name: "SimQuote",
  props: ["quoteData"],

  watch: {
    // 获取父组件传递过来的数据
    quoteData: {
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
            label: "状态",
            prop: "status",
            formslot: true,
          },
          {
            label: "报价编号",
            prop: "quoteNumber",
            width: 180,
          },
          {
            label: "托运人",
            prop: "shipper",
          },
          {
            label: "收货人",
            prop: "consignee",
          },
          {
            label: "始发地",
            prop: "origin",
          },
          {
            label: "目的地",
            prop: "destination",
          },
          {
            label: "收入",
            prop: "income",
          },
          {
            label: "支出",
            prop: "expense",
          },
        ],
      },
      data: [],
      statusOp: [
        {
          value: "请求中",
          label: "请求中",
        },
        {
          value: "定价中",
          label: "定价中",
        },
        {
          value: "正在修改",
          label: "正在修改",
        },
        {
          value: "已发送",
          label: "已发送",
        },
        {
          value: "已批准",
          label: "已批准",
        },
        {
          value: "已取消",
          label: "已取消",
        },
        {
          value: "已完成",
          label: "已完成",
        },
      ],
      userId: this.$route.params.id,
    };
  },

  methods: {
    refreshChange() {
      this.$message.success("刷新回调");
    },

    // 新增数据
    rowSave(form, done) {
      form.userId = this.userId;

      addSimQuoteData(form).then(() => {
        this.$message({
          type: "success",
          message: "新增成功!",
        });
        this.$emit("update-data");
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
          params.quoteId = row.id;

          deleteSimQuoteData(params).then(() => {
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
      updateSimQuoteData(row).then(() => {
        this.$message({
          type: "success",
          message: "编辑成功!",
        });
        this.$emit("update-data");
        done(form);
      });
    },
  },
};
</script>

<style lang="scss" scoped>
::v-deep .cell-color {
  color: #409eff !important;
  cursor: pointer;
}
</style>