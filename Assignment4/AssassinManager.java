import java.util.*;

/**
 * This class is the manager of a game named Assassin,
 * it contains two list, one for live people called killring,
 * one for dead people called graveyard.
 * @author Kit Wong
 */
public class AssassinManager{
	private AssassinNode killRing;
	private AssassinNode graveyard;
	private int live;
	private int dead;

	/**
	 * This method is checking is the size of a collection is illegal.
	 * @param x is the collection.
	 * @param size is lower bounded value exclusive of the size.
	 */
	private void sizeCheck(Collection x, int size){
		if(x.size() < size) throw new IllegalArgumentException();
	}

	/**
	 * This method is the constructor.
	 * @param names is a string arraylist of names.
	 */
	public AssassinManager(ArrayList<String> names){
		sizeCheck(names,2);
		live = names.size();
		dead = 0;
		graveyard = new AssassinNode("graveyard",null);
		killRing = new AssassinNode("killRing",null);
		killRing.next = null;
		killRing.next = new AssassinNode(names.get(0),null);
		AssassinNode current = killRing.next;
		current.killer = names.get(live-1);
		for(int i=1; i<live; i++){
			current.next = new AssassinNode(names.get(i),null);
			current = current.next;
			current.killer = names.get(i-1);
		}
		current.next = killRing.next;

	}

	/**
	 * This method is printing the relative between the live people.
	 */
	public void printKillRing(){
		if(live<2) return;
		AssassinNode current = killRing.next;
		for(int i=0; i<live; i++){
			System.out.println("\t"+current.name+" is stalking "+current.next.name);
			current = current.next;
		}
		System.out.println();
	}

	/**
	 * This method is printing the relative between the dead people.
	 */
	public void printGraveyard(){
		if(graveyard.next==null) return;
		AssassinNode current = graveyard.next;
		Stack<AssassinNode> temp = new Stack<AssassinNode>();
		for(int i=0; i<dead; i++){
			temp.push(current);
			current = current.next;
		}
		while(!temp.isEmpty()){
			current = temp.pop();
			System.out.println("\t"+current.name+" was killed by "+current.killer);
		}
		System.out.println();
	}

	/**
	 * This method is checking if the given name is in the killring.
	 * @param name is the name need to check.
	 * @return true if the name is in the killring, otherwise return false.
	 */
	public boolean killRingContains(String name){
		if(live==0) return false;
		AssassinNode current = killRing.next;
		for(int i=0; i<live; i++){
			if(current.name.equalsIgnoreCase(name)) return true;
			current = current.next;
		}
		return false;
	}

	/**
	 * This method is checking if the given name is in the graveyard.
	 * @param name is the name need to check.
	 * @return true if the name is in the graveyard, otherwise return false.
	 */
	public boolean graveyardContains(String name){
		if(graveyard.next==null) return false;
		AssassinNode current = graveyard.next;
		for(int i=0; i<dead; i++){
			if(current.name.equalsIgnoreCase(name)) return true;
			current = current.next;
		}
		return false;
	}

	/**
	 * This method is checking if the game is finished.
	 * @return true if the game is finished, otherwise reture false.
	 */
	public boolean isGameOver(){
		if(live==1) return true;
		return false;
	}

	/**
	 * This method is getting the winner's name when the game is over.
	 * @return the winner's name.
	 */
	public String winner(){
		if(isGameOver()) return killRing.next.name;
		return null;
	}

	/**
	 * This method is killing (kick out from the killring,
	 * and to be in the graveyard) a person who match the given name.
	 * @param name is the name need to be killed.
	 */
	public void kill(String name){
		if(isGameOver()) throw new IllegalStateException();
		if(!killRingContains(name)) throw new IllegalArgumentException();
		AssassinNode current = killRing.next;
		for(int i=0; i<live; i++){
			if(name.equalsIgnoreCase(current.next.name)){
				AssassinNode temp = current.next;
				current.next = temp.next;
				temp.next.killer = current.name;
				if(temp.name == killRing.next.name) killRing.next = temp.next;
				current = graveyard;
				for(int j=0; j<dead; j++) current = current.next;
				current.next = temp;
				current.next.next = null;
				dead++;
				live--;
				return;
			}
			current = current.next;
		}
	}
}
