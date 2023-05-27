import request from "./axios";

// 分页查询
export const getReceiptData = (data) => {
  return request({
    url: '/api/receipt/queryReceiptList',
    method: 'post',
    dataType: 'json',
    data,
  })
}

// 新增客户
export const addReceiptData = (data) => {
  return request({
    url: '/api/receipt/addReceipt',
    method: 'post',
    dataType: 'json',
    data,
  })
}

// 编辑
export const updateReceiptData = (data) => {
  return request({
    url: '/api/receipt/updateReceipt',
    method: 'post',
    dataType: 'json',
    data,
  })
}

// 详情
export const getReceiptDetail = (params) => {
  return request({
    url: '/api/receipt/getReceiptDetailsById',
    method: 'get',
    dataType: 'json',
    params,
  })
}

// 删除
export const deleteReceiptData = (params) => {
  return request({
    url: '/api/receipt/deleteReceiptById',
    method: 'get',
    dataType: 'json',
    params,
  })
}

