# Question 4 Implementation

1. SeatingChart constructor 1

    Assign random name list to two dimensional array seat location.

2. SeatingChart constructor 2

    Assign given name array to random seat location.

    ```java
        int count = 0;
        int i = (int) (Math.random() * names.length);
        int row = i / c; // one random number determine one seat location
        int col = i % c; 
        int randomTimes=1;
        while (count < names.length) {
            while (!chart[row][col].equals("")) {
                i = (int) (Math.random() * names.length);
                row = i / c;
                col = i % c;
                randomTimes++;
            }
            chart[row][col] = names[count].getLastName() + ", " + names[count].getFirstName();
            count++;
        }

    One random number determine one seat location

    |row | col1 | col2 | col3|
    |--- |---   |---   |---  |
    | 0  |  0   |  1   |  2  |   
    | 1  |  3   |  4   |  5  |
    | 2  |  6   |  7   |  8  |
    | 3  |  9   | 10   | 11  |
    ```

3. SeatingChart constructor 3

    Assign given name array to random seat location.

    ```java
        for (int i = 0; i < names.length; i++) {
            randomTimes+=2;
            int row = (int) (Math.random() * r); // 2 random number determine one seat location
            int col = (int) (Math.random() * c);
            if (chart[row][col].length() == 0) {
                chart[row][col] = names[i].toString();
            } else {
                i--;
            }
        }
    
	Fred, Fitzgerald    Lois, Lane          Ali, Dade           
	Jane, Brne          Greg, Georgian      Minnie, Miller      
	Tim, Titon          Boris, Banner                           
                        Robbie, Robilard    Inde, Indigo        
 
   ```
