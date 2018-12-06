import React, {Component} from 'react';

export default class CartFooter extends Component {
    
    render(){
        return(
            <div className="card-footer cart-footer">
            <div className="coupon col-md-5 col-sm-5 no-padding-left pull-left">
                <div className="row">
                    <div className="col-6">
                        <input type="text" className="form-control" placeholder="cupone code"></input>
                    </div>
                    <div className="col-6">
                        <input type="submit" className="btn btn-default" value="Use cupone"></input>
                    </div>
                </div>
            </div>
            <div className="pull-right checkout" style={style1}>
                <a href="" className="btn btn-success">Checkout</a>
                <div className="pull-right" style={style2}>
                    Total price: <b>50.00€</b>
                </div>
            </div>
        </div>
        )
    }
}

const style1 = {
    margin: '10px',
  };

const style2 = {
    margin: '5px',
  };