package de.goldmann.portfolio.ui.rebalancing;

public class StockEntry {

    private final String name;
    private final double percentage;
    private final String isin;
    private final double amount;

    public StockEntry(final String name, final double percentage, final String isin, final double amount) {
        super();
        this.name = name;
        this.percentage = percentage;
        this.isin = isin;
        this.amount = amount;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (isin == null ? 0 : isin.hashCode());
        return result;
    }

    public String getName() {
        return name;
    }

    public double getPercentage() {
        return percentage;
    }

    public String getIsin() {
        return isin;
    }

    public double getAmount() {
        return amount;
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
        final StockEntry other = (StockEntry) obj;
        if (isin == null)
        {
            if (other.isin != null)
            {
                return false;
            }
        }
        else if (!isin.equals(other.isin))
        {
            return false;
        }
        return true;
    }

}
