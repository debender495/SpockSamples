package more.example.mockAndstub

import more.example.mock.BillDelayNotification
import more.example.mock.EmailSender
import more.example.mock.InvoiceStorage
import more.example.stub.Employ
import spock.lang.Specification

class EventCheckSpec extends Specification{
    //Class to be tested
    private BillDelayNotification billDelayNotification;

    //Dependencies (will be mocked)
    private EmailSender emailSender;
    private InvoiceStorage invoiceStorage;
    private EventRecorder eventRecorder;

    //Test data
    private Employ sampleEmploy;

    /**
     * Runs before each test method, like the JUnit Before
     * annotation
     */
    def setup(){
        invoiceStorage = Stub(InvoiceStorage.class)
        emailSender = Mock(EmailSender.class)
        eventRecorder = Mock(EventRecorder.class)

        billDelayNotification = new BillDelayNotification(emailSender,invoiceStorage,eventRecorder);
        sampleEmploy = new Employ();
        sampleEmploy.setFirstName("Foo")
        sampleEmploy.setLastName("Bar")
    }

    def "email about delay in invoice should contain employ details"() {
        given: "an employ with a delayed invoice"
        invoiceStorage.hasOutstandingInvoice(sampleEmploy) >> true

        when: "we check if an email should be sent"
        billDelayNotification.notifyIfLate(sampleEmploy)

        then: "the employ is indeed emailed"
        1 * emailSender.sendEmail(sampleEmploy)

        and: "the event is recorded with the respective details"
        0 * eventRecorder.recordEvent({
            event ->
                event.getTimestamp() != null &&
                        event.getType() == Type.REMINDER_SENT &&
                        event.getEmployName() == "Foo Bar"
        } as Event)
    }

}