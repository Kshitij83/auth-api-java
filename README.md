# 🧑‍💻 User Registration & Login API - Core Java 

This is a basic REST-like API built using **Core Java**, **Servlets**, and **JDBC** (no Spring Boot). It allows users to register and log in. The backend interacts directly with a **MySQL** database using raw SQL queries.




## Lifecycle Workflow

1. **User Registration**
   - The client (e.g., a web form or HTTP POST) sends a registration request with `name`, `email`, and `password` to the servlet endpoint (`/user?action=register`).
   - [`MainServlet`](src/main/java/servlet/MainServlet.java) receives the request and extracts the parameters.
   - The servlet creates a [`User`](src/main/java/model/User.java) object and calls [`UserService.register`](src/main/java/service/UserService.java).
   - [`UserService`](src/main/java/service/UserService.java) delegates the registration to [`UserDao.registerUser`](src/main/java/dao/UserDao.java).
   - [`UserDao`](src/main/java/dao/UserDao.java) inserts the user data into the MySQL `users` table using JDBC.
   - The result (success or failure) is returned up the chain and an appropriate response is sent to the client.

2. **User Login**
   - The client sends a login request with `email` and `password` to the servlet endpoint (`/user?action=login`).
   - [`MainServlet`](src/main/java/servlet/MainServlet.java) receives the request and extracts the parameters.
   - The servlet calls [`UserService.login`](src/main/java/service/UserService.java) with the credentials.
   - [`UserService`](src/main/java/service/UserService.java) delegates authentication to [`UserDao.loginUser`](src/main/java/dao/UserDao.java).
   - [`UserDao`](src/main/java/dao/UserDao.java) queries the database for a matching user.
   - If a user is found, the user object is returned; otherwise, `null` is returned.
   - The servlet sends a success or failure message back to the client.

## Main Components

- **Model:** [`User`](src/main/java/model/User.java)
- **DAO:** [`UserDao`](src/main/java/dao/UserDao.java)
- **Service:** [`UserService`](src/main/java/service/UserService.java)
- **Controller/Servlet:** [`MainServlet`](src/main/java/servlet/MainServlet.java)
- **Database Connection:** [`DBConnection`](src/main/java/util/DBConnection.java)

---

For further details, see the source files in the `src/main/java` directory.
