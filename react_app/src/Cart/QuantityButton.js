import React, { Component } from 'react'

class QuantityButton extends Component {
    constructor(props) {
        super(props);
        this.state = {
            count: 0,
            show:true
        };
      }

    // handleIncrement = () => {
    //     this.setState({ count: this.state.count + 1 || 0})
        
    // }
    handleIncrement = () => {
        this.setState(({ count }) => ({
          count: count + 1
        }));
      };
    handleDecrement = () => {
        this.setState({ count: this.state.count - 1 })
    }

    render(){
        console.log(this.state.count)

        return(
        <div>
        <div className="quantity">{this.state.count}
        </div>
            <button className='btn btn-default plus btn-outline-secondary' onClick={this.handleIncrement}> + </button>
            <button className='btn btn-default minus btn-outline-secondary' onClick={this.handleDecrement.bind(this)}> - </button>
         </div>
        )
    }
}
export default QuantityButton;