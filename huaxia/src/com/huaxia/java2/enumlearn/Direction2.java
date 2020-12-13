package com.huaxia.java2.enumlearn;
// Define function in each enum fields

public enum Direction2 {
    // enum fields
    EAST {
        @Override
        public String printDirection() {
            String message = "You are moving in east. You will face sun in morning time.";
            return message;
        }
    },
    WEST {
        @Override
        public String printDirection() {
            String message = "You are moving in west. You will face sun in evening time.";
            return message;
        }
    },
    NORTH {
        @Override
        public String printDirection() {
            String message = "You are moving in north. You will face head in daytime.";
            return message;
        }
    },
    SOUTH {
        @Override
        public String printDirection() {
            String message = "You are moving in south. Sea ahead.";
            return message;
        }
    };
 
    public abstract String printDirection();
    
	public static void main(String[] args) {
		System.out.println(WEST.printDirection());
	}
}
