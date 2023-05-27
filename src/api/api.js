import request from "./axios";


// 登陆
export const login = (data) => {
  return request({
    url: '/api/user/login',
    method: 'post',
    dataType: 'json',
    data,
  })
}

// 获取个人资料
export const getUserInfo = (token) => {
  return request({
    url: '/api/user/getUserInfoByToken',
    method: 'get',
    headers: {
      'token': token
    },
 
  })
}

