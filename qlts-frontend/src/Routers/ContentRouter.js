import React  from 'react';
import { Switch, Route } from "react-router-dom";
import Users from '../Components/Pages/Users';
import Function from '../Components/Pages/Function';
import Group from '../Components/Pages/Group';
import NhanVien from '../Components/Pages/NhanVien';
import Chucvu from '../Components/Pages/Chucvu';
import TinhTrang from '../Components/Pages/TinhTrang';
import Donvitinh from '../Components/Pages/Donvitinh';
// import  Module  from '../Components/Pages/Module';

export default () => (
    <Switch>
        <Route exact path="/app/user" component={Users} />
        {/* <Route exact path="/app/module" component={Module} /> */}
        <Route exact path="/app/function" component={Function} />
        <Route exact path="/app/group" component={Group} />
        <Route exact path="/app/employee" component={NhanVien} />
        {/* <Route exact path="/app/phongban" component={} /> */}
        <Route exact path="/app/chucvu" component={Chucvu} />
        <Route exact path="/app/tinhtrang" component={TinhTrang} />
        <Route exact path="/app/donvitinh" component={Donvitinh} />
    </Switch>
)