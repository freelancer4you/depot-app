package de.goldmann.portfolio.ui.depot;

import com.vaadin.ui.Window;

@SuppressWarnings("serial")
public class UploadWindow extends Window {
    private static final String DIALOG_WIDTH = "32%";
    public UploadWindow() {
        super();
        center();
        setWidth(DIALOG_WIDTH);
        setModal(true);
        setResizable(false);
        setContent(new UploadForm(this));
    }

}
