package practiceWithHashMap;

import java.util.Objects;

public class UserKey {
    private String name;
    private int id;

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

    public void setId(int id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "[" + id + ", Name: " + name + "]";
    }
}
