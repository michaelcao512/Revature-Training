import { useState } from "react";
function ListAdd(props) {
    const { list, setList } = props;

    const [value, setValue] = useState("");
    
    const submitHandler = (e) => {
        e.preventDefault();
        setList((prevList => [...prevList, value]));
        setValue("");
    }
    return ( 
        <div>
            <form onSubmit={submitHandler}>
                <input type="text" value={value} onChange={(e) => setValue(e.target.value)} />
                <button>Add</button>
            </form>        </div>
     );
}

export default ListAdd;