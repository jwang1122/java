# Java Swing-I

## 2020-09029
* OpenWindow.java
* AddButton.java // anonymous class
* GetInfo.java //interface
* Student.java // implements GetInfo
* StudentTest.java // test student  
    1. normal interface
    1. named class
    1. anonymous class
* Create Teacher.java // implements GetInfo
* Create Manager.java // implements GetInfo
* Create School.java // implements GetInfo
* AddButtonWithAction.java // extends JFrame
* AddTextField.java
* AddLabel.java
* Frame2.java // extends JFrame and add TextField
* ImageButton.java
* Math1.java
* MoveImage.java + MyPanel1 //
* KeyboardControljava.java + MyPanel2



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


