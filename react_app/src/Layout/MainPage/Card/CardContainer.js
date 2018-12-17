import React, { Component } from 'react';
import axios from 'axios';
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome';
import PropTypes from 'prop-types';
import ProductsListContainer from './ProductsListContainer';
import { Button } from 'antd';
import 'antd/dist/antd.css';
import UserContext from '../../../UserContext';
import UserProvider from '../../../UserProvider';
import AddToCartButton from './AddToCartButton';

export default class CardContainer extends Component {
    constructor(props) {
      super(props)
        
      this.state = {
         id: this.props.match.params.product_No, //is index.js paima url paima productId
         products: [],
         product: {},
         item: {},
        
      }
      console.log("id", this.state.id);
      console.log("propsai:", props)
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

    DeleteItem = (event) => {
        axios.delete(`http://localhost:8090/api/products/${this.state.id}`)
        .then(result => {
          const product = result.data
        this.setState({product});
        })
        .catch(function (error) {
          console.log(error);
        });
        
        this.props.history.push('/') //redirects Home after delete
    }
    

  render() {
   console.log("params url: ", this.props.match.params.product_No)
    return (
        <UserProvider>
        <UserContext.Consumer>
           {(context)=> (  
            <React.Fragment>  
        <div style={username}>You are now shopping as : {context}</div>

         <div className="container" style={style}>
         <div className="card h-100">
            <a href="#"><img className="card-img-top" src="http://placehold.it/700x400" alt={this.state.product.image_url}></img></a>
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
              <AddToCartButton context={context} product={this.state.product}/>
               {/* <Button type="default" onClick={this.addToCart.bind(this)}> Add to cart </Button>  */}
               &nbsp; &nbsp; 
               <Button type="danger" onClick={this.DeleteItem.bind(this)}> Delete </Button>
            </div>
          </div>
        </div>
            </React.Fragment> 
                )}
            </UserContext.Consumer>
            </UserProvider>
    );
  }
}

const style = {
    margin:'auto',
    marginTop:'20px',
    marginBottom:'20px',
    width: '70%'
  }
  const username = {
    border:'solid 1 px grey',
    backgroundColor: 'yellow',
}

