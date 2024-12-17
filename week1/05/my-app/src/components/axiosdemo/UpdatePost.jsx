import { useState } from "react";

function UpdatePost(props) {
    const { posts, setPosts, postId } = props;

    const [updating, setUpdating] = useState(false);

    const post = posts.find((post) => post.id === postId);
    const [updates, setUpdates] = useState({ title: post.title, body: post.body })
        ;
    const url = "http://localhost:8000/posts";

    const handleUpdate = () => {
        setUpdating(true);
    };

    const handleSave = () => {
        const updateUrl = url + "/" + postId;

        fetch(updateUrl, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(updates),
        })
            .then((response) => response.json())
            .then((data) => console.log(data));
        
        setPosts(props.posts.map((post) => {
            if (post.id === postId) {
                return { ...post, ...updates };
            }
            return post;
        }));
        setUpdating(false);
    };
    return (
        <div>
            {!updating && <button onClick={handleUpdate}>Update</button>}
            {updating && (
                <div>
                    <input
                        type="text"
                        value={updates.title}
                        onChange={(e) => setUpdates({ ...updates, title: e.target.value })}
                    />
                    <input
                        type="text"
                        value={updates.body}
                        onChange={(e) => setUpdates({ ...updates, body: e.target.value })}
                    />
                    <button onClick={handleSave}>Save</button>
                </div>
            )}
        </div>
    );
}

export default UpdatePost;