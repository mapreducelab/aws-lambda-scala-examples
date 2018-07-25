evaluate an Amazon microservice-http-endpoint blueprint:
https://console.aws.amazon.com/lambda/home?region=us-east-1#/create/new?bp=microservice-http-endpoint
This Amazon Microservice blueprint includes:
API Gateway endpoint with a proxy integration type
How to create and test a Simple Microservice using Lambda and API Gateway: http://docs.aws.amazon.com/lambda/latest/dg/with-on-demand-https-example-configure-event-source_1.html


Run the Lambda function code from Amazon S3 bucket
Create the custom API re-using Example API or import from Swagger
Create new API: https://console.aws.amazon.com/apigateway/home?region=us-east-1#/apis/create

Link to the API
Deployment flow:
1. Create Lamda Function and upload jar file
2. Create API Gateway Resources
3. Create API Gateway stages
4. Create User Cerificate

AWS Postgres RDS:
Host: testdb.czfe7kky88c3.us-east-1.rds.amazonaws.com
Database: testdb
User: test
password: test
create table phrases (phrase VARCHAR(100));
insert into phrases (phrase) values('Hello World');
select phrase from phrases;

Lambda linked https://console.aws.amazon.com/lambda/home?region=us-east-1#/functions/demofunc?tab=graph
The role created to get access to rds from lambda is https://console.aws.amazon.com/iam/home?region=us-east-1#/roles/rdbms-lambda-access

example.Main$ - getHelloWorld from jdbc:postgresql://testdb.czfe7kky88c3.us-east-1.rds.amazonaws.com:5432/cyberdb
