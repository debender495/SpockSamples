package example.helloworld

import spock.lang.Specification

class HelloWorldGroovySpec extends Specification {
    def "Get Hello Message"() {
        when:
            String msg = HelloWorldGroovy.helloMessage
        then:
            msg.equals("Hello from Groovy class property magic.")
    }
}
