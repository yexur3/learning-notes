public class Main {
    public static void main(String[] args){
        SimpleHashMap<Integer, String> hashMap = new SimpleHashMap<>();

        hashMap.put(1, "test");
        hashMap.put(4, "test test 2");
        hashMap.put(3, "text test");

        System.out.println(hashMap.get(3));
        System.out.println(hashMap.size());

        hashMap.put(3, "yexur");
        System.out.println(hashMap.get(3));
        System.out.println(hashMap.size());

        System.out.println(hashMap.get(5));

        hashMap.put(17, "seventeen");

        System.out.println(hashMap.get(1));
        System.out.println(hashMap.get(17));
        System.out.println(hashMap.size());
    }
}
