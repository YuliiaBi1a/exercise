package org.yulia.day2;

import java.time.LocalDate;
import java.time.Period;

public interface LibraryItem<T> {

    void checkOut();
    void returnItem();
    String getItemType();
    LocalDate getLoanDate();

    default void printReceipt() {
        System.out.println("Thanks for using the Library.");
    }

    static void printLibraryRules() {
        System.out.println("Return items within 14 days.");
    }

}
