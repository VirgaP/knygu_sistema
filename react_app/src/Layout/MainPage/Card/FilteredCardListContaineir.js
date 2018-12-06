import React, {Component} from 'react';
import CardListComponent from './CardListComponent';
import AddToCartButton from './AddToCartButton';
// import items from '../../Resources/products.json';
// import items from '../../../Resources/products.json'
import  newArray  from '../../../Form/FormComponent';


class FilteredCardListContainer extends Component {
  constructor(props) {
    super(props);
        // this.handleRacingBikes = this.handleRacingBikes.bind(this)
        // this.handleCityBikes = this.handleCityBikes.bind(this)
        // this.handleAllProducts = this.handleAllProducts.bind(this)
    this.state = {
        products: null,
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
        },
        {
            id: 1,
            image_url: "http://placehold.it/700x400",
            price: 30,
            category: "bike parts",
            brand: "Specialized",
            gears: 5,
            description: "lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum",
            size: "",
            rating: 4,
            inStock: true
        }
      ]


    // console.log('is cl container mount metodo', this.props.productsArray);
    // this.setState({products: myArray})
    this.setState({products: myArray})
   
      
}
    addToCart() { 
        alert("item added to cart");
    }

 render(){
    let filterInput = this.props.filterInput;
    const filterInputToLowerCase = filterInput.toLowerCase();
 

    if(!this.state.products){
        return <span>No products yet in cl container</span>
    }

        return(   
        <div className="container">
            {/* passing filteredaray to cardcomponent fro mapping rendered in homepage */}
            <CardListComponent products={
                this.state.products.filter(function(product){
                    return product.category === filterInputToLowerCase;
                })
            }>
            <AddToCartButton event={this.addToCart}/>
            </CardListComponent>   
        </div>
        
        
        )
    }
} 
  

export default FilteredCardListContainer;