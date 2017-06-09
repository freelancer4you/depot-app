package de.goldmann.portfolio.domain;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "depots")
public class Depot implements Serializable {

    private static final long     serialVersionUID = 1852970639649179971L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long                  id;

    @Column(name = "name", nullable = true)
    private String                name;

    @Column(name = "seedcapital", nullable = true)
    private Double                seedCapital;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "depot")
    private Set<StockWithinDepot> stocks;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "humanuser_id", nullable = false)
    private HumanUser             user;

    // Anteil der Aktien im Depot
    @Column(name = "stockspercentage", nullable = true)
    private Double                stocksPercentage;

    // Anteil des Bargeldes im Depot
    @Column(name = "cashpercentage", nullable = true)
    private Double                cashPercentage;

    // Bargeld im Depot
    @Column(name = "cashamount", nullable = true)
    private Double                cashAmount;

    Depot() {
        super();
    }

    public Depot(final String name, final double seedCapital, final HumanUser humanUser) {
        super();
        this.name = Objects.requireNonNull(name, "name");
        this.seedCapital = seedCapital;
        user = Objects.requireNonNull(humanUser, "humanUser");
    }

    public String getName() {
        return name;
    }

    public HumanUser getUser() {
        return user;
    }

    public Set<StockWithinDepot> getStocks() {
        if (stocks == null) {
            stocks = new HashSet<>();
        }
        return Collections.unmodifiableSet(stocks);
    }

    public Double getSeedCapital() {
        return seedCapital;
    }

    public Double getStocksPercentage() {
        return stocksPercentage;
    }

    public void setStocksPercentage(final Double stocksPercentage) {
        this.stocksPercentage = stocksPercentage;
    }

    public Double getCashPercentage() {
        return cashPercentage;
    }

    public void setCashPercentage(final Double cashPercentage) {
        this.cashPercentage = cashPercentage;
    }

    public Double getCashAmount() {
        return cashAmount;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ id >>> 32);
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Depot other = (Depot) obj;
        if (id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Depot [" + (name != null ? "name=" + name : "") + "]";
    }

}
