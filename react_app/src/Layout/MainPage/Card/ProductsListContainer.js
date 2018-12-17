import React, {Component} from 'react';
import CardListComponent from './CardListComponent';
import AddToCartButton from './AddToCartButton';
import Sidebar from '../SideBar';
// import items from '../../Resources/products.json';
// import items from '../../../Resources/products.json'
import  newArray  from '../../../Form/FormComponent';
import CardContainer from './CardContainer'
import axios from 'axios';
import UserContext from '../../../UserContext';
import UserProvider from '../../../UserProvider';


class ProductsListContainer extends Component {

// static contextType = UserContext; //or at the bootom

  constructor(props) {
    super(props);
    this.state = {
        products: [],
        
    }
  }

componentDidMount(){  
   
    axios.get('http://localhost:8090/api/products')
  .then(result => {
    const products = result.data;
    console.log('produktai su axios', products);
    this.setState({products})
  })
  .catch(function (error) {
    console.log(error);
  }); 

}

addToCart() { 
        alert("item added to cart");
    }

render(){
    if(!this.state.products){
        return <span>No products are available at the moment. Sorry ...</span>
    }
    return(
        <UserProvider>
        <div className="container">
        <UserContext.Consumer>
        {(context)=> (
            
            <div style={username}>You are now shopping as : {context}</div>
        )}
        </UserContext.Consumer>
        <h2 style={style}>List of products</h2>
            {/* passing all products to cardcomponent, render under Products */}
            <CardListComponent value={this.context} products={this.state.products}>
                    <AddToCartButton event={this.addToCart} />
            </CardListComponent> 
        </div>
        </UserProvider>
        )
    }
} 

const style ={
    marginTop:'30px',
    textAlign:'center'
}
const username = {
    border:'solid 1 px grey',
    backgroundColor: 'yellow',
}

// ProductsListContainer.contextType = UserContext
export default ProductsListContainer;