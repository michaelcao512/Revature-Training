import { useState } from "react";
// props:
// - comments: {id: number, text: string} array
export default function Comments(props) {
    const [comments, setComments] = useState(props.comments);
    return (
        <>
            <h4>Comments</h4>
                {comments.map((comment) => (
                    <p>{comment.text}</p>
                ))}
        </>
    );
}