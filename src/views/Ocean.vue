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
            @click="$router.push(`/ocean/edit/${row.id}`)"
            >编辑</el-button
          >
        </template>
      </avue-crud>
    </main>
  </div>
</template>

<script>
export default {
  name: "OceanImport",

  data() {
    return {
      
      data: [
        {
          Status: "预约中",
          Accounting: "已开票",
          ShipmentNumber: "OOD0000001",
          Departure: "2023-05-01",
          Arrival: "2023-05-05",
          PortOfReceipt: "收货港A",
          PortOfOrigin: "发货港A",
          PlaceOfDate: "2023-05-10",
          PlaceOfDelivery: "收货地点A",
          Shipper: "托运人A",
          Customer: "顾客A",
          Consignee: "收货人A",
          PCS: 50,
          Weight: "1000 kg",
          Income: 5000,
          Expense: 3000,
          Profit: 2000,
          LoadingDate: "2023-05-02",
          Project: "项目A",
          Carrier: "承运人A",
          Cutoffdate: "2023-05-15",
          Commodity: "商品名A",
          MaxPieces: "100",
          Remarks: "备注1",
          CreatedBy: "创建人A",
          CreatedOn: "2023-05-01",
          UpadatedBy: "更新人A",
          UpdateOn: "2023-05-10",
        },
        {
          Status: "运输中",
          Accounting: "空",
          ShipmentNumber: "OOD0000002",
          Departure: "2023-04-15",
          Arrival: "2023-04-20",
          PortOfReceipt: "收货港B",
          PortOfOrigin: "发货港B",
          PlaceOfDate: "2023-04-25",
          PlaceOfDelivery: "收货地点B",
          Shipper: "托运人B",
          Customer: "顾客B",
          Consignee: "收货人B",
          PCS: 20,
          Weight: "500 kg",
          Income: 8000,
          Expense: 4000,
          Profit: 4000,
          LoadingDate: "2023-04-20",
          Project: "项目B",
          Carrier: "承运人B",
          Cutoffdate: "2023-05-05",
          Commodity: "商品名B",
          MaxPieces: "50",
          Remarks: "备注2",
          CreatedBy: "创建人B",
          CreatedOn: "2023-04-15",
          UpadatedBy: "更新人B",
          UpdateOn: "2023-05-05",
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
            label: "会计",
            prop: "Accounting",
          },
          {
            label: "编号",
            prop: "ShipmentNumber",
            width:100
          },
          {
            label: "启航日",
            prop: "Departure",
          },
          {
            label: "抵达日",
            prop: "Arrival",
          },
          {
            label: "收货港",
            prop: "PortOfReceipt",
          },
          {
            label: "发货港",
            prop: "PortOfOrigin",
          },
          {
            label: "收货日",
            prop: "PlaceOfDate",
          },
          {
            label: "收货地点",
            prop: "PlaceOfDelivery",
          },
          {
            label: "托运人",
            prop: "Shipper",
          },
          {
            label: "顾客",
            prop: "Customer",
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
            label: "重量(公斤)",
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
            label: "装载日期",
            prop: "LoadingDate",
          },
          {
            label: "项目",
            prop: "Project",
          },
          {
            label: "承运人",
            prop: "Carrier",
          },
          {
            label: "结算时间",
            prop: "Cutoffdate",
          },
          {
            label: "商品名",
            prop: "Commodity",
          },
          {
            label: "最大容量",
            prop: "MaxPieces",
          },
          {
            label: "客户",
            prop: "Customer",
          },
          {
            label: "注释",
            prop: "Remarks",
          },
          {
            label: "创建人",
            prop: "CreatedBy",
            search: true,
          },
          {
            label: "创建时间",
            prop: "CreatedOn",
            search: true,
          },
          {
            label: "更新人",
            prop: "UpadatedBy",
          },
          {
            label: "更新时间",
            prop: "UpdateOn",
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
        this.$router.push(`/ocean/detail/${row.id}`);
      }
    },

    // 增加数据
    rowadd() {
      this.$router.push("./ocean/add");
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
