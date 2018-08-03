package more.example.mock

import more.example.stub.Employ
import spock.lang.Specification

class BillDelayNotificationSpec extends Specification {
    //Class to be tested
    BillDelayNotification billDelayNotification

    //Dependencies (will be mocked)
    EmailSender emailSender
    InvoiceStorage invoiceStorage

    //Test data
    Employ sampleEmploy

    /**
     * Runs before each test method, like the JUnit Before
     * annotation
     */
    def setup() {
        invoiceStorage = Stub(InvoiceStorage.class)
        emailSender = Mock(EmailSender.class)

        billDelayNotification = new BillDelayNotification(emailSender, invoiceStorage);

        sampleEmploy = new Employ()
        sampleEmploy.setFirstName("Foo")
        sampleEmploy.setLastName("Bar")
    }

    def "a delay in invoice should trigger an email"() {
        given: "an employ with a late invoice"
        invoiceStorage.hasOutstandingInvoice(sampleEmploy) >> true

        when: "we check if an email should be sent"
        billDelayNotification.notifyIfLate(sampleEmploy)

        then: "the employ is indeed emailed"
        1 * emailSender.sendEmail(sampleEmploy)
    }

    def "no late invoices"() {
        given: "an employ with good standing"
        invoiceStorage.hasOutstandingInvoice(sampleEmploy) >> false

        when: "we check if an email should be sent"
        billDelayNotification.notifyIfLate(sampleEmploy)

        then: "an email is never sent out"
        0 * emailSender.sendEmail(sampleEmploy)
    }


}