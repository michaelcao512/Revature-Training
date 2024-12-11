# Javascript
    programming language for web
    interpreted and loosely typed language

    <script></script>

    using external script create .js file
        <script src="script.js"></script>

javascript data types
    var can hold many data types: numbers, strings, objects, boolean, undefined, null, and more

    var evalutes left to right and when adding a string to a number it will convert to a string

    var is dynamic and its type can change and hold different types

    objects
        written with curly braces
        properties are written as name:value pairs separated by comma

        JS Object
            person = {firstsName:"John", lastName:"Doe"};

        JSON String
            person = {"firstName":"John", "lastName":"Doe"};


        conversion
            JSON -> JS Object = parse
            JS Object -> JSON = strinfy

    typeof - operator to find type of variable

    variable scope
        lifetime and visiblity of a scope

        global scope - accessed everywhere
        local scope 
            function scope - 
            block scope - defined by let/const keyworks inside {} and only exists within the correspodnming block
            lexical scope - defined outside a function can be accessed inside another functioned defiend after variable decalration 



    hoisting of functions and variables
        hoisting = variables and function declarations moved to top of their scope before execution

        use strict to force no hoisting

    type coercion
        converting value from one type to another
        
        implicit - automatically; string + number = string; 123 + ""
        explicit - String(123)

    == vs ===
        === : strict equality - checks the type as well
        == : equality
        = is assignment (no equality check)

        5 === '5' -> false
        5 == '5' -> true

    falsy values vs truthy
        any expression that results in boolean false is considered falsy
            false, empty string, undefined, null, NaN (not a number), 0
    
        truthy is anything else that has value

    functions  
        function name(parameter1, ...){

        }

        functions can bad assigned and utilized
        var add = function sum(val1, val2) { return val1 +val2; }
        add(1,2)

        anonymous function    
            defines function w/o name and must be assigned to variable 
            var sayHello = function (firstName) { alert("Hello " + firstname); }

        callback function
            passing a function as an argument (higher order functions)
            function name (parameter1,..., callback) {
                ...
                callback();
            } 

        closures
            function that remembers and accesses the variables and arguments of its outer function even after function return
            enclosed in {}
        
        arrow function
            let func = (arg1, ...) => expression;
            var hello = () => "Hello World";
            hello();

            multiline

    backtick (``)
        allows dynamic code to allow variables inside of strings
        function sayHello(name) {
            alert(`Hello ${name}`);
        }