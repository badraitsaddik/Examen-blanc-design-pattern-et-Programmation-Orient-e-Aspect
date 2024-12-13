package ma.enset.Transaction;

import ma.enset.Transaction.Enums.Type;

import java.time.LocalDate;

public class Transaction {
    private final String id;
    private final LocalDate date;
    private final double montant;
    private final Type type;



    public Transaction(Builder builder) {
        this.id = builder.id;
        this.date = builder.date;
        this.montant = builder.montant;
        this.type = builder.type;
    }

    public Transaction(String nom, Transaction transaction) {
        this.id = transaction.id;
        this.date = transaction.date;
        this.montant = transaction.montant;
        this.type = transaction.type;
    }

    public static class Builder {
        private String id;
        private LocalDate date;
        private double montant;
        private Type type;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder setMontant(double montant) {
            this.montant = montant;
            return this;
        }

        public Builder setType(Type type) {
            this.type = type;
            return this;
        }

        public Transaction build() {
            return new Transaction(this);
        }
    }

    public String getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getMontant() {
        return montant;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", montant=" + montant +
                ", type=" + type +
                '}';
    }


}
