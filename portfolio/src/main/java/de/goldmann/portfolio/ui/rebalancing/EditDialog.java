package de.goldmann.portfolio.ui.rebalancing;

import com.vaadin.ui.Window;

public class EditDialog extends Window {

    private static final String DIALOG_WIDTH     = "26%";
    private static final long serialVersionUID = 1L;

    public EditDialog(final SaveCommand command) {
        center();
        setWidth(DIALOG_WIDTH);
        setModal(true);
        setResizable(false);
        setContent(new EditForm(this, command));
    }

}
