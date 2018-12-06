import React, {Component} from 'react';

var Nowhere = (props) => {
    var goApp = () => props.history.push("/");
    return (
    <div class="container" style ={style}>
    <div class="row">
        <div class="col-md-12">
            <div class="error-template">
                <h1>
                    Oops!</h1>
                <h2>
                    404 Not Found</h2>
                <div class="error-details">
                    Sorry, an error has occured, Requested page not found!
                </div>
                <div class="error-actions">
                <button className="btn btn-primary" onClick={goApp}>Go home</button>
                </div>
            </div>
        </div>
    </div>
</div>
    )
    
}
const style = {
    height:"500px"
}
export default Nowhere;