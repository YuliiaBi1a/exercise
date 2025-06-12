package org.yulia.day4;

import org.yulia.day2.LibraryItem;
import org.yulia.day4.exceptions.LateReturnException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoanManager {

    Map<String, LibraryItem<?>> loans = new HashMap<>();

    public void processLoan(String user, LibraryItem<?> item){
        Thread.startVirtualThread(() -> {
            item.checkOut();
            loans.put(user, item);
            System.out.println("Loan processed for user" + user);
        });
    }
    public void printLoad(){
        loans.forEach((user, item) -> System.out.println(user + " has borrowed " + item.getItemType()));
    }

    public void printLoanDuration(LibraryItem<?> item) {
        LocalDate loanDate = item.getLoanDate();
        Period period = Period.between(loanDate, LocalDate.now());
        System.out.println("Loan duration: " + period.getDays() + " days");

    }
    public void printItems(List<? extends LibraryItem<?>> items) {
        for (LibraryItem<?> item : items) {
            System.out.println(item.getItemType() + " loaned on: " + item.getLoanDate());
        }
    }

    public void logLoan(String user, LibraryItem<?> item) throws IOException {
        String logEntry = "User " + user + " loaned a " + item.getItemType() + "\n";
        Path path = Paths.get("loan_log.txt");
        Files.write(path, logEntry.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    public void checkLateReturn(LibraryItem<?> item) throws LateReturnException {
        if (item.getLoanDate() != null) {
            Period period = Period.between(item.getLoanDate(), LocalDate.now());
            if (period.getDays() > 14) {
                throw new LateReturnException("Item is overdue by " + (period.getDays() - 14) + " days.");
            }
        }
    }

}
