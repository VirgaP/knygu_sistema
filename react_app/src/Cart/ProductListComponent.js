import React from 'react'
import ProductComponent from './ProductComponent';

const productListComponent = (props) => {
    var cartProductList = props.products.map(product => {
       return( 
         <div key={product.id}>
            <ProductComponent 
            id={product.id}
            // handleIncrement={product.handleIncrement}
            // handleDecrement={product.handleDecrement}
            image_url={product.image_url}
            product_name={product.product_name}
            price={product.price}
            brand={product.brand}
            />
   <hr></hr>
   </div>
       );
    });

    return (<div>{cartProductList}</div>);
}

export default productListComponent;