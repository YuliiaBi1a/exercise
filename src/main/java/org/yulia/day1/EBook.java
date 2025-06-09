package org.yulia.day1;

public class EBook extends Book implements Readable {

    private double fileSize;

    public EBook(String title, String author, int year, double fileSize) {
        super(title, author, year);
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
