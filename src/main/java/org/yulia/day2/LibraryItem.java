package org.yulia.day2;

public interface LibraryItem {

    void checkOut();
    void returnItem();
    String getItemType();

    default void printReceipt() {
        System.out.println("Thanks for using the Library.");
    }

    static void printLibraryRules() {
        System.out.println("Return items within 14 days.");
    }

}
