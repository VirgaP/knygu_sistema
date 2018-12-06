import React, {Component} from 'react';
import ProductComponent from './ProductComponent';
import CartProductList from './CartProductList';
import UpdateCartBtn from './UpdateCartBtn';

export const cartArray = [
    {
      id: 1,
      image_url: "http://placehold.it/120x80",
      product_name: "Bike",
      brand: "Grant",
      price: 500,
      quantity: 1,

    }, 
    {
        id: 2,
        image_url: "http://placehold.it/120x80",
        product_name: "Helmet",
        brand: "Helmet supreme",
        price: 55,
        quantity: 1,
    },
    {
        id: 3,
        image_url: "http://placehold.it/120x80",
        product_name: "Sports bike",
        brand: "Specialized",
        price: 1255,
        quantity: 1,
    }
]

class CartBody extends Component {
    render(){
        return(
            <div class="card-body">
            <CartProductList productsArray={cartArray} />
                <div className="pull-right">
                    <UpdateCartBtn items={cartArray}/>
                </div>          
            </div>
             
            
        )
    }
}



export default  CartBody;