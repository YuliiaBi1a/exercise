package org.yulia.day1;

import java.time.LocalDate;

public class PrintedBook extends Book implements Readable{

    private int pages;

    @Override
    public String getDetails() {
        return super.getDetails()
                + "\npages: " + this.getPages();
    }

    public int getPages() {
        return pages;
    }

    @Override
    public void readSample() {

    }

    @Override
    public LocalDate getLoanDate() {
        return null;
    }
}
