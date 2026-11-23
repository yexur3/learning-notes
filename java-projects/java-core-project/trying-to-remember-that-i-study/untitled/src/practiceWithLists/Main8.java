package practiceWithLists;

import java.util.LinkedList;
import java.util.List;

public class Main8 {
    public static void main(String[] args) {
        List<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < 100000; i++) {
            linkedList.add(i);
        }

        double startGetTime = System.nanoTime();
        for (int i = 0; i < linkedList.size(); i++) {
            linkedList.get(i);
        }
        double endGetTime = System.nanoTime();

        double startForEachTime = System.nanoTime();
        for (int x : linkedList) {
            System.out.println(x);
        }
        double endForEachTime = System.nanoTime();

        System.out.println("Get time: " + (endGetTime - startGetTime));
        System.out.println("For Each time: " + (endForEachTime - startForEachTime));
    }
}
