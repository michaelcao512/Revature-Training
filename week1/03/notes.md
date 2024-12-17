DOM -- Document Object Model
    html tree of objects structures
    ![DOM tree](image.png)

    Document node at the top
    Root element (<html>)
    all other elements branched out (<head> <body> etc.)

    what does javascript DOM APi provides
        convenient methods to manipulate the structure and the content of the HTML document dynamically

        getting single element by id (demo)
            document.getElementById(idName)
    
        multiple elements should iterate over (demo 2)
            document.getElementsByTagName(tagName)
            document.getElementsByClassName(className)

        locating elements based on a query (query selector)
            document.querySelector()
            document.querySelectorALL()

        inserting element (demo 3)
            let newElement = document.createElement(elementName)
                .innerHTML("...")
                    set innerhtml accordingly such as "<p>new element</[]>"

            get the element of where to insert and append after it
                document.getElementById("id").append(newElement)

action -> event occurs -> event handler or event listener (demo5)   
    .addEventListener("click", onClickHandler);

    .removeEventListener


Bubbling
    when elements are nested, events are proprogated (demo 6)
    when you click the para, both the div click event and paragraph click event happen
    from innermost to outermost event propogation



Capturing
    outermost to innermost or event propogation
    by default capturing is set to false
    3rd parameter of eventlistener is boolean setting capturing
    .addEventListener("click", onClickHandler, true)    
        capturing enabled    



assignment
    create a to-do list application in javascript
        - add an item to the list
        - delete an item from the list
        - mark an item as complete
        - should be able to edit an item (optional)


Web Tech
    Request and Response (HTTP)
    1. client sends a request to a server
    2. server receives the request
    3. server processes request
    4. server returns a response to client
    5. cleint receive response and displays it

    status codes
        1xx - information
        2xx - success
        3xx - redirection
        4xx - client error
        5xx - server error

asynchronous programming
    waiting for a response
    using callbacks
    

Promise
    handles asynchronous programming

    states
        pending
        resolved
        rejected

    var Promise = new Promise( ... )
        .then( () => { dosomething when successful})
        .then( () => { dosomething when rejected})

        .catch( () => { optional error handling})

Making Asynchronous HTTP requests/response in JS
    1. AJAX
    2. Fetch API - returns Promise


async - async execution
await - wait for the result of the execution of the method
async and await wrap the promises, async and await results in a promise
    async function need await method