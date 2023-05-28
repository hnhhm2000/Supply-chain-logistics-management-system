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
        <!-- 状态选择框 -->
        <template slot-scope="" slot="statusForm">
          <el-select v-model="data.status" placeholder="请选择 状态">
            <el-option
              v-for="item in statusOp"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            >
            </el-option>
          </el-select>
        </template>

        <!-- 入库日期选择框 -->
        <template slot-scope="" slot="receivedDateForm">
          <el-date-picker
            v-model="data.receivedDate"
            type="date"
            placeholder="选择 入库日期"
          >
          </el-date-picker>
        </template>
      </avue-crud>
    </main>
  </div>
</template>

<script>
import {
  getInventoryData,
  deleteInventoryData,
  addInventoryData,
  updateInventoryData,
} from "../api/Inventory";
export default {
  name: "MyInventory",

  data() {
    return {
      activeName: "first",
      query: {},
      data: [],
      page: {
        pageSize: 10,
        currentPage: 1,
      },
      statusOp: [
        {
          value: "已收货",
          label: "已收货",
        },
        {
          value: "运输中",
          label: "运输中",
        },
      ],
      option: {
        searchShow: false,
        excelBtn: true,
        column: [
          {
            label: "状态",
            prop: "status",
            search: true,
            formslot: true,
          },
          {
            label: "收据",
            prop: "receiptNumber",
            search: true,
            width: 180,
          },
          {
            label: "目的地",
            prop: "destination",
          },
          {
            label: "托运人",
            prop: "shipper",
            search: true,
          },
          {
            label: "收货人",
            prop: "consignee",
            search: true,
          },
          {
            label: "件数",
            prop: "pcs",
          },
          {
            label: "描述",
            prop: "description",
          },
          {
            label: "尺寸",
            prop: "dim",
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
            label: "入库日期",
            prop: "receivedDate",
            width: 90,
            formslot: true,
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
    // 获取数据并渲染
    getList(page, params) {
      params.currPage = page.currentPage;
      params.pageSize = page.pageSize;

      getInventoryData(params).then((res) => {
        console.log(res);
        this.data = res.data.data.inventoryList;
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
    rowSave(form, done) {
      addInventoryData(form).then(() => {
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
          deleteInventoryData(params).then(() => {
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
      row.receivedDate = this.formatDate(row.receivedDate);
      updateInventoryData(row).then(() => {
        this.onLoad(this.page);
        this.$message({
          type: "success",
          message: "编辑成功!",
        });
        done(form);
      });
    },

      // 格式化时间
    formatDate(dateString) {
      if (dateString !== "") {
        const date = new Date(dateString);
        const year = date.getFullYear();
        const month = String(date.getMonth() + 1).padStart(2, "0");
        const day = String(date.getDate()).padStart(2, "0");
        const hours = String(date.getHours()).padStart(2, "0");
        const minutes = String(date.getMinutes()).padStart(2, "0");
        const seconds = String(date.getSeconds()).padStart(2, "0");

        return `${year}-${month}-${day} ${hours}:${minutes}:${seconds}`;
      } else {
        return "";
      }
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
