import { useState } from "react";
import ListShow from "./ListShow";
import ListAdd from "./ListAdd";
import ListCount from "./ListCount";
function ToDoList() {
    const [list, setList] = useState([]);

    return (
        <div>
            <h3>ToDoList</h3>
            <ListAdd list={list} setList={setList} />
            <ListShow list={list} />
            <ListCount list={list} />

    
        </div>
    )
}

export default ToDoList;