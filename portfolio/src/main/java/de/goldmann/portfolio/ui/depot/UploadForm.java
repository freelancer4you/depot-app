package de.goldmann.portfolio.ui.depot;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.Objects;

import com.vaadin.server.Page;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.Upload;
import com.vaadin.ui.Upload.Receiver;
import com.vaadin.ui.Upload.SucceededEvent;
import com.vaadin.ui.Upload.SucceededListener;

import de.goldmann.portfolio.services.AccountBookingReadingService;

@SuppressWarnings("serial")
public class UploadForm extends HorizontalLayout{

    public UploadForm(
            final UploadWindow uploadWindow,
            final AccountBookingReadingService accountBookingReadingService,
            final UI mainUi) {
        Objects.requireNonNull(uploadWindow);
        Objects.requireNonNull(accountBookingReadingService);
        Objects.requireNonNull(mainUi);
        final FileReceiver uploadReceiver = new FileReceiver(accountBookingReadingService, uploadWindow, mainUi);
        final Upload upload = new Upload("Upload it here", uploadReceiver);
        upload.addSucceededListener(uploadReceiver);
        addComponent(upload);
    }

    class FileReceiver implements Receiver, SucceededListener {

        private Path fileTmp;
        private final AccountBookingReadingService accountBookingReadingService;
        private final UploadWindow uploadWindow;
        private final UI mainUi;

        public FileReceiver(final AccountBookingReadingService accountBookingReadingService,
                final UploadWindow uploadWindow,
                final UI mainUi) {
            super();
            this.accountBookingReadingService = accountBookingReadingService;
            this.uploadWindow = uploadWindow;
            this.mainUi = mainUi;
        }

        @Override
        public void uploadSucceeded(final SucceededEvent event) {
            accountBookingReadingService.readAndSaveBookingData(fileTmp);
            new Notification("Depot wurde aktualisiert.", Notification.Type.TRAY_NOTIFICATION).show(Page.getCurrent());
            uploadWindow.close();
            // TODO so wird die Oberfläche nicht aktualisiert
            mainUi.getNavigator().navigateTo(DepotView.VIEW_NAME);
        }

        @Override
        public OutputStream receiveUpload(final String filename, final String mimeType) {
            // Create upload stream
            FileOutputStream fos = null; // Stream to write to
            try {
                // Open the file for writing.
                fileTmp = Files.createTempFile(
                        filename.substring(0, filename.indexOf(".") - 1),
                        filename.substring(filename.indexOf("."), filename.length()),
                        new FileAttribute<?>[] {});

                fos = new FileOutputStream(fileTmp.toFile());
            }
            catch (final IOException e)
            {
                new Notification("Could not open file<br/>", e.getMessage(), Notification.Type.ERROR_MESSAGE)
                .show(Page.getCurrent());
                return null;
            }
            return fos; // Return the output stream to write to
        }
    }

}
