package de.goldmann.portfolio.ui;

import java.util.Objects;

public class PieChartData {

    private String name;
    private Long y;

    public PieChartData() {
        super();
    }

    public PieChartData(final String name, final Long y) {
        super();
        this.name = name;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public Long getY() {
        return y;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Objects.hashCode(name);
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
        final PieChartData other = (PieChartData) obj;
        return Objects.equals(name, other.name);
    }

}
