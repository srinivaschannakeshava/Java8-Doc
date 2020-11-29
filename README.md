# Whats New in Java8 ?

## Lambda Expression
- Lambda Expression
- Fuctional Interface
- Method References
- Constructor References
- Process data using lamba and Collection API
### What is Lambda Expression for ?
- To make instances of anonymous class easier to write and read. or another way of writing anonymous class
### Some Imp quetions about Lambda?
- What is the Type of Lambda?
  - Type of a Lambda expression is A Functional Interface - 
    - An interface with only one abstract method.
    - Methods from object class don't count
      - they would be mainly meant for documentation of methods in object class
    - A functional interface can be annotated @FuntionalInterface - Its just here to enable the compiler to validate if its functional interface or not
- Can a Lambda expression be put in a variable?
  - Yes it can be and thats waht we do every where be it in runnable/comparator/any functional interface
- Is a Lambda expression an Object? 
  - The answer is complex, but no its not an object
  - A lambda is an object without identity because
    - A lambda expresion is created without new 
    - The Jvm doesnt create new object everytime the lambda expression is called- less memory and operational expenses
    - Performance are much better than declared as ananomous class intialization
### Funtional interface toolbar
- 43 rich set of functional interface
- 4 categories
  - supplier interfaces - doesnt take any object as parameter and provides a new object
  - consumer/BiConsumer - accepts 1 or 2 objects of any type and return nothting i.e void return type
  - predicate/BiPredicate - takes an object/objects returns a boolean type
  - Function/BiFunction -  take an object as an parameter and returns an object./
    - some of the special functional operators
      - unary operator - return type is same as input type object but takes in only one object as parameter
      - binary operator - return type is same as input type but takes in 2 objects as parameters
### Method references
- ex:- ``` Consumer<String> c = s-> system.out.println(s);``` can be written as 
- ``` Consumer<String> c = System.out::println; ``` without the variable 
- ex:- ``` Comparator<Integer> c = (i1,i2)-> Integer.compare(i1,i2);```
-  ``` Comparator<Integer> c = Integer::compare; ```
-  we can use both static and not static methods with this syntax

### using lambda expression for processing data efficiently

### Using default and static methods in interfaces
- a regular method with ```default``` key word in front of return type declared can be used in interfaces
- this is mainly meant to be used in interfaces for adding new functionality without breaking the old implementations.
- it also allows new patterns
- static methods are also allowed in java8 interfaces

## Java Streams and collectors
- Map/Filter/Reduce algorithm
  - Mapping->Filter->Reduce(equivalent to sql aggregation)
- What is Stream?
  - A stream is a Java Typed Interface -> T
  - A new concept to java
  - It gives a way to efficiently process large amounts of data .. also small amount
    - A data can be processed parallel- to leverage the compunting power of multicore
    -  Pipelined , to avoid unnecessary intermediate computation
 - A stream is an object on which you can define operations like Mapping/Filter/Reduce operations
 - A stream object doesnt hold any data - where as in collection you have data.
 - A stream object doesnt change the data it is processing.
 - A Stream object able to process data in one pass
 - A Stream object optimized from algorithm point of view and able to process data parallel
 - A stream cannot be used once it cant be reused and a new stream as to be used. But how ever the stream are light wait and are less overload for creating a new one
 - Why cant collection be a stream?
   - Stream is a new concept and didnt wanted to change the collection api 
- Pattern to Build Stream.
- 
- Operations on a Stream.
  - All the methods of stream that returns a stream are lazy.
  - An operation on a stream which returns another stream is called an intermediate operation
  - Peek(lazy), forEach(non lazy), filter(lazy)
  - Map Operation : map() return a stream hence its a intermediate operation
    - mapper function is modeled by function interface
  - flatmap operation : 
    - Flatmap basically flattens the list of list to a single stream

- Reduction steps in Stream
  - Reductions are terminal operation(i.e not lazy)
  - streams.reduce(x,y) takes in 2 arguments one is the identity and the other is a binary functional interface.
  - on fly available reduce operations - max, min, count, 
  - allMatch(), noneMatch(), anyMatch()
  - findFirst(),findAny()
- Optionals 
  - its a new concept where it means there might be no result
  -  use isPresent() method to check if data exis or not and use .get() to get data
  -  or use opt.orElse("") this encapsulate both calls


### Java8 - Date and Time API
- New API, package is java.time
- Concept 1 -
  - Instant - is a point on the timeline
  - Instant.now() - current time
  - Instant object is immutable
- Concept 2
  - Duration - amout of time between 2 instant
  - Duration.between(instant1, instant2)
- Concept 3
  - LocalDate - LocalDate.now()
  - LocalDate.of(1991,Month.NOV,09)
- Concept 4
  - Period - amount of timebetween two localDate
  - same concept as duration but for local date
- concept 5 date adjusters
  - Useful to add or subtract an amount of time to an instant or a LocalDate
  - Use the method with() - ex: - LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
- Concept 6 - localTime
- concept 7 - ZonedTime
  - ZoneId.getAvailableZoneIds();
  - ZoneId.of("")

-- -------------------------------------------------
## Strings, I/O and other features
- String class
- Java I/O package
- Collection interface
- Comparators
- Numbers
- Maps
- Annotations - repeatable annotations
  
### Strings and StringJoiner
- Creating a Stream on a string
- StringJoiner -
  - Using +" "+ for joing strings is not a good option due to multiple creation and deletion of strings in this process.. the more efficient way is to use string buffer
  - String buffer is synchronized 
  - String Builder is not synchronized and better than  string buffer
  - ``` String joiner sj = new StringJoiner(", "); sj.add("one").add("two"); String s = sj.toString();```
  - added in java8 more efficient and simpler way of concatinating string
  - can be directly used for string class String.join(", ","one","two","three");
### Java I/O enhancements
- A lines() method has been added to BufferedReader class
- this lines() method opens a stream for each line of the document being read
- Files.lines(path); gives a stream for line of the document
- Reading Directory Entries
  - Files.list(path); -> stream of doc in path
  - Files.Walk(path); -> stream of doc including the recursive directory
### Collection API
- stream() and parallelStream() on collections
- spliterator()
- forEach() on all iterables
- removeIf(predicate), - removes the element from the list
- replaceAll(), ex:- list.replaceAll(String::uppercase)
- sort() - ex: list.sort(Comparator.naturalOrder())
### Comparator - patterns and utilities
- Comparator.comparing(Person::getLastName);
- .thenComparing() -> chaining comparator
- .reversed() -> 
- Comparator.naturalOrder();
- Comparator.nullsFirst(Compartor.naturalOrder());
-  Comparator.nullsLast(Compartor.naturalOrder());  

### Number
- Note: - primitive types: int, long, short, byte, char, boolean
- Long.max(1L,2L)
- Long::sum

### Maps
- foreach() - takes biconsumer as parameter
- getOrDefault(key,DefaultValue)
- map.putIfAbsent(key,value)
- map.replace(key,value)
- map.remove(key,value) - remove keyvalue from map only if both key and value match
- 
- compute(),computeIfPresent(),computeIfAbsent()
- merge() - associates a key not present in the map or associated to a null value, to a new value

### Annotation
- java 8 brings the concept of multiple annotation
- @ Repeatable 
- jav 8 allows annotation to be put on types - @NonNull