<template>
  <div>
    <NavMenu class="sidebar"></NavMenu>
    <TopMenu class="topmenu"></TopMenu>

    <main>
      <avue-crud
        :data="data"
        :option="option"
        :search-show="false"
        :page.sync="page"
        @refresh-change="refreshChange"
        @row-save="rowSave"
        @row-update="rowUpdate"
        @row-del="rowDel"
        @on-load="onLoad"
        @search-change="searchChange"
        @search-reset="resetChange"
        :cell-class-name="addClass"
        @cell-click="pageto"
        v-model="data"
        class="Mycrud"
      >
      </avue-crud>
    </main>
  </div>
</template>

<script>
import {
  getUserData,
  deleteUserData,
  addUserData,
  updateUserData,
} from "../api/User";

export default {
  name: "UserManage",

  data() {
    return {
      query: {},
      data: [],
      page: {
        pageSize: 10,
        currentPage: 1,
      },
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
            label: "用户名",
            prop: "accountName",
          },
           {
            label: "密码",
            prop: "password",
            hide:true
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
            prop: "phoneNumber",
          },
        ],
      },
    };
  },

  methods: {
    refreshChange() {
      this.$message.success("刷新回调");
    },
    // 获取数据并渲染
    getList(page, params) {
      params.currPage = page.currentPage;
      params.pageSize = page.pageSize;

      getUserData(params).then((res) => {
        console.log(res);
        this.data = res.data.data.userList;
        this.page.total = res.data.data.total;
      });
    },
    /**
     * 搜索函数，获取年度日期与地市的绑定值，将它们放入params中，传给this.query以便在其他地方调用
     * @param {[object]} params [搜索框数据]
     * @param {[function]} done [结束]
     */

    searchChange(params, done) {
      this.query = params;

      this.onLoad(this.page, "search");
      done();
    },

    /**
     * 页面初次加载时，会调用该方法
     * 当搜索时，会调用该方法，重置page的数据
     * 最后调用getList，获取最新数据
     * @param {[object]} page [分页器对象]
     * @param {[string]} search [用于“监听”是否进行了搜索]
     */
    onLoad(page, search) {
      if (search) {
        page.total = 0;
        page.currentPage = 1;
      }
      this.getList(page, this.query);
    },

    // 新增数据
    rowSave(row,form, done) {
      addUserData(row).then(() => {
        this.onLoad(this.page);
        this.$message({
          type: "success",
          message: "新增成功!",
        });
        done();
      });
    },

     // 删除数据
    rowDel(row) {
      this.$confirm("此操作将永久删除该文件, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          let params = {};
          params.id = row.id;
          deleteUserData(params).then(() => {
            this.$message({
              type: "success",
              message: "删除成功!",
            });
            this.onLoad(this.page);
          });
        })
        .catch(() => {});
    },

     // 修改数据
    rowUpdate(row, form, done) {
      updateUserData(row).then(() => {
        this.onLoad(this.page);
        this.$message({
          type: "success",
          message: "编辑成功!",
        });
        done(form);
      });
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
