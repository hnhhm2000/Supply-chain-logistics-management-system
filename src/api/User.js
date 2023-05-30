import request from "./axios";

// 登陆
export const login = (data) => {
  return request({
    url: "/api/user/login",
    method: "post",
    dataType: "json",
    data,
  });
};

// 获取个人资料
export const getUserInfo = (token) => {
  return request({
    url: "/api/user/getUserInfoByToken",
    method: "get",
    headers: {
      token: token,
    },
  });
};

// 获取客户联想用列表
export const getUserListByRole = (params) => {
  return request({
    url: "/api/user/getUserListByRole",
    method: "get",
    dataType: 'json',
    params
  });
};

// 获取用户列表
export const getUserData = (params) => {
  return request({
    url: "/api/user/getList",
    method: "get",
    dataType: "json",
    params,
  });
};

// 新增用户
export const addUserData = (data) => {
  return request({
    url: "/api/user/addUser",
    method: "post",
    dataType: "json",
    data,
  });
};

// 编辑用户
export const updateUserData = (data) => {
  return request({
    url: "/api/user/updateUser",
    method: "post",
    dataType: "json",
    data,
  });
};

// 删除用户
export const deleteUserData = (params) => {
  return request({
    url: "/api/user/deleteUserById",
    method: "get",
    params
  });
};

