import React, {Component} from 'react';
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome';

// var jsonData = require('../../../Resources/products.json');

// const loadData = () => JSON.parse(JSON.stringify(jsonData.items));
//class Test extends Component {
    
const Test = (products) => {    
    
    // const data = props.products;
    // const bikes = data.items;
    // console.log(bikes);

    // const productArray = [bikes];
    // console.log(productArray);
     console.log('is test', [products.items]);
    const array = [products.items].map((el, i)=>{
       return i;
     })

     console.log('is test', array);

    var productList = 
    array.map((el, j) => (
            <div class="col-lg-4 col-md-6 mb-4">            
            <div className="card h-100">
            <a href="#"><img class="card-img-top" src={el.image_url}></img></a>
            <div className="card-body">
                  <h4 class="card-title">
                    <a href="#">{el.brand}</a>
                  </h4>
                  <h5>{el.title}</h5>
                  <h5>{el.price} EUR</h5>
                  <span><h6>{el.gears} gears </h6><h6>Size: {el.size}</h6></span>
                  <p className="card-text">{el.description}</p>
            </div>
            <div class="card-footer">
            <p>Rating &nbsp;    
          {Array(el.rating).fill(<FontAwesomeIcon icon="star" color={'yellow'} />)}
          </p>
                <button class="btn btn-primary">Order</button>
                </div>
                </div>
            </div>
        
            ))
          
    return (
      <div className="row">
      {productList}
      </div>      
      );
    
  }


export default Test;