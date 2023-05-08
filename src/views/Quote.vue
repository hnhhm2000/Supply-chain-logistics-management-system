<template>
  <div>
    <NavMenu class="sidebar"></NavMenu>
    <TopMenu class="topmenu"></TopMenu>
    
    <main>
      <avue-crud
        :data="data"
        :option="option"
        :search-show="false"
        @refresh-change="refreshChange"
        @row-update="rowUpdate"
        @row-del="rowDel"
        @search-change="searchChange"
        @search-reset="resetChange"
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
    </main>
  </div>
</template>

<script>
export default {
  name: "QuoteManage",

  data() {
    return {
      data: [
        {
          id: 1,
          name: "张三",
          sex: "男",
          address: "长沙雨花区万家丽商业广场",
          phone: "13667349408",
          reprentative: "王五",
          city: "长沙",
          state: "在线",
          ZIP: "410007",
        },
      ],
      option: {
        searchShow: false,
        excelBtn: true,
        addBtn: false,
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