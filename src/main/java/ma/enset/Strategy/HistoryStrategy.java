package ma.enset.Strategy;

import ma.enset.Transaction.Transaction;

import java.util.ArrayList;
import java.util.List;

public class HistoryStrategy implements Strategy {
    private final List<Transaction> history = new ArrayList<>();

    @Override
    public void execute(Transaction transaction) {
        history.add(transaction);
        System.out.println("History strategy: Transaction added to history: " + transaction);
    }

    public List<Transaction> getHistory() {
        return history;
    }
}