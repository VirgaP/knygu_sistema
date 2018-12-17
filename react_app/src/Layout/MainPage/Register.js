import React, {Component} from 'react';
import { Button, Input } from 'antd';
import 'antd/dist/antd.css';
import axios from 'axios';
import { Redirect } from 'react-router-dom';

class Register extends Component {
  constructor(props) {
    super(props)
    this.state = {
      username: '',
      email: '',
      firstName: '',
      lastName: '',
      redirect: false,
    }
  }
 
  setRedirect = () => {
    this.setState({
      redirect: true
    })
  }
  renderRedirect = () => {
    if (this.state.redirect) {
      return <Redirect to='/products' />
    }
  }

  onChange = (e) => {
      this.setState({
        [e.target.name]: e.target.value,
        
      })
    }
  // static username = {
  //     username: this.state.username
  //   };

  componentDidMount = () => {
    
  }
  
  onSubmit = () => {
  axios.post('http://localhost:8090/api/users', {
    username : this.state.username,
    firstName : this.state.firstName,
    lastName : this.state.lastName,
    email : this.state.email,
})
.then((response) => {
  console.log("NEW USER:", response)
})

  this.setRedirect();
  
}
   
  render() {
  
    return (
    
      <div className="container" style={top}>
      <h2>Register user</h2>
        <Input
         style={style}
          name='username'
          placeholder='Username'
          onChange={e => this.onChange(e)}
          value={this.state.username} />
        <Input
         style={style}
          name='email'
          placeholder='Email'
          onChange={e => this.onChange(e)}
          value={this.state.email} />
        <Input
         style={style}
          name='firstName'
          placeholder='Firstname'
          onChange={e => this.onChange(e)}
          value={this.state.firstName} />
        <Input
          style={style}
          name='lastName'
          placeholder='Lastname'
          value={this.state.lastName}
          onChange={e => this.onChange(e)}
        >
        </Input>
        <br />
        {this.renderRedirect()}
        <Button onClick={() => this.onSubmit()} type="primary">Register!</Button>
      </div>
    );
  }
}
const style = {
    margin:'0 0 20px 0',
   
  }
const top ={
    marginTop: '100px',
    marginBottom: '100px'
}  
export default Register;