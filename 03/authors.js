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
                    authorLi.className = 'author'
                    // adds author name to the list element
                    authorLi.innerHTML = author.name
                    
                    // display email and address as a new unordered list inside the author list element    
                    const ulAuthorInformation = document.createElement('ul')
                    ulAuthorInformation.className = 'author-information'

                    const liEmail = document.createElement('li')
                    liEmail.className = 'email'
                    liEmail.innerHTML = author.email

                    const liAddress = document.createElement('li')
                    liAddress.className = 'address'
                    liAddress.innerHTML = author.address.street + ', ' + author.address.city + ', ' + author.address.zipcode
                   
                    const liPhone = document.createElement('li')
                    liPhone.className = 'phone'
                    liPhone.innerHTML = author.phone

                    const liWebsite = document.createElement('li')
                    liWebsite.className = 'website'
                    liWebsite.innerHTML = author.website

                    const liCompany = document.createElement('li')
                    liCompany.className = 'company'
                    liCompany.innerHTML = author.company.name




                    ulAuthorInformation.appendChild(liEmail)
                    ulAuthorInformation.appendChild(liPhone)
                    ulAuthorInformation.appendChild(liWebsite)
                    ulAuthorInformation.appendChild(liCompany)
                    ulAuthorInformation.appendChild(liAddress)

                    authorLi.appendChild(ulAuthorInformation)

                    AuthorsList.appendChild(authorLi)

                })
            })

}