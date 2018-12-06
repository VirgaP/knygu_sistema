import React, {Component} from 'react';
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome';

var Heading = () => {
    return(
        <div className="card-header bg-dark text-light cart-header">
            <i><FontAwesomeIcon icon="shopping-cart"/></i>
            Shopping cart
            <a href="" className="btn btn-outline-info btn-sm pull-right btn-continue">Continue shopping</a>
            <div class="clearfix"></div>
        </div>
        )
}
export default Heading;