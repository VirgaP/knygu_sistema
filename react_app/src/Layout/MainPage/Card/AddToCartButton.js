import React, {Component} from 'react';

class AddToCartButton extends Component {
    addToCart = (event) => {
        alert('click on ' + event);
    }

    render(){
        return (
            <button className="btn btn-primary" onClick={this.addToCart.bind(this)}>Order</button>
        )
    }
}

export default AddToCartButton;