import React,{Component} from 'react';

var DemonstruotiNavigacija = (props) => {
    var goHome = () => props.history.push("/");
    return (
        <div>
            At route: {props.location.pathname}
            <button onClick={goHome}>Go home</button>
            <pre>
                {JSON.stringify(props, null, 2)}
            </pre>
        </div>
    )
} 
export default DemonstruotiNavigacija;