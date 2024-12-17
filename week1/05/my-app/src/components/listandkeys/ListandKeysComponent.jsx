import CommentDisplayComponent from "./CommentDisplayComponent";
import { useState, useEffect} from "react";

export default function ListandKeysComponent() {
    const [comments, setComments] = useState([
        { id: 1, name: "Test", email: "test@gmail.com" },
        { id: 2, name: "Test2", email: "test2@gmail.com" },
        { id: 3, name: "Test3", email: "test3@gmail.com" },
    ]);
    // working with props to child component
    // you can also pass methods as props
    function handleDelete(id) {
        const newComments = comments.filter((comment) => comment.id !== id);
        setComments(newComments);
    }

    // useEffect
    //  use effect with no dependencies is called on every render
    //  use effect with empty array as dependencies is called only once
    //  use effect with dependencies is called when state of dependencies change

    const [name, setName] = useState("Test");
    useEffect(() => {
        console.log("use Effect called...");
    },[name]);


    return (
        <div>
            <h3>List and Keys Component</h3>
            <CommentDisplayComponent comments={comments} handleDelete={handleDelete}/>
         
            <button onClick={() => setName("Test2")}>Change Name</button>
        </div>
    );
}