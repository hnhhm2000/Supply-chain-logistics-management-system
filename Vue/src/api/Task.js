import request from "./axios";

// 分页查询
export const getTaskData = (data) => {
  return request({
    url: '/api/task/getTaskList',
    method: 'post',
    dataType: 'json',
    data,
  })
}

// 新增客户
export const addTaskData = (data) => {
  return request({
    url: '/api/task/addTask',
    method: 'post',
    dataType: 'json',
    data,
  })
}

// 编辑
export const updateTaskData = (data) => {
  return request({
    url: '/api/task/updateTask',
    method: 'post',
    dataType: 'json',
    data,
  })
}

// 删除
export const deleteTaskData = (params) => {
  return request({
    url: '/api/task/deleteTaskById',
    method: 'get',
    dataType: 'json',
    params,
  })
}

