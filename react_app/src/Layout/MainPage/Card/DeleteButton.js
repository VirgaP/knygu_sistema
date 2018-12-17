import React, { Component } from 'react'

export class DeleteButton extends Component {
    addToCart = (event) => {
        alert('click on  delete' + event);
    }

    render(){
        return (

            <button className="btn btn-danger" onClick={this.addToCart.bind(this)}>Delete </button>
        )
    }
}

export default DeleteButton
