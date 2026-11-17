package practiceWithHashMap;

import java.util.Objects;

public class UserKey {
    private final String name;
    private final int id;

    public UserKey(String name, int id){
        this.name = name;
        this.id = id;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserKey other = (UserKey) o;
        return name.equals(other.name) && id == other.id;
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, id);
    }
}
