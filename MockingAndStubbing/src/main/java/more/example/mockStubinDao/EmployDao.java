package more.example.mockStubinDao;

import lombok.Setter;
import more.example.stub.Employ;
import org.slf4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Setter
public class EmployDao {

    @PersistenceContext
    private EntityManager entityManager;

    private Logger logger;

    public void saveEmploy(String firstName, String lastName) {
        if(firstName == null || lastName==null) {
            logger.error("Missing employ information");
            throw new IllegalArgumentException();
        }
        Employ employ = new Employ(firstName,lastName);
        entityManager.persist(employ);
        entityManager.flush();
        logger.info("Saved employ with id {}", employ.getId());
    }

}
