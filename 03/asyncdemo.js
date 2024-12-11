const getTodos= async () => {
    const response = await fetch('https://jsonplaceholder.typicode.com/todos/1');
    const data = await response.json();
    return data;
}

console.log('Before calling getTodos');

getTodos().then( (data) => {
    console.log('Resolved:', data);
}).catch( (error) => {  
    console.log('Rejected:', error);
}); 

console.log('After calling getTodos');

