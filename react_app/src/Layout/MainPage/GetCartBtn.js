import React, { Component } from 'react';
import UserContext from '../../UserContext';
import axios from 'axios';


export class GetCartBtn extends Component {
    constructor(props) {
        super(props);
        this.createCart = this.createCart.bind(this);
      }


      
    createCart(context) { // context argument passed to the function param from method call
        return function () { 
            var username = context;
            axios.post('http://localhost:8090/api/cart/new', {
                username : username,
            }).then(res => {
                console.log(res);
            })
            .catch(error => {
                console.log(error.response)
            });
            console.log("user kontex:", username)
            console.log(typeof username )
    }
}
    
  render() {
    return (
        <UserContext.Consumer>
        {(context)=> (
        <React.Fragment>   
        <button onClick={this.createCart(context)}>Create cart</button>        
         {/* passing context as prop to createCart func */}
        </React.Fragment> 
        )}
    </UserContext.Consumer>
    )
  }
}

export default GetCartBtn
