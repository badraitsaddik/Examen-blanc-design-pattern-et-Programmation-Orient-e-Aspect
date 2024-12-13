package ma.enset.Strategy;

import jdk.jfr.Event;
import ma.enset.Transaction.Enums.Type;
import ma.enset.Transaction.Transaction;

public class ScoringStrategy implements Strategy {
    private double balance = 0;

    @Override
    public void execute(Transaction transaction) {
        if (transaction.getType() == Type.VENTE) {
            balance += transaction.getMontant();
        } else if (transaction.getType() == Type.ACHAT) {
            balance -= transaction.getMontant();
        }
        System.out.println("Scoring strategy: Updated balance = " + balance);
    }
}

