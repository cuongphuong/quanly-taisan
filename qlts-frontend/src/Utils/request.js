import axios from 'axios'
import { getToken, removeToken } from '../Utils/token'
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
    let token = getToken()
    if (token) {
        config.headers['Authorization'] = 'Bearer ' + token // Json web token-- ['X-Token']
    }
    return config;
}, error => {
    Promise.reject(error)
})

// respone interceptor
service.interceptors.response.use(
    response => {
        const res = response.data;
        if (response.status !== 200) {
            message.error(res.msg);
            return Promise.reject(res.msg);
        } else {
            if (response.config.pgtype === 'login') {
                let authorization = response.headers.authorization
                let jwt = authorization.substring(7);
                message.success("Đăng nhập thành công");
                return jwt;
            } else {
                return response.data;
            }
        }
    },
    error => {
        // loading.hide(error.config)
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
