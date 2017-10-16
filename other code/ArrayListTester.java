import java.util.*;

public class ArrayListTester{

	public static void main (String[] args){

		ArrayIntList integer0 = new ArrayIntList();

		integer0.add (14);
		integer0.add (97);
		integer0.add (35);

		System.out.println (integer0);

		ArrayIntList integer1 = new ArrayIntList(20);

		integer1.add (654);
		integer1.add (234);
		integer1.add (463);

		System.out.println (integer1);

	}
}