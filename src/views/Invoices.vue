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
            
              <el-button slot="menuLeft"
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
          id: 1,
          name: "张三",
          sex: "男",
          address: "长沙雨花区万家丽商业广场",
          phone: "13667349408",
          reprentative: "王五",
          city: "长沙",
          state: "在线",
          ZIP: "410007",
        },
        {
          id: 2,
          name: "李四",
          sex: "女",
          address: "长沙雨花区万家丽商业广场",
          phone: "13667349408",
          reprentative: "王五",
          city: "长沙",
          state: "在线",
          ZIP: "410007",
        },
      ],
      option: {
        searchShow: false,
        excelBtn: true,
        addBtn: false,
        column: [
          {
            label: "发票号",
            prop: "Number",
          },
          {
            label: "是否付款",
            prop: "Payment",
          },
          {
            label: "创造人",
            prop: "CreatedBy",
          },
          {
            label: "创造时间",
            prop: "CreatedOn",
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
          },
            {
            label: "截止日期",
            prop: "Duedate",
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
    handleClick(tab, event) {
      console.log(tab, event);
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
