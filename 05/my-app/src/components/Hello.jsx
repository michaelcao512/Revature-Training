import React from 'react';
export default function Hello(props) {
    return (
        <React.Fragment>
            <h3>Hello, world from Hello Component!</h3>
            <p>{props.message}</p>
        </React.Fragment>
    
    );
}