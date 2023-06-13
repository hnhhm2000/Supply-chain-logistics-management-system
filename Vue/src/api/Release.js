import request from "./axios";

// 分页查询
export const getReleaseData = (data) => {
  return request({
    url: '/api/release/queryReleaseList',
    method: 'post',
    dataType: 'json',
    data,
  })
}

// 新增客户
export const addReleaseData = (data) => {
  return request({
    url: '/api/release/addRelease',
    method: 'post',
    dataType: 'json',
    data,
  })
}

// 编辑
export const updateReleaseData = (data) => {
  return request({
    url: '/api/release/updateRelease',
    method: 'post',
    dataType: 'json',
    data,
  })
}

// 详情
export const getReleaseDetail = (params) => {
  return request({
    url: '/api/release/getReceiptDetailsById',
    method: 'get',
    dataType: 'json',
    params,
  })
}

// 删除
export const deleteReleaseData = (params) => {
  return request({
    url: '/api/release/deleteReleaseById',
    method: 'get',
    dataType: 'json',
    params,
  })
}

