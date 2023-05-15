import request from "./axios";

// 分页查询
export const getUserData = (data) => {
  return request({
    url: '/api/user/getUserList',
    method: 'post',
    dataType: 'json',
    data,
  })
}

// 新增客户
export const addUserData = (data) => {
  return request({
    url: '/api/user/addUser',
    method: 'post',
    dataType: 'json',
    data,
  })
}

// 编辑
export const editUserData = (data) => {
  return request({
    url: '/api/user/updateUser',
    method: 'post',
    dataType: 'json',
    data,
  })
}

// 详情
export const getUserDetail = (params) => {
  return request({
    url: '/api/user/getUserById',
    method: 'get',
    dataType: 'json',
    params,
  })
}

// 删除
export const deleteUserData = (params) => {
  return request({
    url: '/api/user/deleteUserById',
    method: 'get',
    dataType: 'json',
    params,
  })
}

