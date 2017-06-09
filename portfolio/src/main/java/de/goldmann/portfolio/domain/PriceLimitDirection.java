package de.goldmann.portfolio.domain;

public enum PriceLimitDirection {
    EXCEEDED("überschritten"), UNDERCUTTED("unterschritten");

    private final String caption;

    PriceLimitDirection(final String caption) {
        this.caption = caption;
    }

    public String getCaption() {
        return caption;
    }

}
