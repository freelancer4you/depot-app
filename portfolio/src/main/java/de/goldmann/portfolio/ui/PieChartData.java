package de.goldmann.portfolio.ui;

public class PieChartData {

    private String name;
    private double y;

    public PieChartData() {
        super();
    }

    public PieChartData(final String name, final double y) {
        super();
        this.name = name;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public double getY() {
        return y;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (name == null ? 0 : name.hashCode());
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
        if (name == null)
        {
            if (other.name != null)
            {
                return false;
            }
        }
        else if (!name.equals(other.name))
        {
            return false;
        }
        return true;
    }

}
