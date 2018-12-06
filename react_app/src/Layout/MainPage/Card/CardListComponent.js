import React from 'react';
import Card from './Card';

const cardListComponent = (props) => {
    
    var CardList = props.products.map((product)=> {
        return(
          <div class="col-lg-4 col-md-6 mb-4" key={product.id}>   
             <Card key={product.id}
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
        // </div>        
        );
        
     })
     ;
     
    return (
        <div className="row">
       {CardList}
       </div>
    )
}

export default cardListComponent;
