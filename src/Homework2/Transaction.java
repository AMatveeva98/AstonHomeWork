package Homework2;

import java.util.Objects;

public class Transaction {
    private Trader trader;
    private int year;
    private int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return this.trader;
    }

    public int getYear() {
        return this.year;
    }

    public int getValue() {
        return this.value;
    }

    public int hashCode() {
        int hash = 17;
        hash = hash * 31 + (this.trader == null ? 0 : this.trader.hashCode());
        hash = hash * 31 + this.year;
        hash = hash * 31 + this.value;
        return hash;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        } else if (!(other instanceof Transaction)) {
            return false;
        } else {
            Transaction o = (Transaction)other;
            boolean eq = Objects.equals(this.trader, o.getTrader());
            eq = eq && this.year == o.getYear();
            eq = eq && this.value == o.getValue();
            return eq;
        }
    }

    public String toString() {
        return String.format("{%s, year: %d, value: %d}", this.trader, this.year, this.value);
    }
}
