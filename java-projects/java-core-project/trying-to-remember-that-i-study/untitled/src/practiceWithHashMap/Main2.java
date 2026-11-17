package practiceWithHashMap;

import java.util.HashMap;

public class Main2 {
    public static void main(String[] args){
//        HashMap<UserKey, String> map = new HashMap<>();

//        map.put(new UserKey("anna", 1), "first");
//        System.out.println(map.get(new UserKey("anna",1)));
//        System.out.println(map.size());
//        System.out.println(map.containsKey(new UserKey("anna", 1)));

        HashMap<User, String> map = new HashMap<>();

        map.put(new User(1, "Andrew", "Lesk", "anrewlesk"), "lll");
        System.out.println(map.get(new User(1, "Andrew", "Lesk", "anrewlesk")));
        System.out.println(map.size());
        System.out.println(map.containsKey(new User(1, "Andrew", "Lesk", "anrewlesk")));
    }
}
