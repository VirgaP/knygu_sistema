import React, {Component} from 'react';
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome';
import PropTypes from 'prop-types';
import AddToCartButton from './AddToCartButton';


// var jsonData = require('../../../Resources/products.json');

// const loadData = () => JSON.parse(JSON.stringify(jsonData.items));
//class Test extends Component {
    
const Card = (props) => {    
        return(    
          <div className="card h-100">
            <a href="#"><img className="card-img-top" src={props.image_url}></img></a>
            <div className="card-body">
                  <h4 className="card-title">
                    <a href="#">{props.brand}</a>
                  </h4>
                  <h5>{props.category}</h5>
                  <h5>{props.price} EUR</h5>
                  <span><h6>{props.gears} gears </h6></span>
                  <p className="card-text">{props.description}</p>
            </div>
            <div className="card-footer">
              <p>Rating &nbsp;    
              {Array(props.rating).fill(<FontAwesomeIcon icon="star" color={'yellow'} />)}
              </p>
                <AddToCartButton/>
                {/* <button class="btn btn-primary" onClick={props.addToCart}>Order</button> */}
            </div>
          </div>
        )
  }
export default Card;
Card.propTypes = {
    image_url: PropTypes.string.isRequired,
    category: PropTypes.string.isRequired,
    brand: PropTypes.string.isRequired,
    price: PropTypes.number.isRequired,
    gears: PropTypes.number.isRequired,
    size: PropTypes.string,
    rating: PropTypes.number.isRequired,
    description: PropTypes.string.isRequired
  };