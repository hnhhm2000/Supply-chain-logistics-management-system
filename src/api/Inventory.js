import request from "./axios";

// 分页查询
export const getInventoryData = (data) => {
  return request({
    url: '/api/inventory/queryInventoryList',
    method: 'post',
    dataType: 'json',
    data,
  })
}

// 新增客户
export const addInventoryData = (data) => {
  return request({
    url: '/api/inventory/addInventory',
    method: 'post',
    dataType: 'json',
    data,
  })
}

// 编辑
export const updateInventoryData = (data) => {
  return request({
    url: '/api/inventory/updateInventory',
    method: 'post',
    dataType: 'json',
    data,
  })
}


// 删除
export const deleteInventoryData = (params) => {
  return request({
    url: '/api/inventory/deleteInventoryById',
    method: 'get',
    dataType: 'json',
    params,
  })
}

