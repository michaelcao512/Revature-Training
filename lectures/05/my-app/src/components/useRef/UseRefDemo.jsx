import { useRef } from 'react';

//create a component with a button that gives an alert 
// after you click this many times
// using useRef

function UseRefDemo() {
    //create a component with a button that gives an alert
// after you click this many times
    // using useRef
    
    const count = useRef(0);

    const handleClick = () => {
        count.current += 1;
        if (count.current === 5) {
            alert("You clicked me 5 times!");
            count.current = 0;
        }
    }

    return ( 
        <div>
            <button onClick={handleClick}>Click me</button>
        </div>
     );
}

export default UseRefDemo;