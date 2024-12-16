export default function CreatePost() {
    const url = "http://localhost:8000/posts";

    const handleSubmit = (event) => {
        event.preventDefault();
        const title = event.target.title.value;
        const body = event.target.body.value;
        const post = { title: title, body: body };
        fetch(url, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(post),
        })
            .then((response) => response.json())
            .then((data) => console.log(data));
    };

    return (
        <>
            <form>
                <input type="text" name="title" placeholder="Title" />
                <input type="text" name="body" placeholder="Body" />
                <button type="submit">Create</button>
            </form>

        </>
    )   
}
