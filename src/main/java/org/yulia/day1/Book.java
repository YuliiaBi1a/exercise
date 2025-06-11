package org.yulia.day1;

import org.yulia.day2.BookCategory;
import org.yulia.day2.LibraryItem;

import java.time.Year;
import java.util.Arrays;

public class Book implements LibraryItem {
    private final String title;
    private String author;
    private int year;
    private BookCategory bookCategory;

    public Book(String title, String author, int year, BookCategory bookCategory) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.bookCategory = bookCategory;
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
                + "\nauthor: " + getAuthor()
                +"\nyear: "+ getYear()
                +"\nbook category: " + bookCategory.toString();
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

    @Override
    public void checkOut() {
        System.out.println("Checkout successful");
    }

    @Override
    public void returnItem() {
        System.out.println("Thank you for returning the book on time.");
    }

    @Override
    public String getItemType() {
        return bookCategory.toString();
    }

    public static class BookUtils {
        public double averageBookAge(Book[] books) {
//            double averageYear = 0;
//            for (Book book: books) {
//                averageYear += book.getAge();
//            }
//            return averageYear / books.length;
            return Arrays.stream(books)
                    .mapToDouble(Book::getAge)
                    .average()
                    .orElse(0);
        }

        public void listAuthors(String... authors) {
            for (String author: authors) {
                System.out.println(author + "\n");
            }
        }
    }
}
