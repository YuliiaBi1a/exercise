package org.yulia.day2;

public class Librarian {

    private String name;

    public Librarian(String name) {
        this.name = name;
    }

    public void manageItem(LibraryItem libraryItem) {
        System.out.println(name + " is managing the item:");
        libraryItem.printReceipt();
        libraryItem.checkOut();
    }

}
