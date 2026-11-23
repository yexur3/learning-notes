package practiceWithLists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main7 {
    public static void main (String[] args){
        List<Integer> listArray = new ArrayList<>();
        List<Integer> listLinked = new LinkedList<>();

        for (int i = 0; i < 99999; i++){
            listArray.add(i);
            listLinked.add(i);
        }

        double startArrayTime = System.nanoTime();
        for (int i = 0; i < listArray.size(); i++) {
            listArray.get(i);
        }
        double endArrayTime = System.nanoTime();

        double startLinkedTime = System.nanoTime();
        for (int i = 0; i < listLinked.size(); i++) {
            listLinked.get(i);
        }
        double endLinkedTime = System.nanoTime();

        System.out.println("Array list get(i) time: " + (endArrayTime - startArrayTime));
        System.out.println("Linked list get(i) time: " + (endLinkedTime - startLinkedTime));

        List<Integer> listAr = new ArrayList<>();
        double startAddToStart = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            listAr.add(0, i);
        }
        double endAddToEnd = System.nanoTime();

        List<Integer> listLink = new LinkedList<>();
        double startAddToStartLink = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            listLink.add(0, i);
        }
        double endAddToStartLink = System.nanoTime();

        System.out.println("Add to start array list: " + (endAddToEnd - startAddToStart));
        System.out.println("Add to start linked list: " + (endAddToStartLink - startAddToStartLink));

        List<Integer> listArr = new ArrayList<>();
        double startAddToMiddleAr = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            listArray.add(listArr.size() / 2, i);
        }
        double endAddToMiddleAr = System.nanoTime();

        List<Integer> listLi = new LinkedList<>();
        double startAddToMiddleLink = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            listLi.add(listLi.size() / 2, i);
        }
        double endAddToMiddleLink = System.nanoTime();

        System.out.println("Add to middle array list: " + (endAddToMiddleAr - startAddToMiddleAr));
        System.out.println("Add to middle linked list: " + (endAddToMiddleLink - startAddToMiddleLink));

    }
}
