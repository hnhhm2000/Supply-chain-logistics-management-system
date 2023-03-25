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
          <avue-crud
            :data="data"
            :option="option"
            @refresh-change="refreshChange"
            @row-save="rowSave"
            @row-update="rowUpdate"
            @row-del="rowDel"
          ></avue-crud>

      </el-tabs>
    </main>
  </div>
</template>

<script>
export default {
  name: "MyRelease",

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
            label: "状态",
            prop: "status",
          },
          {
            label: "会计",
            prop: "reference",
          },
          {
            label: "号码",
            prop: "number",
          },
          {
            label: "集装箱",
            prop: "containers",
          },
          {
            label: "创造者",
            prop: "createby",
          },
          {
            label: "追踪 ",
            prop: "priority",
          },
            {
            label: "创造时间",
            prop: "createtime",
          },
          {
            label: "放货时间",
            prop: "outtime",
          },
          {
            label: "到货时间",
            prop: "timeout",
          },
           {
            label: "货运点",
            prop: "releaseto",
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
