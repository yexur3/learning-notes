package practiceWithHashMap;

import java.util.HashMap;
import java.util.Objects;

public class Main3 {

    public record People(int id, String name){

        @Override
        public boolean equals(Object o){
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            People other = (People) o;
            return name.equals(other.name);
        }

        @Override
        public int hashCode(){
            return Objects.hash(name);
        }

    }

    public static void main(String[] args){

        HashMap<People, Integer> hashMap = new HashMap<>();
        hashMap.put(new People(1, "anna"), 1);
        hashMap.put(new People(2, "anna"), 2);

        System.out.println(hashMap.size());

    }
}
