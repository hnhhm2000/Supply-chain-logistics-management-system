import request from "./axios";

// 分页查询
export const getGroundData = (data) => {
  return request({
    url: '/api/ground/queryGroundList',
    method: 'post',
    dataType: 'json',
    data,
  })
}

// 新增客户
export const addGroundData = (data) => {
  return request({
    url: '/api/ground/addGround',
    method: 'post',
    dataType: 'json',
    data,
  })
}

// 编辑
export const updateGroundData = (data) => {
  return request({
    url: '/api/ground/updateGround',
    method: 'post',
    dataType: 'json',
    data,
  })
}

// 详情
export const getGroundDetail = (params) => {
  return request({
    url: '/api/ground/getGroundDetailsById',
    method: 'get',
    dataType: 'json',
    params,
  })
}

// 删除
export const deleteGroundData = (params) => {
  return request({
    url: '/api/ground/deleteGroundById',
    method: 'get',
    dataType: 'json',
    params,
  })
}

