import React, { Component } from 'react';
import UserContext from './UserContext';
import axios from 'axios';

// const UserContext = React.createContext();

export default class UserProvider extends Component {
    state = {
        username: '' || 'default_user'
    }

  componentDidMount = () => {
    axios.get('http://localhost:8090/api/users/') //retrieve 1st registered user username from DB
    .then(result => {
    var idx = result.data.length - 1 - result.data.slice().reverse().findIndex( (o) => o.firstName);//finds index of last username from data array 
    console.log("index:", idx )
    const username = result.data[idx].firstName
    this.setState({username});
    })
    .catch(function (error) {
      console.log(error);
    });
}
  render() {
    return (
      <div>
          {/* defines context state=username and passes to children */}
        <UserContext.Provider value={this.state.username}> 
            {this.props.children}
        </UserContext.Provider>
      </div>
    )
  }
}
