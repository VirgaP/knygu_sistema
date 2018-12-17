import React from 'react';
import Card from './Card';
import UserContext from '../../../UserContext'

const cardListComponent = (props) => {
    //perdaryti i kontaineri prideti axios get api/priducts/id 

    var CardList = props.products.map((product)=> {
        return(
          <div className="col-lg-4 col-md-6 mb-4" key={product.product_No}>
         
             <Card 
             product_No={product.product_No}
             image_url={product.image_url}
             category={product.category}
             brand = {product.brand}
             price={product.price}
             rating={product.rating}
             description={product.description}
             addToCart={props.addToCart}
             />  
        </div>
        );
        
     })
     ;
    return (

        <UserContext.Consumer>
            {(context)=> (
            <React.Fragment>   
            <div className="row">
            {CardList}
            </div>
            </React.Fragment> 
            )}
        </UserContext.Consumer>
    )
}

// cardListComponent.contextType = UserContext
export default cardListComponent;
