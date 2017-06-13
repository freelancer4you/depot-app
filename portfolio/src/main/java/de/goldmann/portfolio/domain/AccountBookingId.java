package de.goldmann.portfolio.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class AccountBookingId implements Serializable {

    private static final long serialVersionUID = 3075300961174598298L;
    private String isin;
    private LocalDate date;
    private BigDecimal amount;

    AccountBookingId() {
    }

    public AccountBookingId(
            final String isin,
            final LocalDate date,
            final BigDecimal amount) {
        Objects.requireNonNull(isin);
        Objects.requireNonNull(date);
        Objects.requireNonNull(amount);
        this.isin = isin;
        this.date = date;
        this.amount = amount;
    }

    public String getIsin() {
        return isin;
    }

    public LocalDate getDate() {
        return date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (amount == null ? 0
                : amount.hashCode());
        result = prime * result + (date == null ? 0
                : date.hashCode());
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
        final AccountBookingId other = (AccountBookingId) obj;
        if (amount == null) {
            if (other.amount != null) {
                return false;
            }
        }
        else if (!amount.equals(other.amount)) {
            return false;
        }
        if (date == null) {
            if (other.date != null) {
                return false;
            }
        }
        else if (!date.equals(other.date)) {
            return false;
        }
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

    @Override
    public String toString() {
        return "AccountBookingId [" + (isin != null ? "isin=" + isin + ", "
                : "")
                + (date != null ? "date=" + date + ", "
                        : "")
                + (amount != null ? "amount=" + amount
                        : "")
                + "]";
    }


}
