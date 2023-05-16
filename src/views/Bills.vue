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

      </avue-crud>
    </main>
  </div>
</template>

<script>
export default {
  name: "MyBills",

  data() {
    return {
      activeName: "first",
      data: [
        {
          BillNumber: "B1234",
          CreatedBy: "创建人A",
          createTime: "2023-05-01",
          Reference: "OOD0000001",
          Project: "项目A",
          Date: "2023-05-05",
          Vendor: "供应商A",
          Duedate: "2023-05-15",
          TotalAmount: 5000,
          Remark: "备注1",
        },
        {
          BillNumber: "B5678",
          CreatedBy: "创建人B",
          createTime: "2023-04-15",
                    Reference: "OOD0000002",
          Project: "项目B",
          Date: "2023-04-20",
          Vendor: "供应商B",
          Duedate: "2023-05-01",
          TotalAmount: 8000,
          Remark: "备注2",
        },
        {
          BillNumber: "B9012",
          CreatedBy: "创建人C",
          createTime: "2023-05-05",

          Reference: "OOD0000003",
          Project: "项目C",
          Date: "2023-05-10",
          Vendor: "供应商C",
          Duedate: "2023-05-20",
          TotalAmount: 2000,
          Remark: "备注3",
        },
      ],
      option: {
        searchShow: false,
        excelBtn: true,
        addBtn: false,
        editBtn:false,
        delBtn:false,
        column: [
          {
            label: "账单号",
            prop: "BillNumber",
            search:true
          },
          {
            label: "创建人",
            prop: "CreatedBy",
            search:true
          },
          {
            label: "创建时间",
            prop: "createTime",
            search:true
          },
          {
            label: "引用",
            prop: "Reference",
            width:100
          },
          {
            label: "项目",
            prop: "Project",
          },
          {
            label: "日期",
            prop: "Date",
          },
          {
            label: "供应商",
            prop: "Vendor",
          },
          {
            label: "截止日期",
            prop: "Duedate",
          },
          {
            label: "总额",
            prop: "TotalAmount",
          },
          {
            label: "备注",
            prop: "Remark",
          },
        ],
      },
    };
  },

  methods: {
    refreshChange() {
      this.$message.success("刷新回调");
    },
      // 清空搜索
    searchReset() {
      this.createdDate = ''
      this.untilDate = ''
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
