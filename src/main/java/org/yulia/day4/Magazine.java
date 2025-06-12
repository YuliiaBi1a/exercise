package org.yulia.day4;

import org.yulia.day2.LibraryItem;

import java.time.LocalDate;

public class Magazine<T> implements LibraryItem<String> {
    private final String title;
    private final T issueNumber;
    private final String genre;
    private LocalDate loanDate;

    public Magazine(String title, T issueNumber, String genre) {
        this.title = title;
        this.issueNumber = issueNumber;
        this.genre = genre;
    }

    @Override
    public void checkOut() {
        this.loanDate = LocalDate.now();
    }

    @Override
    public void returnItem() {
        System.out.println("Magazine returned: " + title);
    }

    @Override
    public String getItemType() {
        return "Magazine";
    }

    @Override
    public LocalDate getLoanDate() {
        return loanDate;
    }
}
