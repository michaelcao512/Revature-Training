WHAT
WHY
HOW

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









WHAT
WHY
HOW

# Questions

## HTML

- what is HTML
  - hyper text mark up language is a structured way create webpages thorugh elements
  - DOM - Document Object Model is a tree like structure in memory that tells the browser how to render HTML webpage
    - format of HTML is root HTML with children of head (meta data) and body (content) tag
- what are tags

  - everything in HTML defined by elements defined by content enclosed by opening and closing tags that determine what purpose of content
  - tags are _nested_ within each other in parent child tree structure
    HTML -> DOM
    tag -> Element

- what are attributes
  - specific properties that give additional information about element using propery value pairs specified inside the tag
  - global attributes - ID, class, name, style
  - element specific attributes - type, placeholder, value, etc.
  - schema - published template that defines how these tags and attribute and determine whats right and go with specifics

## CSS

- how do we add in styling
  - use css to create styles for a web page
  - inline - in the element, internal - in the document in `<style>` under `<head>`, external - link to extenral css files
  - uses selectors to select who were applying the styling to and what styling of key value pairs
- what are some of the selectors
  - element selector - applies to specific element name
  - class selector (.) - applies to elements w/ attributes of same class name
  - id selector (#) - applies to a element w/ attributes with the same unique id
  - universal selector (\*) - everything
  - pseudo selector (:event) - based on specific events like hover
  - grouping selector (,) - multiple selectors
  - child (space)
- how do we styling
  - declaration of key value pairs

## JavaScript / TypeScript

What is it

- language that is mainly for web development and brings behavior allowing our webpage to be more dynamic
- DOM manipulation
- Why
  - behavior / event manipulation and more complex in HTML

what is Node.js

- allows javascript to be run outside of the web
- node takes interpreter out of the browser (v8) and allows us to interpret js from outside browser

important aspects

- webdevelopment and BEHAVIOR
- dyanmically and loosely typed language
- interpreted - goes line by line
  - as opposed to compiled where its compiled into byte code before running
- multi-pardigm - functional, oop, modular
- high level languages
  - abstracted away from hardware
  - as opposed to low level - deal closely with hardware (memory, etc.)

origin

- main very quickly in a week
- nothing to do with java - rebranded because java was popular

dynamic typing

- we dont need to explicitly define the type of the vaiable during declaration
- variable type could change over the runtime
- type coercion
  - constantly changing type implicitly

Scopes - where a variable exists and how long it persists

- global scope - declared outside of the function and can be used anywhere
- function scope - declared inside a function and only exists in execution of the function
- block scope - declared only inside a particular block {}

Closures

- lexical - access to variables outside of its defined scope
- closures can remember a variable outside of its scope even after the outer scope finishes executing (lexical binding keeps a copy of the variable)
- example usage: react props - components(props) with lexical binding to variables outside of its component

var vs let vs const

- var hoists variable decalration to the top - leaking out of scope - shouldn't be used modern days
- let variable declaration is defined specifically in its scope
- let and const (not reassignable) are blocked scope

testing equality

- === -> strict matches type and value 1==="1" -> false
- == -> just needs to match value 1 == "1" -> true

creating object
- JS Object notation
  - { } with key value pairs of property: "propertyValue"
  ```javascript
  let obj = {
    propety1: "property1Value",
    propety2: "property2Value"
  }
  ```
-  can nest objects inside object as well 

OOP
- classes syntax
  - constructor keyword
  - get and set keywords 
```javascript
class className() {

  constructor(name) {
    this.name = name;
  }
  get name(){
    return this.name;
  }
}
```

callback function
- function that is passed in as a parameter to another function with intention of execution later

types
- string, number, boolean, null, undefined, NaN, object, 
- typeof operator used to find type of something
- typeof function = object
- typeof array = object
  - js array is wrapper abstraction over array
  - arrays are contiguous in memory
  - dynamic (can change size)
- Truthy and Falsy
  - general representation for different types of true or false
  - False -> 0, "", null, false, ...

enhanced forloops loops
- for (const x of arr)
  - iterates over the value/object
- for (const x in arr)
  - iterates over the index

DOM manipulation
- js API to manipulate the DOM directly
- document.ge

typescript
- strongly typed javascript
- variable typed using :type after the variable declaration
- interfaces - OOP and abstraction

# React
- js library that uses component based architecture
- component - reusuable units of codes that encapsulate data and behavior
  - modular components that work together with single responisbility
- creates a single page application
  - dynamically re-renders pre-laoded content instead of requesting the server for a new page (faking navigation)
  - not modifying the dom directly - virtual dom synchronizes with actual dom only when necessary -> reconciliation
  - react router dom

- drawbacks of single page application
  - everything most be initally loaded causing longer intial load time because of prerendering everything (eager loading)
  - complexity -> 
  - search engine optimization is impacted negatively (struggle to find url because were faking it) -> solved problem now 

- creating new react app
  - dont use create react app anymore (deprecated)
  - yarn create vite


- creating a component
  - class-based component (less used)
  - functional-based component
    - components start with capital letter
    - `function ComponentName(props) { return ( <> </>)}`

- props
  - properties that are passed one way from parent to child components

- lifting state
  - instead of declaring the state in the child component you would declare them in the parent component and pass the state and setState down through the child component as props allowing you to manipulate the state from the child component and thus sharing state through siblings

- context
  - can share state globally
  - `const MyContext = createContext(defaultValues)`
  - ` <MyContext.Provider value={contextValues}> </MyContext.Provider>`
  - `const value = useContext(MyContext)`

- routing
  - create route navigation between components of your webpages
  - allows for SPA to simulate navigation
  - `<BrowserRouter> <Routes> <Route path="/" element={<HomePage />} />`
  - `<Link to="/"> Home </Link>`