import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import * as serviceWorker from './serviceWorker';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import { Switch, Redirect, Route } from 'react-router';
import { BrowserRouter, Link } from 'react-router-dom';
import NavbarContainer from './Layout/NavbarContainer';
import Nowhere from './Layout/Nowhere';
import ProductsList from './Layout/MainPage/Card/ProductsListContainer';
import CartPage from './Cart/CartPage';
import Form from './Form/FormComponent';
import HomePage from './HomePage';
import cardList from './Layout/MainPage/Card/CardListComponent';
import Card from './Layout/MainPage/Card/Card';
import CardContainer from './Layout/MainPage/Card/CardContainer';
import Register from './Layout/MainPage/Register';


ReactDOM.render((
    <BrowserRouter>
        <NavbarContainer>
            <Switch>
                <Route exact path='/' component={HomePage}/>
                <Route path="/products" component={ProductsList}/>
                <Route path="/cart/:username" render={(props) => <CartPage {...props} />}/> 
                <Route path="/admin" component={Form}/>
                {/* <Route path="/product/:productId" component={Card}/> */}
                <Route path="/register" component={Register}/>
                <Route path="/product/:product_No" render={(props) => <CardContainer {...props} />}/> 
                <Route path="*" component={Nowhere}/>   
            </Switch>
        </NavbarContainer>
    </BrowserRouter>
), document.getElementById('root'));
// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: http://bit.ly/CRA-PWA
serviceWorker.unregister();
