import React  from 'react';
import { Switch, Route } from "react-router-dom";
import CreateUser from '../Components/Pages/UserPages/CreateUser';

export default () => (
    <Switch>
        <Route exact path="/app/create" component={CreateUser} />
    </Switch>
)