# Java Swing-I

## Create jar file

```
jar cf <jar file name> <input-files>
```

* for example
```
cd Snake-Game/bin
jar cf snake.jar .
```

* to execute jar file
```
java -jar snake.jar
```

* get Error
```
Johns-MacBook-Pro:bin wangqianjiang$ java -jar snake.jar
no main manifest attribute, in snake.jar
```

## manifest solution

* Create META-INF/MANIFEST.MF
* add the following content to the file
'''
Main-Class: com.huaxia.snake
Class-Path: .; snake.jar
```
* create jar file
```
jar cmvf snake.jar META-INF/MANIFEST.MF
```

