import React, {Component} from 'react';
import PropTypes from 'prop-types'
import QuantityButton from './QuantityButton'
import DeleteButton from './DeleteButton'

class ProductComponent extends Component {
    
    render(){
        return(
            <div className="row">
            <div className="col-12 col-sm-12 col-md-2 text-center">
                <img className="img-responsive" src={this.props.image_url} alt={this.props.product_name} width="120" height="80"></img>
            </div>
            <div className="col-12 text-sm-center col-sm-12 text-md-left col-md-6">
                <h4 className="product-name"><strong>{this.props.product_name}</strong></h4>
                <h4>
                    <small>{this.props.brand}</small>
                </h4>
            </div>
            <div className="col-12 col-sm-12 text-sm-center col-md-4 text-md-right row">
                <div className="col-3 col-sm-3 col-md-6 text-md-right" style={styleCol}>
                    <h6><strong>{this.props.price} EUR <span className="text-muted">x</span></strong></h6>
                </div>
                <div className="col-4 col-sm-4 col-md-4">
                    <QuantityButton/>
                </div>
                <div className="col-2 col-sm-2 col-md-2 text-right">
                    <DeleteButton/>
                </div>
            </div>
        </div>
       
      
        );
    }
}

ProductComponent.propTypes = {
    id:PropTypes.number.isRequired,
    image_url: PropTypes.string.isRequired,
    product_name: PropTypes.string.isRequired,
    brand: PropTypes.string.isRequired,
    price: PropTypes.number.isRequired,
}

const styleCol = {
    paddingTop: '5px',
  };

export default ProductComponent;