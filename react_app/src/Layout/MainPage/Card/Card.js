import React, {Component} from 'react';
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome';
import PropTypes from 'prop-types';
import AddToCartButton from './AddToCartButton';
import {Link } from "react-router-dom";

//class Test extends Component {
    
const Card = (props) => { 
        return(    
          <div className="card h-100">
            <a href="#"><img className="card-img-top" src={props.image_url} alt={props.brand}></img></a>
            <div className="card-body">
                  <h4 className="card-title">
                  <Link to={`/product/${props.id}`}>{props.brand}</Link>
                  </h4>
                  <h5>{props.category}</h5>
                  <h5>{props.price} EUR</h5>
                  <p className="card-text">{props.description}</p>
            </div>
            <div className="card-footer">
              <p>Rating &nbsp;    
              {Array(props.rating).fill(<FontAwesomeIcon icon="star" color={'yellow'} />)}
              </p>
                <AddToCartButton/>
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