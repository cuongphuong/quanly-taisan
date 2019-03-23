import React from 'react';
import { Switch, Route } from "react-router-dom";
import Login from '../Components/Pages/Login';
let Layout = null;

Layout = require('../Components/Dashboard/Dashboard').default;

export default () => (
    <Switch>
        <Route exact path="/login" component={Login} /> 
        <Route path="/" component={Layout} />
    </Switch>
)