import { useState } from "react";

function Counter() {
    const [counter, setCounter] = useState(0);
    return (  
        <>
            <button data-testid="increment-button" onClick ={() => setCounter(counter + 1)}>Increment</button>
            <h3 data-testid="counter">{counter}</h3>
            <button data-testid="decrement-button" onClick={() => setCounter(counter - 1)}>Decrement</button>
        </>
    );
}

export default Counter;