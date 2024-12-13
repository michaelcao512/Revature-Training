import { useState } from 'react';
import Comments from './Comments';

export default function Post(props) {
    const [content, setComments] = useState(props.post.content);
    return (
        <>
            <h1>Post</h1>
            <p>{content}</p>
            <Comments comments={props.comments}></Comments>
        </>
    );
}