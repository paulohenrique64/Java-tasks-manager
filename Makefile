build: out/ mytask.jar
	@rm manifest

out/: 
	@javac -cp ./dependencies/picocli-4.7.6.jar:./dependencies/sqlite-jdbc-3.46.0.0.jar:./dependencies/slf4j-api-1.7.36.jar:./src -d ./out/ ./src/main/aplication/MyTask.java

mytask.jar:
	@echo "Main-Class: main.aplication.MyTask" > manifest
	@echo "Class-Path: dependencies/picocli-4.7.6.jar dependencies/slf4j-api-2.0.13.jar dependencies/slf4j-nop-2.0.13.jar dependencies/sqlite-jdbc-3.45.2.0.jar out/" >> manifest
	@jar cfm mytask.jar manifest out/ dependencies/
	
.PHONY: clean
clean:
	@rm -r out/
	@rm mytask.jar
