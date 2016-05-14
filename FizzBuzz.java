package testing;
import java.util.*;


public class FizzBuzz {
	void fizzBuzz(int n) {
	  ArrayList<String> result = new ArrayList<>();
	  for (int i = 1; i <= n; i++) {
	    if (i % 3 == 0 && i % 5 == 0) {
	      result.add("fizz buzz");
	    }
	    else if (i % 3 == 0) {
	      result.add("fizz");
	    }
	    else if (i % 5 == 0) {
	      result.add("buzz");
	    }
	    else {
	      result.add(Integer.toString(i));
	    }
	  }
	  System.out.println(result);  
	}

	public static void main(String[] args) {
		Integer n = 15;
		FizzBuzz S = new FizzBuzz();
		S.fizzBuzz(n);
		List<List<String>> list = new ArrayList<>();
	}
}

