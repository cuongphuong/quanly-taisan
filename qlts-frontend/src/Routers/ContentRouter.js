import React  from 'react';
import { Switch, Route } from "react-router-dom";
import Users from '../Components/Pages/Users';
// import  Module  from '../Components/Pages/Module';

export default () => (
    <Switch>
        <Route exact path="/app/user" component={Users} />
        {/* <Route exact path="/app/module" component={Module} /> */}
    </Switch>
)