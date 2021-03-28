# pv260_solid

## Open/Closed Principle
- using the given code and maintaining its "style", I would have to add attributes like JsonFilePath, different constructor and the calling method, change usage of the class in main etc.
- I altered the code, so that there are only attributes type and file

## Liskov principle
- I am not entirely sure about this - by running the main() function, I discovered that CSVSerializer does not satisfy the specification of SimpleSerilizer that says that applying desrialization after serialization should result in the original value 
- in the code, I think that SuperCar is child of Vehicle but does not behave as such - its constructor takes 4 parameters, whereas constructor of vehicle takes only 2 (actually, this was alright in basic Java course, so I am not sure if this is violation) 
