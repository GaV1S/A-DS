import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {
    private static TwoSideLinkedList<Integer> linkedList = new TwoSideLinkedListImpl<>();

    public static void main(String[] args) {

        testLinkedList(linkedList);
        testHomeWork();
        testIterator();

    }

    private static void testLinkedList(TwoSideLinkedList<Integer> linkedList) {

        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
        linkedList.insertFirst(5);
        linkedList.insertFirst(6);
        linkedList.insertFirst(7);
        linkedList.insertFirst(8);
        linkedList.insertLast(9);
        linkedList.insertLast(10);
        linkedList.insertLast(11);

        linkedList.display();

        System.out.println("Find 2: " + linkedList.contains(2));

        linkedList.removeFirst();
        linkedList.remove(4);

        linkedList.display();

    }

    private static void testHomeWork() {
        System.out.println("==== LinkedList testing ====");

        SimpleLinkedListImpl<Integer> linkedList = new SimpleLinkedListImpl<>();
        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
        linkedList.insertFirst(5);
        for (Integer value : linkedList) {
            System.out.println("value: " + value);
        }
    }

    private static void testIterator() {
        System.out.println("==== Iterator testing ====");
        List<Integer> linkedList = new LinkedList<>();
        Collections.addAll(linkedList, 1, 2, 3, 4, 5, 6, 7);

        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            System.out.println(integer);
        }
    }
}