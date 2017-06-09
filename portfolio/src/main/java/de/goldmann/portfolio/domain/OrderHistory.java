package de.goldmann.portfolio.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orderhistory")
public class OrderHistory implements Serializable {

    private static final long serialVersionUID = -1130430694180431917L;

    public static final String PRICE            = "price";

    public static final String QUANTITY         = "quantity";

    public static final String TRANSACTION      = "orderAction";

    public static final String STAMP            = "stamp";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long              id;

    @ManyToOne
    @JoinColumn(name = "stockdata_isin", nullable = false)
    private StockData          stock;

    @Column(name = "price", nullable = false)
    private double            price;

    @Column(name = "quantity", nullable = false)
    private int               quantity;

    @Column(name = "orderaction", nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderAction       orderAction;

    @Column(name = "stamp", nullable = false)
    private LocalDate         stamp;

    OrderHistory() {}

    public OrderHistory(final StockData stock, final double price, final int quantity,
            final OrderAction orderAction) {
        this.stock = stock;
        this.price = price;
        this.quantity = quantity;
        this.orderAction = orderAction;
        stamp = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public StockData getStock() {
        return stock;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDate getStamp() {
        return stamp;
    }

    public void setStamp(final LocalDate stamp) {
        this.stamp = stamp;
    }

    public void setPrice(final double price) {
        this.price = price;
    }

    public void setQuantity(final int quantity) {
        this.quantity = quantity;
    }

    public OrderAction getOrderAction() {
        return orderAction;
    }

    @Override
    public String toString() {
        return "OrderHistory [price="
                + price
                + ", quantity="
                + quantity
                + ", "
                + (stamp != null ? "stamp=" + stamp : "")
                + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (id == null ? 0 : id.hashCode());
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
        final OrderHistory other = (OrderHistory) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

}
