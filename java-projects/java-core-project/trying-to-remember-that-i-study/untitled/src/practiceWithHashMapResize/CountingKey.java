package practiceWithHashMapResize;

import java.util.Objects;

public class CountingKey {

    private static int hashCalls = 0;
    private final int id;

    public CountingKey(int id){
        this.id = id;
    }

    @Override
    public int hashCode() {
        hashCalls++;
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountingKey other = (CountingKey) o;
        return id == other.id;
    }

    public int getHashCalls() {
        return hashCalls;
    }

}
