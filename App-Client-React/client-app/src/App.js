import React, { Component } from 'react';
import {BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import InventoryTable from './components/InventoryTable';
import Login from './containers/login';
import './App.css';

class App extends Component {
  render() {
    return (
      <Router>
        <Switch>
            <Route exact path="/" component={ Login }/>
            <Route path="/dashboard" component={ InventoryTable }/>
            <Route render={ () => <h1>404 Error</h1> } />
        </Switch>
      </Router>
    );
  }
}

export default App;
