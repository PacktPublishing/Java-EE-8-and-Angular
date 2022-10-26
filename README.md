# Java EE 8 and Angular
This is the code repository for [Java EE 8 and Angular](https://www.packtpub.com/application-development/java-ee-8-and-angular?utm_source=github&utm_medium=repository&utm_campaign=9781788291200), published by [Packt](https://www.packtpub.com/?utm_source=github). It contains all the supporting project files necessary to work through the book from start to finish.
## About the Book
The demand for modern and high performing web enterprise applications is growing rapidly. No more is a basic HTML front-end enough to meet customer demands. This book will be your one stop guide to build outstanding enterprise web applications with Java EE and Angular. It will teach you how to harness the power of Java EE to build sturdy back ends while applying Angular on the front end. Your journey to building excellent web enterprise applications starts here!


## Instructions and Navigation
All of the code is organized into folders. Each folder starts with a number followed by the application name. For example, Chapter02.

Chapters 1, 3, and 12 do not have codes

The code will look like the following:
```
@NgModule({
  declarations: [ AppComponent, PositivePipe ],
  exports:      [ AppComponent ],
  imports:      [ BrowserModule, AppRoutingModule ],  
  providers:    [ DashboardService ],
  bootstrap:    [ AppComponent]
})
export class AppModule { }
```

The book is being written considering Java EE 8 and Payara. But a compatible/stable version of Payara for the latest EE 8, hasn't been released yet. So the code has been verified against Payara Micro 5 Alpha releases (https://www.payara.fish/upstream_builds)

* Hardware: 64-bit machine with minimum 2 GB of RAM (4 GB preferred) and at least 5 GB of free disk space
* Software: JDK 8, Git, Maven, Payara Micro Server, Docker, Node, npm, Angular CLI
* Oracle JDK 8: All the codes are tested on Oracle JDK 8, but OpenJDK should work fine as well
* Docker: Docker CE and Docker Compose
* More details: Latest version of Git and Maven (Apache Maven 3.5 or above), Payara Micro 5 (https://www.payara.fish/downloads)

### Specific instructions

With the repository cloned or downloaded, navigate to the chapter for building and running the projects.

#### Chapter 2 

**cdise-starter**
Within the project run:
`mvn clean install`
This downloads the dependencies and runs the single JUnit Test for CDI.

#### Open the project and browse and run these classes 

* BootCDI - To see simple CDI usage.
* Task - To see @RequestScoped usage using RequestContextController and @ActivateRequestContext binding
* Check org.jee8ng.starter.cdise.observer.Test for observer behaviour
* Check org.jee8ng.starter.cdise.orderedobserver.AccountService for ordered observer
* Check org.jee8ng.starter.cdise.annotationliteral.Test for seeing qualifier in action
* Check org.jee8ng.starter.cdise.annotationliteral.TestDynamicQualifier for seeing dynamic qualifier

**cdise-jpa-starter**
```
Within the project run: mvn clean install
Browse code starting with class App.java
```
* App - contains CRUD operations using JPA
* JPAProvider - used for obtaining EntityManager and cleanup


#### jpa-validation-starter 
Within the project run: mvn clean install

Run project on Java EE 8 Server such as Payara 5 and observe output (Ignore the DROP TABLE exceptions)

Browse code under package org.jee8ng.jpa.validation.starter which demos validations

* Task.java makes use of @Entity, @MappedSuperclass and @EntityListeners
* App.java executes JPA code on startup
* WEB-INF/web.xml defines a datasource
* src/main/resources/META-INF/persistence.xml defines the Persistence Unit

#### Chapter 4 

**payara folder has 3 projects**
Within each project run: **mvn clean install**

Then run each project as independent process using payara-micro-xxx.jar (xxx is version of latest server downloaded).

**java -jar payara-micro-xxx.jar --deploy ims-micro-users/target/ims-microusers.war
--port 8081**

**java -jar payara-micro-xxx.jar --deploy ims-micro-tasks/target/ims-microtasks.war
--port 8082**

**java -jar payara-micro-xxx.jar --deploy ims-micro-notify/target/ims-micronotify.war
--port 8083**


#### Running with Docker ####
ims-micro-users (Uses Payara Micro base image)

* docker build -t jee8ng/ims-micro-users .
* docker run -p 8080:8080 jee8ng/ims-micro-users

ims-micro-tasks

Create the runnable jar and then next create Docker container image using it.

* java -jar payara-micro-xxx.jar --deploy ims-micro-tasks.war --outputUberJar ims-micro-tasks.jar
* docker build -t jee8ng/ims-micro-tasks
* docker run -p 8080:8080 jee8ng/ims-micro-tasks


#### spring folder
issue-manager-users - Maven example of Spring Boot Microservice project

**mvn spring-boot:run**

#### swarm folder
issue-manager-users - Maven example of Wildfly Swarm Microservice project

**mvn wildfly-swarm:run**


#### Chapter 5

* ims-micro-tasks
* Deploy on a Payara 5 or Java EE 8 server and see server logs
* Browse code under package org.jee8ng.ims.tasks


#### Chapter 6

Sample code to browse JAXRS features

* ims-micro-notify
* ims-micro-tasks
* ims-micro-users

jaxrsdemo

* Sample code to check resource life cycle and filters.
* Contains swagger annotations

#### Chapter 7

Build ims-security first by going to the project folder and running:
**mvn clean install**

Next run these commands to get the project up and running.

* ims-users/buildAndRun.sh
* ims-issues/buildAndRun.sh
* ims-comments/buildAndRun.sh
* ims-chat/buildAndRun.sh
* Run **docker ps** and see if all Docker containers are up

You can either play around with Postman or curl with the REST APIs or startup the Angular IMS app.


#### Chapter 11

Running the Angular IMS Application locally. This depeneds on Chapter 7 (backend).

Run **npm install** from ims-ui project folder.
Run **ng serve --open** from ims-ui project folder

Two accounts would be setup already:

>Account: Admin
Username: admin
Password: admin

>Account: Guest
Username: guest
Password: guest


#### Chapter 13 
This depeneds on Chapter 7 (backend).

Build project using **mvn clean install**


#### Chapter 14 
This library gets used in Chapter 7 code as well.

Build project using **mvn clean install**


## Related Products
* [Java EE 8 High Performance](https://www.packtpub.com/application-development/java-ee-8-high-performance?utm_source=github&utm_medium=repository&utm_campaign=9781788473064)

* [Architecting Modern Java EE Applications](https://www.packtpub.com/application-development/architecting-modern-java-ee-applications?utm_source=github&utm_medium=repository&utm_campaign=9781788393850)

* [Java EE 8 Microservices](https://www.packtpub.com/application-development/java-ee-8-microservices?utm_source=github&utm_medium=repository&utm_campaign=9781788475143)
### Download a free PDF

 <i>If you have already purchased a print or Kindle version of this book, you can get a DRM-free PDF version at no cost.<br>Simply click on the link to claim your free PDF.</i>
<p align="center"> <a href="https://packt.link/free-ebook/9781788291200">https://packt.link/free-ebook/9781788291200 </a> </p>