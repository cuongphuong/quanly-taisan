import axios from 'axios'
import { getToken, removeToken } from '@/utils/token'
import loading from '@/utils/loading'
import permission from '@/utils/permission'
import history from './history'
import { message } from 'antd';

// create an axios instance
const service = axios.create({
    baseURL: 'http://localhost:8080', // api base_url
    timeout: 20000 // request timeout
})

// request interceptor
service.interceptors.request.use(config => {
    // Do something before request is sent
    if (!permission.check(config)) {
        throw "403"
    }
    loading.show(config)
    let token = getToken()
    if (token) {
        config.headers['Authorization'] = 'Bearer ' + token // Json web token-- ['X-Token']
    }
    return config
}, error => {
    // Do something with request error
    //console.log(error) // for debug
    Promise.reject(error)
})

// respone interceptor
service.interceptors.response.use(
    response => {
        loading.hide(response.config)
        const res = response.data;
        if (res.statusCode !== 200) {
            message.error(res.msg);
            return Promise.reject(res.msg);
        } else {
            return response.data;
        }
    },
    error => {
        loading.hide(error.config)
        if (error.response && error.response.status === 401) {
            removeToken();
            if (error.config.url.indexOf("logout") === -1) {
                message.error('Hết phiên làm việc, đăng nhập lại!');
            }
            setTimeout(() => {
                history.push('/login')
            }, 1000)

        } else if (error.response && error.response.status === 500) {
            message.error('Lổi hệ thống!');
        } else if (error.message && error.message.indexOf("timeout") > -1) {
            message.error('Máy chủ không phản hồi!');
        }
        else if (error === "403") {
            message.error('Yêu cầu không được cho phép!');
        } else {
            message.error('Không có kết nối!');
        }
        return Promise.reject(error)
    })

export default service
