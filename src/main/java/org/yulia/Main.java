package org.yulia;

import org.yulia.day1.Book;
import org.yulia.day1.EBook;
import org.yulia.day2.BookCategory;
import org.yulia.day2.Librarian;
import org.yulia.day2.LibraryItem;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        testBookDay2();
    }

    public static void testBookDay2(){
        Book b1 = new EBook("1984", "Orwell", 1949, BookCategory.FICTION, 1.2);
        Book b2 = new EBook("1985", "Orwell", 1950, BookCategory.FICTION, 1.2);
        LibraryItem item = b2;
        Librarian lib = new Librarian("Alice");

        lib.manageItem(item);
        LibraryItem.printLibraryRules();
    }
}