import request from "../Utils/request";


// API lấy tất cả chúc vụ
export function getAllChucvu()
{
    return request({
        url: '/chucvu/listchucvu ',
        method: 'GET'
    })
}

export function addNewChucvu(data)
{
    return request({
        url: '/chucvu/add-chucvu',
        method:'POST',
        data: data
    })
}

export function updateChucvu(data)
{
    return request({
        url: '/chucvu/update-chucvu',
        method: 'PUT',
        data: data
    })
}
export function deleteChucVu(id)
{
    return request({
        url: '/chucvu/delete-Chucvu/' + id,
        method: 'DELETE'
    })
}

export function deleteByList(lst)
{
    return request({
        url:'/chucvu/delete-by-LIST',
        method: 'DELETE',
        data: lst
    })
}

// API Lấy tất cả ĐVT
export function getALLDonvitinh()
{
    return request({
        url:'/donvitinh/listdvt',
        method:'GET'
    })
}

export function addNewDonvitinh(data)
{
    return request({
        url:'/donvitinh/add-dvt',
        method:'POST',
        data: data
    })
}
export function updateDonvitinh(data)
{
    return request({
        url:'/donvitinh/donvitinh',
        method:'PUT',
        data: data
    })
}
export function deleteDonvitinh()
{
    return request(
        {
            url:'/donvitinh/xoa-dvt',
            method: 'DELETE'
        }
    )
}
export function deleteByListdvt(lstdvt)
{
    return request({
        url:'',
        method:'',
        data : lstdvt
    })
}