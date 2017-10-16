import java.util.*;
public class Test {
	public static void main(String[] args) {
		LetterInventory li = new LetterInventory("abc");
		LetterInventory li1 = new LetterInventory("efg");
		LetterInventory li2 = new LetterInventory("ae");
		System.out.println(li);
		System.out.println(li.get('a'));
		System.out.println(li.isEmpty());
		System.out.println(li.size());
		li.set('d',2);
		System.out.println(li);
		li = li.subtract(li2);
		System.out.println(li);
	}
}


public void print(String s, int max){
		if(max < 0){
			throw new IllegalArgumentException();
		}
		LetterInventory letterS = new LetterInventory(s);
		Queue<String> possible = new LinkedList<String>();
		List<String> result = new ArrayList<String>();
		//take every possible words in the dict
		for(String word: dict){
			LetterInventory letterD = new LetterInventory(word);
			//check if the given s contains word
			if(letterS.subtract(letterD) != null){
				possible.add(word);
			}
		}
		//print the result
		printAllOrder(result, possible, letterS, max);
	}
	private void printAllOrder(List<String> result, Queue<String> possible,
								LetterInventory letterS, int max){
		if(letterS.isEmpty()){
			System.out.println(result);
		}
		else if(max ==0 || max > result.size()){
			for(String word: possible){
				LetterInventory letterP = new LetterInventory(word);
				if(letterS.subtract(letterP) != null){
					result.add(word);
					LetterInventory newLetterS = letterS.subtract(letterP);
					printAllOrder(result, possible, newLetterS, max);
					result.remove(word);
				}
			}
		}
	}