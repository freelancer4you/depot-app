package de.goldmann.portfolio.ui.depot;

import com.vaadin.ui.UI;
import com.vaadin.ui.Window;

import de.goldmann.portfolio.services.AccountBookingReadingService;

@SuppressWarnings("serial")
public class UploadWindow extends Window {

    private static final String DIALOG_WIDTH = "32%";

    public UploadWindow(final AccountBookingReadingService accountBookingReadingService, final UI mainUi) {
        super();
        center();
        setWidth(DIALOG_WIDTH);
        setModal(true);
        setResizable(false);
        setContent(new UploadForm(this, accountBookingReadingService, mainUi));
    }

}
