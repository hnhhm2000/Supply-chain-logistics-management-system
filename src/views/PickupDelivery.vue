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
        @row-del="rowDel"
        @on-load="onLoad"
        @search-change="searchChange"
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

        <template slot-scope="{ type, size, row }" slot="menu">
          <el-button
            icon="el-icon-edit"
            class="editbtn"
            :size="size"
            :type="type"
            @click="$router.push(`/pickupdelivery/edit/${row.id}`)"
            >编辑</el-button
          >
        </template>
      </avue-crud>
    </main>
  </div>
</template>

<script>
import {
  getPickupDeliveryData,
  deletePickupDeliveryData,
} from "../api/PickupDelivery";

export default {
  name: "PickupDelivery",

  data() {
    return {
      activeName: "first",
      query: {},
      data: [],
      page: {
        pageSize: 10,
        currentPage: 1,
      },
      option: {
        searchShow: false,
        excelBtn: true,
        addBtn: false,
        editBtn: false,
        column: [
          {
            label: "状态",
            prop: "status",
            search: true,
          },
          {
            label: "财务",
            prop: "accounting",
          },
          {
            label: "订单编号",
            prop: "pickupDeliveryNumber",
            search: true,
            width: 180,
          },
          {
            label: "提货日期",
            prop: "pickupDate",
            search: true,
            width: 90,
          },
          {
            label: "发货日期",
            prop: "deliveryDate",
            width: 90,
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
            label: "提货人",
            prop: "pickupFrom",
          },
          {
            label: "送货人",
            prop: "deliveryTo",
          },
          {
            label: "承运人",
            prop: "carrier",
          },
          {
            label: "客户",
            prop: "customer",
            search: true,
          },
          {
            label: "件数",
            prop: "pcs",
          },
          {
            label: "价格",
            prop: "price",
          },
          {
            label: "重量",
            prop: "weight",
          },
          {
            label: "体积",
            prop: "vol",
          },
          {
            label: "收入",
            prop: "income",
          },
          {
            label: "支出",
            prop: "expense",
          },
          {
            label: "利润",
            prop: "profit",
          },
          {
            label: "创造人",
            prop: "createBy",
            search: true,
          },
          {
            label: "创造时间",
            prop: "createTime",
            search: true,
            width: 90,
          },
          {
            label: "更新人",
            prop: "updateBy",
          },
          {
            label: "最近更新",
            prop: "updateTime",
            width: 90,
          },
          {
            label: "预计到达时间",
            prop: "eta",
            width: 90,
          },
          {
            label: "预计发货时间",
            prop: "etd",
            width: 90,
          },
          {
            label: "货物签收时间",
            prop: "podDate",
            width: 90,
          },
          {
            label: "备注",
            prop: "remarks",
          },
        ],
      },
    };
  },

  methods: {
    // 点击姓名进入详情
    addClass({ columnIndex }) {
      if (columnIndex === 2) {
        return "cell-color"; // cell-blue就是添加的类名，添加完之后记得设置样式
      }
    },

    /**
     * @description: 点击名字进行跳转
     */
    pageto(row, column) {
      if (column.label == "订单编号") {
        this.$router.push(`/pickupdelivery/detail/${row.id}`);
      }
    },

    // 增加数据
    rowadd() {
      this.$router.push("./pickupdelivery/add");
    },

    // 获取数据并渲染
    getList(page, params) {
      params.currPage = page.currentPage;
      params.pageSize = page.pageSize;
      

      getPickupDeliveryData(params).then((res) => {
        console.log(res);
        this.data = res.data.data.pickupDeliveryList;
        this.page.total = res.data.data.total;
      });
    },

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

    refreshChange() {
      this.$message.success("刷新回调");
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
          deletePickupDeliveryData(params).then(() => {
            this.$message({
              type: "success",
              message: "删除成功!",
            });
            this.onLoad(this.page);
          });
        })

        .catch(() => {});
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
