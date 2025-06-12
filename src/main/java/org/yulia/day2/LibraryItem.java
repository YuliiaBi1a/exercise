package org.yulia.day2;

import java.time.LocalDate;

public interface LibraryItem <T> {

    void checkOut();
    void returnItem();
    T getItemType();
    //T
    LocalDate getLoanDate();

    default void printReceipt() {
        System.out.println("Thanks for using the Library.");
    }

    static void printLibraryRules() {
        System.out.println("Return items within 14 days.");
    }


}
