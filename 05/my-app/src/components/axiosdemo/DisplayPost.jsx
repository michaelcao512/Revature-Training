import { useEffect } from "react"

export default function DisplayPost(props) {
    useEffect(() => {
        
    }, [props.posts])
    return (
        props.posts.map((post) => (
            <div key={post.id}>
                <h4>{post.title}</h4>
                <p >{post.body}</p>
            </div>
        ))
    )

}