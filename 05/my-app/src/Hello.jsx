import React from 'react';
export default function Hello(props) {
    return (

        <React.Fragment>
            <h1>Hello, world from Hello Component!</h1>
            <p>{props.message}</p>
        </React.Fragment>
    
    );
}