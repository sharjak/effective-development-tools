# Effective development tools 

## SETUP
1. Set the SDK to 17 and language level to default (File -> Project Structure )
2. Set Gradle JVM to Project SDK (under settings: Build, Execution, Deployment -> Build tools -> Gradle -> Gradle JVM)
3. Build the project in root folder with command: ./gradlew build (Terminal tab below)
4. Run the project either through IntelliJ configuration or ./gradlew bootRun

NB! If you get any errors while trying to build/run the project, ask the tutors, we will come and help. 

### Useful shortcuts:
* SHIFT + SHIFT - find all (classes, files)
* CTRL + SHIFT + F - find in files (search for text, methods)
* Hold CTRL and click on attribute/method - goes straight to the method
* Hold CTRL + ALT and click on method - goes straight to the implementation of the method
* CTRL + ALT + <- - goes back to the previous file you were on
* CTRL + ALT + -> - goes back to the next file you are on
* Select a method or attribute SHIFT + F6, edit name, press enter - changes the name everywhere based on scope

### Structure - simplification of ports and adapter architecture:

Controller <- uses UseCase (interface)    <- UseCaseImpl            <- uses Port (interface) <-  Gateway
Adapter    <-         port                <- core business logic    -> port                  -> adapter
Web layer          Domain layer           Domain layer              Domain layer             JDBC layer

* DTO-s (Data transfer objects) are used to transfer data, may only contain necessary data for specific UseCases.
   Example class PersonDto
* Domain Model represents core business concepts, embodies real world entities. Example class Person

To move data between DTO from domain model we need to map it. The mapping often occurs at the boundaries of the system, 
where the data is transferred between different layers or components. In our project we can do it in the controller. 

## Exercises with Controllers and Domain layer
Notes: 
1. We do not use database for this example. Use PersonUtil persons list as database
2. Try to follow the rules of hexagonal architecture (UseCase interface is public, UseCaseImpl is package default)
3. Check if you can understand how DemoController works (please ask questions if not)

### Exercise 1: Set up your first controller PersonsController with a method to find all persons

Instructions:

1. Create first controller GET method to findAllPersons
2. Create applicable use case in domain layer and implement it (Controller only uses UseCase - an abstract interface &
   UseCaseImpl is the implementation of it)
3. Make sure to convert the List of Person result to List of PersonDtos

### Exercise 2: Create controller method fetchPerson (using id as input)
Note: you can get id of person by using findAllPersons

Instructions:

1. Create GET controller method that takes in person id
2. Create use case to find person from the list
3. Return PersonDto as result or throw exception when person with id does not exist
4. Make sure to add resolver for thrown exception into ApiExceptionHandler (to see the actual error message)

### Exercise 3: Create controller method to deletePerson (using id as input)
Note: you can get id of person by using findAllPersons

Instructions:

1. Create DELETE controller method that takes in person id
2. Remove the person with id from the list

To check if it was removed, use findAllPersons endpoint

### Exercise 4: Create controller method to savePerson (using PersonDto RequestBody as input)

Instructions:

1. Create POST controller method that takes in PersonDto
2. Add person to the list

To check if person was added, use findAllPersons endpoint

### BONUS exercise: Create filter for findAllPersons method

Instructions:

1. Create filter for findAllPersons PersonsFilterDto, use it as optional requestParam
2. Add capability to filter out persons by firstName and lastName
3. Return List of filtered PersonDtos

For example:
filter firstName: jo, on, JON, On (ignore case)
Would return Jon Snow person

## Exercise with Lombok:
Note: keep in mind that the main method still works correctly

Instructions:

1. Open the class User
2. Replace the boilerplate code with Lombok annotations

## Exercise with Liquibase:
NOTE: liquibase files exist under liquibase/changelog and there is an example called 010_person.yaml
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
   * Create a port and a gateway with the correct names in the right packages