package org.yulia.day1;

import java.time.Year;

public class Book {
    private final String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public Book() {
        this.title = "Title";
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
        return "The title is: " + getTitle()
                + "\n author: " + getAuthor()
                +"\n year: "+ getYear();
    }

    public String getDetails(boolean withAge) {
        if (withAge) {
            return getDetails() + ", Age: " + getAge() + " years";
        } else {
            return getDetails();
        }
    }

    public int getAge(){
        int year = Year.now().getValue();
        return year - this.year;
    }

    public static class BookUtils {
        public double averageBookAge(Book[] books) {
//            Arrays
//                    .stream(books).map(Book::getAge);
            double averageYear = 0;
            for (Book book: books) {
                averageYear += book.getYear();
            }
            return averageYear / books.length;
        }

        public void listAuthors(String... authors) {
            for (String author: authors) {
                System.out.println(author + "\n");
            }
        }
    }
}
