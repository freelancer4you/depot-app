package de.goldmann.portfolio.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RebalancingDetails {

    @Column(name = "percentage", nullable = true)
    private Double percentage;

    @Column(name = "actualamount", nullable = true)
    private Double actualAmount;

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(final Double percentage) {
        this.percentage = percentage;
    }

    public Double getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(final Double actualAmount) {
        this.actualAmount = actualAmount;
    }

}
