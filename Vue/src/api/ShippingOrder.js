import request from "./axios";

// 分页查询
export const getShipmentOrderData = (data) => {
  return request({
    url: '/api/shipmentOrder/queryShipmentOrderList',
    method: 'post',
    dataType: 'json',
    data,
  })
}

// 新增装货单
export const addShipmentOrder = (data) => {
  return request({
    url: '/api/shipmentOrder/addShipmentOrder',
    method: 'post',
    dataType: 'json',
    data,
  })
}

// 编辑
export const updateShipmentOrder = (data) => {
  return request({
    url: '/api/shipmentOrder/updateShipmentOrder',
    method: 'post',
    dataType: 'json',
    data,
  })
}

// 详情
export const getShipmentOrderDetails = (params) => {
  return request({
    url: '/api/shipmentOrder/getShipmentOrderDetailsById',
    method: 'get',
    dataType: 'json',
    params,
  })
}

// 删除
export const deleteShipmentOrderData = (params) => {
  return request({
    url: '/api/shipmentOrder/deleteShipmentOrderById',
    method: 'get',
    dataType: 'json',
    params,
  })
}

