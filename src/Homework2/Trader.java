package Homework2;

import java.util.Objects;

public class Trader {
    private String name;
    private String city;

    public Trader(String n, String c) {
        this.name = n;
        this.city = c;
    }

    public String getName() {
        return this.name;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String newCity) {
        this.city = newCity;
    }

    public int hashCode() {
        int hash = 17;
        hash = hash * 31 + (this.name == null ? 0 : this.name.hashCode());
        hash = hash * 31 + (this.city == null ? 0 : this.city.hashCode());
        return hash;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        } else if (!(other instanceof Trader)) {
            return false;
        } else {
            Trader o = (Trader)other;
            boolean eq = Objects.equals(this.name, o.getName());
            eq = eq && Objects.equals(this.city, o.getCity());
            return eq;
        }
    }

    public String toString() {
        return String.format("Trader:%s in %s", this.name, this.city);
    }
}
