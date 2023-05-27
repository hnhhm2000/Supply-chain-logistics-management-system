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
  name: "UserManage",

  data() {
    return {
      data: [],
      option: {
        searchShow: false,
        excelBtn: true,
        addBtn: true,
        column: [
          {
            label: "邮箱",
            prop: "email",
          },
          {
            label: "姓名",
            prop: "Name",
          },
          {
            label: "用户名",
            prop: "username",
          },
          {
            label: "角色",
            prop: "roles",
          },
          {
            label: "状态",
            prop: "status",
          },
           {
            label: "手机号",
            prop: "phone",
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
