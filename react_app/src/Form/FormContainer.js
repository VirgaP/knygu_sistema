import React, {Component} from 'react';
import FormComponent from './FormComponent'

class FormContainer extends Component {

        constructor(props) {
          super(props)
          this.handleSelect = this.handleSelect.bind(this)
          // ...
          this.state = {
            optionGroup: {
              racing_bike: false,
              city_bike: true,
              bike_parts: false,
              other: false
            },
            // inputGroup: {
            //     id: "",
            //     brand: "",
            //     price: "",
            //     description: ""
            // }
          }
        }

    // getInitialState(){
    //     return (
    //         { product_id: '_'}
    //     );
    // }

    handleSelect(event) {
        let obj = Object.assign(this.state.optionGroup)
        obj[event.target.value] = event.target.checked
        this.setState({optionGroup: obj})
    }

    handleChange(event){
        this.setState(
            {id: event.target.value},
            {brand: event.target.value},
            {price: event.target.value},
            {description: event.target.value}
            );
    }

    handleSubmit(event) {
        return this.sendData()
      }
    render (){
        return(
          <FormComponent state={this.state.optionGroup}/>
        )
    }
}
export default FormContainer;