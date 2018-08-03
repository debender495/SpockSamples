package more.example.mockStubinDao

import more.example.stub.Employ
import org.slf4j.Logger
import spock.lang.Specification

import javax.persistence.EntityManager

class EmployDaoSpec extends Specification{
    // Class to be tested
    private EmployDao employDao;

    // Dependencies (will be mocked)
    private EntityManager entityManager
    private Logger logger

    //Test data
    private Employ sampleEmploy

    /**
     * Runs before each test method, like the JUnit Before
     * annotation
     */
    def setup(){
        employDao = new EmployDao();

        entityManager = Stub(EntityManager.class)
        employDao.setEntityManager(entityManager)

        logger = Mock(Logger.class)
        employDao.setLogger(logger)
    }

    def "employ IDs are logged whenever they are saved in the DB"() {
        given: "an employ dao that assigns an ID to employ"
        entityManager.persist( _ as Employ) >> { Employ employ ->  employ.setId(123L)}

        when: "that employ is saved in the DB"
        employDao.saveEmploy("Foo", "Bar")

        then: "the ID is correctly logged"
        1 * logger.info("Saved employ with id {}", 123L)

    }
}