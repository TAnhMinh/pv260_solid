# pv260_solid

## Open/Closed Principle
- using the given code and maintaining its "style", I would have to add attributes like JsonFilePath, different constructor and the calling method, change usage of the class in main etc.
- I altered the code, so that there are only attributes type and file

## Liskov principle
- I am not entirely sure about this - by running the main() function, I discovered that CSVSerializer does not satisfy the specification of SimpleSerilizer that says that applying desrialization after serialization should result in the original value 
- in the code, I think that SuperCar is child of Vehicle but does not behave as such - its constructor takes 4 parameters, whereas constructor of vehicle takes only 2 (actually, this was alright in basic Java course, so I am not sure if this is violation) 

## Dependency Inversion Principle
- The methods for lunch recommendation and outfit recommendation depend directly implementations of two forecast classes
- We should replace this by an interface, so that we would be able to abstract the weather forecast
- implementing DIP enables us to have more testable code, less fragile code. We can alter implementation details more easily, without rewriting the higher level parts.
- DIP is the principle that higher level classes should not depend on concrete implementation of low level classes, instead they should both depend on abstractions. Alos, abstraction should not depend on implementation details.
- inversion of control: I am not sure about this. I think about it as one of principles / ways how to achieve DIP principle. Instead of calls to specific function in some library, we call some "handler" which will deliver the functionality we need. I also found a description that it is separating "what to do" from "when to do"
- dependency injection: I understand it as one of ways how to implement IoC, such that inject dependencies using constructors, setters etc.
