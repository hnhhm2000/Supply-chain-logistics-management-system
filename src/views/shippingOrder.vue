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
            @click="$router.push(`/shippingorder/edit/${row.id}`)"
            >编辑</el-button
          >
        </template>
      </avue-crud>
    </main>
  </div>
</template>

<script>
export default {
  name: "ShippingOrder",

  data() {
    return {
      activeName: "first",
      data: [
        {
          Status: "已下单",
          Accounting: "空",
          ShipmentOrders: "SAO0000001",
          CreatedBy: "创建人A",
          CreatedOn: "2023-05-01",
          Type: "海运",
          Departure: "2023-05-10",
          Arrival: "2023-05-20",
          Shipper: "托运人A",
          Consignee: "收货人A",
          PCS: 50,
          Weight: 1000,
          VOL: 10,
          Income: 5000,
          Expense: 3000,
          Profit: 2000,
          UpdateOn: "2023-05-12",
          Remarks: "备注1",
        },
        {
          Status: "提货中",
          Accounting: "空",
          ShipmentOrders: "SGO0000001",
          CreatedBy: "创建人B",
          CreatedOn: "2023-04-15",
          Type: "空运",
          Departure: "2023-04-25",
          Arrival: "2023-05-05",
          Shipper: "托运人B",
          Consignee: "收货人B",
          PCS: 20,
          Weight: 500,
          VOL: 5,
          Income: 8000,
          Expense: 4000,
          Profit: 4000,
          UpdateOn: "2023-05-10",
          Remarks: "备注2",
        },
        {
          Status: "已装货",
          Accounting: "空",
          ShipmentOrders: "SAO0000002",
          CreatedBy: "创建人C",
          CreatedOn: "2023-05-05",
          Type: "陆运",
          Departure: "2023-05-15",
          Arrival: "2023-05-25",
          Shipper: "托运人C",
          Consignee: "收货人C",
          PCS: 10,
          Weight: 200,
          VOL: 2,
          Income: 2000,
          Expense: 1500,
          Profit: 500,
          UpdateOn: "2023-05-12",
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
            Search: true,
          },
          {
            label: "财务",
            prop: "Accounting",
          },
          {
            label: "装运单编号",
            prop: "ShipmentOrders",
            Search: true,
          },
          {
            label: "创建人",
            prop: "CreatedBy",
            Search: true,
          },
          {
            label: "创建时间",
            prop: "CreatedOn",
            Search: true,
          },
          {
            label: "运输类型",
            prop: "Type",
          },
          {
            label: "发货日",
            prop: "Departure",
          },
          {
            label: "收货日",
            prop: "Arrival",
          },
          {
            label: "托运人",
            prop: "Shipper",
            Search: true,
          },
          {
            label: "收货人",
            prop: "Consignee",
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
            label: "更新时间",
            prop: "UpdateOn",
          },
          {
            label: "注释",
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
      if (column.label == "装运单编号") {
        this.$router.push(`/shippingOrder/detail/${row.id}`);
      }
    },

    refreshChange() {
      this.$message.success("刷新回调");
    },

    // 增加数据
    rowadd() {
      this.$router.push("./shippingorder/add");
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
      this.$message.success("模拟网络请求");
      setTimeout(() => {
        this.$message.success("关闭按钮等待");
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
