import request from "./axios";

// 分页查询
export const getOceanData = (data) => {
  return request({
    url: '/api/ocean/queryOceanList',
    method: 'post',
    dataType: 'json',
    data,
  })
}

// 新增客户
export const addOceanData = (data) => {
  return request({
    url: '/api/ocean/addOcean',
    method: 'post',
    dataType: 'json',
    data,
  })
}

// 编辑
export const updateOceanData = (data) => {
  return request({
    url: '/api/ocean/updateOcean',
    method: 'post',
    dataType: 'json',
    data,
  })
}

// 详情
export const getOceanDetail = (params) => {
  return request({
    url: '/api/ocean/getOceanDetailsById',
    method: 'get',
    dataType: 'json',
    params,
  })
}

// 删除
export const deleteOceanData = (params) => {
  return request({
    url: '/api/ocean/deleteOceanById',
    method: 'get',
    dataType: 'json',
    params,
  })
}

