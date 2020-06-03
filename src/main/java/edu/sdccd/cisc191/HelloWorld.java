package edu.sdccd.cisc191;

/**
 * A class to store hello world! strings
 */
public class HelloWorld {
    private String helloWorld;

    public HelloWorld() {
        helloWorld = "hello world!";
    }

    /**
     * Getter for helloWorld object variable
     * @return helloWorld
     */
    public String getHelloWorld() {
        return helloWorld;
    }

    /**
     * Setter for helloWorld object variable
     * @param helloWorld a hello world! string
     */
    public void setHelloWorld(String helloWorld) {
        this.helloWorld = helloWorld;
    }
}
