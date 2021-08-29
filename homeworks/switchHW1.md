* Write a Java program to detect key presses.

hint:

```Java

char key='';
try{
    key = (char)System.in.read();
    System.out.println(key);
}catch(IOException e){}

switch(key){

}
```