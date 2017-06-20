package de.goldmann.portfolio.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

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

import org.apache.commons.lang3.math.NumberUtils;

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
    @JoinColumn(name = "STOCKDATA_ISIN", nullable = false)
    private StockData         stockData;

    private int               anzahl;

    // Das sollte berechnet werden
    private boolean           aristocrat;

    @ManyToOne
    @JoinColumn(name = "depot_id", nullable = false)
    private Depot             depot;

    @Embedded
    private RebalancingDetails rebalancingDetails;

    StockWithinDepot() {}

    public StockWithinDepot(final StockData stockData, final Depot depot) {
        this.stockData = Objects.requireNonNull(stockData, "stockData cannot be null");
        this.depot = Objects.requireNonNull(depot, "depot cannot be null");
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

    public void updateAmout(final String description) {
        // "Kauf 35 zu je 2,28"
        // "Verkauf 2 zu je 150,61"
        final String[] splittedDesc = description.split(" ");
        OrderAction orderAction = null;
        int orderCount = 0;
        if (splittedDesc.length > 0) {
            if (OrderAction.BUY.getWindowCaption().equals(splittedDesc[0])) {
                orderAction = OrderAction.BUY;
            }
            if (OrderAction.SELL.getWindowCaption().equals(splittedDesc[0])) {
                orderAction = OrderAction.SELL;
            }
            if (splittedDesc.length > 1 && NumberUtils.isNumber(splittedDesc[1])) {
                orderCount = new BigDecimal(splittedDesc[1]).intValue();
            }
        }
        if (orderAction != null) {
            // System.out.println(isin + " " + orderAction + ": " +
            // orderCount);
            switch (orderAction) {
                case BUY:
                    setAnzahl(getAnzahl() + orderCount);
                    break;
                case SELL:
                    setAnzahl(getAnzahl() - orderCount);
                    break;
                default:
                    break;
            }
        }
    }

}
