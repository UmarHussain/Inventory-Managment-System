import React from 'react';
import { Button, FormGroup, FormControl, ControlLabel } from "react-bootstrap";
import { CustomAlert } from '../components/CustomAlert';
import 'bootstrap/dist/css/bootstrap.css';
import axios from 'axios';


export default class Login extends React.Component{

    constructor(props){
        super(props);

        this.state = {
            userName : "",
            password : "",
            error: "",
            showError: false
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
        event.preventDefault();
        let url = "http://localhost:8080/login";
        let payload = {
            userName : this.state.userName,
            password : this.state.password
        }
        axios.post(url, payload).then(response => {
            if(response.status == 200){
                alert("Welcome user :" + this.state.userName);
                sessionStorage.setItem("jwtToken", response.headers.authorization);
                window.location = "/dashboard";
            } else {
                this.setState({error : "Login Failed", showError: true}) 
            }
        }).catch(err => {
                this.setState({error : "Login Failed", showError: true})
            });
    }

    render(){
        return (
            <div className="container login">
                <CustomAlert type="danger" message={this.state.error} show={this.state.showError}
                />
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
                    <hr/>
                    <Button
                        block
                        bsSize="large"
                        disabled={!this.validateForm()}
                        type="submit"
                        className="btn btn-primary"
                    >
                        Login
                    </Button>
                </form>
            </div>
        );
    }

} 