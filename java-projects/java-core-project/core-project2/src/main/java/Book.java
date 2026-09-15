import java.util.Objects;

public class Book implements Comparable<Book>{
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year){
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || o.getClass() != getClass()) return false;
        Book other = (Book) o;
        return title.equals(other.title) && author.equals(other.author) && year == other.year;
    }

    @Override
    public int hashCode(){
        return Objects.hash(title, author, year);
    }

    @Override
    public String toString(){
        return "[Title: " + title + ", author: " + author + ", year " + year + "]";
    }

    @Override
    public int compareTo(Book o){
        return Integer.compare(year, o.year);
    }

    public static Book create(String title, String author, int year){
        if(year < 0 || year > 2026) throw new InvalidYearException("Year must be < 0 or > 2026");

        return new Book(title, author, year);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }
}
