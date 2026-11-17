package practiceWithHashMap;

import java.util.Objects;

public class User {
    private final int id;
    private final String name;
    private final String surname;
    private final String username;

    public User(int id, String name, String surname, String username){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        User other = (User) o;
        return id == other.id
                && name.equals(other.name)
                && surname.equals(other.surname)
                && username.equals(other.username);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, name, surname, username);
    }
}
