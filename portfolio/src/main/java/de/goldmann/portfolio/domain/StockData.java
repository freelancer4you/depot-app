package de.goldmann.portfolio.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "stockdata")
public class StockData implements Serializable {

    public static final int ISIN_MAX_LENGTH = 12;

    private static final long serialVersionUID = -8399894969039257669L;

    @Id
    @Column(nullable = false, unique = true, length = ISIN_MAX_LENGTH)
    private String            isin;

    @Column(nullable = false, unique = true)
    private String            name;

    @Column(nullable = false, name = "searchkey", unique = true)
    private String            searchKey;

    @Column(nullable = false)
    private String            currency;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "LEADINGINDEX_ID")
    private LeadingIndex      leadingIndex;

    @Column(name = "stocktype", nullable = false)
    @Enumerated(EnumType.STRING)
    private StockType         stockType;

    @Column(name = "industry", nullable = false)
    @Enumerated(EnumType.STRING)
    private Industry			industry;

    StockData() {}

    public StockData(final String isin, final String name, final String searchKey,
            final String currency, final LeadingIndex leadingIndex, final StockType stockType,
            final Industry industry) {
        super();
        this.isin = isin;
        this.name = name;
        this.searchKey = searchKey;
        this.currency = currency;
        this.leadingIndex = leadingIndex;
        this.stockType = stockType;
        this.industry = industry;
    }

    /**
     * Getter of currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Getter of isin
     */
    public String getIsin() {
        return isin;
    }

    /**
     * Getter of name
     */
    public String getName() {
        return name;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public StockType getStockType() {
        return stockType;
    }

    public Industry getIndustry() {
        return industry;
    }

    public LeadingIndex getLeadingIndex() {
        return leadingIndex;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (isin == null ? 0 : isin.hashCode());
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
        final StockData other = (StockData) obj;
        if (isin == null) {
            if (other.isin != null) {
                return false;
            }
        } else if (!isin.equals(other.isin)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StockData ["
                + (isin != null ? "isin=" + isin + ", " : "")
                + (name != null ? "name=" + name + ", " : "")
                + (searchKey != null ? "searchKey=" + searchKey + ", " : "")
                + (leadingIndex != null ? "leadingIndex=" + leadingIndex + ", " : "")
                + (stockType != null ? "stockType=" + stockType + ", " : "")
                + (industry != null ? "industry=" + industry : "")
                + "]";
    }
}
