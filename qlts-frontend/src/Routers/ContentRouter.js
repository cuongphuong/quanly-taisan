import React  from 'react';
import { Switch, Route } from "react-router-dom";
import Users from '../Components/Pages/Users';
import Function from '../Components/Pages/Function';
import Group from '../Components/Pages/Group';
import NhanVien from '../Components/Pages/NhanVien';
import Chucvu from '../Components/Pages/Chucvu';
import TinhTrang from '../Components/Pages/TinhTrang';
import Donvitinh from '../Components/Pages/Donvitinh';
import Permission from '../Components/Pages/Permission';
import PhongBan from '../Components/Pages/PhongBan';
import DeviceRequirement from '../Components/Pages/DeviceRequirement/DeviceRequirement';
import SeeDetailedList from '../Components/Pages/DeviceRequirement/SeeDetailedList';
// import  Module  from '../Components/Pages/Module';

export default () => (
    <Switch>
        <Route exact path="/app/user" component={Users} />
        {/* <Route exact path="/app/module" component={Module} /> */}
        <Route exact path="/app/function" component={Function} />
        <Route exact path="/app/group" component={Group} />
        <Route exact path="/app/employee" component={NhanVien} />
        <Route exact path="/app/phongban" component={PhongBan} />
        <Route exact path="/app/chucvu" component={Chucvu} />
        <Route exact path="/app/tinhtrang" component={TinhTrang} />
        <Route exact path="/app/donvitinh" component={Donvitinh} />
        <Route exact path="/app/permission/:id" component={Permission} />
        <Route exact path="/app/yeucauthietbi" component={DeviceRequirement} />
        <Route exact path="/app/seedetailslist" component={SeeDetailedList} />
    </Switch>
)