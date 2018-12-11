import React from 'react';
import Card from './Card';

const cardListComponent = (props) => {
    //perdaryti i kontaineri prideti axios get api/priducts/id 
    var CardList = props.products.map((product)=> {
        return(
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
