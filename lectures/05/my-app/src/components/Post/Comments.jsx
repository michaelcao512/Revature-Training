// props:
// - comments: {id: number, text: string} array
export default function Comments(props) {
    return (
        <>
            <h4>Comments</h4>
                {props.comments.map((comment) => (
                    <p>{comment.text}</p>
                ))}
        </>
    );
}