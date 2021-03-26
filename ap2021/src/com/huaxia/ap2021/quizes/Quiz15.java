package com.huaxia.ap2021.quizes;

public class Quiz15 {

	public static void main(String[] args) {
		question1();
		question2();
		question3();
		question4();
		question5();
	}

	private static void question1() {
		System.out.println("question 1...");
		Book b1 = new Book();
		Book b2 = new Novel();
		Book b3 = new Textbook();
		// (B)
		System.out.println(b1.computeShelfLife());
		System.out.println(b2.computeShelfLife());
		System.out.println(b3.computeShelfLife());
		// (C)
//		System.out.println(b2.myTitle);
//		System.out.println(b3.myTitle);
		// (D)
		
		// (E)
//		b2.readFile();
//		b3.readFile();
		
	}

	private static void question2() {
		System.out.println("question 2...");
		System.out.println("Buttom-up Development.");
		
	}

	private static void question3() {
		System.out.println("question 3...");
		Card card = new Card("HEARTS", 12);
		System.out.println(card);
	}

	private static void question4() {
		System.out.println("question 4...");
		Deck deck = new Deck();
		deck.writeDeck();		
	}

	private static void question5() {
		System.out.println("question 5...");
		int[] arr = {1, -1, 4, 12, 9, 32, -11};
		int min = findMin(arr);
		System.out.println(min);
	}

	public static int findMin(int[] arr )
	{
//	    int min = Integer.MAX_VALUE;
	    int min = arr[0];
	    int index = 0;
	    while (index< arr.length) 
	    {
	        if (arr[index] < min)
	            min = arr[index]; 
	        index++;
	    }
	    return min;
	}
}

class Book{
	private String myTitle;
	private String myAuthor;
		
	public Book() {
		
	}
	public Book(String title) {
		
	}
	protected int computeShelfLife() {
		return 0;
	}
	private void readFile() {
		
	}
}

class Novel extends Book{
	public Novel(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public Novel() {
		// TODO Auto-generated constructor stub
	}

}

class Textbook extends Book{
	public Textbook(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public Textbook() {
		// TODO Auto-generated constructor stub
	}

	private String contents;
	
	@Override
	protected int computeShelfLife() {
		return 1;
	}

}

class Card 
{
    private String mySuit; 
    private int myValue; //O to 12 

    public Card (String suit, int value )
    {
        /* implementation */
    	mySuit = suit; 
        myValue = value; 
    }

    public String getSuit () 
    { return mySuit; } 

    public int getValue()
    { return myValue;}

    public String toString()
    {
        String faceValue = "";
        if (myValue == 11) 
            faceValue= "J" ;
        else if(myValue == 12)
            faceValue= "Q" ;
        else if(myValue == 0)
            faceValue= "K" ;
        else if(myValue == 1)
            faceValue= "A" ;
        if (myValue >= 2 && myValue <= 10)
            return myValue + " of " + mySuit;
        else
            return faceValue + " of " + mySuit;

    }
}

class Deck 
{
    private Card[] myDeck;
    public final static int NUMCARDS = 52;
    private String[] suits = {"SPADES","CLUBS","DIAMONDS","HEARTS"};
    
    public Deck() 
    {
    	myDeck = new Card[NUMCARDS];
    	for(int i=0; i<13; i++) {
    		int j=0;
    		for(String suit: suits) {
    			Card card = new Card(suit, i);
    			myDeck[i*4+j] = card;
    			j++;
    		}
    	}
    }
    
    //Simulate shuffling the deck. 
    public void shuffle () 
    {
        
    }
    //other methods not shown ...

	public Card[] getMyDeck() {
		return myDeck;
	}

	public void writeDeck()
	{
	    /* implementation code */ 
		for (Card card : myDeck) 
		    System.out.println(card);
		
//		for (Card card : myDeck) 
//		    System.out.println((String)card); // card cannot be casted to String
		
	} 

}