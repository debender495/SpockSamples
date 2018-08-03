package more.example.stub

import spock.lang.Specification

import javax.persistence.EntityManager

class EmployReader2Spec extends Specification {
    //Class to be tested
    private EmployReader employReader;

    //Dependencies
    private EntityManager entityManager;

    /**
     * Runs before each test method, like the JUnit Before
     * annotation
     */
    def setup() {
        employReader = new EmployReader();

        entityManager = Stub(EntityManager.class);
        employReader.setEntityManager(entityManager);
    }


    def "employ full name is formed from first name and last name"() {
        given: "an employ with example name values"
        Employ sampleEmploy = new Employ()
        sampleEmploy.setFirstName("Foo")
        sampleEmploy.setLastName("Bar")

        and: "an entity manager that always returns this employ"
        entityManager.find(Employ.class, 1L) >> sampleEmploy

        when: "we ask for the full name of the employ"
        String fullName = employReader.findFullName(1L)

        then: "we get both first and last name"
        fullName == "Foo Bar"
    }

    //As an exercise, feel free to correct the EmployReader implementation and also add extra unit tests
    // when the first and/or last name are null themselves.

    def "employ is not in the database"() {
        given: "the database has no record for the employ"
        entityManager.find(Employ.class, 1L) >> null

        when: "we ask for the full name of the employ"
        String fullName = employReader.findFullName(1L)

        then: "the empty string should be returned"
        fullName == ""
    }
}

