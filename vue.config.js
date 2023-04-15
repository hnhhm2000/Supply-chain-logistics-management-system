module.exports = {
  transpileDependencies: true,

  // 开发模式反向代理配置，生产模式请使用 Nginx 部署并配置反向代理
  devServer: {
    // 你可以在此处设置开发服务器监听的端口
    port: 8080,

    proxy: {
      '/customer': {
        target: 'http://150.158.19.230:8849',
        changeOrigin: true,
      }
    }
  }
}