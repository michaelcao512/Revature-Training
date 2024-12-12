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
        special: any (disables type checking), unknown, never, undefiend, null

typescript annotations
    :type after the variable/function/object/etc. to identify the type
    let name: string = 'John';
    let age: number = 25;
    let active: boolean = true;