package de.goldmann.portfolio.domain.repository;

import de.goldmann.portfolio.domain.Industry;

public class IndustryStatistics {

    private Industry industry;
    private Long count;

    IndustryStatistics() {
    }

    public IndustryStatistics(final Industry industry, final Long count) {
        this.industry = industry;
        this.count = count;
    }

    public Industry getIndustry() {
        return industry;
    }

    public Long getCount() {
        return count;
    }

}
