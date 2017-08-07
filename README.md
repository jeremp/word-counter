# Java Word Counter 

A simple Java utility to count words in a sentence.

## How to build it ? 

You must have a JDK8 and Maven to run : 

`mvn clean install`

## How to use it ?

### Add Dependency to your project

```xml
<dependency>
	<groupId>om.jeremp</groupId>
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
