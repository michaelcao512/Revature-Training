import { useState, useEffect } from "react";
import DisplayPost from "./DisplayPost";
import CreatePost from "./CreatePost";
export default function FetchDemo() {
    const [posts, setPosts] = useState([]);
    // consts url = "https://jsonplaceholder.typicode.com/posts";
    const url = "http://localhost:8000/posts";
    useEffect(() => {
        fetch(url, {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
            },
        })
            .then((response) => response.json())
            .then((data) => setPosts(data));
    }, []);
    return (
        <>
            <h3>Fetch CRUD Demo</h3>
            <CreatePost />
            <DisplayPost posts={posts} />
        </>
    )
}