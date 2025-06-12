package org.yulia;

import org.yulia.day1.Book;
import org.yulia.day1.EBook;
import org.yulia.day2.BookCategory;
import org.yulia.day2.Librarian;
import org.yulia.day2.LibraryItem;
import org.yulia.day4.LoanManager;
import org.yulia.day4.Magazine;
import org.yulia.day4.exceptions.LateReturnException;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        //testBookDay2();
        testLoanManager();
    }

    public static void testBookDay2(){
        Book b1 = new EBook("1984", "Orwell", 1949, BookCategory.FICTION, 1.2);
        Book b2 = new EBook("1985", "Orwell", 1950, BookCategory.FICTION, 1.2);
        LibraryItem item = b2;
        Librarian lib = new Librarian("Alice");

        lib.manageItem(item);
        LibraryItem.printLibraryRules();
        ((Book)item).getDetails();
    }

    public static void testLoanManager() throws InterruptedException, IOException {
        LoanManager manager = new LoanManager();

        Book book = new EBook("1984", "Orwell", 1949, BookCategory.FICTION, 1.2);
        Magazine<Integer> magazine = new Magazine<>("Time", 42, "News");

        manager.processLoan("Alice", book);
        manager.processLoan("Bob", magazine);

        Thread.sleep(1000); // espera a que los hilos terminen

        manager.printLoad();
        manager.printLoanDuration(book);
        manager.logLoan("Alice", book);
        manager.checkLateReturn(book);

/*        manager.getLoans().forEach((user, item) -> {
            try {
                new Main().logLoan(user, item);
                new Main().printLoanDuration(item);
                new Main().checkLateReturn(item);
            } catch (LateReturnException | IOException e) {
                System.err.println(e.getMessage());
            }
        });*/

    }

}