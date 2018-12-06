import React, {Component} from 'react'
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome';

class DeleteButton extends Component {
    constructor(props) {
        super(props);
        this.state = {
          rowData: [],
        };
    //    this.handleRowDelete = this.handleRowDelete.bind(this);
    }
    render(){
       
        return(
            
            <button type="button" 
                    onClick = {this.handleRowDelete}
                    class="btn btn-outline-danger btn-xs">
                    <i><FontAwesomeIcon icon="trash-alt"/></i>
            </button>
        )
    }
}

export default DeleteButton;