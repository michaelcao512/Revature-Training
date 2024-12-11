DOM -- Document Object Model
    html tree of objects structures
    ![DOM tree](image.png)

    Document node at the top
    Root element (<html>)
    all other elements branched out (<head> <body> etc.)

    what does javascript DOM APi provides
        convenient methods to manipulate the structure and the content of the HTML document dynamically

        getting single element by id
            document.getElementById(idName)
    
        multiple elements should iterate over
            document.getElementsByTagName(tagName)
            document.getElementsByClassName(className)

        locating elements based on a query
            document.querySelector()
            document.querySelectorALL()