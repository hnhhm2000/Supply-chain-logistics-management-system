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
            $router.push(`/crm/edit/${row.id}`)
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
      data: [
        {
          name:'黄皓铭',
          Sex:'男',
          PhoneNumber:'13467678074',
          Address:'湖南省长沙市',
          city:'长沙',
          Province:'湖南',
          State:'中国',
          ZIP:'410000',
          Email:'986667872@qq.com',
          Roles:'托运人',
          Remarks:'来点备注',
          CreatedBy:'黄皓铭',
          CreatedOn:'2023-05-08',
          UpdatedBy:'黄皓铭',
          UpdatedOn:'2023-05-08'
        }
      ],
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
            prop: "Sex",
          },
          {
            label: "电话",
            prop: "PhoneNumber",
            width: 100
          },
          {
            label: "地址",
            prop: "Address",
          },
          {
            label: "城市",
            prop: "city",
            search: true,
          },
          {
            label: "省",
            prop: "Province",
            search: true,
          },
          {
            label: "国家",
            prop: "State",
            search: true,
          },
          {
            label: "邮编",
            prop: "ZIP",
          },
          {
            label: "电子邮件",
            prop: "Email",
            width: 140
          },
          {
            label: "角色",
            prop: "Roles",
          },
          {
            label: "创造人",
            prop: "CreatedBy",
          },
          {
            label: "创造时间",
            prop: "CreatedOn",
            width: 100
          },
          {
            label: "更新人",
            prop: "UpdatedBy",
          },
          {
            label: "最近更新",
            prop: "UpdatedOn",
            width: 100
          },
           {
            label: "备注",
            prop: "Remarks",
            width: 150
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
    // 获取接口数据并渲染列表
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
