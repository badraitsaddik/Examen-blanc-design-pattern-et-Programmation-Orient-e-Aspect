package ma.enset.Strategy;

import jdk.jfr.Event;
import ma.enset.Transaction.Transaction;

public interface Strategy {
    void execute(Transaction transaction);
}
