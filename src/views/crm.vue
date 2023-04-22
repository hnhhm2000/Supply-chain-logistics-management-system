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
 <!-- params: { id: $route.params.id }, -->
        <template slot-scope="{ type, size, row }" slot="menu">
          <el-button
            icon="el-icon-edit"
            class="editbtn"
            :size="size"
            :type="type"
            @click="
              $router.push({
                name: 'crmEdit',
                params: { id: row.id },
              })
            "
            >编辑</el-button
          >
        </template>
      </avue-crud>
    </main>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "SystemCrm",

  data() {
    return {
      data: [],
      option: {
        editBtn: false,
        searchShow: false,
        excelBtn: true,
        addBtn: false,
        column: [
          {
            label: "姓名",
            prop: "name",
            search: true,
          },
          {
            label: "性别",
            prop: "sex",
          },
          {
            label: "账户编码",
            prop: "code",
            search: true,
          },
          {
            label: "电话",
            prop: "phone",
          },
          {
            label: "地址",
            prop: "address",
          },
          {
            label: "城市",
            prop: "city",
            search: true,
          },
          {
            label: "省",
            prop: "province",
          },
          {
            label: "状态",
            prop: "state",
            search: true,
          },
          {
            label: "邮编",
            prop: "ZIP",
          },
          {
            label: "销售代表",
            prop: "reprentative",
          },
          {
            label: "代理",
            prop: "Agent",
          },
          {
            label: "电子邮件",
            prop: "email",
          },
          {
            label: "传真",
            prop: "Fax",
          },
          {
            label: "联系方式",
            prop: "Contact",
          },
          {
            label: "账户ID",
            prop: "CustomerID",
          },
          {
            label: "供应商ID",
            prop: "VendorID",
          },
          {
            label: "角色",
            prop: "Roles",
          },
          {
            label: "注释",
            prop: "Notes",
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
            label: "更新者",
            prop: "UpdatedBy",
          },
          {
            label: "更新于",
            prop: "UpdateOn",
          },
        ],
      },
    };
  },

  methods: {
    addClass({ columnIndex }) {
      // console.log(columnIndex);
      if (columnIndex === 0) {
        return "cell-color"; // cell-blue就是添加的类名，添加完之后记得设置样式
      }
    },
    /**
     * @description: 点击名字进行跳转
     */
    pageto(row, column) {
      if (column.label == "姓名") {
        this.$router.push(`/crm/detail/${row.id}`);
      }
    },
    rowadd() {
      this.$router.push("./crm/add");
    },

    handleClick(tab, event) {
      console.log(tab, event);
    },
    refreshChange() {
      this.$message.success("刷新回调");
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
    resetChange() {
      this.$message.success("清空回调");
    },
    searchChange(params, done) {
      this.$message.success("2s后关闭锁定");
      setTimeout(() => {
        done();
        this.$message.success(JSON.stringify(params));
      }, 2000);
    },
  },

  created() {
    axios.get("/customer/selectAllCustomer").then((res) => {
      this.data = res.data.data.customerList;
      // console.log(res);
      console.log(res.data.data.customerList);
    });
  },
};
</script>

<style lang="scss" scoped>
::v-deep .cell-color {
  color: #409eff !important;
  cursor: pointer;
}
</style>
