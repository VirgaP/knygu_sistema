import React from 'react';
import Card from './Card';

const RacingBikeList = (props) => {
    
    var racingBikesList = props.products
    .filter(function(product) {
        return product.category === "racing bike";
    })
    .map(product=> {
        return( 
          <div className="row">
          <div class="col-lg-4 col-md-6 mb-4" key={product.id}>   
             <Card 
             id={product.id}
             image_url={product.image_url}
             category={product.category}
             brand = {product.brand}
             price={product.price}
             gears={product.gears}
             rating={product.rating}
             description={product.description}
             addToCart={props.addToCart}
             />  
        </div>
        </div>
        );
     })
     ;
     
    return (
        <div>
       {racingBikesList}
       </div>
    )
}

export default RacingBikeList;