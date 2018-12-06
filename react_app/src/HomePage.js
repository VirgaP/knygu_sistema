import React, { Component } from 'react';
// import logo from './logo.svg';
import './App.css';
import Footer from './Layout/Footer';
import SideBar from './Layout/MainPage/SideBar';
import  {library} from '@fortawesome/fontawesome-svg-core';
import { faStar, faShoppingCart, faTrashAlt } from '@fortawesome/free-solid-svg-icons'
import Carousel from './Layout/MainPage/Carousel';
import CardListContainer from './Layout/MainPage/Card/FilteredCardListContaineir';
 

library.add(faStar, faShoppingCart, faTrashAlt);


class HomePage extends Component {
  constructor(props) {
    super(props)
    this.state = {
       filterInput: ''
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
      <div className="body">  
        <div className="container">
          <div className="row">
            <SideBar //inject props 
            onFilterInputChange={this.handleFilterInputChange}
            filterInput={this.state.filterInput}
            />
              <div className="col-lg-9">
              <Carousel/>
              </div>
          </div>
            <div className="container-fluid">
              <CardListContainer 
              filterInput={this.state.filterInput} />
            </div>
          </div>
      </div>
    
    );
  }
}

export default HomePage;
