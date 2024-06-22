build:
	javac -classpath ./src/dependencies/sqlite-jdbc-3.45.2.0.jar:./src/dependencies/slf4j-api-2.0.13.jar:./src/dependencies/slf4j-nop-2.0.13.jar:./src/dependencies/picocli-4.7.6.jar:./src -d ./out src/main/aplication/MyTasks.java

run: 
	java -classpath ./src/dependencies/sqlite-jdbc-3.45.2.0.jar:./src/dependencies/slf4j-api-2.0.13.jar:./src/dependencies/slf4j-nop-2.0.13.jar:./src/dependencies/picocli-4.7.6.jar:./out main.aplication.MyTasks $(PARAM)

.PHONY: clean
clean:
	rm -rf ./out
