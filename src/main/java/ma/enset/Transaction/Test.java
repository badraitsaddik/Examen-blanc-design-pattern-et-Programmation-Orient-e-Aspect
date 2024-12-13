package ma.enset.Transaction;


import ma.enset.Transaction.Enums.Type;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
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

        System.out.println(transaction1);
        System.out.println(transaction2);
    }
}