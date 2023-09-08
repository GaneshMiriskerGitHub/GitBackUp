package package1;

import java.util.ArrayList;
import java.util.List;

public class Tester {

	public static void main(String[] args) {
		
		List<String> names=new ArrayList<String>();
		names.add("Jack");
		names.add("John");
		names.add("Jill");
		names.add("Jim");
		names.add("Garry");
		names.add("Frank");
		
		names.stream()
		     .filter(ele ->   ele.charAt(0) == 'J' && ele.length() == 4 )
		     .forEach(ele -> System.out.println(ele));

	}

}
