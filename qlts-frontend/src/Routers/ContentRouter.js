import React  from 'react';
import { Switch, Route } from "react-router-dom";
import Users from '../Components/Pages/Users';

export default () => (
    <Switch>
        <Route exact path="/app/user" component={Users} />
    </Switch>
)