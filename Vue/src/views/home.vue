<template>
  <div>
    <NavMenu class="sidebar"></NavMenu>
    <TopMenu class="topmenu"></TopMenu>

    <div class="main">
      <div ref="store" class="store"></div>
      <div ref="performance" class="performance"></div>
      <div ref="portTypeChart" class="chart"></div>
      <div ref="profitChart" class="chart"></div>

      <el-card class="port-card">
        <div slot="header" class="card-header">
          <span>五大港口目的地</span>
        </div>
        <div class="card-content">
          <ul>
            <li>上海港</li>
            <li>深圳港</li>
            <li>天津港</li>
            <li>青岛港</li>
            <li>广州港</li>
          </ul>
        </div>
      </el-card>

      <el-card class="progress">
        <div slot="header" class="clearfix">
          <span>正在装运</span>
        </div>

        <table style="display: block; margin-left: 4em">
          <tr style="display: flex">
            <th>报告情况</th>
            <th>截止日期</th>
            <th>截止时间</th>
            <th>类型</th>
          </tr>
        </table>
      </el-card>
    </div>
  </div>
</template>

<script>
import * as echarts from "echarts";

export default {
  name: "MyHome",

  data() {
    return {};
  },

  mounted() {
    const store = echarts.init(this.$refs.store);
    const performance = echarts.init(this.$refs.performance);
    const portTypeChart = echarts.init(this.$refs.portTypeChart);
    const profitChart = echarts.init(this.$refs.profitChart);

    // 设置图表选项
    portTypeChart.setOption({
      title: {
        text: "港口货物类型分布",
      },
      series: [
        {
          type: "pie",
          data: [
            { name: "凤梨", value: 10 },
            { name: "香蕉", value: 15 },
            { name: "茶叶蛋", value: 12 },
          ],
        },
      ],
    });

    profitChart.setOption({
      title: {
        text: "客户的利润占比",
      },
      series: [
        {
          type: "pie",
          data: [
            { name: "黄皓铭", value: 15 },
            { name: "杨维斌", value: 20 },
          ],
        },
      ],
    });

    performance.setOption({
      title: {
        text: "装运表现",
      },
      xAxis: {
        type: "category",
        data: [
          "1月",
          "2月",
          "3月",
          "4月",
          "5月",
          "6月",
          "7月",
          "8月",
          "9月",
          "10月",
          "11月",
          "12月",
        ],
      },
      yAxis: {
        type: "value",
        min: -1,
        max: 1,
        interval: 0.2,
      },
      series: [
        {
          data: [0.2, 0.3, 0.5, 0.6, 0.7, 0.8, 0.9, 0.7, 0.5, 0.3, 0.1, -0.2],
          type: "line",
        },
      ],
    });

    store.setOption({
      title: {
        text: "当前库存情况",
      },
      tooltip: {},
      xAxis: {
        data: ["衬衫", "羊毛衫", "雪纺衫", "裤子", "高跟鞋", "袜子"],
      },
      yAxis: {},
      series: [
        {
          name: "销量",
          type: "bar",
          data: [5, 20, 36, 10, 10, 20],
        },
      ],
    });

    performance.setOption({
      series: [
        {
          data: [
            -0.2, -0.3, -0.5, -0.6, -0.7, -0.8, -0.9, -0.7, -0.5, -0.3, -0.1,
            0.2,
          ],
        },
      ],
    });
  },

  methods: {},
};
</script>

<style lang="scss" scoped>
body {
  overflow: hidden;
}

.main {
  display: flex;
  flex-wrap: wrap;
  margin-left: 16em;
}

.store {
  width: 40%;
  height: 20em;
  margin-top: 5em;
}

.performance {
  width: 55%;
  height: 20em;
  margin-top: 5em;
}

.card-header {
  font-size: 18px;
  font-weight: bold;
  padding: 10px;
}

.card-content {
  padding: 3em;
}

.port-card {
  width: 35em;
}

.progress {
  margin-left: 2em;
  width: 33.5em;
}

.chart {
  width: 50%;
  height: 20em;
  margin-top: 5em;
}

// .sidebar {
//   position: fixed;
//   left: 0;
//   top: 0;
//   bottom: 0;
// }

ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
}

th {
  flex-basis: 25%;
  text-align: left;
}

li::before {
  content: "•";
  margin-right: 8px;
  color: #409eff;
}
</style>
