# bankingAPI
This application is a simple API that can perform common banking operations such as getting all accounts, getting an account by account id, deposit money, withdraw money, add account and delete account.
The API is built using **Java, Spring Boot, Spring Data JPA (Hibernate), & MySQL**.
Dependencies used: Spring Web, Spring Data JPA, MySQL Driver, Lombok 

## Instructions
To test the API, preferabbly using Postman, clone the repository onto your local system and change the application.properties file in src/main/resources/ to replace the MySQL database name, username and password of your database.
Then you can run the application and test it using GET, POST, PUT, DELETE requests in postman

### The app has the following Rest APIs:
- **/api/accounts** - to get all accounts (GET Request)
- **/api/accounts** - to create new account. the account holder name and balance should be provided in the request body as a JSON object with 'accountHolderName' and 'balance' as keys.
- **/api/accounts/{id}** - to get account with account number 'id' (GET Request)
- **/api/accounts/{id}/deposit**" - to deposit amount to account with account number 'id'. The deposit amount should be provided in the request body as a JSON object with key as 'amount'.
- **/api/accounts/{id}/withdraw**" - to withdraw amount to account with account number 'id'. The withdraw amount should be provided in the request body as a JSON object with key as 'amount'.
- **/api/accounts/{id}** - to delete account with account number 'id' (DELETE Request)

