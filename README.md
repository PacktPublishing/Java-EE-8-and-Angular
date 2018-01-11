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



## Related Products
* [Java EE 8 High Performance](https://www.packtpub.com/application-development/java-ee-8-high-performance?utm_source=github&utm_medium=repository&utm_campaign=9781788473064)

* [Architecting Modern Java EE Applications](https://www.packtpub.com/application-development/architecting-modern-java-ee-applications?utm_source=github&utm_medium=repository&utm_campaign=9781788393850)

* [Java EE 8 Microservices](https://www.packtpub.com/application-development/java-ee-8-microservices?utm_source=github&utm_medium=repository&utm_campaign=9781788475143)

### Suggestions and Feedback
[Click here](https://docs.google.com/forms/d/e/1FAIpQLSe5qwunkGf6PUvzPirPDtuy1Du5Rlzew23UBp2S-P3wB-GcwQ/viewform) if you have any feedback or suggestions.
