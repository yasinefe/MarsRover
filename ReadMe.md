# COMMENTS

I will give some details about this implementation.

- Unit test coverage is %99.
- I used only third party jar such as JUnit and Mockito for unit test.
- If you want to measure unit test coverage you should use 'mvn cobertura:cobertura' command
- I used 'Should' for unit test classes and I configured cobertura to see my test classes in pom.xml
- You can find cobertura coverage report in the RAR file in target folder.

# USAGE

- You can use com.musicqubed.marsrover.Main to try the implementation

# NEW FEATURES CAN BE ADDED

Following feature can be added but I did not.

- I used command pattern, and I separate rover implementation and command pattern via Rover interfaces
- New commands can be added easily,
	- Add new functionality to MarsRover.
	- Create a new command
	- Register it to command executor
	- and just use it.
- I used Command Reader implementation and I give input and output stream from outside(Dependency Injection)
thanks to this, you can use file input stream or socket input stream or output stream. Commands can be feed from file or socket (for example a telnet interface).