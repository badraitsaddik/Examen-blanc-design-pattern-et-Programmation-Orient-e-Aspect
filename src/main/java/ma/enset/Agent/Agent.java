package ma.enset.Agent;

import jdk.jfr.Event;
import ma.enset.Strategy.DefaultStrategy;
import ma.enset.Strategy.Strategy;
import ma.enset.Transaction.Transaction;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Agent {
    private final String nom;
    private final List<Transaction> transactions;
    private final List<Agent> observateurs;
    private Strategy strategy;

    public Agent(String nom) {
        this.nom = nom;
        this.transactions = new ArrayList<>();
        this.observateurs = new ArrayList<>();
        this.strategy = new DefaultStrategy();
    }

    public void souscrire(Agent agent) {
        observateurs.add(agent);
    }

    public void ajouterTransaction(Transaction transaction) {
        transactions.add(transaction);
        notifier(transaction);
    }

    private void notifier(Transaction transaction) {
        Transaction transaction1 = new Transaction(this.nom, transaction);
        for (Agent observer : observateurs) {
            observer.update(transaction1);
        }
    }

    public void update(Transaction transaction) {
        strategy.execute(transaction);
    }

    public void changerStrategy(Strategy newStrategy) {
        this.strategy = newStrategy;
    }

    public Transaction calculerPlusGrandeTransaction() {
        return transactions.stream()
                .max(Comparator.comparingDouble(Transaction::getMontant))
                .orElse(null);
    }

    public void afficherNom() {
        System.out.println("Agent: " + nom);
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "nom='" + nom + '\'' +
                '}';
    }
}

