# spring_data_mongodb_example

## What is this project about?
It's a simple spring bot app to demonstrate spring data framework. Created for university course

## What will I need?
At first - database. To run this example you will need mongoDB instance somewhere. I encourage you to grab the docker image, this would be the easiest way.
Expose port 27017, or any port you like. Please adjust settings in application.properties if needed. It is already configured to connect to database on port 27017, without specifying username or password.
If you set any, please make changes in app properties file. 

Next, you will need maven and Java 11 to run examples. That's all.

## Running examples
Type in terminal `mvn spring-boot:run`. App will start.
To run examples please send GET requests to localhost:8080/zti/example{id}
where id is number of example, eg. http://localhost:8080/zti/example1.
After you send it, the output will be visible on app output in terminal.

