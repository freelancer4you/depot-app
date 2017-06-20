package de.goldmann.portfolio.ui.depot;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.vaadin.server.Page;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Upload;
import com.vaadin.ui.Upload.Receiver;
import com.vaadin.ui.Upload.SucceededEvent;
import com.vaadin.ui.Upload.SucceededListener;

@SuppressWarnings("serial")
public class UploadForm extends HorizontalLayout{

    public UploadForm(
            final UploadWindow uploadWindow) {

        final Upload upload = new Upload("Upload it here", new FileReceiver());
        addComponent(upload);
    }

    @SuppressWarnings("serial")
    class FileReceiver implements Receiver, SucceededListener {

        public File file;

        @Override
        public void uploadSucceeded(final SucceededEvent event) {
            System.out.println("uploadSucceeded");
        }

        @Override
        public OutputStream receiveUpload(final String filename, final String mimeType) {
            // Create upload stream
            FileOutputStream fos = null; // Stream to write to
            try {
                // Open the file for writing.
                file = new File("/tmp/uploads/" + filename);
                fos = new FileOutputStream(file);
            } catch (final java.io.FileNotFoundException e) {
                new Notification("Could not open file<br/>", e.getMessage(), Notification.Type.ERROR_MESSAGE)
                .show(Page.getCurrent());
                return null;
            }
            return fos; // Return the output stream to write to
        }
    }

}
