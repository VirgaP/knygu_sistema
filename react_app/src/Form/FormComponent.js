import React, {Component} from 'react';
import axios from 'axios';

class Form extends Component {
    constructor() {
        super();
        this.state = {
          products: []
        };
        this.handleSubmit = this.handleSubmit.bind(this);
      }
     
      handleSubmit(e) {
        e.preventDefault();
        const
        { products } = this.state,
        product_No = this.refs.product_No.value,
        image_url = this.refs.image_url.value,
        price = this.refs.price.value,
        category = this.refs.category.value,
        brand = this.refs.brand.value,
        description = this.refs.description.value,
        quantity = this.refs.quantity.value;
        this.setState({
          products: [...products, {
            product_No,
            image_url,
            price,
            category,
            brand,
            description,
            quantity,
          }]
        },
       
        () => {
          this.refs.product_No.value = '';
          this.refs.image_url.value = '';
          this.refs.price.value = '';
          this.refs.category.value = '';
          this.refs.brand.value = '';
          this.refs.description.value = '';
          this.refs.quantity.value = '';
        });
        this.serverRequest = axios
        .post('http://localhost:8090/api/products', {
          product_No : this.refs.product_No.value,
          image_url : this.refs.image_url.value,
          price : this.refs.price.value,
          category : this.refs.category.value,
          brand : this.refs.brand.value,
          description : this.refs.description.value,
          quantity : this.refs.quantity.value
        })
        .then(function(response) {
            console.log(response);
        }).catch(function (error) {
            console.log(error);
        })
      }
    
      render() {
        const { products } = this.state;
        console.log('produktai',this.state.products);
        return (   
          <div className="container">
            <h2>Add new product</h2>
            
            <form onSubmit={this.handleSubmit}>
              <div className="form-group">
                <input style={style} type="number" ref="product_No" placeholder="product number" className="form-control"  />
                <input style={style} type="text" ref="image_url" placeholder="image title" className="form-control" />
                <input style={style} type="number" min="0" step="0.01" ref="price" placeholder="price" className="form-control" />
                <input style={style} type="text" ref="category" placeholder="product category" className="form-control" />
                <input style={style} type="text" ref="brand" placeholder="title of the products brand" className="form-control"  />
                <input style={style} type="text" ref="description" placeholder="description"className="form-control" />
                <input style={style} type="number" ref="quantity" placeholder="quantity" className="form-control" />
              </div>
              <button className="btn btn-primary" type="submit">Save</button>
            </form>
            <h2>Entered products:</h2>
            <ul>
              {products.map((product) => 
               <li>{`Title: ${product.brand} Image: ${product.image_url} Price: ${product.price} Quantity: ${product.quantity}`}</li>
              )}
            </ul>
          </div>
        ) 
      }

}
const style = {
  margin:'0 0 20px 0'
}
export default Form;

//updater method
// this.setState(prevState => ({
//     array: [...prevState.array, newElement]
// }))


