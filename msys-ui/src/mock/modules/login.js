/* 
 * 系统登录模块
 */

// 登录接口
export function login() {
  const loginData = {
    "code": 200,
    "msg": null,
    "data": {
      "id": null,
      "userId": 1,
      "token": "77ae89be36504adfb5c09ef71409ea0e",
    }
  }
  return { 
    url: 'login',
    type: 'post',
    data: loginData
  }
}
// 登出接口
export function logout() {
  const logoutData = {
    "code": 200,
    "msg": null,
    "data": {
    }
  }
  return {
    url: 'logout',
    type: 'get',
    data: logoutData
  }
}