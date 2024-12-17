import React, { useContext } from 'react';
import TextComponent from '../hoc/TextComponent';
import MyContext from '../Context/MyContext';
export default function Hello(props) {
    const theData = useContext(MyContext);
    return (
        <>
            <h3>Hello, world from Hello Component!</h3>
            <p>{props.message}</p>
            <hr />
            <TextComponent />

            <h3>Shared Data: {theData}</h3>
        </>
    
    );
}