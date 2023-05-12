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
            @click="$router.push(`/ground/edit/${row.id}`)"
            >编辑</el-button
          >
        </template>
      </avue-crud>
    </main>
  </div>
</template>

<script>
export default {
  name: "MyGround",

  data() {
    return {
      activeName: "first",
      data: [
        {
          Status: "预约中",
          Accounting: "财务部A",
          ShipmentNumber: "GOC0000001",
          Departure: "2023-05-01",
          Arrival: "2023-05-05",
          PortOfOrigin: "发货港A",
          PlaceOfDate: "2023-05-10",
          PlaceOfDelivery: "收货地点A",
          Shipper: "托运人A",
          Consignee: "收货人A",
          PCS: 50,
          Weight: "1000 斤",
          Income: 5000,
          Expense: 3000,
          Profit: 2000,
          Remarks: "备注1",
        },
        {
          Status: "准备装载",
          Accounting: "财务部B",
          ShipmentNumber: "GOC0000002",
          Departure: "2023-04-15",
          Arrival: "2023-04-20",
          PortOfOrigin: "发货港B",
          PlaceOfDate: "2023-04-25",
          PlaceOfDelivery: "收货地点B",
          Shipper: "托运人B",
          Consignee: "收货人B",
          PCS: 20,
          Weight: "500 斤",
          Income: 8000,
          Expense: 4000,
          Profit: 4000,
          Remarks: "备注2",
        },
        {
          Status: "装载中",
          Accounting: "财务部C",
          ShipmentNumber: "GOC0000003",
          Departure: "2023-05-05",
          Arrival: "2023-05-10",
          PortOfOrigin: "发货港C",
          PlaceOfDate: "2023-05-15",
          PlaceOfDelivery: "收货地点C",
          Shipper: "托运人C",
          Consignee: "收货人C",
          PCS: 10,
          Weight: "200 斤",
          Income: 2000,
          Expense: 1500,
          Profit: 500,
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
            search:true
          },
          {
            label: "财务",
            prop: "Accounting",
          },
          {
            label: "陆运编号",
            prop: "ShipmentNumber",
            width:100,
            search:true
          },
          {
            label: "启航日",
            prop: "Departure",
            width:90
          },
          {
            label: "抵达日",
            prop: "Arrival",
            width:90
          },
          {
            label: "发货港",
            prop: "PortOfOrigin",
            search:true
          },
          {
            label: "收货日",
            prop: "PlaceOfDate",
          },
          {
            label: "收货地点",
            prop: "PlaceOfDelivery",
            search:true
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
            label: "件数",
            prop: "PCS",
          },
          {
            label: "重量（斤）",
            prop: "Weight",
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
      if (column.label == "陆运编号") {
        this.$router.push(`/ground/detail/${row.id}`);
      }
    },

    // 增加数据
    rowadd() {
      this.$router.push("./ground/add");
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
