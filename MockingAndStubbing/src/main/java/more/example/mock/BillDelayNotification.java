package more.example.mock;

import lombok.AllArgsConstructor;
import more.example.mockAndstub.EventRecorder;
import more.example.stub.Employ;

@AllArgsConstructor
public class BillDelayNotification {

    private final EmailSender emailSender;
    private final InvoiceStorage invoiceStorage;
    private EventRecorder eventRecorder;


    public BillDelayNotification(final EmailSender emailSender, final InvoiceStorage invoiceStorage) {
        this.emailSender = emailSender;
        this.invoiceStorage = invoiceStorage;
    }

    public void notifyIfLate(Employ employ) {
        if (invoiceStorage.hasOutstandingInvoice(employ)) {
            emailSender.sendEmail(employ);
        }
    }
}
