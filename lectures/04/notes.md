node.js
    runtime environment that allows us to execute js outside of browser environment
npm
    node package manager
dynamic vs static / strongly typed
    javascript is dynamic type
        var x;
        x could be a string or number or anything

    typescrpit is static / strongly typed
        x: number
        x is a number

write in typescript in the .ts file
compile the typescript file into javascript using 
    tsc ./filename.ts
run the javascript file
    node ./filename.js


why use typescript
    object orientated programming language (js is prototype based)
    when you have a largecode base

    when team of developers are already accustomed to statically-typed languages

typescript types
    primitive
        simple: string, number, boolean
        special: any (disables type checking), unknown, never (return type of error), undefined, null, union


type interference
    when you assign to a variable it will automatically assign type

typescript annotations
    :type after the variable/function/object/etc. to identify the type
    let name: string = 'John';
    let age: number = 25;
    let active: boolean = true;

    function greeting: (name: string): string {
        return "hello " + name;
    }

    let employee: {
        firstname: string;
        lastname: string;
    };

    let scores : (string | number)[] - array of type string OR number

    typescript tuple
        let skill: [string, number]; = ['Programming', 5]
    
    optional tuple elements 
        ? after the element
        let bgColor: [number, number, number, number?]

    enums
        group of named constant values
        enum Month {
            Jan,
            Feb,
            ...
        }
    
    union type 
        combining multiple types into one using |
        let result: number | string - result can be either number or string

    type aliases
        allows creation of a new name for a a type (variable for a type)

        type alphanumeric = string | number;
        let input: alphanumeric


if else, switch, for loop, while loop, do while

fucntions
    void = no return type

    function name(parameter: type, ...): returnType {
        do something...
    }
    (paramter: type, ...) => returnType {
        do something...
    }
    optional parameters
        ? after parameter to indicate parameter is optional
    defualt paramter
        = value after paramter to set defualt value

    Rest Paramter
        accept zero or more arguments of a specific type
        rules
            1) only 1 rest parameter
            2) appears last
            3) type of rest parameter is an array
        
        function getTotal(...numbers: number[]): number {
            ... sum numbers
        }
        getTotal(1,2,3) returns 6

classes
    class className{

        ...
    }
    can have properties variables
    with access modifiers (protected, public, private, etc.)

    readonly to make a property immutable
        can only assign in the constructor or the property declaration
    
        compared to const
            const used for variables while readonly use for class properties
            const can only be assigned in property declaration while readonly can also be done in constructor
    getters and setters
        get and set keywords

        calling the getters setter using .property notation

        public set age(theAge: number){
            if (age validation ... ) { throw error }
            this._age =   theAge 
        }

        let p = new Person()
        p.age = 10 -> this calls the set age method and validates accordingly
        console.log(p.age) -> calls getter

    inheritance
        extends
        can use super(parameters) in the child call to call the constructor of the aprent class

        constructor(params...){
            properties and assignment
            super(params);
        }

    method overriding 

    static properties or methods
        shared between all instances of the class

    abstract class
        common behavior between derived classes
        
    interfaces
        create contracts that other classes can implement
        implements keyword
        can have optional properties
        readonly properties for when object first created and doesnt change
        typescript doesn't not convert interfaces to javascript 
        it is used for typing checking

        can extend one orm ultiple interfaces
        can extend class

advanced types
    intersection type &
        combining multiple existing types 

        type tpyeAB = typeA & typeB

        contrasts with union type | which represents either typeA or typeB

        type order doesnt matter

    type guards
        allows narrow down type of variable within condiotnal block

        typeof
            returns type 
    
        instanceof
            type A = B | C
            B instanceof A -> true
    
        in
            check if a property is on an object

        userdefined type guard
            function isCustomer(partner: any): boolean {
                return partner instanceof Customer
            }

    typecasting
        as keyword or <> operator for typecasting

        let a: typeA;
        let b = <typeB>a;

        or
        let b = a as typeB


generics
    provide compile time safety

    List <String> name = new ArrayList();
    specify array list as list of Strings using generics <>



Imports with {} and without {}
    you use without {} when importing a package that is not exported as a default 


decorators  
    used to as special behaviors to a class or members of a class
    @RestController
    Class, Method, Property, Parameter decorators