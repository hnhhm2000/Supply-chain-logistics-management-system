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
export const updateUserData = (data) => {
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

// 根据客户id查询报价
export const getQuoteData = (params) => {
  return request({
    url: '/api/user/getQuoteList',
    method: 'get',
    dataType: 'json',
    params,
  })
}

// 根据客户id查询库存
export const getInventoryData = (params) => {
  return request({
    url: '/api/user/getInventoryList',
    method: 'get',
    dataType: 'json',
    params,
  })
}

// 新增报价(SimQuote)
export const addSimQuoteData = (data) => {
  return request({
    url: '/api/user/addQuote',
    method: 'post',
    dataType: 'json',
    data,
  })
}

// 编辑报价(SimQuote)
export const updateSimQuoteData = (data) => {
  return request({
    url: '/api/quote/updateQuote',
    method: 'post',
    dataType: 'json',
    data,
  })
}

// 删除(SimQuote)
export const deleteSimQuoteData = (params) => {
  return request({
    url: '/api/user/deleteQuoteById',
    method: 'get',
    dataType: 'json',
    params,
  })
}

// 新增库存(SimInventory)
export const addSimInventoryData = (data) => {
  return request({
    url: '/api/user/addInventory',
    method: 'post',
    dataType: 'json',
    data,
  })
}

// 编辑库存(SimInventory)
export const updateSimInventoryData = (data) => {
  return request({
    url: '/api/user/updateInventory',
    method: 'post',
    dataType: 'json',
    data,
  })
}

// 删除库存(SimInventory)
export const deleteSimInventoryData = (params) => {
  return request({
    url: '/api/user/getInventoryById',
    method: 'get',
    dataType: 'json',
    params,
  })
}

