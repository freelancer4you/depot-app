package de.goldmann.portfolio.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class AccountBooking implements Serializable {

    private static final long serialVersionUID = 4419308852001059072L;

    public static final String ID = "id";
    public static final String ID_ISIN = "id.isin";
    public static final String ID_DATE = "id.date";
    public static final String DESCRIPTION = "description";
    public static final String AMOUNT = "id.amount";

    @EmbeddedId
    private AccountBookingId id;

    private String description;

    AccountBooking() {
    }

    public AccountBooking(
            final AccountBookingId id,
            final String description) {
        Objects.requireNonNull(id);
        Objects.requireNonNull(description);
        this.id = id;
        this.description = description.replace("\"", "");
    }

    public AccountBookingId getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isNecessaryForCalculation() {
        return description.contains("Dividende")
                || description.contains("Transaktionsgebühr")
                || description.contains("Verkauf")
                || description.contains("Kauf");
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (id == null ? 0
                : id.hashCode());
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
        final AccountBooking other = (AccountBooking) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        }
        else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AccountBooking [" + (id != null ? "id=" + id + ", "
                : "")
                + (description != null ? "description=" + description
                        : "")
                + "]";
    }

    public boolean isFee() {
        return "Transaktionsgebühr".equals(description) || "Dividendensteuer".equals(description);
    }

}
