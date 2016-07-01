COMMENTS
--------------------------------
I will give some dteails about this implementation.

- I spend almost 10 hours for this implementation.
- Unit test coverage is %99.
- I used only third party jar such as JUnit and Mockito for unit test.
- If you want to measure unit test coverage you should use 'mvn cobertura:cobertura' command
- I used 'Should' for unit test classes and I configured cobertura to see my test classes in pom.xml
- You can find cobertura coverage report in the RAR file in target folder.

USAGE
--------------------------------
- You can use com.musicqubed.marsrover.Main to try the implementation

ASSUMPTIONS
--------------------------------
I did some assumptions

- Logging should have been done but I did not use log4j or something else for logging and I did not write any log.
- Normally, I develop unit tests and write the implementation and watch the logs if logs are enough.
- I wrote integration test as unit test. I know that integration tests must be written with a BDD framework such as JBehave, Spock, Cucumber or a scripting language from outside such as Ruby, Groovy, I want to keep simple for this case.
- In addition, integration test must be run from outside like blackbox testing but we have no interface. Of course this is not an application or service this is a simple module.

NEW FEATURES CAN BE ADDED
--------------------------------
Following feature can be added but I did not.

- I used command pattern, and I separate rover implementation and command pattern via Rover interfaces
- New commands can be added easily,
	- Add new functionality to MarsRover.
	- Create a new command
	- Register it to command executor
	- and just use it.
- I used Command Reader implementation and I give input and output stream from outside(Dependency Injection)
thanks to this, you can use file input stream or socket input stream or output stream. Commands can be feed from file or socket (for example a telnet interface).