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
  name: "MyInvoices",

  data() {
    return {
      activeName: "first",
      data: [
        {
          invoiceNumber: "INV0000001",
          Payment: "是",
          CreatedBy: "创建人A",
          createTime: "2023-05-01",
          Type: "类型A",
          Module: "关联模块A",
          Project: "项目A",
          Date: "2023-05-05",
          Duedate: "2023-05-15",
          Amount: 5000,
          TaxAmount: 500,
          TotalAmount: 5500,
          Remarks: "备注1",
        },
        {
          invoiceNumber: "INV0000002",
          Payment: "是",
          CreatedBy: "创建人B",
          createTime: "2023-04-15",
          Type: "类型B",
          Module: "关联模块B",
          Project: "项目B",
          Date: "2023-04-20",
          Duedate: "2023-05-01",
          Amount: 8000,
          TaxAmount: 800,
          TotalAmount: 8800,
          Remarks: "备注2",
        },
        {
          invoiceNumber: "INV0000003",
          Payment: "否",
          CreatedBy: "创建人C",
          createTime: "2023-05-05",
          Type: "类型C",
          Module: "关联模块C",
          Project: "项目C",
          Date: "2023-05-10",
          Duedate: "2023-05-20",
          Amount: 2000,
          TaxAmount: 200,
          TotalAmount: 2200,
          Remarks: "备注3",
        },
      ],
      option: {
        searchShow: false,
        excelBtn: true,
        addBtn: false,
        column: [
          {
            label: "发票号",
            prop: "invoiceNumber",
            search:true
          },
          {
            label: "是否付款",
            prop: "Payment",
            search:true
          },
          {
            label: "创造人",
            prop: "CreatedBy",
            search:true
          },
          {
            label: "创造时间",
            prop: "createTime",
            width:90,
            search:true
          },
          {
            label: "类型",
            prop: "Type",
          },
          {
            label: "关联模块",
            prop: "Module",
          },
          {
            label: "项目",
            prop: "Project",
          },
          {
            label: "开具日期",
            prop: "Date",
            width:90
          },
          {
            label: "截止日期",
            prop: "Duedate",
            width:90
          },
          {
            label: "金额",
            prop: "Amount",
          },
          {
            label: "税额",
            prop: "TaxAmount",
          },
          {
            label: "总额",
            prop: "TotalAmount",
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
