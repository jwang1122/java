# AP Computer Science Prep - Question Catagory - method

|Catagory | Questions in 40 | Percentage
|---      |---              |---         |
|datatype |2                |5%
|operator |3                |7.5%
|if-else  |5                |12.5%
|loop     |16               |40%
|method   |14               |35%

Questions related to **method** can be divided by 
* method signature
* recursion call
* pass by reference
* constructor


1. Determine output of the following code.

	```java
		public static void swap(String s1, String s2) {
			String hold = s1;
			s1 = s2;
			s2 = hold;
		}
		
		public static void main(String[] args) {
			String animal1 = "elephant";
			String animal2 = "lion";
			swap(animal1, animal2);
			animal1.toUpperCase();
			animal2.toUpperCase();
			System.out.println(animal1 + " " + animal2);
		}
	```

	```
	(A) elephant lion
	(B) ELEPHANT LION
	(C) lion elephant
	(D) LION elephant
	(E) LION ELEPHANT
	```

	Question 5-6 refer to the Constellation class below:

	```java
	public class Constellation {
		private String name;
		private String month;
		private int northernLatitude;
		private int southernLatitude;
		
		
		public Constellation(String name, String month) {
			super();
			this.name = name;
			this.month = month;
			northernLatitude = 0;
			southernLatitude = 0;
		}
		
		public Constellation(String name, String month, int northernLatitude, int southernLatitude) {
			super();
			this.name = name;
			this.month = month;
			this.northernLatitude = northernLatitude;
			this.southernLatitude = southernLatitude;
		}

		public void chgMonth(String m) {
			String month = m;
		}
	}
	```

1. Using Constellation class, which of the following will cause compiler error?

	```
	(A) Constellation c1 = new Constellation("Hercules", "July");
	(B) Constellation c2 = new Constellation("Pisces", "Nov", 90, 65);
	(C) Constellation c3 = new Constellation("Aquarius", "Oct", 65.0, 9.0);
	(D) Constellation c4 = new Constellation("Leo", "4", 0, 0);
	(E) Constellation c5 = new Constellation("Phoenix", "Nov", 32, 90);
	```

1. A programmer has attempted to add three mutator methods to use Constellation class.

	I: 

	```java
		public void chgLatitude(String direction, int latitude) {
			if(direction.toUpperCase().equals("N")) {
				this.northernLatitude = latitude;
			}else if(direction.toUpperCase().equals("S")) {
				this.southernLatitude = latitude;			
			}
		}

	```
	II:

	```java
		public void chgLatitude(int northLatitude, int southLatitude) {
				this.northernLatitude = northLatitude;
				this.southernLatitude = southLatitude;			
		}
	```
	III.

	```java
		public void chgLatitude(double northLatitude, double southLatitude) {
				this.northernLatitude = (int)northLatitude;
				this.southernLatitude = (int)southLatitude;			
		}
	```

	which of the three will compile without compiler error?

	```
	(A) I only
	(B) II only
	(C) III only
	(D) I and II only
	(E) I, II and III
	```
1. Given the following code except for the Tile Class:

	```java
	public class Tile {
		private int styleNumber;
		private String color;
		private double width;
		private double height;
		private String material;
		private double price;
		
		Tile(int style, String col){
			styleNumber = style;
			color = col;
		}
		
		Tile(int style, String col, double w, double h, String mat, double price){
			styleNumber = style;
			color = col;
			width = w;
			height = h;
			material = mat;
			price =price;
		}
		
		Tile(int style, String col, String mat, double price){
			styleNumber = style;
			color = col;
			material = mat;
			price =price;		
		}
		
		public void chgMaterial(String mat) {
			String material = mat;
		}
		
		public String toString() {
			return (styleNumber + " " + color + " " + width + " " + height + " " + material + " " + price);
		}
	```
	What is the output after the following client code is executed?
	```java
		Tile t1 = new Tile(785, "grey", "ceramic", 6.95);
		t1.chgMaterial("marble");
		System.out.println(t1.toString());
	```
	```
	(A) Tile@5ccd43c2
	(B) 785 grey 0.0 0.0 marble 0.0
	(C) 785 grey 0.0 0.0 ceramic 0.0
	(D) 785 grey 0.0 0.0 ceramic 6.95
	(E) 785 grey 0.0 0.0 marble 6.95
	```
1. What is the output after the followingclient code is executed?

	```java
		Tile t2 = new Tile(101, "blue");
		System.out.print(t2);
	```
	```
	(A) Tile@5ccd43c2
	(B) 785 blue 0.0 0.0 null 0.0
	(C) Type mismatch error
	(D) NullPointerException
	(E) There will be no output; the program will not compile
	```
1. The Tile Class is going to be used for an application built for a small independent tile store. The owner wants the programmer to add a field for the number of unopened boxes of tile he has for each style of tile he has in stock and a method to change the value. What would be the proper declaration for this field?

	```java
	(A) public static int inventory;
	(B) private static double inventory;
	(C) final int inventory;
	(D) private int inventory;
	(E) private int [] inventory;
	```
1. A programmer has written two different methods for a client program to swap the elements of one array with those of another array.

	```java
		public static void swap1(int[] a1, int[] a2) {
			for (int i=0; i< a1.length; i++) {
				int arrhold = a1[i];
				a1[i] = a2[i];
				a2[i] = arrhold;
			}
		}
		
		public static void swap2(int[] a1, int[] a2) {
			int[] arrhold = a1;
			a1 = a2;
			a2 = arrhold;
		}
	```
	Which of the following statements best reflects the outcome of the two methods?

	(A) Both methods will swap the contents of the two arrays correctly in all cases.

	(B) swap1 will swap the contens of the two arrays correctly only if both arrays have the same munber of elements whereas swap2 will work correctly for all cases.

	(C) swap1 will only swap the contents of the two arrays correctly if both arrays have the same number of elements, whereas swap2 will never work correctly.

	(D) swap1 will only swap the contents of the two arrays correctly if both arrays have the same number of elements or a2 has more elements, whereas swap2 will work correctly for all cases.
	
	(E) Neither method will swap the contents of the two arrays correctly under any condition.

	Questions 33-34 refer to the Percussion and Xylophone class below. 

	```java
	public class Percussion {
		private String name;
		private double weight;

		Percussion() {

		}

		Percussion(String n, double w) {
			name = n;
			weight = w;
		}

		public String getName() {
			return name;
		}

		public double getWeight() {
			return weight;
		}
	}

	public class Drums extends Percussion {

	}

	public class Xylophone extends Percussion{
		private int numberOfKeys; 
		Xylophone (String name, double weight, int numberOfKeys) {
			//<missing code>
		}
		
		public int getNumberOfKeys() {
			return numberOfKeys;
		}
	}
	```
1. Which of the following is the most appropriate replacement for <missing code> in the Xylophone constructor?

	```java
	(A) this.numberOfKeys = numberOfKeys;
		super (name, weight);
	(B) super (name, weight);
		this.numberOfKeys = numberOfKeys;
	(C) super (name, weight);
		numberOfKeys = this.numberOfKeys;
	(D) this.numberOfKeys = numberOfKeys;
	(E) numberOfKeys = this.numberOfKeys;
	```
1. Assuming the above classes compile correctly, which of the following will not compile within a client program?

	```java
	(A) Xylophone [] xylophones = new Xylophone [5]; 
	(B) Percussion [] xylophones = new Xylophone [5]; 
	(C) Xylophone x1 = new Xylophone ("xylophone", 65, 32) ; 
		System.out.println(x1.getNumKeys()); 
	(D) Xylophone x2 = new Xylophone ("xylophone", 65, 32); 
		System.out.println(x2.numberOfKeys); 
	(E) Drums[] drums;
	```
1. A client program wishes to compare the two xylophone objects as follows: 

	```java
	Xylophone x2 = new Xylophone ("xylophone", 80, 32) ; 
	Xylophone X3 = new Xylophone ("xylophone", 65,	32);
	```
	The two objects should be considered “equally heavy’' if and only if they have the same weight. Which of the following code excerpts accomplishes that task? 
	```java
	(A) if (x2.weight==x3.weight)
			System.out.println ("equally heavy") ; 
		else
			System.out.println ("not equally heavy");
	(B) if (x2.weight()==x3.weight())
			System.out.println ("equally heavy") ; 
		else
			System.out.println ("not equally heavy");
	(C) if (x2.getWeight()==x3.getWeight())
			System.out.println ("equally heavy") ; 
		else
			System.out.println ("not equally heavy");
	(D) if (x2.weight.equals(x3.weight)
			System.out.println ("equally heavy") ; 
		else
			System.out.println ("not equally heavy");
	```
	(E) The weight of each object cannot be compared.

	Questions 36-37 refer to the following classes. 

	```java
	public class Dog {
		private int height; 
		private String size; 
		private String color; 
		Dog (int iheight, int iweight, String icolor) {
			height = iheight; 
			color = icolor;
			if (iweight >= 65)
				size = "large" ; 
			else 
				size = "medium" ;
		}
		public int getHeight() { return height; } 
		public String getSize() { return size;}
		public String getColor() {return color; } 
		public String toString () {return "        color is: "+ color;}
	}

	public class SportingDog extends Dog {
		private String purpose; 
		SportingDog (int h, int w, String c) {
			super (h, w, c);
			purpose = "hunting";
		}
		public String getPurpose() {
			return purpose;
		}
		
	}

	public class Retriever extends SportingDog {
		private String type;
		Retriever (String itype, String icolor, int iweight) {
			super(24, iweight, icolor); 
			type = itype; 
		}
		public String toString () {return "type: " + type + super.toString(); }
	}
	```
1. Which of the following declarations will not compile?

	```java
	(A) Dog d1 = new SportingDog (30 , 74 , "Black"); 
	(B) Dog d2 = new Retriever("Labrador", "Yellow", 75) ; 
	(C) SportingDog d3 = new Retriever ("Golden", "Red", 70);
	(D) SportingDog d4 = new Dog (25, 80, "Bed");
	(E) Retriever d5 = new Retriever ("Golden", "Blonde", 60 ) ;
	```
1. VVhat is the output after the execution of the following code in the client program: 

	```java
		Dog mason = new Retriever ("Labrador", "chocolate", 85);
		System.out.println (mason.toString());
	```
	```
	(A) type: Labrador 
	(B) type: Labrador	color is: chocolate   purpose: hunting
	(C) color is: chocolate  type: Labrador 
	(D) type: Labrador purpose: hunting color is: chocolate 
	(E) type: Labrador 	color is: chocolate 
	```
1. The following pow method was written to return b raised to the xth power where x > 0, but it does not work properly. Choose the changes to the method below to work properly.

	```java
	1	public double pow (double b, int x) 
	2	{
	3		if (x==0) 
	4			return 0; 
	5		else
	6			return b + pow (b, x-1); 
	7	}
	```
	``` No answer is correct
	(A) Change lines 3 and 4 to: 
	3 	if (x=-l) 
	4		return 1; 
	(B) Change lines 3 and 4 to: 
	3 	if (x=-l) 
	4		return b; 
	(C) Change line 6 to: 
	6 		return b * mystery(b, x-1);
	(D) Both (A) and (C) 
	(E) Both (B) and (C) 
	```
1. What is output given the following code excerpt? 

	```java
		public static int f (int n) {
			if (n==0)
				return 0;
			else 
				return f(n/10) + n % 10; 
				
		}
		System.out.println(f(8765));
	```
	```
	(A) 5678 
	(B) 8765 
	(C) 58 
	(D) 26 
	(E) A run-time error 
	```



