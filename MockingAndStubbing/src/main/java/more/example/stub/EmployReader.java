package more.example.stub;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Getter
@Setter
public class EmployReader {
    @PersistenceContext
    private EntityManager entityManager;

    public String findFullName(Long empID) {
        Employ employ = entityManager.find(Employ.class, empID);
        return employ.getFirstName() + " " + employ.getLastName();
    }

}
