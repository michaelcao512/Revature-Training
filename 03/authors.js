function getAuthorsData(){
    const AuthorsList = document.getElementById('authors')
    AuthorsList.innerHTML = ''


    const url = 'https://jsonplaceholder.typicode.com/users'


    fetch(url)
        .then( (response) => {
            return response.json()})
            .then( (data) => {
                data.forEach( (author) => {
                    // creaet new list element
                    const authorLi = document.createElement('li')
                      
                    // adds author name to the list element
                    authorLi.innerHTML = author.name
                    
                    // display email and address as a new unordered list inside the author list element    
                    const ulAuthorInformation = document.createElement('ul')

                    const liEmail = document.createElement('li')
                    liEmail.innerHTML = author.email

                    const liAddress = document.createElement('li')
                    liAddress.innerHTML = author.address.street + ', ' + author.address.city + ', ' + author.address.zipcode
                   
                    ulAuthorInformation.appendChild(liEmail)
                    ulAuthorInformation.appendChild(liAddress)

                    authorLi.appendChild(ulAuthorInformation)

                    AuthorsList.appendChild(authorLi)

                })
            })

}