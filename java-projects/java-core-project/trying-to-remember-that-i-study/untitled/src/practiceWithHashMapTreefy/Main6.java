package practiceWithHashMapTreefy;

import java.util.HashMap;
import java.util.Map;

public class Main6 {
    public static void main(String[] args){

        Map<BadKeyA, String> mapA = new HashMap<>();
        Map<BadKeyB, String> mapB = new HashMap<>();

        var startTimeA = System.nanoTime();
        for (int i = 0; i < 40000; i++) {
            mapA.put(new BadKeyA(i), "hello");
        }
        var endTimeA = System.nanoTime();

        var startTimeB = System.nanoTime();
        for(int i = 0; i < 40000; i++) {
            mapB.put(new BadKeyB(i), "hello");
        }
        var endTimeB = System.nanoTime();

        System.out.println("A: " + (endTimeA - startTimeA) + " B: " + (endTimeB - startTimeB));

    }
}
