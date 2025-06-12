package org.yulia.day1;

import org.yulia.day2.BookCategory;
import org.yulia.day2.LibraryItem;

import java.time.LocalDate;
import java.time.Year;

public class Book implements LibraryItem<String> {
    private final String title;
    private String author;
    private int year;
    private BookCategory category;
    private LocalDate loanDate;


    public Book(String title, String author, int year, BookCategory category) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.category = category;
    }
//getters
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

    public BookCategory getCategory() {
        return category;
    }

    public String getDetails(){
        return "The title is: " + getTitle()
                + "\n author: " + getAuthor()
                +"\n year: "+ getYear()
                +"\n year: "+ getCategory();
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
        this.loanDate = LocalDate.now();
    }

    @Override
    public void returnItem() {
        System.out.println("Book returned" + title);
    }

    @Override
    public String getItemType() {
        return "Book";
    }

    @Override
    public LocalDate getLoanDate() {
        return loanDate;
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
