import request from "./axios";

// 分页查询
export const getQuoteData = (data) => {
  return request({
    url: '/api/quote/queryQuoteList',
    method: 'post',
    dataType: 'json',
    data,
  })
}

// 新增客户
export const addQuoteData = (data) => {
  return request({
    url: '/api/quote/addQuote',
    method: 'post',
    dataType: 'json',
    data,
  })
}

// 编辑
export const editQuoteData = (data) => {
  return request({
    url: '/api/quote/updateQuote',
    method: 'post',
    dataType: 'json',
    data,
  })
}

// 详情
export const getQuoteDetail = (params) => {
  return request({
    url: '/api/quote/getQuoteDetailsById',
    method: 'get',
    dataType: 'json',
    params,
  })
}

// 删除
export const deleteQuoteData = (params) => {
  return request({
    url: '/api/quote/deleteQuoteById',
    method: 'get',
    dataType: 'json',
    params,
  })
}

