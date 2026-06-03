import java.util.TreeSet;
class Library{
    String title;
    String status;

    Library(String title,String status){
        this.title=title;
        this.status=status;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Status: " + status;
    }

}

class LibraryManagement{
    private TreeSet<String> books;

    LibraryManagement(){
        books = new TreeSet<>();
    }

    public String addBooks(String title){
        books.add(title);
        return "Books Added";
    }
    public String removeBooks(String title){
        if(books.contains(title)) {
            books.remove(title);
        }else {
            System.out.println("Books no Available");
            return" ";
        }
        return "Books removed";
    }
    public String check(String title){
        if(books.contains(title)) {
            System.out.println("Book Available");
        }else {
            System.out.println("Books not Available");
            return" ";
        }
        return "Books removed";
    }
    public void findBook(char c) {
        for (String book : books) {
            if (book.startsWith(String.valueOf(c)))
                System.out.println(book);
        }
    }

    public void display(){
        for(String book : books){
            System.out.println(book);
        }
    }
}
public class Main {
    public static void main(String[] args) {
        LibraryManagement manager = new LibraryManagement();
        manager.addBooks("Computer Science");
        manager.addBooks("Y");
        manager.addBooks("G");
        manager.addBooks("H");
        manager.addBooks("B");
        manager.findBook('C');
        manager.display();

        manager.removeBooks("G");
        manager.display();

        manager.check("P");
    }
}
