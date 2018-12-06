import React, { Component } from 'react';
import PropTypes from 'prop-types';

export default class SideBar extends Component {
    constructor(props) {
        super(props)
        this.state = {
            isCityBikes: false,
            isRacingBikes: false,
            isAllProducts: true,
            isBikeParts: false
        }
        this.handleFilterInputChange = this.handleFilterInputChange.bind(this)
      }

      //get value of button as prop

      handleFilterInputChange(event){
        let input = this.props.onFilterInputChange(event.target.innerHTML)
        console.log('button inout:', input);
      }

      handleBikeParts(){
        this.setState({isBikeParts: true})
        console.log('city bikes after click ', this.state.isBikeParts);
        // let racingBikes = this.state.isRacingBikes;
        // return racingBikes;
      }
    
    render () {
    
        return (
            <div className="col-lg-3">
            <h1 className="my-4">Awesome Bike Shop</h1>
            <div className="list-group">
              <button style ={style} className="btn btn-primary" onClick={this.handleFilterInputChange}>Racing bike</button>
              <button style ={style} className="btn btn-primary" onClick={this.handleFilterInputChange}>city bike</button>
              <button style ={style} className="btn btn-primary" onClick={this.handleFilterInputChange}>bike parts</button>
              <button style ={style} className="btn btn-primary" onClick={this.handleFilterInputChange}>other</button>
            </div>
            
          </div>
        )
    }
}

const style = {
  margin: '3px',
}
SideBar.protoTypes = {
  handleRacingBikes : PropTypes.func,
  }