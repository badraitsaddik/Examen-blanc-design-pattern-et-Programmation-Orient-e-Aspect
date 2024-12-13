package ma.enset.Agent;

import ma.enset.Transaction.Transaction;
import ma.enset.Transaction.Enums.Type;

import java.time.LocalDate;

public class TestAgent {
    public static void main(String[] args) {
        // Créer des agents
        Agent agent1 = new Agent("Agent1");
        Agent agent2 = new Agent("Agent2");

        // Souscrire agent2 comme observateur de agent1
        agent1.souscrire(agent2);

        // Créer des transactions
        Transaction transaction1 = new Transaction.Builder()
                .setId("001")
                .setDate(LocalDate.of(2023, 10, 1))
                .setMontant(500.0)
                .setType(Type.VENTE)
                .build();

        Transaction transaction2 = new Transaction.Builder()
                .setId("002")
                .setDate(LocalDate.of(2023, 10, 2))
                .setMontant(300.0)
                .setType(Type.ACHAT)
                .build();

        // Ajouter des transactions à agent1
        agent1.ajouterTransaction(transaction1);
        agent1.ajouterTransaction(transaction2);

        // Afficher les transactions et les états des agents
        System.out.println("Transactions de " + agent1.getNom() + ":");
        System.out.println(agent1.calculerPlusGrandeTransaction());

        System.out.println("Transactions de " + agent2.getNom() + ":");
        System.out.println(agent2.calculerPlusGrandeTransaction());
    }
}