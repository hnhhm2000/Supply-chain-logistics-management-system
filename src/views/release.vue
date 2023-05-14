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

         <template slot-scope="{ type, size, row }" slot="menu">
          <el-button
            icon="el-icon-edit"
            class="editbtn"
            :size="size"
            :type="type"
            @click="$router.push(`/release/edit/${row.id}`)"
            >编辑</el-button
          >
        </template>
      </avue-crud>
    </main>
  </div>
</template>

<script>
export default {
  name: "MyRelease",

  data() {
    return {
      activeName: "first",
      data: [
        {
          Status: "预发货",
          Accounting: "空",
          number: "WRO0000001",
          CreatedBy: "创建人A",
          CreateOn: "2023-05-01",
          DateTimeOut: "2023-05-10",
          ReleaseTo: "发往A",
          PCS: 50,
          Weight: "1000 kg",
          VOL: "10 m³",
          Income: 5000,
          Expense: 3000,
          Profit: 2000,
          UpdatedBy: "更新人A",
          UpdatedOn: "2023-05-12",
        },
        {
          Status: "已完成",
          Accounting: "已开票",
          number: "WRO0000002",
          CreatedBy: "创建人B",
          CreateOn: "2023-04-15",
          DateTimeOut: "2023-04-30",
          ReleaseTo: "发往B",
          PCS: 20,
          Weight: "500 kg",
          VOL: "5 m³",
          Income: 8000,
          Expense: 4000,
          Profit: 4000,
          UpdatedBy: "更新人B",
          UpdatedOn: "2023-05-05",
        },
        {
          Status: "发货中",
          Accounting: "待定中",
          number: "WRO0000003",
          CreatedBy: "创建人C",
          CreateOn: "2023-05-05",
          DateTimeOut: "2023-05-20",
          ReleaseTo: "发往C",
          PCS: 10,
          Weight: "200 kg",
          VOL: "2 m³",
          Income: 2000,
          Expense: 1500,
          Profit: 500,
          UpdatedBy: "更新人C",
          UpdatedOn: "2023-05-12",
        },
      ],
      option: {
        searchShow: false,
        excelBtn: true,
        addBtn: false,
        editBtn:false,
        column: [
          {
            label: "状态",
            prop: "Status",
            search:true
          },
          {
            label: "财务",
            prop: "Accounting",
          },
          {
            label: "编号",
            prop: "number",
            search:true,
            width:100
          },
          {
            label: "创建人",
            prop: "CreatedBy",
            search:true
          },
          {
            label: "创造时间",
            prop: "CreateOn",
            search:true,
            width:90
          },
          {
            label: "出库日期",
            prop: "DateTimeOut",
            width:90
          },
          {
            label: "发往",
            prop: "ReleaseTo",
          },
          {
            label: "件数",
            prop: "PCS",
          },
          {
            label: "重量",
            prop: "Weight",
          },
          {
            label: "体积",
            prop: "VOL",
          },
          {
            label: "收入",
            prop: "Income",
          },
          {
            label: "支出",
            prop: "Expense",
          },
          {
            label: "利润",
            prop: "Profit",
          },
          {
            label: "更新人",
            prop: "UpdatedBy",
          },
          {
            label: "更新时间",
            prop: "UpdatedOn",
            width:90
          },
        ],
      },
    };
  },

  methods: {
    // 点击姓名进入详情
    addClass({ columnIndex }) {
      if (columnIndex === 2) {
        return "cell-color"; // cell-blue就是添加的类名，添加完之后记得设置样式
      }
    },

    /**
     * @description: 点击名字进行跳转
     */
    pageto(row, column) {
      if (column.label == "编号") {
        this.$router.push(`/release/detail/${row.id}`);
      }
    },

    refreshChange() {
      this.$message.success("刷新回调");
    },

    // 增加数据
    rowadd() {
      this.$router.push("./release/add");
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
