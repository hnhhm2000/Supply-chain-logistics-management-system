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
            label: "状态",
            prop: "Status",
          },
          {
            label: "会计",
            prop: "Accounting",
          },
          {
            label: "号码",
            prop: "Number",
          },
          {
            label: "集装箱",
            prop: "Containers",
          },
          {
            label: "项目",
            prop: "Project",
          },
          {
            label: "货物追踪 ",
            prop: "tracking",
          },
            {
            label: "提单",
            prop: "lading",
          },
          {
            label: "装载日期",
            prop: "PickUpDate",
          },
          {
            label: "交货日期",
            prop: "DeliveryDate",
          },
           {
            label: "托运人",
            prop: "shipper",
          },
            {
            label: "收货人",
            prop: "shipper",
          },
           {
            label: "发货地",
            prop: "PickupFrom",
          },
           {
            label: "收货地",
            prop: "DeliverTo",
          },
           {
            label: "承运商",
            prop: "shipper",
          },
           {
            label: "货运代理人",
            prop: "shipper",
          },
           {
            label: "客户",
            prop: "Customer",
          },
           {
            label: "PCS",
            prop: "PCS",
          },
           {
            label: "重量(斤)",
            prop: "Weight",
          },
           {
            label: "体积(立方英尺)",
            prop: "VOL(FT3)",
          },
           {
            label: "体积重量(斤)",
            prop: "VOLWeight",
          },
           {
            label: "体积重量(斤)",
            prop: "VOLWeight",
          },
           {
            label: "收入",
            prop: "VOLWeight",
          },
           {
            label: "费用",
            prop: "VOLWeight",
          },
           {
            label: "利润",
            prop: "VOLWeight",
          },
           {
            label: "货币",
            prop: "VOLWeight",
          },
           {
            label: "客户资料",
            prop: "VOLWeight",
          },
           {
            label: "更新者",
            prop: "CreatedBy",
          },
           {
            label: "创造者",
            prop: "CreatedOn",
          },
          {
            label: "预计发货时间",
            prop: "ETA",
          },
          {
            label: "预计到达时间",
            prop: "ETD",
          },
          {
            label: "货物签收时间",
            prop: "PODDate",
          },
          {
            label: "注释",
            prop: "Notes",
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
