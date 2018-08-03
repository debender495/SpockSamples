# maven-java-groovy-spock-example
Barebone Maven project for Java together with Groovy and Spock Test Framework.

Mandatory dependencies for using Spock


        <dependency>
            <groupId>org.spockframework</groupId>
            <artifactId>spock-core</artifactId>
            <version>1.1-groovy-2.4</version>
            <scope>test</scope>
        </dependency>
        <!-- Optional dependencies for using Spock -->
        <dependency> <!-- enables mocking of classes (in addition to interfaces) -->
            <groupId>cglib</groupId>
            <artifactId>cglib-nodep</artifactId>
            <version>3.1</version>
            <scope>test</scope>
        </dependency>
        <dependency> <!-- enables mocking of classes without default constructor (together with CGLIB) -->
            <groupId>org.objenesis</groupId>
            <artifactId>objenesis</artifactId>
            <version>2.1</version>
            <scope>test</scope>
        </dependency>
        <dependency> <!-- only necessary if Hamcrest matchers are used -->
            <groupId>org.hamcrest</groupId>
            <artifactId>hamcrest-core</artifactId>
            <version>1.3</version>
            <scope>test</scope>
        </dependency>
    </dependencies>