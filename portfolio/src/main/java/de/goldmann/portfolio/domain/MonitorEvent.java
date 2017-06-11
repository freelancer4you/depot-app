package de.goldmann.portfolio.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "monitorevent")
public class MonitorEvent implements Serializable {

    private static final long serialVersionUID = -3140957728372683692L;

    public static final String STOCKDATA_NAME = "stock.name";

    public static final String STOCKDATA_ISIN = "stock.isin";

    public static final String COMMENT = "comment";

    public static final String PRICE_LIMIT = "priceLimit";

    public static final String ID = "id";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "stockdata_isin", nullable = false)
    private StockData stock;

    @Lob
    @Column(name = "comment", nullable = true)
    private String comment;

    @Column(name = "pricelimit", nullable = false)
    private double priceLimit;

    @Column(name = "pricelimitdirection", nullable = false)
    @Enumerated(EnumType.STRING)
    private PriceLimitDirection priceLimitDirection;

    private LocalDate greated;

    @Column(name = "limithit", nullable = true)
    private LocalDate limitHit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "humanuser_id", nullable = false)
    private HumanUser user;

    public MonitorEvent() {}

    public MonitorEvent(final StockData stock, final String comment, final double priceLimit,
            final PriceLimitDirection priceLimitDirection, final HumanUser user) {
        this.stock = stock;
        this.comment = comment;
        this.priceLimit = priceLimit;
        this.priceLimitDirection = priceLimitDirection;
        this.user = user;
        greated = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public StockData getStock() {
        return stock;
    }

    public String getComment() {
        return comment;
    }

    public double getPriceLimit() {
        return priceLimit;
    }

    public PriceLimitDirection getPriceLimitDirection() {
        return priceLimitDirection;
    }

    public LocalDate getGreated() {
        return greated;
    }

    public LocalDate getLimitHit() {
        return limitHit;
    }

    public void setComment(final String comment) {
        this.comment = comment;
    }

    public void setPriceLimit(final double priceLimit) {
        this.priceLimit = priceLimit;
    }

    public void setPriceLimitDirection(final PriceLimitDirection priceLimitDirection) {
        this.priceLimitDirection = priceLimitDirection;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (id == null ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final MonitorEvent other = (MonitorEvent) obj;
        if (id == null)
        {
            if (other.id != null)
            {
                return false;
            }
        }
        else if (!id.equals(other.id))
        {
            return false;
        }
        return true;
    }

    public void setLimitHit(final LocalDate hitLimit) {
        limitHit = hitLimit;
    }

    @Override
    public String toString() {
        return "MonitorEvent ["
                + (comment != null ? "comment=" + comment + ", " : "")
                + "priceLimit="
                + priceLimit
                + ", "
                + (priceLimitDirection != null ? "priceLimitDirection=" + priceLimitDirection + ", " : "")
                + (greated != null ? "greated=" + greated + ", " : "")
                + (limitHit != null ? "limitHit=" + limitHit : "")
                + "]";
    }

}
