package more.example.stub

import spock.lang.Specification

import javax.persistence.EntityManager

class EmployReaderSpec extends Specification {

    def "employ full name is formed from first name and last name"() {
        given: "an employ with example name values"
        Employ sampleEmploy = new Employ()
        sampleEmploy.setFirstName("Foo")
        sampleEmploy.setLastName("Bar")

        and: "an entity manager that always returns this employ"
        EntityManager entityManager = Stub(EntityManager.class)
        entityManager.find(Employ.class,1L) >> sampleEmploy

        and: "an employ reader which is the class under test"
        EmployReader employReader = new EmployReader()
        employReader.setEntityManager(entityManager)

        when: "we ask for the full name of the employ"
        def fullName = employReader.findFullName(1L)

        then: "we get both the first and the last name"
        fullName == "Foo Bar"
    }
}
