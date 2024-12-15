# HTML

### Basic Layout

```html
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Welcome Title</title>
  </head>
  <body>
    <h1>Hello World</h1>
  </body>
</html>
```

### Tags

```html
<h1>Heading 1</h1>
<h2>Heading 2</h2>
<h3>Heading 3</h3>

<p>Paragraph</p>

<!-- line break -->
<br />

<!-- ordered list and unordered list-->
<!--  attributes: type, start-->
<ol type="i">
  <li>item 1</li>
  <li>item 2</li>
  <li>item 3</li>
</ol>
<ul type="circle">
  <li>item 1</li>
  <li>item 2</li>
  <li>item 3</li>
</ul>

<!-- table -->
<!-- colspan/rowspan -> determines how many spaces a box takes -->
<table border="1">
  <th colspan="3">Grade Book</th>
  <tr>
    <th>Name</th>
    <th>Exam</th>
    <th>Grade</th>
  </tr>

  <tr>
    <td rowspan="2">Michael</td>
    <td>Midterm</td>
    <td>100</td>
  </tr>
  <tr>
    <td>Final</td>
    <td>100</td>
  </tr>

  <tr>
    <td rowspan="2">John</td>
    <td>Midterm</td>
    <td>90</td>
  </tr>
  <tr>
    <td>Final</td>
    <td>95</td>
  </tr>
</table>

<!-- forms -->
<!-- attributes:
    action - specifies endpoint where data of the form is submitted 
    method - declares type (post) -->
<form>
  <!-- id attribute - identifier for an inputs -->
  <!-- name attribute - specify name for an element in a form-->

  <label for="fname">First Name:</label>
  <input
    type="text"
    id="fname"
    name="fname"
    placeholder="Enter Your First Name"
    required
    minlength="5"
  />
  <br />

  <label for="gender">Choose Your Gender</label>
  <input type="radio" name="gender" value="female" />Female
  <input type="radio" name="gender" value="male" />Male
  <br />
  <!-- other input types: text, password, number, radio, checkbox, submit -->

  <label for="courses">Courses</label>
  <select name="courses" multiple>
    <option value="datastructures">Data Structures</option>
    <option value="databases">Databases</option>
  </select>
  <br />

  <label>Some Comments</label>
  <textarea row="5" cols="30"></textarea>
  <br />

  <input type="submit" value="Submit" />
</form>
```

# CSS - Cascading Styling Sheets

### HTML - Elements (Tags)

### CSS - Style the Elements

```css
property: value;
color: red;

selector {
  property: value;
}

h2 {
  color: red;
}
```

### Types of CSS

- **Inline CSS** - styling for a particular element, inside style attribute
  ```html
  <h1 style="color:blue;">This is a heading</h1>
  ```
- **Internal CSS** - styling for a particular document, inside the `<style>` tag within the `<head>`
  ```html
  <style>
    h1 {
      color: blue;
    }
  </style>
  ```
- **External CSS** - link in a separate css file with .css extension
  ```html
  <link rel="stylesheet" type="text/css" href="styles.css" />
  ```

### Developer Tools

- **Inspect Elements** - allows us to see the elements and the CSS applied to them

### Box Model

Every element is represented as a box:

- **Content** - innermost
- **Padding** - space between content and border
- **Border** - border around the content
- **Margin** - space between the border and the next element

### CSS Selectors

Used to select the context you want to style.

### Types of Selectors

- **Universal Selector (\*)** - selects all elements
- **Element Selector** - selects all elements of a particular type
- **ID Selector (#)** - selects an element with a specific id
- **Class Selector (.)** - selects all elements with a specific class
- **Grouping Selectors (,)** - multiple selectors separated by commas
- **Attribute Selector ([])** - selects elements with a specific attribute
- **Descendent/Child Selector (space)** - selects an element that is a child of another element
- **Pseudo Selector (:)** - selects elements based on a certain state such as hover
- **Sibling (~)** - select elements on the same hierarchy level
- **Adjacent Sibling (+)** - select elements directly after another element on the same hierarchy level

### Responsive Web Design

- **Layout**
  - **Flex** - 1D layout
  - **Grid** - 2D layout with rows and columns
- **Media Queries**
  ```css
  @media screen and (max-width: 1000px) {
    /* styles */
  }
  ```

### CSS Variables

- --variableName = value
- var(--variableName)
  ```css
  --blue=#10ff0e
  color: var(--blue)
  ```

# JavaScript

JavaScript is a programming language for the web. It is an interpreted and loosely typed language.

```html
<script>
  ...
</script>
```

Using an external script, create a .js file:

```html
<script src="script.js"></script>
```

### JavaScript Data Types

- **var** can hold many data types: numbers, strings, objects, boolean, undefined, null, and more
- **var** evaluates left to right and when adding a string to a number it will convert to a string
- **var** is dynamic and its type can change and hold different types

### var vs let vs const

- **var**: function-scoped, can be re-declared and updated, hoisted to the top of its scope.
- **let**: block-scoped, cannot be re-declared but can be updated, not hoisted.
- **const**: block-scoped, cannot be re-declared or updated, not hoisted.

### Objects

- Written with curly braces
- Properties are written as name:value pairs separated by commas

- JS Object
  ```javascript
  person = { firstName: "John", lastName: "Doe" };
  ```
- JSON String
  ```
  { "firstName": "John", "lastName": "Doe" }
  ```

### Conversion

- JSON -> JS Object: `JSON.parse()`
- JS Object -> JSON: `JSON.stringify()`

### typeof

Operator to find the type of a variable.

### Variable Scope

- **Global Scope** - accessed everywhere
- **Local Scope**

  - **Function Scope** - defined within a function
  - **Block Scope** - defined by `let`/`const` keywords inside `{}` and only exists within the corresponding block
  - **Lexical Scope** - defined outside a function can be accessed inside another function defined after variable declaration

    ```javascript
    function parent(){
        let x = 5;

        function child(){
            let  y = 1;
            console.log(x);
            console.log(y);

            <!-- inner child function has access to x -->
        }
    }
    ```

### Hoisting

- Variables and function declarations are moved to the top of their scope before execution
- Use `use strict` to enforce no hoisting

### Type Coercion

- **Implicit** - automatically; e.g., `string + number = string; 123 + ""`
- **Explicit** - e.g., `String(123)`

### == vs ===

- `===` : strict equality - checks the type as well
- `==` : equality
- `=` is assignment (no equality check)

```javascript
5 === "5"; // false
5 == "5"; // true
```

### Falsy Values vs Truthy Values

- **Falsy Values**: `false`, `""`, `undefined`, `null`, `NaN` (not a number), `0`
- **Truthy Values**: anything else that has value

### Functions

```javascript
function name(parameter1, ...) {
    // function body
}
```

- Functions can be assigned and utilized

```javascript
var add = function sum(val1, val2) {
  return val1 + val2;
};
add(1, 2);
```

### Anonymous Function

Defines a function without a name and must be assigned to a variable.

```javascript
var sayHello = function (firstName) {
  alert("Hello " + firstName);
};

var sayHello2 = (lastName) => {
  alert("Hello " + lastName);
};
sayHello("Michael");
sayHello2("Cao");
```

### Callback Function

Passing a function as an argument (higher-order functions).

```javascript
function name(parameter1, ..., callback) {
    // ...
    callback();
}
```

### Closures

- A function that remembers and accesses the variables and arguments of its outer function even after the function returns.
- the inner function has access to its parents function (lexical scope)
- even after the outer scope finishes executing and no logner has access to its variable

```javascript
function outer(x) {
  return function inner(y) {
    x++; // x incremented and persists
    y++; // y incremented
    let result = x + y;
    console.log(result);
  };
}

const result = outer(1);
//  result is a function (inner) with closures over x (remembers x = 1)

result(3);
//  we call the function and x and y are both incremented (x=2, y=4)
//  so results should log 6

result(3);
//  we call the function again and it remembers x = 2 and we increment once more to 3, y is passed in as paramter and is incremented from 3 to 4
//  so results should log 7
```

### Arrow Function

```javascript
const func = (arg1, ...) => expression;
const hello = () => "Hello World";
hello();
```

### Backtick (``)

Allows dynamic code to include variables inside of strings.

```javascript
let name = "Michael";
alert(`Hello ${name}`);
```

### DOM - Document Object Model

HTML tree of objects structures.
![DOM tree](03/image.png)

- **Document node** at the top
- **Root element** (`<html>`)
- All other elements branched out (`<head>`, `<body>`, etc.)

### JavaScript DOM API

Provides convenient methods to manipulate the structure and the content of the HTML document dynamically.

- **Getting single element by id**

  ```javascript
  document.getElementById(idName);
  ```

- **Multiple elements (should iterate over)**

  ```javascript
  document.getElementsByTagName(tagName);
  document.getElementsByClassName(className);
  ```

- **Locating elements based on a query (query selector)**

  ```javascript
  document.querySelector();
  document.querySelectorAll();
  ```

- **Inserting element**
  ```javascript
  let newElement = document.createElement(elementName);
  newElement.innerHTML = "...";
  document.getElementById("id").append(newElement);
  ```

### Event Handling

- **Action -> Event occurs -> Event handler or event listener**
  ```javascript
  .addEventListener("click", onClickHandler);
  .removeEventListener();
  ```

### Event Propagation

- when elements are nested with events that need to be handle, the events will be propagated
- **Bubbling**: from innermost to outermost event propagation
  - by default, bubbling is true
- **Capturing**: from outermost to innermost event propagation
  - By default, capturing is set to false
  - 3rd parameter of `addEventListener` is a boolean setting capturing
  ```javascript
  .addEventListener("click", onClickHandler, true); // capturing enabled
  ```

### Web Technologies

### Request and Response (HTTP)

1. Client sends a request to a server
2. Server receives the request
3. Server processes the request
4. Server returns a response to the client
5. Client receives the response and displays it

### Status Codes

- **1xx** - Information
- **2xx** - Success
- **3xx** - Redirection
- **4xx** - Client error
- **5xx** - Server error

### Asynchronous Programming

Waiting for a response using callbacks.

### Promise

Handles asynchronous programming.

- **States**: pending, resolved, rejected
  ```javascript
  var promise = new Promise((resolve, reject) => { ... });
  promise.then(() => { /* do something when successful */ })
         .catch(() => { /* optional error handling */ });
  ```

### Making Asynchronous HTTP Requests/Responses in JS

1. **AJAX**
2. **Fetch API** - returns a Promise

### async and await

- `async` - async execution
- `await` - wait for the result of the execution of the method
- `async` and `await` wrap the promises, resulting in a promise
  ```javascript
  async function example() {
    let result = await someAsyncFunction();
  }
  ```

### Node.js

Runtime environment that allows us to execute JavaScript outside of the browser environment.

### npm

Node package manager.

# TypeScript

### Dynamic vs Static / Strongly Typed

- **JavaScript** is dynamic type

  ```javascript
  var x;
  x = "string";
  x = 123;
  ```

- **TypeScript** is static / strongly typed
  ```typescript
  let x: number;
  x = 123;
  ```

### Writing in TypeScript

- Write in TypeScript in the `.ts` file
- Compile the TypeScript file into JavaScript using:
  ```bash
  tsc ./filename.ts
  ```
- Run the JavaScript file:
  ```bash
  node ./filename.js
  ```

### Why Use TypeScript

- Object-oriented programming language (JavaScript is prototype-based)
- Useful for large codebases
- Teams accustomed to statically-typed languages

### TypeScript Types

- **Primitive**: string, number, boolean
- **Special**: any (disables type checking), unknown, never (return type of error), undefined, null, union

### Type Inference

Automatically assigns type when you assign to a variable.

### TypeScript Annotations

- `:type` after the variable/function/object/etc. to identify the type

  ```typescript
  let name: string = "John";
  let age: number = 25;
  let active: boolean = true;

  function greeting(name: string): string {
    return "hello " + name;
  }

  let employee: {
    firstname: string;
    lastname: string;
  };

  let scores: (string | number)[]; // array of type string OR number
  ```

### TypeScript Tuple

- Tuple with optional elements
  ```typescript
  let skill: [string, number] = ["Programming", 5];
  let bgColor: [number, number, number, number?];
  ```

### Enums

Group of named constant values.

```typescript
enum Month {
  Jan,
  Feb,
  // ...
}
```

### Union Type

Combining multiple types into one using `|`

```typescript
let result: number | string; // result can be either number or string
```

### Type Aliases

Allows creation of a new name for a type (variable for a type).

```typescript
type alphanumeric = string | number;
let input: alphanumeric;
```

### Control Structures

- if-else, switch, for loop, while loop, do-while

### Functions

- `void` = no return type

  ```typescript
  function name(parameter: type, ...): returnType {
      // do something...
  }

  (parameter: type, ...) => returnType {
      // do something...
  }


  // Optional parameters (param?)
  function example(param1: string, param2?: number) {
      // ...
  }

  // Default parameter (param = value)
  function example(param1: string, param2: number = 10) {
      // ...
  }

  // Rest parameter (...)
  /*
    accept zero or more arguments of a specific type
            rules
                1) only 1 rest parameter
                2) appears last
                3) type of rest parameter is an array
  */
  function getTotal(...numbers: number[]): number {
      // sum numbers
  }
  getTotal(1, 2, 3); // returns 6
  ```

### Classes

- Can have properties and variables with access modifiers (protected, public, private, etc.)
- `readonly` to make a property immutable

  ```typescript
  class Example {
    readonly prop: string;

    constructor(prop: string) {
      this.prop = prop;
    }
  }
  ```

- Getters and setters

  ```typescript
  class Person {
    private _age: number;

    public set age(theAge: number) {
      if (theAge < 0) {
        throw new Error("Age cannot be negative");
      }
      this._age = theAge;
    }

    public get age(): number {
      return this._age;
    }
  }

  let p = new Person();
  p.age = 10; // calls the setter for age method and validates accordingly
  console.log(p.age); // calls getter
  ```

- Inheritance

  - extends
  - constructor(params)
  - super(...) -> calls parent constructor

  ```typescript
  class Child extends Parent {
      constructor(params...) {
          super(params);
      }
  }
  ```

- Method overriding

- Static properties or methods

  - shared between all instances of the class

  ```typescript
  class Example {
    static staticProp: string = "static value";
  }
  ```

- Abstract class

  - class with common behavior between derived classes

  ```typescript
  abstract class AbstractClass {
    abstract method(): void;
  }
  ```

- Interfaces

  - creates contracts that other classes can implement

  ```typescript
  interface ExampleInterface {
    prop: string;
    method(): void;
  }

  class ExampleClass implements ExampleInterface {
    prop: string;
    method() {
      // implementation
    }
  }
  ```

### Advanced Types

- **Intersection Type** `&`

  - combining multiple existing types

  ```typescript
  type TypeAB = TypeA & TypeB;
  ```

- **Type Guards**

  - typeof
    - typeof "hello" -> string
  - instanceof
    - type A = B | C
    - B instanceof A -> ture
  - in

    - checks if property exists in object type

  - User-defined type guards

  ```typescript
  function isCustomer(partner: any): partner is Customer {
    return partner instanceof Customer;
  }
  ```

- **Typecasting**

  ```typescript
  let a: TypeA;

  let b = <TypeB>a;
  // or
  let b = a as TypeB;
  ```

### Generics

Provide compile-time safety.

```typescript
function identity<T>(arg: T): T {
  return arg;
}
```

### Imports

- With `{}` and without `{}`:
  - Without `{}` when importing a package that is exported as a default

### Decorators

Used to add special behaviors to a class or members of a class.

```java
@RestController
class ExampleClass {
  // ...
}
```

### React

- JavaScript library (not framework) to create front-end UI.
- Used with other modules such as React Router and Redux.

- **Component-based architecture**: front-end more modular and maintainable
  - **Single Responsibility Principle**: each components has a singular responsiblity and should be broken a part further if grows beyond a signle responsibility
- **Virtual DOM**: more efficient than direct DOM manipulation
- **Single Page Application (SPA)**: loads a single HTML page

### Virtual DOM

- For every DOM object, react creates a correspodning lightweight virtual DOM Object
- **Reconciliation**: update process where virtual DOM synchronizes with DOM
  - React updates DOM with changes from Virtual DOM only when changes are necessary (improving performance)
  -

### Single Page Application (SPA)

- React app loads a single HTML page
- React swaps out existing HTML on the page with other pre-loaded content to give illusion of page nav without requests to server
- React Router - creates navigation between different views in React
- SPA tends to perform faster than multipage because no overhead for requests to server
- Drawbacks
  - everything must be loaded on first request (inital loading longer)
  - does not perform well on search engine optimization (SEO)

### Creating a New React Application

```bash
npx create-react-app "app_name"
yarn create react-app appname
```

- **package.json**: all info about the app
- **node_modules**: installed libraries
- **public folder**: favicon.ico, logo, index.html
- **src folder**: source folder for React components

### React Components

- We mainly use Function-based components now because it simplicity and ability to do the same as class-based compoents

  - it used to not have state management but React hooks (useState) can do that

- **Class-based component**

  - class, extends React.Component, returns render() { ... }

  ```javascript
  class Hello extends React.Component {
    render() {
      return <p>Hello World</p>;
    }
  }
  ```

- **Function-based component**
  ```javascript
  function Hello() {
    return <p>Hello World</p>;
  }
  export default Hello;
  ```

### JSX

- JavaScript XML - syntax extension to JavaScript to produce React "elements". JavaScript + HTML
- any JavaScript must be inclosed in curly braces
  ```javascript
  function Hello() {
    let message = "Hello World";
    return <p>{message}</p>;
  }
  ```
- Babel compiles JSX into regular JavaScript before everything is rendered
- tags are casesesnsitive
  - capitlized tags are rendered as components
  - uncapitlized tags are rendered as HTML
- only one root tag can be returned by a component
  - must surround multiple tags to be returned with <React.Fragment> or <>

#### Why JSX?

- embraces rendering logic
- coupled UI logic
  - components with logic and rendering in same file

### Conditional Rendering

- components encapsulating distinct behaviors and rendering based on state of app

```javascript
if (boolean) {
  return componentA;
} else {
  return componentB;
}
```

### Component Lifecycle

1. **Mounting** - putting elements into DOM
   constructor()
   render()
   componentDidMount() - if is mounted
2. **Updating** - updating the render after state change
   (new props, setState(), forceUpdate)
   render()
   componentDidUpdate() - if did update
3. **Unmounting** - removing component from DOM
   componentWillUnmount()

- ErrorHandling

### Props (Properties)

- props are passed from parent to child component

```javascript
function Hello(props) {
  return <p>{props.message}</p>;
}
```

### State

- Current state of data that changes over time
- in classcomponent, you would use this.setState()
- in Functional Components, you would use hooks (useState())
  ```javascript
  const [name, setName] = useState("Michael");
  ```

### Events in React

- attribute names use camelCase (onClick) in React rather than normal and requires passing in the JavaScript reference rather than a string

```javascript
function handleClick(name) {
  console.log("hello " + name);
}

<button onClick={() => handleClick("Michael")}>Click me</button>;
```
