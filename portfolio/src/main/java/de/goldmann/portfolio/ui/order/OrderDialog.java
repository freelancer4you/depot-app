package de.goldmann.portfolio.ui.order;

import com.vaadin.ui.Window;

public class OrderDialog extends Window {

    private static final String DIALOG_WIDTH    = "32%";
    private static final long serialVersionUID = 1L;

    public OrderDialog(final OrderCommand command) {
        super(command.getWindowCaption());

        center();
        setWidth(DIALOG_WIDTH);
        setModal(true);
        setResizable(false);
        setContent(new OrderForm(command, this));
    }

}
