package monad;

import java.util.Optional;

public class OptionalTest {
	public static Optional<Integer> optionalAdd(Optional<Integer> val1, Optional<Integer> val2) {
	    if(val1.isPresent() && val2.isPresent()) {
	        return Optional.of(val1.get() + val2.get());
	    }
	  
	    return Optional.empty();
	}
	
	public static void main(String[] args) {
		Optional<Integer> i1 = Optional.of(1);
		Optional<Integer> i2 = Optional.of(1);
		Optional<Integer> o = optionalAdd(i1, i2);
		System.out.println(o);
		
	}

}
