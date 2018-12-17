import React, { Component } from 'react';
// import logo from './logo.svg';
import './App.css';
import SideBar from './Layout/MainPage/SideBar';
import  {library} from '@fortawesome/fontawesome-svg-core';
import { faStar, faShoppingCart, faTrashAlt } from '@fortawesome/free-solid-svg-icons'
import Carousel from './Layout/MainPage/Carousel';
import CardListContainer from './Layout/MainPage/Card/FilteredCardListContaineir';
import UserContext from './UserContext'; 
import ProductsListContainer from './Layout/MainPage/Card/ProductsListContainer';
import axios from 'axios';
import UserProvider from './UserProvider';
import GetCartBtn from './Layout/MainPage/GetCartBtn';

library.add(faStar, faShoppingCart, faTrashAlt);


class HomePage extends Component {  
  constructor(props) {
    super(props)
    this.state = {
       filterInput: '',
       show: false, 
       username: ''
    }
    this.handleFilterInputChange = this.handleFilterInputChange.bind(this);
  }
  //pasing data from sibling sidebar to cardliscontainer via parent homepage
  handleFilterInputChange(filterInput){
    this.setState({
      filterInput: filterInput
    })
  }

  render() {
    
    return (
      <UserProvider>
      <div className="body">  
        <div className="container">
          <div className="row">
            <SideBar //inject props 
            onFilterInputChange={this.handleFilterInputChange}
            filterInput={this.state.filterInput}
            />
              <div className="col-lg-9">
              <Carousel/>
              <GetCartBtn/>
              </div>
              </div>
              <div className="container-fluid">
                <CardListContainer filterInput={this.state.filterInput} />
                <ProductsListContainer/>
              </div>
          </div>
      </div>
      </UserProvider>
    );
  }
}

export default HomePage;
