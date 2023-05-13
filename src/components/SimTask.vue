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
  name: "SimTask",

  data() {
    return {
      data: [
        {
          DueDate: "2023-05-15",
          Reference: "QUO0000001",
          subject: "新的报价",
          TaskOwner: "任务负责人A",
          Status: "进行中",
          priority: "高",
          AccountReleted: "相关账户A",
          Module: "报价",
        },
        {
          DueDate: "2023-05-20",
          Reference: "",
          subject: "一车菠萝",
          TaskOwner: "任务负责人B",
          Status: "已完成",
          priority: "中",
          AccountReleted: "相关账户B",
          Module: "",
        },
        {
          DueDate: "2023-05-25",
          Reference: "",
          subject: "一百吨钢材",
          TaskOwner: "任务负责人C",
          Status: "已取消",
          priority: "低",
          AccountReleted: "相关账户C",
          Module: "",
        },
      ],
      option: {
        searchShow: false,
        excelBtn: true,
        addBtn: false,
        column: [
          {
            label: "截止日期",
            prop: "DueDate",
          },
          {
            label: "引用",
            prop: "Reference",
          },
          {
            label: "主题",
            prop: "subject",
          },
          {
            label: "任务负责人",
            prop: "TaskOwner",
          },
          {
            label: "状态",
            prop: "Status",
          },
          {
            label: "优先事项",
            prop: "priority",
          },
          {
            label: "相关账户",
            prop: "AccountReleted",
          },
          {
            label: "模块",
            prop: "Module",
          },
        ],
      },
    };
  },

  methods: {
    handleClick(tab, event) {
      console.log(tab, event);
    },
    refreshChange() {
      this.$message.success("刷新回调");
    },
    rowSave(form, done, loading) {
      form.id = new Date().getTime();
      setTimeout(() => {
        loading();
      }, 1000);
      setTimeout(() => {
        this.$message.success("新增数据" + JSON.stringify(form));
        done(form);
      }, 2000);
    },
    rowDel(form, index, done) {
      this.$confirm("此操作将永久删除该文件, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          done(form);
          this.$message({
            type: "success",
            message: "删除成功!",
          });
        })
        .catch(() => {});
    },
    rowUpdate(form, index, done, loading) {
      setTimeout(() => {
        loading();
      }, 1000);
      setTimeout(() => {
        this.$message.success(
          "编辑数据" + JSON.stringify(form) + "数据序号" + index
        );
        done(form);
      }, 2000);
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
