package practiceWithHashMap;

import java.util.HashMap;
import java.util.Map;

public class Main4 {
    public static void main(String[] args){
        UserKey key = new UserKey("anna", 1);
        Map<UserKey, String> map = new HashMap<>();
        map.put(key, "first");

        key.setId(2);

        System.out.println(key);
        System.out.println(map.get(key));
        System.out.println(map.containsKey(key));
        System.out.println(map.size());
        System.out.println(map);
        System.out.println(map.get(new UserKey("anna", 1)));
    }
}
