import axios from 'axios';

//默认超时时间
axios.defaults.timeout = 60000;
//返回其他状态码
axios.defaults.validateStatus = function (status) {
  return status >= 200 && status <= 500;
};
//跨域请求，允许保存cookie
axios.defaults.withCredentials = true;

export default axios;