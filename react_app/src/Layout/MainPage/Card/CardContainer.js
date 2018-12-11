import React, { Component } from 'react';
import axios from 'axios';
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome';
import PropTypes from 'prop-types';
import AddToCartButton from './AddToCartButton';
import ProductsListContainer from './ProductsListContainer';

export default class CardContainer extends Component {
    constructor(props) {
      super(props)
        
      this.state = {
         id: this.props.match.params.productId, //is index.js paima url paima productId
         products: [],
         product: {},
         item: {}
      }
      console.log("id", this.state.id);
      console.log("propsa:", props)
    }
  
    componentDidMount = () => {
        axios.get(`http://localhost:8090/api/products/${this.state.id}`)
        .then(result => {
          const product = result.data
        this.setState({product});
        })
        .catch(function (error) {
          console.log(error);
        });
    }

  render() {
   console.log("params url: ", this.props.match.params.productId)
    return (
   <div className="container" style={style}>
         <div className="card h-100">
            <a href="#"><img className="card-img-top" src={this.state.product.image_url} alt={this.state.product.brand}></img></a>
            <div className="card-body">
                  <h4 className="card-title">
                  </h4>
                  <h5>{this.state.product.brand}</h5>
                  <h5>{this.state.product.category}</h5>
                  <h5>{this.state.product.price} EUR</h5>
                  <p className="card-text">{this.state.product.description}</p>
            </div>
            <div className="card-footer">
              <p>Rating &nbsp;    
              {Array(this.state.product.rating).fill(<FontAwesomeIcon icon="star" color={'yellow'} />)}
              </p>
                <AddToCartButton/>
            </div>
          </div>
        </div>
    );
  }
}

const style = {
    margin:'auto',
    marginTop:'20px',
    marginBottom:'20px',
    width: '70%'
  }
