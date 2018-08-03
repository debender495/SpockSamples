package example.helloworld

import spock.lang.Specification
import spock.lang.Unroll

class MoreExamples extends Specification {

    @Unroll
    def "length of #name is #length"() {
        expect:
        name.size() == length

        where:
        name      | length
        "Java"    | 4
        "Angular" | 7
        "Spring"  | 6
    }

    @Unroll
    def "maximum of #a #b #c two numbers"() {
        expect:
        Math.max(a, b) == c

        where:
        a << [3, 5, 9]
        b << [7, 4, 9]
        c << [7, 5, 9]
    }

    @Unroll
    def "minimum of #a and #b is #c"() {
        expect:
        Math.min(a, b) == c

        where:
        a | b || c
        3 | 7 || 3
        5 | 4 || 4
        9 | 9 || 9
    }

    @Unroll
    def "#country.name likes #game.toLowerCase()"() {
        expect:
        country.getGames() == game

        where:
        country                     || game
        new Country(name: "India")  || "Cricket"
        new Country(name: "Brazil") || "Soccer"
    }

    static class Country {
        String name

        String getGames() {
            name == "India" ? "Cricket" : "Soccer"
        }
    }
}
