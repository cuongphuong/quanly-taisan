import { combineReducers } from 'redux';
import config from './ConfigReducer';
import path from './PathReducer';

const reduces = combineReducers({
    config,
    path
});

export default reduces;