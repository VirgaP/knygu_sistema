import React, {Component} from 'react';
import CardListComponent from './CardListComponent';
import AddToCartButton from './AddToCartButton';
import Sidebar from '../SideBar';
// import items from '../../Resources/products.json';
// import items from '../../../Resources/products.json'
import  newArray  from '../../../Form/FormComponent';


class ProductsListContainer extends Component {
  constructor(props) {
    super(props);
    this.state = {
        newArray:[]
    }
  }

componentDidMount(){  
   
    var myArray = [
        {
        id: 1,
        image_url: "http://placehold.it/700x400",
        price: 391,
        category: "city bike",
        brand: "Urbanbike",
        gears: 5,
        description: "lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum",
        size: "L",
        rating: 4,
        inStock: false
        },
        {
            id: 1,
            image_url: "http://placehold.it/700x400",
            price: 1300,
            category: "racing bike",
            brand: "Specialized",
            gears: 5,
            description: "lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum",
            size: "L",
            rating: 4,
            inStock: false
        }
      ]
    this.setState({products: myArray})
      
}
    addToCart() { 
        alert("item added to cart");
    }

 render(){
    if(!this.state.products){
        return <span>No products yet in cl container</span>
    }
        return(   
        <div className="container">
            {/* passing all products to cardcomponent, render under Products */}
            <CardListComponent products={this.state.products}>
            <AddToCartButton event={this.addToCart}/>
            </CardListComponent>   
        </div>
        )
    }
} 
export default ProductsListContainer;