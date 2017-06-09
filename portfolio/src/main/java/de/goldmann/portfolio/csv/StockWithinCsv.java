package de.goldmann.portfolio.csv;

import java.io.Serializable;

public class StockWithinCsv implements Serializable{

    private static final long serialVersionUID = -5062864005109012077L;

    private String produkt;
    private String isin;
    private String anzahl;

    public String getProdukt() {
        return produkt;
    }

    public void setProdukt(final String produkt) {
        this.produkt = produkt;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(final String isin) {
        this.isin = isin;
    }

    public String getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(final String anzahl) {
        this.anzahl = anzahl;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (isin == null ? 0
                : isin.hashCode());
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
        final StockWithinCsv other = (StockWithinCsv) obj;
        if (isin == null) {
            if (other.isin != null) {
                return false;
            }
        }
        else if (!isin.equals(other.isin)) {
            return false;
        }
        return true;
    }


}
