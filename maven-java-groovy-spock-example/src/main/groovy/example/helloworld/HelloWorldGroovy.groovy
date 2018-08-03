package example.helloworld

class HelloWorldGroovy {

    static void main(String... args){
        println helloWorld()
        println helloWorld2()
        println helloMessage
        HelloWorldJava.sayHello()
    }

    static def helloWorld() {
        "Hello from Groovy dynamic method!"
    }

    static String helloWorld2() {
        return "Hello from Groovy strong typed method!"
    }

    static def getHelloMessage(){
        "Hello from Groovy class property magic."
    }
}
