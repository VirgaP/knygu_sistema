import React, {Component} from 'react';
import Heading from './Heading';
import CartFooter from './CartFooter';
import CartBody from './CartBody';
import UserContext from '../UserContext';
import UserProvider from '../UserProvider';
import axios from 'axios';


export default class CartPage extends Component {
    constructor(props) {
        super(props)
      
        this.state = {
            username: this.props.match.params.username,
        }
        console.log("propsai USERNAME:", this.state.username)
      }

    componentDidMount = () => {
    
        axios.get(`http://localhost:8090/api/cart/${this.state.username}`)
        .then(result => {
            const product = result
          this.setState({product});
          console.log("PRODUKTAI" , product)
          })
          .catch(function (error) {
            console.log(error);
          });

          
    }
    render(){
        return(
            <UserProvider>
                <UserContext.Consumer>
           {(context)=> (  
            <React.Fragment>  
            <div className="container">
                <div className="card shopping-cart">
                    <Heading/>
                    <CartBody context={context}/>
                    <CartFooter/>
                </div>
            </div>   
            </React.Fragment> 
                )}
            </UserContext.Consumer>
            </UserProvider>
        )
    }

}