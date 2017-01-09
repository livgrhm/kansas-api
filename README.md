# Kansas

About Kansas API (Dropwizard)
--
Kansas is a personal goal-setting app that allows the user to define long term goals, milestones and habits to help get toward those goals.

This repository contains the back-end RESTful API which contains the business logic and the database abstraction layer. It allows users to register and subsequently authenticate before performing CRUD operations on their own data (their personal data, goals, milestones and habits).

It has been built using [Java 8](http://www.oracle.com/technetwork/java/javase/overview/java8-2100321.html) and [Dropwizard (1.0.5)](http://www.dropwizard.io/1.0.5/docs/).

There is a corresponding mobile app built in [Ionic v2](http://ionicframework.com) which is built on top of [Angular2](http://www.angular2.com). - Please see my [other repositories](https://github.com/livgrhm).

API Reference
--
- [USER](#)
	- [GET Users](#)
  - [GET User By ID](#)
  - [GET User By Email](#)
  - [POST Add User](#)
  - [PUT Update User](#)
  - [DELETE Delete User](#)
- [GOAL](#)
	- [GET Goals](#)
  - [GET Goals By User ID](#)
  - [GET Goal By ID](#)
  - [POST Add Goal](#)
  - [PUT Update Goal](#)
  - [DELETE Delete Goal](#)
- [GOALSTEP](#)
- [MILESTONE](#)
- [HABIT](#)

How to start the Kansas application
--

1. Fork this repository
2. Run `mvn clean install` to build the application
3. Start application with (note the build number in the jar file) `java -jar target/kansas-0.0.1.jar server config.yml` 
4. To check that your application is running enter url `http://localhost:8080`
5. For further instructions please check the [Dropwizard docs](http://www.dropwizard.io/1.0.5/docs/)

Health Check
--

To see your applications health enter url `http://localhost:8081/healthcheck`

TODO: *Document health checks here.*

API Documentation
--

**GET Users**
----
  
  Get a list of all users. Returns a list of user objects.

* **URL**

  /user

* **Method:**

  `GET`
  
*  **URL Params**

   **Required:**
 
   `auth=[string]`  authentication hash for an administrator

* **Data Params**

  None

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{ userId : 1, firstName: "Olivia", lastName: "Graham" ... }`
 
* **Error Response:**

  * **Code:** 404 NOT FOUND <br />
    **Content:** `{ error : "User doesn't exist" }`

  OR

  * **Code:** 401 UNAUTHORIZED <br />
    **Content:** `{ status : "Unauthorized", message: "Authorization is required." }`

* **Sample Call:**

 ```javascript
    $.ajax({
      url: "/user",
      params: { auth: "authString" },
      dataType: "json",
      type : "GET",
      success : function(r) {
        console.log(r);
      }
    });
  ```

* **Notes:**

