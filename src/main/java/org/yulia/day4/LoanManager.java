package org.yulia.day4;

import org.yulia.day2.LibraryItem;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class LoanManager {
    private Map<String, LibraryItem<?>> loans = new HashMap<>();
    Deque<LibraryItem<?>> loanQueue = new ArrayDeque<>();

    public void addItemToQueue(LibraryItem<?> item) {
        loanQueue.push(item);
        System.out.println("Item up for loan.");
    }

    public void processNextLoan(String user) {
        if (loanQueue.isEmpty()) {
            System.out.println("No items.");
            return;
        }
        LibraryItem<?> nextItem = loanQueue.removeFirst();
        processLoan(user, nextItem);
    }

    public void processLoan(String user, LibraryItem<?> item) {
        Thread.startVirtualThread(() -> {
            item.checkOut();
            loans.put(user, item);
            System.out.println("Loan processed for: " + user);
        });
    }

    public void printLoans() {
        loans.forEach((user, item) ->
                System.out.println(user + " has borrowed " + item.getItemType()));
    }

    public int trackLoan(LibraryItem<?> item) {
        LocalDate loanDate = item.getLoanDate();
        Period period = Period.between(loanDate, LocalDate.now());
        return period.getYears() * 365 + period.getMonths() * 30 + period.getDays();
    }

    public void printItems(List<? extends LibraryItem<?>> items) {
        for (LibraryItem<?> item : items) {
            System.out.println(item.getItemType() + " loaned on: " + item.getLoanDate());
        }
//        items.forEach(item -> System.out.println(item.getItemType()
//                        + " loaned on: " + item.getLoanDate()));
    }

    public void returnItem(String userName) throws LateReturnException {
        LibraryItem<?> libraryItem = loans.get(userName);
        if (libraryItem == null) {
            System.out.println("No items found for: " + userName);
            return;
        }
        if (trackLoan(libraryItem) >= 30) {
            throw new LateReturnException("Late return.");
        }
        loans.remove(userName);
        System.out.println("Returned on time");
    }
}
