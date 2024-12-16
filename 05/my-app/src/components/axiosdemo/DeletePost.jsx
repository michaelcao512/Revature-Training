function DeletePost(props) {
    const url = "http://localhost:8000/posts";

    const handleDelete = () => {
        const deleteUrl = url + "/" + props.postId;
        fetch(deleteUrl, {
            method: "DELETE",
            headers: {
                "Content-Type": "application/json",
            },
        })
            .then((response) => response.json())
            .then((data) => console.log(data));
        
        props.setPosts(props.posts.filter((post) => post.id !== props.postId));
    };

    return ( 
        <div>
            <button onClick={handleDelete}>Delete</button> 
        </div>
     );
}

export default DeletePost;