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

