import java.util.*;

/**
 * This class is an anagram solver that can take a phrase, then check if there are some
 * words in the dictionary is matched.
 * @author Kit Wong
 */
public class AnagramSolver{

	private List<String> dict;

	/**
	 * This method is the constructor of an anagram solver.
	 * @param list is the given dictionary.
	 */
	public AnagramSolver(List<String> list){
		dict = list;
	}

	/**
	 * This method is printting out the result that match the given phrase.
	 * @param s is the given phrase
	 * @param max is how many words in the phrase
	 * @throws IllegalArgumentException
	 */
	public void print(String s, int max){
		if(max < 0){
			throw new IllegalArgumentException();
		}
		//Initializing the letter inventory of the phrase.
		LetterInventory letterS = new LetterInventory(s);
		//Initializing the result that need to print out.
		List<String> result = new ArrayList<String>();
		//Initializing a list of possible words that match the phrase.
		List<String> possible = getPossible(letterS);
		//Printing all possible orders of possible matched words.
		printAll(max,letterS,possible,result);
	}

	private List<String> getPossible(LetterInventory given){
		List<String> possible = new ArrayList<String>();
		//taking every single word from dictionary
		for(String word: dict){
			LetterInventory letterD = new LetterInventory(word);
			//checking if the phrase contains the word
			if(given.subtract(letterD) != null){
				possible.add(word);
			}
		}
		return possible;
	}

	private void printAll(int max, LetterInventory letterS, List<String> possible, List<String> result){
		//if the phrase letterinventory is empty, print the result
		if(letterS.isEmpty()){
			System.out.println(result);
		}
		//if the max is zero or the result's size is not approch the max, keep checking
		else if(max == 0 || result.size() < max){
			//checking every single word from possible words
			for(String word: possible){
				LetterInventory letterP = new LetterInventory(word);
				//checking if the phrase contains the word
				if(letterS.subtract(letterP) != null){
					result.add(word);
					//initializing a new phrase that exclused the word
					LetterInventory TempLetterP = letterS.subtract(letterP);
					printAll(max, TempLetterP, possible, result);
					result.remove(word);
				}
			}
		}
	}
}








