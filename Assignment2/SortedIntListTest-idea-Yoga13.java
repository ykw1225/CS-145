
import java.util.*;

/**
 * This class is a tester to test if the SortedIntList object is working fine.
 * @author Kit Wong
 */
public class SortedIntListTest{
	public static void main (String[] args){
		SortedIntList list1 = new SortedIntList();
		list1.add(5);
		list1.add(9);
		list1.add(4);
		list1.add(5);
		list1.add(2);
		list1.add(6);
		list1.remove(0);
		list1.add(2);
		list1.add(8);
		list1.add(0);
		list1.add(3);
		System.out.println("" + list1 + "\nsize: " + list1.size());
		System.out.println("capacity: " + list1.capacity());
		list1.setUnique(false);
		System.out.println("" + list1 + "\nsize: " + list1.size());
		System.out.println("capacity: " + list1.capacity());
		list1.add(3);
		list1.add(3);
		list1.add(3);
		list1.add(3);
		list1.add(3);
		System.out.println("" + list1 + "\nsize: " + list1.size());
		System.out.println("capacity: " + list1.capacity());

		SortedIntList list2 = new SortedIntList(false);
		list2.add(65);
		list2.add(25);
		list2.add(25);
		list2.add(45);
		list2.add(97);
		list2.add(35);
		list2.add(25);
		list2.add(74);
		list2.add(26);
		System.out.println("" + list2 + "\nsize: " + list2.size());
		System.out.println("capacity: " + list1.capacity());
		list2.setUnique(true);
		list2.add(25);
		System.out.println("" + list2 + "\nsize: " + list2.size());
		System.out.println("capacity: " + list1.capacity());
	}
}


