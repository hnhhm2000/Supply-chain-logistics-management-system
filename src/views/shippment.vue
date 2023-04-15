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
        <el-tab-pane label="全部" name="first" style="margin-left: 1em">
          <avue-crud
            :data="data"
            :option="option"
            @refresh-change="refreshChange"
            @row-save="rowSave"
            @row-update="rowUpdate"
            @row-del="rowDel"
          ></avue-crud>
        </el-tab-pane>
        <el-tab-pane label="产地来源" name="second"></el-tab-pane>
        <el-tab-pane label="过境" name="third"></el-tab-pane>
        <el-tab-pane label="目的地" name="fourth"></el-tab-pane>
        <el-tab-pane label="完成" name="sixth"></el-tab-pane>
      </el-tabs>
    </main>
  </div>
</template>

<script>
export default {
  name: "MyShippment",

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
            label: "姓名",
            prop: "name",
          },
          {
            label: "会计",
            prop: "Accounting",
          },
          {
            label: "装运",
            prop: "ShipMent",
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
            label: "预订",
            prop: "Booking",
          },
          {
            label: "顾客参考",
            prop: "CustomerRef",
          },
          {
            label: "类型",
            prop: "Type",
          },
          {
            label: "出发地",
            prop: "Departure",
          },
          {
            label: "目的地",
            prop: "reprentative",
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
            label: "PCS",
            prop: "PCS",
          },
           {
            label: "重量",
            prop: "Weight",
          },
           {
            label: "VOL(FT3)",
            prop: "VOL(FT3)",
          },
           {
            label: "VOL重量",
            prop: "VOLWeight",
          },
           {
            label: "收入",
            prop: "Income",
          },
           {
            label: "费用",
            prop: "Expense",
          },
           {
            label: "利润",
            prop: "Profit",
          },
          {
            label: "货币",
            prop: "Currency",
          },
          {
            label: "最新消息",
            prop: "UpdateOn",
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
