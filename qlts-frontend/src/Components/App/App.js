import React, { Component } from 'react';
import './App.css';
import { BrowserRouter as Router } from "react-router-dom";
import AppRouter from '../../Routers/AppRouter';

class App extends Component {
  render() {
    return (
      <Router>
        <AppRouter></AppRouter>
      </Router>
    );
  }
}

export default App;
