package more.example.mockAndstub;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Event {

    public enum Type  {REMINDER_SENT, REGISTRATION, INVOICE_ISSUED, PAYMENT, SETTLEMENT};

    private Type type;
    private String employName;
    private LocalDate timestamp;

}
