import java.util.*;

public class test{
	public static void main (String[]args){

		Stack<String> words = new Stack<String>();
		words.push ("this");
		words.push ("is");
		words.push ("a");
		words.push ("sentence");
		Stack<String> temp = (Stack<String>)words.clone();
		System.out.println(temp);
		System.out.println(words);
		String theTop = words.pop();
		System.out.println (theTop);
		System.out.println(words);
		theTop = words.peek();
		System.out.println(theTop);
		System.out.println(words);
		int theSize = words.size();
		System.out.println("The stack has " + theSize + " elements");

		Queue<String> requests = new LinkedList<String>();
		requests.add("Clean the kitchen");
		requests.add("Fix the garage door");
		requests.add("Water the plants");

		String theFront = requests.peek();
		System.out.println("The front item, is: " + theFront);

		System.out.println(Pitch.valueOf("R"));

		Queue<String> a = new LinkedList<String> (requests);
		System.out.println(a);
		//Queue<String> b = (Queue<String>)requests.clone();
		//System.out.println(b);

		Note r = new Note(2,Pitch.valueOf("C"),false);
		if (r.note.equals(Pitch.R)) {
			System.out.println("true");
		}
		else System.out.println("false");
	}
}