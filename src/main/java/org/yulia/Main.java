package org.yulia;

import org.yulia.day1.Book;
import org.yulia.day1.EBook;
import org.yulia.day2.BookCategory;
import org.yulia.day2.Librarian;
import org.yulia.day2.LibraryItem;
import org.yulia.day4.LoanManager;

import java.util.ArrayDeque;
import java.util.Deque;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        testBook();
        Deque<LibraryItem<?>> loanQueue = new ArrayDeque<>();

    }



    public static void testBook() {
        Book book1 = new Book();
        Book book2 = new Book("Lotr", "Tolkien",2000, BookCategory.FICTION);
        Book book3 = new Book("HP", "JK", 2002, BookCategory.FICTION);
        Book book4 = new EBook("HP2", "JK", 2007, 11.3, BookCategory.BIOGRAPHY);
        Book book5 = new EBook("Dune", "Author", 2007, 11.3, BookCategory.SCIENCE);
        Book[] books = { book1, book2, book3, book4, book5 };

        Book.BookUtils inner = new Book.BookUtils();

        System.out.println(book1.getDetails());
        System.out.println(book2.getDetails());
        System.out.println(book3.getDetails());
        System.out.println(book4.getDetails());
        System.out.println(inner.averageBookAge(books));

        book1.checkOut();
        System.out.println(book2.getItemType());
        book3.returnItem();

        Librarian librarian = new Librarian("Librarian");
        librarian.manageItem(book5);
//        List<LibraryItem> libraryItems =  Arrays.asList(book1, book2, book3, book4, book5);
//        libraryItems.forEach(System.out::println);
        Book b1 = new EBook("1984", "Orwell", 1949, 1.2, BookCategory.FICTION);
        LibraryItem item = b1;
        Librarian lib = new Librarian("Alice");

        lib.manageItem(item);
        LibraryItem.printLibraryRules();
        System.out.println(inner.averageBookAge(books));
        Book b2 = b1;
        b2.getDetails();

        LoanManager loanManager = new LoanManager();

    }
}