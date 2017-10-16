import java.util.*;

/**
 * This class is a grammar solver that can take some grammar rules, then making
 * some random symbols, words, phrase, or sentence.
 * @author Kit Wong
 */
public class GrammarSolver{

	private Map<String,String> map;

	/**
	 * This method is the constructor of a grammarsolver object.
	 * @param rules is a string list which contains a bounch of grammar rules.
	 * @throws IllegalArgumentException
	 * @throws IllegalArgumentException
	 */
	public GrammarSolver(List<String> rules){
		//checking if the list is null or empty size.
		if(rules == null || rules.size() == 0){
			throw new IllegalArgumentException();
		}
		//initializing the map as a hashMap.
		map = new HashMap<String, String>();
		for(int i = 0; i < rules.size(); i++){
			//spliting each elements in the rules with "::=", and
			//		saving it into a string array.
			String[] line = rules.get(i).split("::=");
			//checking if the rules contains more than one same nonTerminal.
			if( map.keySet().contains(line[0])){
				throw new IllegalArgumentException();
			}
			//puting both the first element of the array as the key, and
			//		the second element as the value into the map.
			map.put(line[0], line[1]);
		}
	}

	/**
	 * This method is checking if the given symbol is a nonTerminal.
	 * @param symbol is the symbol need to check.
	 * @return true if the given symbol is a nonTerminal, otherwise return false.
	 * @throws IllegalArgumentException
	 */
	public boolean contains(String symbol){
		if(symbol == null || symbol.length() == 0){
			throw new IllegalArgumentException();
		}
		return map.keySet().contains(symbol);
	}

	/**
	 * This method is return a string set that contains all nonTerminals in the map.
	 * @return the string set that contains all nonTerminals.
	 */
	public Set<String> getSymbols(){
		return  map.keySet();
	}

	/**
	 * This method is generating a string which depends on given symbol.
	 * @param symbol is a given string symbol
	 * @return a generated string by using the symbol to go through the rules.
	 * @throws IllegalArgumentException.
	 */
	public String generate(String symbol){
		//initializing a string that will return as the result
		String result = "";
		if(symbol == null || symbol.length() == 0){
			throw new IllegalArgumentException();
		}
		//if the symbol is not an nonTerminal, return the symbol itself.
		if(!contains(symbol)){
			return symbol + " ";
		}else{  //if the symbol is an nonTerminal, do something.
			//initializing a string to save the terminal of the symbol.
			String terminal = map.get(symbol);
			//initializing a string array to save the nonTerminals because
			//		sometimes the terminal is a group of nonTerminals.
			String[] tempNonTerminals;
			Random rand = new Random();
			//if the terminal has "|", then split it, and choose one randomly.
			if(terminal.contains("|")){
				tempNonTerminals = terminal.split("[|]");
				terminal = tempNonTerminals[rand.nextInt(tempNonTerminals.length)];
			}
			//if the terminal has tab in it, delete tabs.
			if(terminal.contains("\t")){
				terminal = terminal.replaceAll("\t","");
			}
			//if the terminal has space in it, split it,
			//		and use each elements as a symbol to run this generate method again.
			if(terminal.contains(" ")){
				//deleting the spaces before and after the terminals to avoid when
				//		spliting terminal with space the array will have empty element.
				terminal.trim();
				//spliting the terminal with space.
				tempNonTerminals = terminal.split("[ ]+");
				//using each elements as a symbol to run this generate method again.
				for(int i = 0; i < tempNonTerminals.length; i++){
					if(tempNonTerminals[i] != null && tempNonTerminals[i].length() > 0){
						result += generate(tempNonTerminals[i]);
					}
				}
			}
			//if the terminal has no space in it,
			//		just run generate method by using the terminal as the symbol.
			else{
				if(terminal != null && terminal.length() > 0){
					result += generate(terminal);
				}
			}
		}
		return result;
	}
}
