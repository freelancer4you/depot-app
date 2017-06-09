package de.goldmann.portfolio.domain;

public enum OrderAction {
    SELL("V", "Verkauf"), BUY("K", "Kauf");

    private final String btnCaption;
    private final String windowCaption;

    OrderAction(final String btnCaption, final String windowCaption) {
        this.btnCaption = btnCaption;
        this.windowCaption = windowCaption;
    }

    public String getBtnCaption() {
        return btnCaption;
    }

    public String getWindowCaption() {
        return windowCaption;
    }

}
