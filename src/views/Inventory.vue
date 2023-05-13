<template>
  <div>
    <NavMenu class="sidebar"></NavMenu>
    <TopMenu class="topmenu"></TopMenu>

    <main>
      <avue-data-display :option="displayoption"></avue-data-display>
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
  name: "MyInventory",

  data() {
    return {
      activeName: "first",
      data: [
        {
          Status: "运输中",
          Receipt: "WRI0000001",
          Destination: "目的地A",
          Shipper: "托运人A",
          Comsignee: "收货人A",
          PCS: 50,
          Description: "描述1",
          DIM: "10 x 5 x 3",
          Weight: "1000 kg",
          VOL: "10 m³",
          ReceivedDate: "2023-05-01",
        },
        {
          Status: "已订购",
          Receipt: "WRI0000002",
          Destination: "目的地B",
          Shipper: "托运人B",
          Comsignee: "收货人B",
          PCS: 20,
          Description: "描述2",
          DIM: "5 x 3 x 2",
          Weight: "500 kg",
          VOL: "5 m³",
          ReceivedDate: "2023-04-15",
        },
        {
          Status: "报价中",
          Receipt: "WRI0000003",
          Destination: "目的地C",
          Shipper: "托运人C",
          Comsignee: "收货人C",
          PCS: 10,
          Description: "描述3",
          DIM: "3 x 2 x 1",
          Weight: "200 kg",
          VOL: "2 m³",
          ReceivedDate: "2023-05-05",
        },
      ],
      option: {
        searchShow: false,
        excelBtn: true,
        column: [
          {
            label: "状态",
            prop: "Status",
            search: true,
          },
          {
            label: "收据",
            prop: "Receipt",
            search: true,
            width: 100,
          },
          {
            label: "目的地",
            prop: "Destination",
          },
          {
            label: "托运人",
            prop: "Shipper",
            search: true,
          },
          {
            label: "收货人",
            prop: "Comsignee",
            search: true,
          },
          {
            label: "件数",
            prop: "PCS",
          },
          {
            label: "描述",
            prop: "Description",
          },
          {
            label: "尺寸",
            prop: "DIM",
          },
          {
            label: "重量",
            prop: "Weight",
          },
          {
            label: "体积",
            prop: "VOL",
          },
          {
            label: "入库日期",
            prop: "ReceivedDate",
          },
        ],
      },

      displayoption: {
        span: 6,
        data: [
          {
            click: function (item) {
              alert(JSON.stringify(item));
            },
            count: 100,
            decimals: 2,
            title: "日活跃数",
            href: "https://avuejs.com",
            target: "_blank",
          },
          {
            click: function (item) {
              alert(JSON.stringify(item));
            },
            count: "3,000",
            title: "月活跃数",
            href: "https://avuejs.com",
            target: "_blank",
          },
          {
            click: function (item) {
              alert(JSON.stringify(item));
            },
            count: "20,000",
            title: "年活跃数",
            href: "https://avuejs.com",
            target: "_blank",
          },
          {
            click: function (item) {
              alert(JSON.stringify(item));
            },
            count: "40,000",
            title: "周活跃数",
            href: "https://avuejs.com",
            target: "_blank",
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
.MyCard {
  margin-top: 1em !important;
}

.avue-data-display {
  margin-top: 4em;
}

::v-deep .cell-color {
  color: #409eff !important;
  cursor: pointer;
}
</style>
