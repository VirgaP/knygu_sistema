import React, {Component} from 'react';
import Heading from './Heading';
import CartFooter from './CartFooter';
import CartBody from './CartBody';


export default class CartPage extends Component {
    render(){
        return(
            <div className="container">
                <div className="card shopping-cart">
                    <Heading/>
                    <CartBody/>
                    <CartFooter/>
                </div>
            </div>    
        )
    }

}