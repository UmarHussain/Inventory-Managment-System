import React from 'react';
import { Button, FormGroup, FormControl, ControlLabel } from "react-bootstrap";
import {BrowserRouter as Router} from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.css';


export default class Login extends React.Component{

    constructor(props){
        super(props);

        this.state = {
            userName : "",
            password : ""
        };
    }

    validateForm() {
        return this.state.userName.length > 0 && this.state.password.length > 0;
    }
    
    handleChange = event => {
        this.setState({
          [event.target.id]: event.target.value
        });
    }
    
    handleSubmit = event => {
        alert("UserName:" + this.state.userName + " Password:" + this.state.password );
    }

    render(){
        return (
            <div className="container login">
                <form onSubmit={this.handleSubmit}>
                    <FormGroup controlId="userName" bsSize="large">
                        <ControlLabel>User Name</ControlLabel>
                        <FormControl
                        placeholder="User Name"
                        autoFocus
                        value={this.state.userName}
                        onChange={this.handleChange}
                        />
                    </FormGroup>
                    <FormGroup controlId="password" bsSize="large">
                        <ControlLabel>Password</ControlLabel>
                        <FormControl
                        value={this.state.password}
                        placeholder="Password"
                        onChange={this.handleChange}
                        type="password"
                        />
                    </FormGroup>
                    <Button
                        block
                        bsSize="large"
                        disabled={!this.validateForm()}
                        type="submit"
                    >
                        Login
                    </Button>
                </form>
            </div>
        );
    }

} 