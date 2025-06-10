package org.yulia.day1;

import org.yulia.day2.BookCategory;

public class EBook extends Book implements Readable {

    private double fileSize;

    public EBook(String title, String author, int year, BookCategory category, double fileSize) {
        super(title, author, year, category);
        this.fileSize = fileSize;
    }

    @Override
    public String getDetails() {
        return super.getDetails()
                + "\nfileSize: " + this.getFileSize();
    }

    public double getFileSize() {
        return fileSize;
    }

    @Override
    public void readSample() {

    }
}
