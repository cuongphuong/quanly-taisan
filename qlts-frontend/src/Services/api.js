import request from "../Utils/request";


// API đăng nhập hệ thống
export function loginByUsername(username, password) {
    var formData = new FormData();
    formData.append('username', username);
    formData.append('password', password);

    return request({
        url: '/login',
        method: 'POST',
        data: formData,
        pgtype: 'login'
    })
}

//API Lấy thông tin user đang đăng nhập
export function getInfoUser() {
    return request({
        url: '/account/get-info-user',
        method: 'GET'
    })
}

// API lấy danh sách chức năng trên menu
export function getFunctionMenu() {
    return request({
        url: '/permission/get-function-active/',
        method: 'GET',
    })
}

// API lấy tất cả user
export function getAllUser() {
    return request({
        url: '/account/get-all-user',
        method: 'GET'
    })
}
