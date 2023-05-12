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
            @click="$router.push(`/air/edit/${row.id}`)"
            >编辑</el-button
          >
        </template>
      </avue-crud>
    </main>
  </div>
</template>

<script>
export default {
  name: "MyAir",

  data() {
    return {
      activeName: "first",
      data: [
        {
          Status: "装载中",
          Accouting: "已发票",
          Shipment: "S1234",
          Departure: "2023-05-01",
          Arrival: "2023-05-05",
          Origin: "始发地A",
          Destination: "目的地A",
          Customer: "客户A",
          Shipper: "托运人A",
          Consignee: "收货人A",
          PCS: 50,
          Weight: "1000 斤",
          Income: 5000,
          Expense: 3000,
          Profit: 50,
        },
        {
          Status: "运输中",
          Accouting: "空",
          Shipment: "AIR0000001",
          Departure: "2023-04-15",
          Arrival: "2023-04-20",
          Origin: "始发地B",
          Destination: "目的地B",
          Customer: "客户B",
          Shipper: "托运人B",
          Consignee: "收货人B",
          PCS: 20,
          Weight: "500 斤",
          Income: 8000,
          Expense: 4000,
          Profit: 20,
        },
        {
          Status: "已完成",
          Accouting: "待定中",
          Shipment: "AIR0000002",
          Departure: "2023-05-05",
          Arrival: "2023-05-10",
          Origin: "始发地C",
          Destination: "目的地C",
          Customer: "客户C",
          Shipper: "托运人C",
          Consignee: "收货人C",
          PCS: 10,
          Weight: "200 斤",
          Income: 2000,
          Expense: 1500,
          Profit: 10,
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
            prop: "Accouting",
          },
          {
            label: "空运编号",
            prop: "Shipment",
            search:true
          },
          {
            label: "起飞日",
            prop: "Departure",
          },
          {
            label: "抵达日",
            prop: "Arrival",
          },
          {
            label: "始发地",
            prop: "Origin",
            search:true
          },
          {
            label: "目的地",
            prop: "Destination",
            search:true
          },
          {
            label: "客户",
            prop: "Customer",
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
            label: "重量(斤)",
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
            prop: "PCS",
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
      if (column.label == "空运编号") {
        this.$router.push(`/air/detail/${row.id}`);
      }
    },
     // 增加数据
    rowadd() {
      this.$router.push("./air/add");
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
