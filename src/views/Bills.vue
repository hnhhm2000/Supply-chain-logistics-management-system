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
  name: "MyBills",

  data() {
    return {
      activeName: "first",
      data: [
        {
          BillNumber: "B1234",
          CreatedBy: "创建人A",
          createTime: "2023-05-01",
          Type: "类型A",
          Reference: "REF1234",
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
          Type: "类型B",
          Reference: "REF5678",
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
          Type: "类型C",
          Reference: "REF9012",
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
            label: "类型",
            prop: "Type",
          },
          {
            label: "引用",
            prop: "Reference",
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
