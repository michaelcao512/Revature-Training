import DeletePost from "./DeletePost";
import UpdatePost from "./UpdatePost";

export default function DisplayPost(props) {

    return (
        <div>
            {props.posts.map((post) => (
                <li key={post.id}>
                    <h4>{post.title}</h4>
                    <p >{post.body}</p>

                    <DeletePost postId={post.id} setPosts={props.setPosts} posts={props.posts}></DeletePost>
                    <UpdatePost postId={post.id} setPosts={props.setPosts} posts={props.posts}></UpdatePost>
                </li>
            ))
            }
        </div>

    );

}