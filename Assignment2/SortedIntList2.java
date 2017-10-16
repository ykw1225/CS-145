import java.util.*;

public class SortedIntList{

	private static final int DEFAULT_CAPACITY = 100;
	private int[] intList;
	private int size;
	private boolean unique;

	//public SortedIntList (){
		intList = new int[DEFAULT_CAPACITY];
		size = 0;
		unique = true;
	}

	//public SortedIntList (int capacity){
		if (capacity < 0){
			throw new IllegalArgumentException ("capacity: " + capacity);
		}
		intList = new int[capacity];
		size = 0;
		unique = true;
	}

	//public SortedIntList (boolean unique){
		intList = new int[DEFAULT_CAPACITY];
		size = 0;
		this.unique = unique;
	}

	//public SortedIntList (boolean unique, int capacity){
		if (capacity < 0){
		throw new IllegalArgumentException ("capacity: " + capacity);
		}
		intList = new int[capacity];
		size = 0;
		this.unique = unique;
	}

	//public int min (){
			isEmpty ();
			return intList[0];
	}

	//public int max (){
		isEmpty ();
		return intList[size-1];
	}

	//public boolean getUnique (){
		return unique;
	}

	//public void setUnique (boolean value){
		unique = value;
		if (unique){
			for (int i=0; i < size; i++){
				if (intList[i] == intList[i+1]){
					remove(i);
					i--;
				}
			}
		}
	}

	//public int size (){
		return size;
	}

	//public int get (int index){
		checkIndex (index);
		return intList[index];
	}

	//public void set (int index, int num){
		checkIndex (index);
		if (unique){
			if (contains (num)){
				return;
			}
		}
		intList[index] = num;
	}

	//public String toString (){
		String result = "[";
		if  (size > 0){
			for (int i = 0; i < size-1; i++){
				result += intList[i] + ", ";
			}
			result += intList[size-1] + "]";
		}
		else{
			result += intList[0] + "]";
		}
		return result;
	}

	//public int indexOf (int num){
			return Arrays.binarySearch (intList, 0, size, num);
	}

	//public boolean isEmpty (){
		return size == 0;
	}

	//public boolean contains (int num){
		for (int i = 0; i < size; i++){
			if (intList[i] == num){
				return true;
			}
		}
		return false;
	}

	//public void add (int num){
		if (unique){
			if (contains (num)){
				return;
			}
		}
		if (isEmpty()){
			intList[size] = num;
			size++;
			return;
		}
		else{
			if (!contains (num)){
				add (Arrays.binarySearch (intList, 0, size, num) * -1 - 1, num);
			}
			else{
				add (Arrays.binarySearch (intList, 0, size,num), num);
			}
		}
	}

	//public void add (int index, int num){
		checkIndex (index);
		if(index != size){
			for (int i = size-1; i >= index; i--){
				intList[i+1] = intList[i];
			}
		}
		intList[index] = num;
		size++;
	}

	//public void clear (){
		size = 0;
	}

	public void ensureCapacity (int capacity){
		if (capacity > intList.length){
			int newCapacity = intList.length * 2 + 1;
			if (capacity > newCapacity){
				newCapacity = capacity;
			}
			intList = Arrays.copyOf (intList, newCapacity);
		}
    }


    //public void remove (int index){
		checkIndex (index);
		for (int i = index; i < size; i++){
			intList[i] = intList[i+1];
		}
		size--;
		intList[size] = 0;
	}

	//private void checkIndex (int index){
		if (index < 0 || index > size){
			throw new ArrayIndexOutOfBoundsException (index);
		}
	}
}