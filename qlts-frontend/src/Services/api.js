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

//API thêm mới user
export function addNewUser(data){
    return request({
        url: '/account/add-new-user',
        method: 'POST',
        data: data
    })
}

//API cập nhật user
export function updateUser(data){
    return request({
        url: '/account/update-user',
        method: 'PUT',
        data: data
    })
}

//API xóa user
export function deleteUser(id){
    return request({
        url: '/account/delete-user/' + id,
        method: 'DELETE',
    })
}

//API xóa theo list
export function deleteByList(lst){
    return request({
        url: '/account/delete-by-list',
        method: 'DELETE',
        data: lst
    })
}

/////////////////////////////////////////////////

// API lấy tất cả module
export function getAllModule() {
    return request({
        url: '/permission/get-all-module',
        method: 'GET'
    })
}

//API thêm mới module
export function addNewModule(data){
    return request({
        url: '/permission/add-module',
        method: 'POST',
        data: data
    })
}

//API cập nhật module
export function updateModule(data){
    return request({
        url: '/permission/update-module',
        method: 'PUT',
        data: data
    })
}

//API xóa module
export function deleteModule(id){
    return request({
        url: '/permission/delete-module/' + id,
        method: 'DELETE',
    })
}

//API xóa module theo list
export function deleteModuleByList(lst){
    return request({
        url: '/account/delete-by-list',
        method: 'DELETE',
        data: lst
    })
}