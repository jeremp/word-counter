# Java Word Counter 

A simple Java utility to count words in a sentence.

## How to build it ? 

You'll need a **JDK-8** and **Maven** to run : 

`mvn clean install`

## How to use it ?

### Add Dependency to your project

```xml
<dependency>
	<groupId>com.jeremp</groupId>
	<artifactId>word-counter</artifactId>
	<version>1.0</version>	
</dependency>    
```    

### Instanciate a word counter

```java
// two implementations exist, you're free to choose the one your prefer 
private final WordCounter collectionWordCounter = new CollectionWordCounter();
private final WordCounter arrayWordCounter = new ArrayWordCounter();
```    

## I want to build it with docker

Run the build in a container

`docker run -it --rm --name my-maven-project -v "$PWD":/usr/src/mymaven -w /usr/src/mymaven maven:3.5.0-jdk-8 mvn clean install`