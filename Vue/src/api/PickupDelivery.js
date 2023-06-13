import request from "./axios";

// 分页查询
export const getPickupDeliveryData = (data) => {
  return request({
    url: '/api/pickupDelivery/queryPickupDeliveryList',
    method: 'post',
    dataType: 'json',
    data,
  })
}

// 新增客户
export const addPickupDeliveryData = (data) => {
  return request({
    url: '/api/pickupDelivery/addPickupDelivery',
    method: 'post',
    dataType: 'json',
    data,
  })
}

// 编辑
export const updatePickupDeliveryData = (data) => {
  return request({
    url: '/api/pickupDelivery/updatePickupDelivery',
    method: 'post',
    dataType: 'json',
    data,
  })
}

// 详情
export const getPickupDeliveryDetail = (params) => {
  return request({
    url: '/api/pickupDelivery/getPickupDeliveryDetailsById',
    method: 'get',
    dataType: 'json',
    params,
  })
}

// 删除
export const deletePickupDeliveryData = (params) => {
  return request({
    url: '/api/pickupDelivery/deletePickupDeliveryById',
    method: 'get',
    dataType: 'json',
    params,
  })
}

