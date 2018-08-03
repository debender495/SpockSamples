package more.example.stub;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Staff {
    private long id;

    private String firstName;

    private String lastName;
}
