package org.yulia.day1;

import java.time.Year;

public class Book {
    private String title;
    private String author;
    private int year;

    public Book() {
    }

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDetails(){
        return "The title is: " + getTitle() + "\\n author: " + getAuthor() +"\\n year: "+ getYear();
    }

    public int getAge(){
        int year = Year.now().getValue();
        return year - this.year;
    }

}
