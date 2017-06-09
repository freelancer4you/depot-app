package de.goldmann.portfolio.ui.stocks;

import java.util.Objects;

import com.vaadin.ui.Button;
import com.vaadin.ui.UI;

import de.goldmann.portfolio.domain.OrderAction;
import de.goldmann.portfolio.ui.order.OrderCommand;
import de.goldmann.portfolio.ui.order.OrderController;
import de.goldmann.portfolio.ui.order.OrderDialog;

public class StockTableButton extends Button {

    private static final long serialVersionUID = 1L;

    public StockTableButton(final OrderAction action, final String isin, final OrderController orderController) {
        Objects.requireNonNull(action);
        setCaption(action.getBtnCaption());
        Objects.requireNonNull(isin, "isin");
        Objects.requireNonNull(orderController, "orderController");
        addClickListener(
                new StockTableButtonClickListener(action, isin, orderController)
                );
        addStyleName("primary-button");
    }

    class StockTableButtonClickListener implements ClickListener {

        private static final long                serialVersionUID = 1L;

        private final OrderAction                action;

        private final String                     isin;

        private final OrderController            orderController;

        public StockTableButtonClickListener(final OrderAction action, final String isin,
                final OrderController orderController) {
            this.action = Objects.requireNonNull(action, "action");
            this.isin = Objects.requireNonNull(isin, "isin");
            this.orderController = Objects.requireNonNull(orderController, "orderController");
        }

        @Override
        public void buttonClick(final ClickEvent event) {
            switch (action) {
                case BUY:
                case SELL:
                    UI.getCurrent().addWindow(
                            new OrderDialog(new OrderCommand(isin, orderController, action))
                            );
                    break;
                default:
                    break;
            }
        }
    }

}
