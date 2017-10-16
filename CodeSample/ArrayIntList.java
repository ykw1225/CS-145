/**
 * Created by khang on 1/21/2015.
 */
public class ArrayIntList {
    // fields
    private int[] elementData;
    private int size;
    public static final int DEFAULT_CAPACITY = 10;

    // constructs a new ArrayIntList
    public ArrayIntList() {
        size = 0;
        elementData = new int[DEFAULT_CAPACITY];
    }

    // add will add a number to the ArrayIntList
    public void add(int numToAdd) {
        elementData[size] = numToAdd;   // put the number into the array
        size = size + 1;                // increase the size

        // TO DO: handle the case when we get to position 9
        // as it will currently crash if it gets there

    }

    // this version of add will add a number at a specific position
    public void add(int position, int numToAdd) {
        // shift the items over by one spot
        for (int i = size; i > position; i--) {
            elementData[i] = elementData[i - 1];
        }

        // place the item into the desired position
        elementData[position] = numToAdd;

        // update size
        size = size + 1;
    }

    public void remove(int position) {
        // shift items left to replace the position
        for (int i = position; i < size; i++) {
            elementData[i] = elementData[i + 1];
        }

        size = size - 1;        // reduce the list size by 1
        elementData[size] = 0;  // optional, but a good practice
    }

    public int get(int position) {
        return elementData[position];
    }

    public void set(int position, int value) {
        elementData[position] = value;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        String result = "[";

        if (size > 0) {
            result = result + elementData[0];

            for (int i = 1; i < size; i++) {
                result = result + ", " + elementData[i];
            }
        }

        result = result + "]";
        return result;
    }


}