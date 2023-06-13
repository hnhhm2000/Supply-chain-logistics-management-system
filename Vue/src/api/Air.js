import request from "./axios";

// 分页查询
export const getAirData = (data) => {
  return request({
    url: '/api/air/queryAirList',
    method: 'post',
    dataType: 'json',
    data,
  })
}

// 新增客户
export const addAirData = (data) => {
  return request({
    url: '/api/air/addAir',
    method: 'post',
    dataType: 'json',
    data,
  })
}

// 编辑
export const updateAirData = (data) => {
  return request({
    url: '/api/air/updateAir',
    method: 'post',
    dataType: 'json',
    data,
  })
}

// 详情
export const getAirDetail = (params) => {
  return request({
    url: '/api/air/getAirDetailsById',
    method: 'get',
    dataType: 'json',
    params,
  })
}

// 删除
export const deleteAirData = (params) => {
  return request({
    url: '/api/air/deleteAirById',
    method: 'get',
    dataType: 'json',
    params,
  })
}

