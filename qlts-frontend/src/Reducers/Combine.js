import { combineReducers } from 'redux';
import config from './ConfigReducer';
import path from './PathReducer';
import PermissionReducer from './PermissionReducer';
import lstBanGiao from './BanGiaoReducer';

const reduces = combineReducers({
    config,
    path,
    PermissionReducer,
    lstBanGiao
});

export default reduces;