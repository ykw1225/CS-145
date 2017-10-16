// An example of a very simple test case to help check
// if add is adding in sorted order. It can be expanded
// and made more complex as further tests are needed.

public class SimpleTest {
    public static void main(String[] args) {
        SortedIntList list = new SortedIntList(false);

        list.add(1);
        System.out.println("list = " + list);
        list.add(5);
        System.out.println("list = " + list);
        list.add(-3);
        System.out.println("list = " + list);
        list.add(2);
        System.out.println("list = " + list);
        list.add(2);
        System.out.println("list = " + list);
        list.add(2);
        System.out.println("list = " + list);
        list.add(6);

        System.out.println("list = " + list);
        System.out.println(list.size());

        list.setUnique(true);
        System.out.println("list = " + list);
        System.out.println(list.size());
    }
}
