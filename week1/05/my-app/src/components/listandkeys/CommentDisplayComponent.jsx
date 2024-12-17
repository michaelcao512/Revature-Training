
export default function CommentDisplayComponent(props) {
    // with lists each item needs a unique key

    // comments from parent is passed to this component
    //  through the props.comments

    return (
        <>
            <ul>
                {props.comments.map((comment) => (
                    <li key={comment.id}>
                        <h5>{comment.name}</h5>
                        <p>{comment.email}</p>
                        <button onClick={() => props.handleDelete(comment.id)}>Delete</button>
                    </li>
                ))}
            </ul>
        </>
    );
}