package org.yulia;

import org.yulia.day1.Book;
import org.yulia.day1.EBook;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        testBook();
    }

    public static void testBook() {
        Book book1 = new Book();
        Book book2 = new Book("Lotr", "Tolkien",2000);
        Book book3 = new Book("HP", "JK", 2002);
        Book book4 = new EBook("HP2", "JK", 2007, 11.3);
        Book[] books = { book1, book2, book3, book4 };

        Book.BookUtils inner = new Book.BookUtils();

        System.out.println(book1.getDetails());
        System.out.println(book2.getDetails());
        System.out.println(book3.getDetails());
        System.out.println(book4.getDetails());
        System.out.println(inner.averageBookAge(books));

    }
}