import java.util.*;

public class ArrayListTester {

    public static void main(String[] args) {
        System.out.println("This is the array list tester.");

        SortedIntList list1 = new SortedIntList();
        list1.add(23);
        list1.add(34);
        list1.add(67);

        System.out.println(list1);
        //list1.add(1, 78);
        System.out.println(list1);

        list1.remove(2);

    }

}