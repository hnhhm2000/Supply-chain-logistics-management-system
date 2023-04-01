    <template>
  <div>
    <NavMenu class="sidebar"></NavMenu>
    <TopMenu class="topmenu"></TopMenu>

    <main>
      <el-tabs
        v-model="activeName"
        @tab-click="handleClick"
        style="width: 80em"
      >
       
          <avue-crud
            :data="data"
            :option="option"
            @refresh-change="refreshChange"
            @row-save="rowSave"
            @row-update="rowUpdate"
            @row-del="rowDel"
          ></avue-crud>

       
      </el-tabs>
    </main>
  </div>
</template>

<script>
export default {
  name: "MyInvoices",

  data() {
    return {
      activeName: "second",
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
        column: [
          {
            label: "发票号",
            prop: "Number",
          },
          {
            label: "状态",
            prop: "Status",
          },
          {
            label: "付款",
            prop: "Payment",
          },
          {
            label: "创造者",
            prop: "CreatedBy",
          },
          {
            label: "创造于",
            prop: "CreatedOn",
          },
          {
            label: "类型",
            prop: "Type",
          },
          {
            label: "模块",
            prop: "Module",
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
            label: "发送到",
            prop: "BillTo",
          },
            {
            label: "顾客",
            prop: "Customer",
          },
            {
            label: "有效期",
            prop: "Duedate",
          },
            {
            label: "货币",
            prop: "Currency",
          },
           {
            label: "金额",
            prop: "Amount",
          },
           {
            label: "税额",
            prop: "Tax",
          },
           {
            label: "总额",
            prop: "Total",
          },
           {
            label: "项次号和项目号",
            prop: "ItNumber",
          },
           {
            label: "顾客参考",
            prop: "VOLWeight",
          },
           {
            label: "注释",
            prop: "Notes",
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

<style lang="scss" scoped></style>
