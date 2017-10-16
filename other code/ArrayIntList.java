

public class ArrayIntList{

	private static final int DEFAULT_CAPACITY = 10;
	private int[] intList;
	private int size;

	public ArrayIntList(){
		size = 0;
		intList = new int[DEFAULT_CAPACITY];
	}

	public ArrayIntList(int CAPACITY){
		size = 0;
		intList = new int[CAPACITY];
	}

	private void checkIndex(int index){
		if(index < 0 || index >= size){
			throw new ArrayIndexOutOfBoundsException(index);
		}
	}

	public void add(int num){
		intList[size] = num;
		size++;
	}

	public void add(int index, int num){
		checkIndex(index);
		for(int i = size-1; i >= index; i--){
			intList[i+1] = intList[i];
		}
		intList[index] = num;
		size++;
		intList[size] = 0;
	}

	public void remove(int index){
		checkIndex(index);
		for(int i = index; i < size; i++){
			intList[i] = intList[i+1];
		}
		size--;
		intList[size] = 0;
	}

	public int get(int index){
		checkIndex(index);
		return intList[index];
	}

	public void set(int index, int num){
		checkIndex(index);
		intList[index] = num;
	}

	public int size(){
		return size;
	}

	public boolean isEmpty(){
		return size == 0;
	}

	public int indexOf(int num){
		for(int i = 0; i < size; i++){
			if(intList[i] == num){
				return i;
			}
		}
		return -1;
	}

	public boolean contains(int num){
		for(int i = 0; i < size; i++){
					if(intList[i] == num){
						return true;
					}
		}
		return false;
	}

	public String toString(){
		String result = "[";

		if (size > 0){
			for(int i = 0; i < size-1; i++){
				result += intList[i] + ", ";
			}
			result += intList[size-1] + "]";
		}

		else{
			result += intList[0] + "]";
		}

		return result;
	}

}
