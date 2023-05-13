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
            @click="$router.push(`/quote/edit/${row.id}`)"
            >编辑</el-button
          >
        </template>
        
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
          Status: "请求中",
          Activity: "WRO0000001",
          QuoteNumber: "QUO0000001",
          Project: "项目A",
          Mode: "海运",
          CreatedOn: "2023-05-01",
          UntilDate: "2023-05-15",
          Customer: "客户A",
          Origin: "上海",
          Destination: "纽约",
          Carrier: "承运人A",
          TransitDays: 10,
          PCS: 50,
          Weight: 1000,
          VOL: 10,
          Income: 5000,
          Expense: 3000,
          Profit: 2000,
          CreatedBy: "创建人A",
          CreatedTime: "08:00",
          UpdatedBy: "更新人A",
          UpdateOn: "2023-05-10",
          Remarks: "备注1",
        },
        {
          Status: "定价中",
          Activity: "WRO0000002",
          QuoteNumber: "QUO0000002",
          Project: "项目B",
          Mode: "空运",
          CreatedOn: "2023-04-15",
          UntilDate: "2023-04-30",
          Customer: "客户B",
          Origin: "北京",
          Destination: "伦敦",
          Carrier: "承运人B",
          TransitDays: 7,
          PCS: 20,
          Weight: 500,
          VOL: 5,
          Income: 8000,
          Expense: 4000,
          Profit: 4000,
          CreatedBy: "创建人B",
          CreatedTime: "12:30",
          UpdatedBy: "更新人B",
          UpdateOn: "2023-05-05",
          Remarks: "备注2",
        },
        {
          Status: "已取消",
          Activity: "WRO0000003",
          QuoteNumber: "QUO0000003",
          Project: "项目C",
          Mode: "陆运",
          CreatedOn: "2023-05-05",
          UntilDate: "2023-05-20",
          Customer: "客户C",
          Origin: "广州",
          Destination: "深圳",
          Carrier: "承运人C",
          TransitDays: 3,
          PCS: 10,
          Weight: 200,
          VOL: 2,
          Income: 2000,
          Expense: 1500,
          Profit: 500,
          CreatedBy: "创建人C",
          CreatedTime: "16:45",
          UpdatedBy: "更新人C",
          UpdateOn: "2023-05-08",
          Remarks: "备注3",
        },
      ],
      option: {
        searchShow: false,
        excelBtn: true,
        addBtn: false,
        editBtn: false,
        column: [
          {
            label: "状态",
            prop: "Status",
            search: true,
          },
          {
            label: "业务",
            prop: "Activity",
          },
          {
            label: "报价编号",
            prop: "QuoteNumber",
            search: true,
          },
          {
            label: "项目",
            prop: "Project",
          },
          {
            label: "运输方式",
            prop: "Mode",
            search: true,
          },
          {
            label: "创建日期",
            prop: "CreatedOn",
            search: true,
          },
          {
            label: "截止日期",
            prop: "UntilDate",
          },
          {
            label: "客户",
            prop: "Customer",
            search: true,
          },
          {
            label: "始发地",
            prop: "Origin",
            search: true,
          },
          {
            label: "目的地",
            prop: "Destination",
            search: true,
          },
          {
            label: "承运人",
            prop: "Carrier",
            search: true,
          },
          {
            label: "运输天数",
            prop: "TransitDays",
          },
          {
            label: "件数",
            prop: "PCS",
          },
          {
            label: "重量（斤）",
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
            label: "创建人",
            prop: "CreatedOn",
            width:90
          },
          {
            label: "创建时间",
            prop: "CreatedOn",
            width:90
          },
          {
            label: "更新人",
            prop: "UpdatedBy",
            search: true,
          },
          {
            label: "最近更新",
            prop: "UpdateOn",
            width:90
          },
          {
            label: "备注",
            prop: "Remarks",
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
      if (column.label == "报价编号") {
        this.$router.push(`/quote/detail/${row.id}`);
      }
    },

    refreshChange() {
      this.$message.success("刷新回调");
    },

    // 增加数据
    rowadd() {
      this.$router.push("./quote/add");
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