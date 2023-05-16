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
            @click="$router.push(`/pickupdelivery/edit/${row.id}`)"
            >编辑</el-button
          >
        </template>
      </avue-crud>
    </main>
  </div>
</template>

<script>
export default {
  name: "PickupDelivery",

  data() {
    return {
      activeName: "first",
      data: [
        {
          Status: "请求中",
          Accounting: "空",
          OrderNumber: "PKD0000001",
          BillOfLading: "BOL1234",
          PickupDate: "2023-05-01",
          DeliveryDate: "2023-05-15",
          Shipper: "托运人A",
          Consignee: "收货人A",
          PickupFrom: "提货人A",
          DeliveryTo: "送货人A",
          Carrier: "承运人A",
          Customer: "客户A",
          PCS: 50,
          Value: 5000,
          Weight: 1000,
          VOL: 10,
          Income: 5000,
          Expense: 3000,
          Profit: 2000,
          CreatedBy: "创建人A",
          createTime: "2023-05-01",
          UpdatedOn: "更新人A",
          updateTime: "2023-05-10",
          ETA: "2023-05-18",
          ETD: "2023-05-02",
          PodDate: "2023-05-16",
          Remarks: "备注1",
        },
        {
          Status: "正在调度",
          Accounting: "空",
          OrderNumber: "PKD0000004",
          BillOfLading: "BOL5678",
          PickupDate: "2023-04-15",
          DeliveryDate: "2023-04-30",
          Shipper: "托运人B",
          Consignee: "收货人B",
          PickupFrom: "提货人B",
          DeliveryTo: "送货人B",
          Carrier: "承运人B",
          Customer: "客户B",
          PCS: 20,
          Value: 8000,
          Weight: 500,
          VOL: 5,
          Income: 8000,
          Expense: 4000,
          Profit: 4000,
          CreatedBy: "创建人B",
          createTime: "2023-04-15",
          UpdatedOn: "更新人B",
          updateTime: "2023-05-05",
          ETA: "2023-05-03",
          ETD: "2023-04-20",
          PodDate: "2023-05-01",
          Remarks: "备注2",
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
            label: "订单编号",
            prop: "OrderNumber",
            search:true,
            width:100
          },
          {
            label: "提货日期",
            prop: "PickupDate",
            search:true,
            width:90
          },
          {
            label: "发货日期",
            prop: "DeliveryDate",
            width:90
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
            label: "提货人",
            prop: "PickupFrom",
          },
          {
            label: "送货人",
            prop: "DeliveryTo",
          },
          {
            label: "承运人",
            prop: "Carrier",
          },
          {
            label: "客户",
            prop: "Customer",
            search:true
          },
          {
            label: "件数",
            prop: "PCS",
          },
          {
            label: "价格",
            prop: "Value",
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
            label: "创造人",
            prop: "CreatedBy",
            search:true
          },
          {
            label: "创造时间",
            prop: "createTime",
            search:true,
            width:90
          },
          {
            label: "更新人",
            prop: "UpdatedOn",
          },
          {
            label: "最近更新",
            prop: "updateTime",
            width:90
          },
          {
            label: "预计到达时间",
            prop: "ETA",
            width:90
          },
          {
            label: "预计发货时间",
            prop: "ETD",
            width:90
          },
          {
            label: "货物签收时间",
            prop: "PodDate",
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
      if (column.label == "订单编号") {
        this.$router.push(`/pickupdelivery/detail/${row.id}`);
      }
    },

    // 增加数据
    rowadd() {
      this.$router.push("./pickupdelivery/add");
    },

    refreshChange() {
      this.$message.success("刷新回调");
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
  },
};
</script>

<style lang="scss" scoped>
::v-deep .cell-color {
  color: #409eff !important;
  cursor: pointer;
}
</style>
