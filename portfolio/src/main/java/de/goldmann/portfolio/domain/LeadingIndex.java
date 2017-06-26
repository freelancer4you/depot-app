package de.goldmann.portfolio.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "leadingindex")
public class LeadingIndex implements Serializable {

    private static final long serialVersionUID = -5229291498116603810L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long              id;

    @Column(nullable = false, unique = true)
    private String            name;

    @Column(unique = true, length = StockData.ISIN_MAX_LENGTH)
    private String            isin;

    @Column(nullable = false, name = "searchkey")
    private String            searchKey;

    @OneToMany(mappedBy = "leadingIndex", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<StockData>   stocks;

    public LeadingIndex() {}

    public List<StockData> getStocks() {
        return stocks;
    }

    public void setStocks(final List<StockData> stocks) {
        this.stocks = stocks;
    }

    @Override
    public String toString() {
        return "Index ["
                + (name != null ? "name=" + name + ", " : "")
                + (isin != null ? "isin=" + isin + ", " : "")
                + (searchKey != null ? "searchKey=" + searchKey : "")
                + "]";
    }

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(final String isin) {
        this.isin = isin;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(final String searchKey) {
        this.searchKey = searchKey;
    }
}
