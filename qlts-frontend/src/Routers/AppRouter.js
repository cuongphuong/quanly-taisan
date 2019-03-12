import React, { Component } from 'react';
import { Switch, Route } from "react-router-dom";
import Dashboard from '../Components/Dashboard/Dashboard';

class AppRouter extends Component {
    render() {
        return (
            <Switch>
                <Route exact path="/" component={Dashboard} />
            </Switch>
        );
    }
}

export default AppRouter;