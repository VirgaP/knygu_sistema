import React, { Component } from 'react';
// import './App.css';
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome';
import {cartArray} from '../Cart/CartBody';



class Navbar extends Component {

  constructor(props) {
    super(props)
  
    this.state = {
       products:cartArray
    }
  }
  

  
  // goProducts = (props) => this.props.history.push("products");
  render() {
  
    return (    
        // <!-- Navigation -->
        <nav className="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
          <div className="container">
            {/* <a className="navbar-brand" href="#">Home</a> */}
            <Link className="navbar-brand" to='/'>Home</Link> 
            <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
              <span className="navbar-toggler-icon"></span>
            </button>
            <div className="collapse navbar-collapse" id="navbarResponsive">
              <ul className="navbar-nav ml-auto">
                <li className="nav-item active">
                  {/* <a className="nav-link" href="#">Home */}
                  <Link className="nav-link" to='/'> Home</Link> 
                    <span className="sr-only">(current)</span>
                  {/* </a> */}
                </li>
                <li className="nav-item">
                  {/* <a className="nav-link" href="#">Cart</a> */}
                  <Link className="nav-link" to='/cart'>Cart<FontAwesomeIcon icon="shopping-cart"/>
                  </Link> 
                </li>
                <li>
                {/* {
                  this.state.products.map(product => (
                    <div key={product.id}>
                        <Link to={`/product/${product.id}`}>{product.id}</Link>
                    </div>
                ))
                } */}
                </li>
                {/* <li className="nav-item">
                  <a className="nav-link" onClick={this.goProducts} href="/products">Products</a>
                </li> */}
                <Link className="nav-link" to='/products'>Products</Link> 
                <li className="nav-item">
                  {/* <a className="nav-link" href="#">Contact</a> */}
                  <Link className="nav-link" to='/admin'>Admin form</Link> 

                </li>
              </ul>
            </div>
          </div>
          {/* <p><button onClick={this.goProducts}
      className="btn btn-primary">Go to Products</button></p> */}
      
        </nav>
      
    );
  }
}

export default Navbar;