import { useState, useEffect } from "react";
import DisplayPost from "./DisplayPost";
import CreatePost from "./CreatePost";
export default function FetchDemo() {
    // npx json-server --watch ./data/db.json --port 8000
    const [posts, setPosts] = useState([]);
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
            
            <CreatePost posts={posts} setPosts={setPosts} />
            <DisplayPost posts={posts} setPosts={setPosts} />
        </>
    )
}