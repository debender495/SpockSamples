#Spock stubs (i.e. classes that hardcoded return values)
The idea is that somebody can focus only on these labels and understand what the unit tests does without actually 
looking at the code. In this particular example, the following blocks are contained:


        given: "a employ with example name values"
        and: "an entity manager that always returns this employ"
        and: "a employ reader which is the class under test"
        when: "we ask for the full name of the employ"
        
        then: "we get both the first and the last name"
        
        
Reading the block descriptions creates an English sentence that serves as a mini-specification of what the test does. 
The labels can be normal strings, so you should strive to name them according to your business domain and abstraction 
depth that suits you. Ideally, you should use full sentences to explain what each block does in a high-level manner.

The given: block contains just some Java code that creates a sample employ. 
The first and: block is where we actually create a fake object. 

In this particular case, we create a stub using the static method Stub() that Spock offers. 
We essentially tell Spock that it will need to create a fake object for the EntityManager class.

The most important line of the whole test is the next one. 
The line entityManager.find(Employ.class,1L) >> sampleEmploy instructs Spock, 
what to do when the find() method of the stub is called.