package org.yulia.day2;

public class Librarian {
    private String name;

    public Librarian(String name) {
        this.name = name;
    }

    public void manageItem(LibraryItem item) {
        System.out.println(name + " is managing item:");
        item.printReceipt();
        item.checkOut();
    }
}
