import React, {Component} from 'react';
import ProductComponent from './ProductComponent';
import CartProductList from './CartProductList';
import UpdateCartBtn from './UpdateCartBtn';
import axios from 'axios';
import UserProvider from '../UserProvider';
import UserContext from '../UserContext';

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

   
    

    // componentDidMount = () => {
    
    //     axios.get(`http://localhost:8090/api/cart/${this.props.context}`, {
    //         // params: {
    //         //   id: this.state.id
    //         // }
    //       })
    //       .then(function (response) {
    //         console.log(response);
    //       })
    //       .catch(function (error) {
    //         console.log(error);
    //       });

    //       console.log("user in cart: ", this.props.context)
    // }

   
    componentDidMount = () => {
        console.log("user in cart: ", this.context )
    }
    
    
    render(){
        return(
            <div class="card-body">
            <UserProvider>
           
            <UserContext.Consumer>
            {(context)=> (
            <React.Fragment>   
            <CartProductList context={this.props.context} productsArray={cartArray} />
                <div className="pull-right">
                    <UpdateCartBtn items={cartArray}/>
                </div>
                </React.Fragment> 
            )}
        </UserContext.Consumer>
            </UserProvider>
            </div>
        )
    }
}



export default  CartBody;