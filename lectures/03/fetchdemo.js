// Get - to get a resource
let fetchRes = fetch('https://jsonplaceholder.typicode.com/todos/1')

fetchRes.then( response => {
    console.log(response)
    response.json()
        .then( data => {
            console.log(data)
        }).catch( error => {
            console.log(error)
        })
})

// Post - to createa resource
let postRes = fetch('https://jsonplaceholder.typicode.com/posts', {
    method: 'POST',
    body: JSON.stringify({
        title: 'foo',
        body: 'bar',
        userId: 1
    }),
    headers: {
        'Content-type': 'application/json; charset=UTF-8'
    }
})

postRes.then( response => { 
    response.json()
        .then( data => {
            console.log(data)
        }).catch( error => {
            console.log(error)
        })
}
)