package de.goldmann.portfolio.domain;

public enum StockType {
    AKTIE("Aktie"), ETF("ETF");

    private final String caption;

    StockType(final String caption) {
        this.caption = caption;
    }

    public String getCaption() {
        return caption;
    }
}
