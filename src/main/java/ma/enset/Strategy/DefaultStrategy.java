package ma.enset.Strategy;

import jdk.jfr.Event;
import ma.enset.Transaction.Transaction;

public class DefaultStrategy implements Strategy {
    @Override
    public void execute(Transaction transaction) {
        System.out.println("Default strategy: No specific action for transaction: " + transaction);
    }
}
