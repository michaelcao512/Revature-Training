import { useState } from 'react';
import Comments from './Comments';

// props:
// - comments: {id: number, text: string} array
// - post: {id: number, content: string}
export default function Post(props) {
    const [content, setComments] = useState(props.post.content);
    return (
        <>
            <h1>Post</h1>
            <p>{content}</p>
            <Comments comments={props.comments} setComments={setComments}></Comments>
        </>
    );
}