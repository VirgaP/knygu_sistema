import React, {Component} from 'react';
import {cartArray} from './CartBody'

export default class UpdateCartBtn extends Component {
    constructor() {
        super();
        this.state = {
            total:0
        };
        this.getTotal = this.getTotal.bind(this);
        
      }
      //updates on second click
      getTotal = () => {
        this.setState(({ total }) => ({
          total: cartArray.reduce((i, {price}) => i + price, 0)
          
        }));
        console.log(this.state.total);
      };
    // getTotal(){
    //     const total = cartArray.reduce((i, {price}) => i + price, 0);
        
    //     console.log(total);
    // }
   
    render() {
        console.log('importuoti pr: ', cartArray)
        return(
            <div className="update">  
               <button onClick={this.getTotal} class="btn btn-outline-secondary pull-right update-cart-button">
                    Update and get total
                </button>
                <div>Total price: {this.state.total}</div>
            </div>
            
        )
    }
}
