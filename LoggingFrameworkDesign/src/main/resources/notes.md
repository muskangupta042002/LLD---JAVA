## **Requirements**
- should be able to log in more than one place like console, Log file, database, etc.
- should be able to log multiple category of messages like INFO, DEBUG, ERROR etc.
- category and place of logging should be configurable

### **Components Involved**
- Logger: which will be exposed to the application
- Category: this should be selected at run time based on some parameter
- Sink: this should be selected at run time based on some parameter or config file we provide

**Tips**
- try to follow SOLID principles
- relate to some design pattern

**How to choose design pattern**
- creational : enum for info, error, debug i.e. singleton instance of all of these to avoid multiple instance creation(tedious in multithreading application)  and same goes for sink, logger
- sink : factory pattern use for creating object later
- hierarchy : chain of responsibility(if showing info wont be able to show error and debug, if error able to show info and error but not debug and so.on)