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
        <el-tab-pane label="请求" name="second"></el-tab-pane>
        <el-tab-pane label="已批准" name="third"></el-tab-pane>
        <el-tab-pane label="完成" name="fourth"></el-tab-pane>
      </el-tabs>
    </main>

    </div>
</template>

<script>
export default {
    name: 'QuoteManage',

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
      ],
      option: {
        column: [
          {
            label: "地位",
            prop: "date",
          },
          {
            label: "活动",
            prop: "reference",
          },
          {
            label: "数字",
            prop: "subject",
          },
          {
            label: "由....制作",
            prop: "owner",
          },
           {
            label: "创建于",
            prop: "states",
          },
          {
            label: "项目",
            prop: "priority",
          },
          {
            label: "客户参考",
            prop: "Account",
          },
          {
            label: "模式",
            prop: "module",
          },
          {
            label: "有效期至...",
            prop: "module",
          },
          {
            label: "顾客",
            prop: "module",
          },
          {
            label: "收货港",
            prop: "module",
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

</style>