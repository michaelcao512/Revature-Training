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