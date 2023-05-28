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

        <!-- 优先级选择框 -->
        <template slot-scope="" slot="priorityForm">
          <el-select v-model="data.priority" placeholder="请选择 优先级">
            <el-option
              v-for="item in priorityOp"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            >
            </el-option>
          </el-select>
        </template>

        <!-- 截止日期选择框 -->
        <template slot-scope="" slot="dueDateForm">
          <el-date-picker
            v-model="data.dueDate"
            type="date"
            placeholder="选择 截止日期"
          >
          </el-date-picker>
        </template>
      </avue-crud>
    </main>
  </div>
</template>

<script>
import {
  getTaskData,
  deleteTaskData,
  addTaskData,
  updateTaskData,
} from "../api/Task";

export default {
  name: "MyTask",

  data() {
    return {
      activeName: "first",
      statusOp: [
        {
          value: "请求中",
          label: "请求中",
        },
        {
          value: "定价中",
          label: "定价中",
        },
        {
          value: "正在修改",
          label: "正在修改",
        },
        {
          value: "已发送",
          label: "已发送",
        },
        {
          value: "已批准",
          label: "已批准",
        },
        {
          value: "已取消",
          label: "已取消",
        },
        {
          value: "已完成",
          label: "已完成",
        },
      ],
      priorityOp: [
        {
          value: "高",
          label: "高",
        },
        {
          value: "普通",
          label: "普通",
        },
        {
          value: "低",
          label: "低",
        },
      ],
      query: {},
      data: [],
      page: {
        pageSize: 10,
        currentPage: 1,
      },
      option: {
        searchShow: false,
        excelBtn: true,
        addBtn: true,
        column: [
          {
            label: "主题",
            prop: "subject",
          },
          {
            label: "截止日期",
            prop: "dueDate",
            formslot: true,
          },
          {
            label: "任务负责人",
            prop: "taskOwner",
          },
          {
            label: "状态",
            prop: "status",
            formslot: true,
          },
          {
            label: "优先级",
            prop: "priority",
            formslot: true,
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

      getTaskData(params).then((res) => {
        console.log(res);
        this.data = res.data.data.taskList;
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
      addTaskData(form).then(() => {
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
          deleteTaskData(params).then(() => {
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
      row.dueDate = this.formatDate(row.dueDate);
      updateTaskData(row).then(() => {
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
::v-deep .cell-color {
  color: #409eff !important;
  cursor: pointer;
}
</style>
