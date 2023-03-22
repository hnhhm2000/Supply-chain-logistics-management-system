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
        <el-tab-pane label="查看全部" name="first" style="margin-left: 1em">
          <avue-crud
            :data="data"
            :option="option"
            @refresh-change="refreshChange"
            @row-save="rowSave"
            @row-update="rowUpdate"
            @row-del="rowDel"
          ></avue-crud>
        </el-tab-pane>
        <el-tab-pane label="客户" name="second">我是客户</el-tab-pane>
        <el-tab-pane label="托运人" name="third">我是托运人</el-tab-pane>
        <el-tab-pane label="收货人" name="fourth">我是收货人</el-tab-pane>
        <el-tab-pane label="运营商" name="fourth">我是运营商</el-tab-pane>
      </el-tabs>
    </main>
  </div>
</template>

<script>
export default {
  name: "SystemCrm",

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
          reprenative: "王五",
          city: "长沙",
          state: "在线",
          邮编: "410007",
        },
        {
          id: 2,
          name: "李四",
          sex: "女",
          address: "长沙雨花区万家丽商业广场",
          phone: "13667349408",
          reprenative: "王五",
          city: "长沙",
          state: "在线",
          邮编: "410007",
        },
      ],
      option: {
        column: [
          {
            label: "姓名",
            prop: "name",
          },
          {
            label: "性别",
            prop: "sex",
          },
          {
            label: "账户id",
            prop: "id",
          },
          {
            label: "地址",
            prop: "address",
          },
          {
            label: "城市",
            prop: "city",
          },
          {
            label: "状态",
            prop: "state",
          },
          {
            label: "邮编",
            prop: "ZIP",
          },
          {
            label: "电话",
            prop: "phone",
          },
          {
            label: "销售代表",
            prop: "reprentative",
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
      this.$message.success("模拟网络请求");
      setTimeout(() => {
        this.$message.success("关闭按钮等待");
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
      this.$message.success("模拟网络请求");
      setTimeout(() => {
        this.$message.success("关闭按钮等待");
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
main {
  width: 80%;
  margin-left: 15em;
}

.tabs {
  margin-left: 1em;
}
</style>
