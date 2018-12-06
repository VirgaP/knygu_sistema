import React, {Component} from 'react';
// import ProductComponent from './ProductComponent';
import PropTypes from 'prop-types';
import ProductListComponent from './ProductListComponent';


class CartProductList extends Component {
    constructor(props) {
        super(props);
        this.state = {
            products: null,
        };
      }

    componentDidMount(){  
        this.setState({products: this.props.productsArray})
    }

      
     render(){
       
        if(this.state.products == null){
            return <span>No products yet</span>
        }
            return (
                <ProductListComponent 
                        products={this.state.products}
                        // handleIncrement={this.handleIncrement.bind(this)}
                        // handleDecrement={this.handleDecrement.bind(this)}
                        />
            );
           
        }
        
    }


export default CartProductList;