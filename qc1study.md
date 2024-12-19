WHAT
HOW
WHY

# HTML

### What is HTML

- hypertext markup languages structured way create webpages thorugh elements
- elements hold meaning defined through `<opening tag>, content, </closing tag>`
  - many tags examples: p, h1
- elements can also have _attributes_ which define properties for the element as a key:value pair
  - example would class attribute which is used to define a class name from styling and class selectors
- there exists self closing tags such as <br/>

### What is DOM

- doocument object model is HTML representation in memory and allows us to manipulate HTML elements through its API
- it is a tree like structure with html as the root tag and branching off into usually the <head> element which would contain meta data for the project andthe <body> element which would contain actual content

# CSS

### What is CSS

- Cascading Style sheets is the way you style elements in html
- 3 ways you can style an element

  - inline: using style attribute within the element; this is preferred for styling a single element

  - selector { declaration }
    - internal css: using styling within the same document inside the <style> tag within the head; ideal for styling multiple elements of similar styles
    - external css: <link> tag within the head to link to an external style sheet using href attribute to specify the file; ideal for styling the same elements of a similar styling thorugh multiple documents or having a paritcular theme

### Selectors

    - how you pick what you want to style in an internal / external css
    - elements selector directly pick elements
    - class selector using . to select elements was the attribute class of the same name (better for multiple elements)
    - id selector using # to select a specfic element with a unique id
    - grouping multiple selectors using commas
    - parent child selector using space
    - many more...

### box model

    - every elements encapsulated by the box model that allows them to allign
    - Content: inner most layer with content
    - Padding: space between content and border
    - Border: border around content
    - Margin: space between border and next element

# Javascript

### What is JavaScript

- Dynamic and weakly typed language used mainly to implement dynamic features on webpages
- variables are dynamic and weakly typed: data type can change over runtime and dont require typing
- javascript can be run outside of the browser environment using Node.js with a package manager such as npm

### Event Propagation

- bubbling: events propagated inner to outer (enabled by default)
- capturing: events propagated outer to inner

### Asynchronous Programming

- execution of code can run simultaneously and isn't dependent on another
- Promise: method that will produce a result in some time
  - "Pending": method processing
  - "Fufiled": successful
  - "rejected": failure

```javascript
let promise = new Promise(function(resolve, reject)) {
    // logic resulting in successful
    resolve(...);

    // logic resulitng in error
    reject(...);
}
```

- consuming a promise using then(handleSuccess, handleError)

```javascript
promise.then(
    function(result) { /* handle success result */}
    function(error) { /* handle error result */}
);
```

- can use async and await to wrap promises
  - async function: creates function that returns a promise
  - await keywork inside async function used to make program wait until execution of function finishes before continuing
  ```javascript
  async function fetchData() {
    try {
      const response = await fetch(url);
      const data = await response.json();
    } catch (error) {}
  }
  ```

# TypeScript

- javascript extension with added ruling
- static/strongly typed
  - annotated with :type
    `let x: number = 5;`
  - implicitly type inference auto assigns type
- typescript compiles ts into js using tsc
- interface support as well (none in js)

### why use?

- accustomed to strongly typed languages (java, etc.)
- OOP
- type checking to ensure correctly working large databases

# React

- library to create front-end UI and has many importable libraries

### Component based architecture

- unit of reusable code encompassing rendering and logic
- single reponsiblity principle: each componany has singular responsibility
- class-based (outdated) and functional-based components
  - class extends React.Component and returns render() and uses lifecycle methods to manage state
  - function returns html and hooks for state management
- JSX - JavaScript XML: syntax extension to produce react elmeents which allows JS with HTML
  - babel compiles JSX into JS

### Virtual DOM

- reconiliation: virtual DOM (virtual lightweight copy DOM) synchornizes the actual DOM when necessary (state changes)
- improving performance greatly (less overhead calls to server)

### Navigation

- react swaps preloaded content onto single HTML page to give illusion of navigation
- react dom router creates navigation between different views
- browserrouter, routes, route
- cons: everything must be loaded first and doesn't perform well on SEO

### props
- properties passed as paramters from parent to child component and can be accessed thourgh destructuring the prop

### hooks
- functions to add behavior and start with use
- useState() 
- useEffect()


