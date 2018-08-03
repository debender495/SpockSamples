package more.example.mock;

import more.example.stub.Employ;

public interface InvoiceStorage {

    boolean hasOutstandingInvoice(Employ employ);
}
