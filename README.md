How to build and run this:

Step 1: Package Spring Boot App-
./mvnw clean package--> It creates target/app_name.jar

Step 2: Run Docker Compose
docker-compose up --build

Then do the Postman Testing:
go to: https://localhost:8081/register and create a user there.
E.g: 
Content-Type: application/json
{
  "username": "Admin",
  "password": "admin",
  "role": "ADMIN"
}
And it should create a user.
