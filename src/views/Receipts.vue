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
            @click="$router.push(`/receipt/edit/${row.id}`)"
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
          Status: "测量中",
          Accounting: "待定",
          Receipt: "WRI0000001",
          CreatedBy: "创建人A",
          createTime: "2023-05-01",
          ReceiptTime: "2023-05-05",
          Shipper: "托运人A",
          Consignee: "收货人A",
          Project: "项目A",
          PCS: 50,
          Weight: "1000 kg",
          VOL: "10 m³",
          Handing: "注意事项1",
          Income: 5000,
          Expense: 3000,
          Profit: 2000,
          UpdatedOn: "2023-05-10",
          ServiceType: "服务类别A",
        },
        {
          Status: "文件处理中",
          Accounting: "已开票",
          Receipt: "WRI0000002",
          CreatedBy: "创建人B",
          createTime: "2023-04-15",
          ReceiptTime: "2023-04-20",
          Shipper: "托运人B",
          Consignee: "收货人B",
          Project: "项目B",
          PCS: 20,
          Weight: "500 kg",
          VOL: "5 m³",
          Handing: "注意事项2",
          Income: 8000,
          Expense: 4000,
          Profit: 4000,
          UpdatedOn: "2023-05-05",
          ServiceType: "服务类别B",
        },
        {
          Status: "拍照扫描中",
          Accounting: "空",
          Receipt: "WRI0000003",
          CreatedBy: "创建人C",
          createTime: "2023-05-05",
          ReceiptTime: "2023-05-10",
          Shipper: "托运人C",
          Consignee: "收货人C",
          Project: "项目C",
          PCS: 10,
          Weight: "200 kg",
          VOL: "2 m³",
          Handing: "注意事项3",
          Income: 2000,
          Expense: 1500,
          Profit: 500,
          UpdatedOn: "2023-05-12",
          ServiceType: "服务类别C",
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
            label: "财务",
            prop: "Accounting",
          },
          {
            label: "收据编号",
            prop: "Receipt",
            search: true,
            width:100
          },
          {
            label: "创造人",
            prop: "CreatedBy",
            search: true,
          },
          {
            label: "创造时间",
            prop: "createTime",
            search: true,
            width: 90,
          },
          {
            label: "开具时间",
            prop: "ReceiptTime",
            width: 90,
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
            label: "项目",
            prop: "Project",
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
            label: "注意事项",
            prop: "Handing",
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
            label: "最近更新",
            prop: "UpdatedOn",
            width: 90,
          },
          {
            label: "服务类别",
            prop: "ServiceType",
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
      if (column.label == "收据编号") {
        this.$router.push(`/receipt/detail/${row.id}`);
      }
    },

    // 增加数据
    rowadd() {
      this.$router.push("./receipt/add");
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
