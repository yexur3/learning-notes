package practiceWithHashMapResize;

import java.util.HashMap;
import java.util.Map;

public class Main5 {
    public static void main(String[] args) {

        Map<CountingKey, String> map = new HashMap<>();

        CountingKey ck = new CountingKey(1);

        map.put(ck, "yexura");
        map.put(new CountingKey(2), "yexurb");
        map.put(new CountingKey(3), "yexurc");
        map.put(new CountingKey(4), "yexurd");
        map.put(new CountingKey(5), "yexure");
        map.put(new CountingKey(6), "yexurf");
        map.put(new CountingKey(7), "yexurq");
        map.put(new CountingKey(8), "yexurw");
        map.put(new CountingKey(9), "yexurr");
        map.put(new CountingKey(10), "yexurt");
        map.put(new CountingKey(11), "yexury");
        map.put(new CountingKey(12), "yexuru");
        map.put(new CountingKey(13), "yexuri");

        System.out.println(ck.getHashCalls());

    }
}
