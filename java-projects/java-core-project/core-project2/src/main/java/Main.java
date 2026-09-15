import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        Book b1 = Book.create("lalal", "dsdfs", 2004);
        Book b2 = Book.create("ncsps", "msdsw", 1993);
        Book b3 = Book.create("wqdflsp", "dsogfd", 1995);
        Book b4 = Book.create("jsidfsp", "msdsw", 1802);

        List<Book> books = new ArrayList<>(List.of(b1, b2, b3, b4));

        System.out.println(findMin(books));

        Comparator<Book> comparator = Comparator.comparing((Book b) -> b.getAuthor()).thenComparing(Comparator.comparing((Book b) -> b.getYear()).reversed());
        books.sort(comparator);

        System.out.println(books);

        System.out.println(findOldestBookByAuthor(books, "msdsw"));

        System.out.println(grouping(books));

    }

    public static <T extends Comparable<T>> T findMin(List<T> list){
        return Collections.min(list);
    }

    public static Optional<Book> findOldestBookByAuthor(List<Book> list, String author){
        return list.stream()
                .filter(x -> x.getAuthor().equals(author))
                .min(Comparator.naturalOrder());
    }

    public static Map<String, List<Book>> grouping(List<Book> books){
        Map<String, List<Book>> result = books.stream()
                .collect(Collectors.groupingBy(x -> x.getAuthor()));

        return result;
    }

}
