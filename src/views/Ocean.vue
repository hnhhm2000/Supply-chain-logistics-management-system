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
            @click="$router.push(`/ocean/edit/${row.id}`)"
            >编辑</el-button
          >
        </template>

        <!-- 运输时间选择器 -->
        <template slot="shippingTimeSearch">
          <div style="display: flex">
            <el-date-picker
              v-model="departure"
              size="small"
              type="date"
              placeholder="开始日期"
            >
            </el-date-picker>
            <label style="margin: 0 0.1em">—</label>
            <el-date-picker
              v-model="arrival"
              size="small"
              type="date"
              placeholder="截止日期"
            >
            </el-date-picker>
          </div>
        </template>
      </avue-crud>
    </main>
  </div>
</template>

<script>
import { getOceanData, deleteOceanData } from "../api/Ocean";
export default {
  name: "OceanImport",

  data() {
    return {
      departure: "",
      arrival: "",
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
            label: "会计",
            prop: "accounting",
          },
          {
            label: "编号",
            prop: "oceanNumber",
            width: 180,
          },
          {
            label: "启航日",
            prop: "departure",
            width: 90,
          },
          {
            label: "抵达日",
            prop: "arrival",
            width: 90,
          },
          {
            label: "收货港",
            prop: "destination",
          },
          {
            label: "发货港",
            prop: "origin",
          },
          {
            label: "收货日",
            prop: "placeOfDate",
            width: 90,
          },
          {
            label: "托运人",
            prop: "shipper",
          },
          {
            label: "顾客",
            prop: "customer",
          },
          {
            label: "收货人",
            prop: "consignee",
          },
          {
            label: "件数",
            prop: "pcs",
          },
          {
            label: "重量",
            prop: "weight",
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
            label: "装载日期",
            prop: "loadingDate",
            width: 90,
          },
          {
            label: "项目",
            prop: "project",
          },
          {
            label: "承运人",
            prop: "carrier",
          },
          {
            label: "商品名",
            prop: "commodity",
          },
          {
            label: "最大容量",
            prop: "maxPieces",
          },
          {
            label: "客户",
            prop: "customer",
          },
          {
            label: "注释",
            prop: "remarks",
          },
          {
            label: "创建人",
            prop: "createBy",
            search: true,
          },
          {
            label: "创建时间",
            prop: "createTime",
            width: 140,
          },
          {
            label: "运输时间",
            prop: "shippingTime",
            search: true,
            hide: true,
            searchSpan: 7,
          },
          {
            label: "更新人",
            prop: "updateBy",
          },
          {
            label: "更新时间",
            prop: "updateTime",
            width: 140,
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
      if (column.label == "编号") {
        this.$router.push(`/ocean/detail/${row.id}`);
      }
    },

    // 增加数据
    rowadd() {
      this.$router.push("./ocean/add");
    },

    // 清空搜索
    resetChange() {
      this.departure = "";
      this.arrival = "";
    },

    // 获取数据并渲染
    getList(page, params) {
      params.currPage = page.currentPage;
      params.pageSize = page.pageSize;

      getOceanData(params).then((res) => {
        console.log(res);
        this.data = res.data.data.oceanList;
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
          deleteOceanData(params).then(() => {
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
