import { combineReducers } from 'redux';
import config from './ConfigReducer';
import path from './PathReducer';
import phongban from './phongban';
import thietbis from './thietbis';

const reduces = combineReducers({
    config,
    path, 
    phongban,
    thietbis
});

export default reduces;