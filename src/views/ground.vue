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
        <el-tab-pane label="今天" name="second"></el-tab-pane>
        <el-tab-pane label="待处理" name="third"></el-tab-pane>
        <el-tab-pane label="新任务" name="fourth"></el-tab-pane>
        <el-tab-pane label="晚点" name="fifth"></el-tab-pane>
        <el-tab-pane label="完成" name="sixth"></el-tab-pane>
      </el-tabs>
    </main>
  </div>
</template>

<script>
export default {
  name: "MyGround",

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
      searchShow: false,
        excelBtn: true,
        addBtn: false,
      option: {
        column: [
          {
            label: "状态",
            prop: "Status",
          },
          {
            label: "会计",
            prop: "reference",
          },
          {
            label: "装运",
            prop: "subject",
          },
          {
            label: "主货",
            prop: "owner",
          },
          {
            label: "预订",
            prop: "states",
          },
          {
            label: "集装箱",
            prop: "priority",
          },
          {
            label: "项目",
            prop: "Account",
          },
          {
            label: "顾客参考",
            prop: "module",
          },
           {
            label: "顾客参考",
            prop: "module",
          },
           {
            label: "离开",
            prop: "module",
          },
           {
            label: "抵达",
            prop: "module",
          },
           {
            label: "原产地港口",
            prop: "module",
          },
           {
            label: "卸货港",
            prop: "Unloading",
          },
           {
            label: "顾客",
            prop: "Customer",
          },
           {
            label: "托运人",
            prop: "Shipper",
          },
           {
            label: "体重(斤)",
            prop: "Weight",
          },
          {
            label: "体重(斤)",
            prop: "Weight",
          },
          {
            label: "VOL(立方体积)",
            prop: "VOL(FT3)",
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
            label: "截止日期",
            prop: "CutOffTime",
          },
          {
            label: "注释",
            prop: "Notes",
          },
          {
            label: "交货时间",
            prop: "Delivery",
          },
          {
            label: "签收时间",
            prop: "Receive",
          },
          {
            label: "货物签收注释",
            prop: "Notes",
          },
          {
            label: "项目",
            prop: "Project",
          },
          {
            label: "创造者",
            prop: "CreatedBy",
          },
          {
            label: "更新人",
            prop: "UpdatedBy",
          },
          {
            label: "创造于",
            prop: "CreatedOn",
          },
          {
            label: "更新时间",
            prop: "UpdatedOn",
          },
          {
            label: "组织",
            prop: "Division",
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
