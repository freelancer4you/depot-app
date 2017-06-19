package de.goldmann.portfolio.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "stock")
public class StockWithinDepot implements Serializable {

    private static final long  serialVersionUID = 5145031088862708508L;

    public static final String ID = "id";

    public static final String NAME = "stockData.name";

    public static final String ISIN = "stockData.isin";

    public static final String INDUSTRY = "stockData.industry";

    public static final String QUANTITY = "anzahl";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long              id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "STOCKDATA_ISIN")
    private StockData         stockData;

    private int               anzahl;

    // Das sollte berechnet werden
    private boolean           aristocrat;

    @ManyToOne
    @JoinColumn(name = "depot_id", nullable = false)
    private Depot             depot;

    @Embedded
    private RebalancingDetails rebalancingDetails;

    public StockWithinDepot() {
        super();
    }

    public Long getId() {
        return id;
    }

    public int getAnzahl() {
        return anzahl;
    }

    public boolean isAristocrat() {
        return aristocrat;
    }

    public Depot getDepot() {
        return depot;
    }

    public StockData getStockData() {
        return stockData;
    }

    public void setAnzahl(final int anzahl) {
        this.anzahl = anzahl;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (id == null ? 0 : id.hashCode());
        return result;
    }

    public RebalancingDetails getRebalancingDetails() {
        if (rebalancingDetails == null)
        {
            rebalancingDetails = new RebalancingDetails();
        }
        return rebalancingDetails;
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
        final StockWithinDepot other = (StockWithinDepot) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StockWithinDepot ["
                + (stockData != null ? "stockData=" + stockData + ", " : "")
                + "anzahl="
                + anzahl
                + ", "
                + (depot != null ? "depot=" + depot : "")
                + "]";
    }

}
