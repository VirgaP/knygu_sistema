import React, {Component} from 'react';

const productsArray = [
    { 
        title: 'specialized',
        image: 'http://placehold.it/700x400',
        price: 1000,
        quantity: 3,
        description: 'lorem pisum'
      },
      {
        title: 'SuperAwesomeBike',
        image: 'http://placehold.it/700x400',
        price: 5000,
        quantity: 1,
        description: 'lorem pisum'
      }
    ];
   
class Form extends Component {
    
  
    constructor() {
        super();
        this.state = {
          products: productsArray
        };
        this.handleSubmit = this.handleSubmit.bind(this);
      }
    
      handleSubmit(e) {
        e.preventDefault();
        const
        { products } = this.state,
        id = this.refs.id.value,
        title = this.refs.title.value,
        image = this.refs.imageUrl.value,
        price = this.refs.price.value,
        quantity = this.refs.quantity.value,
        description = this.refs.description.value;
        this.setState({
          products: [...products, {
            id,
            title,
            image,
            price,
            quantity,
            description
          }]
        }, () => {
          this.refs.id.value = '';
          this.refs.title.value = '';
          this.refs.image.value = '';
          this.refs.price.value = '';
          this.refs.quantity.value = '';
          this.refs.description.value = '';
        });
      }
    
      render() {
        const { products } = this.state;
        console.log('produktai',this.state.products);
        return (   
          <div className="container">
            <h2>Add new product</h2>
            
            <form onSubmit={this.handleSubmit}>
              <div className="form-group">
                <input style={style} type="number" ref="id" placeholder="id" className="form-control"  />
                <input style={style} type="text" ref="title" placeholder="title" className="form-control"  />
                <input style={style} type="text" defaultValue={'http://placehold.it/700x400'} ref="image" placeholder="image url" className="form-control" />
                <input style={style} type="number" ref="price" placeholder="price" className="form-control" />
                <input style={style} type="number" ref="quantity" placeholder="quantity" className="form-control" />
                <input style={style} type="text" ref="description" placeholder="description"className="form-control" />
              </div>
              <button className="btn btn-primary" type="submit">Save</button>
            </form>
            <h2>Exsiting products:</h2>
            <ul>
              {products.map((product) => 
               <li>{`Title: ${product.title} Image: ${product.imageUrl} Price: ${product.price} Quantity: ${product.quantity}`}</li>
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


