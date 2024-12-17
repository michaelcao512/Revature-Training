# React

    JavaScript library to create front end UI

    used with other modules such as React Router and Redux

    boiler plate code = repetitive code -> framesworks reduce boilerplate code by certain configurations -> example React does components

    React uses Component-based architecture -> front end more modular and maintainable


    React uses virtual dom - more efficient than direct DOM manipulation
        DOM (document object model) -> overhead to change the document
        virtual dom -> creates virtual copy of DOM and final changes go to real DOM

    React is a libary not a framework

    Single Page Application (SPA)
        app that loads a single HTML page

        React will swap out existing HTML on the page with other pre-loaded content to give illusion of page navigation w/o requests to server

        React Router
            create navigation between different views in React

        SPA tend to performan faster htna multipage - overhead for request to server
        drawback
            everything must be loaded on first request -> inital loading is longer
            does not perform well on search engine optimization (SEO)

    Creating a neww React Application
        npx create-react-app "app_name"

        yarn create react-app appname

        package.json
            all info about the app
            dependencies and scripts and information etc.

        node_modules
            installed libraries downloaded into this folder
            
        public folder
            favicon.ico -> icon on browser tab
            logo
            index.html -> page that is rendered onto browser

        src folder
            source folder where we should code or react components
            other properties files

            index.js
                renders our component onto the root element

    Changes
        className attribute used instead of class

# React Fundamentals
    React - component based libarry 
    Components - reusable piece of UI 
        single responsibility principle 
            should break apart a component if grow beyond single responsibility
        javascript function
        accepts arbitary input (props)
        render components in index.js

        create components
            class-based component 
                traditional
                class Hello extends React.Component {
                    render() {
                        ...
                    }
                }
                not used often now ; need to use Render and extend
            
            function - based compoents (MAIN way now)
                function Hello() {
                    return ...

                }   
                export default Hello;

            class-based compoennts used to be more powerful because ability to handle state (life cycle components) but now functional components can do the same with React Hooks
            functional components is preferred
                less typing and more concise


    
    utilizing a component
        need to export default on the function
        export default function Hello() {
            return (<p>Hello World</p>)
        }

        import the component and then use them
        <Hello></Hello>


    JSX
        JavaScript XML
        syntax extension to javascript to produce React "elements"
        javascript + HTML

        why JSX
            embraces rendering logic coupled UI logic
            instead of separting technologies putting up markup and logic in separate files, React has compoentns containing both logic / rendering
        

        function Hello(){
            return (html...)
        }

        Babel compiles JSX into regular javascript before everything is rendered

        any javascript must be inclosed in curly braces {}
            variables
                let message = "Hello World"
                use {message} inside the return to render this variable

        casesenstiive
            capitlized tag = rendered as component
            uncapitlized tag = rendered as html

        only one root tag can be returned by a component
            if you have multiple tags you can surrounded with React.Fragment or <>


    Conditoinal Rendering
        components encapsulating distinct behavior and rendering a component based on the state of app
        
        if (boolean) {
            return componentA;
        } else {
            return componentB;
        }

 
    Authentication - estabilishing identity (logging in)
    Authorization - permission with identity (accessing a page)


    Virtual DOM
        React HTML views using JS 
        For every DOM object, react has correspodning virtual DOM object

        only updates when changes are necessary (improving performance)

        reconciliation - update process in EwXR where virtual DOM updates real DOM

    Component Lifecycle
        Mounting - putting elements into DOM
            constructor()
            render()
            componentDidMount() - if is mounted
        Updating - updating the render after state change
            (new props, setState(), forceUpdate)
            render()
            componentDidUpdate() - if did update
        Unmounting - removing component from DOM
            componentWillUnmount()
        ErrorHandling 

    Props (properties)
        components can be nested in other compoents (parent child compoentns)

        props are passed from parent to child
            <Hello message="prop message"/>
            Hello components that passes message prop to Hello component    

            function Hello(props) {
                return ( <p> {props.message} </p> );
            }

    State
        current state of data that is changed

        in a classcomponent you woud use  this.setState()

        in a funcitonal copmonent you use would use hooks
            useState


    Built-in React Hooks
        let you use built in functionalities
        hooks always preceded with "use" in the name
        useState()

    Events in React
        handling events similar to inline HTML event handling
        in JSX, event attributes names use camelCase (onClick) abd a javascript reference {handleClick()} is passed rather than a string 

        function handleClick(){
            console.log("hello")
        }
        
        <button onClick={handleClick}>
            no paratnehsis because that will call the function instead of passing the function
            if you want parmaeters use anonymous function
         
        function handleClick2(name){
            console.log(name);
        }
        <button onClick={() => handleClick2("Michael")}>

    State
        useState(initialState) 
            a hook which takes initial state and returns a tuple of the state with the property and function that allows you update the state
        const [name, setName] = useState("Michael");


assignment
    a post can have multiple comments associated with it
    write components to display comments associated with a post