import request from "../Utils/request";

// API lấy tất cả tinh trang
export function getAllTinhTrang() {
    return request({
        url: '/infor/list-tinhtrang',
        method: 'GET'
    })
}

//API thêm mới tinh trang
export function addNewTinhTrang(data){
    return request({
        url: '/infor/add-tinhtrang',
        method: 'POST',
        data: data
    })
}

//API cập nhật user
export function updateTinhTrang(data){
    return request({
        url: '/infor/update-tinhtrang',
        method: 'PUT',
        data: data
    })
}

//API xóa user
export function deleteTinhTrang(id){
    return request({
        url: '/infor/delete-tinhtrang/' + id,
        method: 'DELETE',
    })
}

//API xóa theo list
export function deleteByListTinhTrang(lst){
    return request({
        url: '/infor/delete-by-list',
        method: 'DELETE',
        data: lst
    })
}
// API lấy tất cả các nhân viên
export function getAllNhanVien() {
    return request({
        url: '/infor/list-employeeUpdate',
        method: 'GET'
    })
}

//API thêm mới nhan vien
export function addNewNhanVien(data){
    return request({
        url: '/infor/add-employee',
        method: 'POST',
        data: data
    })
}

//API cập nhật nhan vien
export function updateNhanVien(data){
    return request({
        url: '/infor/update-employee',
        method: 'PUT',
        data: data
    })
}

//API xóa nhan vien
export function deleteNhanVien(id){
    return request({
        url: '/infor/delete-employee/' + id,
        method: 'DELETE',
    })
}

///////////////////////
// crud barng chuc vu
export function getAllChucVu(){
    return request({
        url: '/infor/listAllChucVu',
        method: 'GET',
    })
}
////////////////////
// crud list All phong ban
export function getAllPhongBan(){
    return request({
        url: '/infor/listAllPhongBan',
        method: 'GET',
    })
}

//API xóa theo list
export function deleteByListNhanVien(lst){
    return request({
        url: '/infor/delete-by-listNhanVien',
        method: 'DELETE',
        data: lst
    })
}

// crud list All phong ban
export function getAllDonViTinh(){
    return request({
        url: '/infor/listAllDonViTinh',
        method: 'GET',
    })
}

export function addNewDonViTinh(data)
{
    return request({
        url : '/infor/add-newdonvitinh',
        method : 'POST', 
        data : data
    })
}

export function updateDonViTinh(data){
    return request({
        url : '/infor/update-donviinh',
        method : 'PUT', 
        data : data
    });
}

export function deleteDonViTinh(id){
    return request({
        url : '/infor/delete-donvitinh/'+ id, 
        method : 'DELETE'
    });
}

export function deleteByListDonViTinh(list){
    return request({
        url : '/infor/delete-list-donvitinh',
        method : 'DELETE', 
        data : list
    });
}/////////////////////////////////////////////////////////////