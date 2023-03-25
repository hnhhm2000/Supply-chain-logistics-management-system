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
        <el-tab-pane label="已申请" name="second"></el-tab-pane>
        <el-tab-pane label="派遣" name="third"></el-tab-pane>
        <el-tab-pane label="等待中" name="fourth"></el-tab-pane>
        <el-tab-pane label="取货" name="fifth"></el-tab-pane>
        <el-tab-pane label="在途" name="sixth"></el-tab-pane>
        <el-tab-pane label="晚点" name="Seventh"></el-tab-pane>
        <el-tab-pane label="外送" name="Eighth"></el-tab-pane>
        <el-tab-pane label="已交付" name="Ninth"></el-tab-pane>
        <el-tab-pane label="已收到" name="Tenth"></el-tab-pane>
        <el-tab-pane label="已完成" name="Eleventh"></el-tab-pane>
      </el-tabs>
    </main>
  </div>
</template>

<script>
export default {
  name: "PickupDelivery",

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
            label: "会计",
            prop: "reference",
          },
          {
            label: "数字",
            prop: "subject",
          },
          {
            label: "集装箱",
            prop: "owner",
          },
          {
            label: "项目",
            prop: "states",
          },
          {
            label: "追踪 ",
            prop: "priority",
          },
            {
            label: "提单",
            prop: "module",
          },
          {
            label: "提货单",
            prop: "Account",
          },
          {
            label: "交货日期",
            prop: "module",
          },
           {
            label: "托运人",
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

<style lang="scss" scoped></style>
