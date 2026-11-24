package practiceWithSets;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Main10 {

    public record Product(String name, double price) implements Comparable<Product>{

        @Override
        public int compareTo(Product o){
            return Double.compare(price, o.price);
        }

        @Override
        public boolean equals(Object o){
            if (o == this) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Product other = (Product) o;
            return other.name.equals(name) && price == other.price;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, price);
        }

    }

    public static void main (String[] main) {
        Set<Product> tree = new HashSet<>();
        tree.add(new Product("apple", 20.0));
        tree.add(new Product("banana", 20.0));
        System.out.println(tree.size());
        System.out.println(tree.add(new Product("cherry", 20.0)));
    }
}
