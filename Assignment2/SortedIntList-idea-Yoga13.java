
import java.util.*;

/**
 * This class represents a integer array list which is sorted.
 * @author Kit Wong
 */
public class SortedIntList {
	public static final int DEFAULT_CAPACITY = 10;
	private int[] intList;
	private int size;
	private boolean unique;

	/**
	 * This method is the constructor with no param.
	 */
	public SortedIntList () {
		intList =  new int[DEFAULT_CAPACITY];
		size = 0;
		unique = true;
	}

	/**
	 * This method is the constructor.
	 * @param unique is the switch of that if the unique is on or off.
	 */
	public SortedIntList (boolean unique) {
		intList = new int[DEFAULT_CAPACITY];
		size = 0;
		this.unique = unique;
	}

	/**
	 * This method is the constructor.
	 * @param capacity is the capacity of the list.
	 */
	public SortedIntList (int capacity) {
		checkCapacity (capacity);
		intList = new int[capacity];
		size = 0;
		unique = true;
	}

	/**
	 * This method is the constructor.
	 * @param unique is the switch of that if the unique is on or off.
	 * @param capacity is the capacity of the list.
	 */
	public SortedIntList (boolean unique, int capacity) {
		checkCapacity (capacity);
		intList = new int[capacity];
		size = 0;
		this.unique = unique;
	}

	/**
	 * This method is checking if the capacity is full.
	 */
	private void enoughCapacity () {
		if (size == intList.length) {
			ensureCapacity (intList.length * 2);
		}
	}

	/**
	 * This method is to make sure the capacity is not less than zero.
	 * @param capacity is the capacity need to check.
	 */
	private void checkCapacity (int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException ("capacity: " + capacity);
		}
	}

	/**
	 * This method is to make sure the index is in the range of the list.
	 * @param index is the index need to check.
	 */
	private void checkIndex (int index) {
		if (index < 0 || index > size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
	}

	/**
	 * This method is checking if the list is empty.
	 * @return return true if the list is empty, otherwise return false.
	 */
	private boolean isEmpty() {
		return size == 0;
	}

	/**
	 * This method is adding a integer number into the list at a specific position.
	 * @param index is the position need to add the number.
	 * @param num is the number need to add.
	 */
	private void add (int index, int num) {
		checkIndex (index);
		enoughCapacity ();
		if (index != size){
			for (int i = size-1; i >= index; i--) {
				intList[i+1] = intList[i];
			}
		}
		intList[index] = num;
		size++;
	}

	/**
	 * This method is adding a integer number into the list.
	 * @param num is the number need to add.
	 */
	public void add (int num) {
		if (unique && contain(num)) return;
		if (isEmpty ()) {
			intList[size] = num;
			size++;
			return;
		}
		else if (!contain(num)) {
			add (Arrays.binarySearch (intList, 0, size, num) * -1 -1, num);
		}
		else {
			add (Arrays.binarySearch (intList, 0, size, num), num);
		}
	}

	/**
	 * This method is deleting a number from the list at a specific position.
	 * @param index is the position of the number need to delete.
	 */
	public void remove (int index) {
		checkIndex (index);
		for (int i = index; i<size-1; i++){
			intList[i] = intList[i+1];
		}
		intList[size-1] = 0;
		size--;
	}

	/**
	 * This method is deleting all numbers from the list.
	 */
	public void clear () {
		size = 0;
	}

	/**
	 * This method is checking if the list contains the specific number.
	 * @param num is the number need to check.
	 * @return return true if the list contains the number, otherwise return false.
	 */
	public boolean contain (int num){
		int index = Arrays.binarySearch(intList, 0, size, num);
		if (index < 0) return false;
		return true;
	}

	/**
	 * This method is checking what the index of a specific number is.
	 * @param num is the number need to check.
	 * @return return the index of the number, otherwise return negative one.
	 */
	public int indexOf (int num){
		if (contain (num)) return Arrays.binarySearch (intList, 0, size, num);
		return -1;
	}

	/**
	 * This method is checking what the smallest number in the list is.
	 * @return return the smallest number.
	 */
	public int min () {
		isEmpty ();
		return intList[0];
	}

	/**
	 * This method is checking what the biggest number in the list is.
	 * @return return the biggest number.
	 */
	public int max () {
		isEmpty ();
		return intList[size-1];
	}

	/**
	 * This method is checking if the unique switch is on or not.
	 * @return return true if unique is on, otherwise return false.
	 */
	public boolean getUnique () {
		return unique;
	}

	/**
	 * This method is setting the unique switch.
	 * @param value is the value that user want the unique to be.
	 */
	public void setUnique (boolean value) {
		unique = value;
		for (int i=0; unique && i<size-1 && size>1 ; i++) {
			if (intList[i] == intList[i+1]){
				remove(i);
				i--;
			}
		}
	}

	/**
	 * This method is checking how many numbers in the list are..
	 * @return return the quantity of number in the list.
	 */
	public int size () {
		return size;
	}

	/**
	 * This method is checking what is the number at the specific position.
	 * @param index is index(position) need to check.
	 * @return return the number at that index.
	 */
	public int get (int index) {
		checkIndex (index);
		return intList[index];
	}

	/**
	 * This method is checking how big the space of the list is.
	 * @return return the capacity of the list.
	 */
	public int capacity () {
		return intList.length;
	}

	/**
	 * This method is printing all the numbers in the list.
	 * @return a string that inclued all the numbers in the list.
	 */
	public String toString (){
		if (isEmpty()) return "[]";
		String result = "[";
		for (int i = 0; i < size-1; i++){
			result += intList[i] + ", ";
		}
		result += intList[size-1] + "]";
		return result;
	}

	/**
	 * This method is making the capacity bigger when there is not enough space to store number.
	 * @param capacity is the capacity need to check.
	 */
	public void ensureCapacity (int capacity) {
		if (capacity > intList.length) {
			int newCapacity = intList.length * 2 +1;
			if (capacity > newCapacity) {
				newCapacity = capacity;
			}
			intList = Arrays.copyOf (intList, newCapacity);
		}
	}
}