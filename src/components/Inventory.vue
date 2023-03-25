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
      </el-tabs>

      <avue-crud
        :data="data"
        :option="option"
        @refresh-change="refreshChange"
        @row-save="rowSave"
        @row-update="rowUpdate"
        @row-del="rowDel"
      ></avue-crud>
    </main>
  </div>
</template>

<script>
export default {
  name: "MyInventory",

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
            label: "货物",
            prop: "cargo",
          },
          {
            label: "收据",
            prop: "receipt",
          },
          {
            label: "收据状态",
            prop: "receiptstatus",
          },
          {
            label: "装运单",
            prop: "shippingorder",
          },
          {
            label: "目的地",
            prop: "destination",
          },
          {
            label: "托运人",
            prop: "shipper",
          },
          {
            label: "收货人",
            prop: "consignee",
          },
          {
            label: "提货单",
            prop: "Account",
          },
          {
            label: "代理",
            prop: "agent",
          },
          {
            label: "类型",
            prop: "type",
          },
          {
            label: "物品编码",
            prop: "itemcode",
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
