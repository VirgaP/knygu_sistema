import React, {Component} from 'react';
import axios from 'axios';

class AddToCartButton extends Component {

    constructor(props) {
        super(props)
        this.state = {
            
        }
      }
   
      
    addToCart = (event) => {
      
            const user = {
                username: this.props.context
              };

              const product = {
                  product_No: this.props.product.product_No
              }
          
            //   axios.post(`http://localhost:8090/api/cart/add/product`, { user, product })
            //     .then(res => {
            //       console.log(res);
            //       console.log(res.data);
            //     })


    axios.post("http://localhost:8090/api/cart/add/product", {
        username: user,
        product_No: product
      }).then(function(response) {
        console.log(response);
      }).catch(function(error) {
        console.log(error);
      })

    }

    render(){
        return (

            <button className="btn btn-primary" onClick={this.addToCart.bind(this)}>Order </button>
        )
    }
}

export default AddToCartButton;