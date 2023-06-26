# Effective development tools

## Exercises with Controllers and Domain layer
Notes: 
1. We do not use database for this example. Use PersonUtil persons list as database
2. Try to follow the rules of hexagonal architecture (UseCase interface is public, UseCaseImpl is package default)
3. Check if you can understand how DemoController works (please ask questions if not)

### Exercise 1: Set up your first controller PersonsController with method to find all persons

Instructions:

1. Create first controller GET method to findAllPersons
2. Create applicable use case in domain layer and implement it (Controller only uses UseCase - an abstract interface &
   UseCaseImpl is the implementation of it)
3. Make sure to convert the List of Person result to List of PersonDtos

### Exercise 2: Create filter for findAllPersons method

Instructions:

1. Create filter for findAllPersons PersonsFilterDto, use it as optional requestParam
2. Add capability to filter out persons by firstName and lastName
3. Return List of filtered PersonDtos

For example:
filter firstName: jo, on, JON, On (ignore case)
Would return Jon Snow person

### Exercise 3: Create controller method fetchPerson (using id as input)
Note: you can get id of person by using findAllPersons

Instructions:

1. Create GET controller method that takes in person id
2. Create use case to find person from the list
3. Return PersonDto as result or throw exception when person with id does not exist
4. Make sure to add resolver for thrown exception into ApiExceptionHandler (to see the actual error message)

### Exercise 4: Create controller method to deletePerson (using id as input)
Note: you can get id of person by using findAllPersons

Instructions:

1. Create DELETE controller method that takes in person id
2. Remove the person with id from the list

To check if it was removed, use findAllPersons endpoint

### Exercise 5: Create controller method to savePerson (using PersonDto RequestBody as input)

Instructions:

1. Create POST controller method that takes in PersonDto
2. Add person to the list

To check if person was added, use findAllPersons endpoint

## Exercise with Lombok:
Note: keep in mind that the main method still works correctly

Instructions:

1. Open the class User
2. Replace the boilerplate code with Lombok annotations

## Exercise with Liquibase:
Create a New Table and Add a Foreign Key Constraint

Instructions:

1. Navigate to the correct folder, create a new changeset that includes the creation of a new "address" table and a 
   foreign key constraint between the "person" table and the new table.
2. Define appropriate columns in the new table, including a primary key column and columns that establish the  
   relationship with the "person" table. You should include id, city, street, postal code and country.
3. Add a foreign key constraint in the "person" table, referencing the primary key column of the new table. 
4. Execute the changeset to apply the schema modifications (find the update command).
5. Check from http://localhost:8080/persons-api/h2-console that the changeset was applied
JDBC URL: jdbc:h2:file:./TestDataBase
User name: sa
Password: password

## Exercises with Database layer

Instructions:
1. Try to create JDBC layer classes (gateways) instead of PersonUtil for the use cases