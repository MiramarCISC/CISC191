package edu.sdccd.cisc191;

import static org.junit.jupiter.api.Assertions.*;

class HelloWorldTest {
    private HelloWorld helloWorld;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        helloWorld = new HelloWorld();
    }

    @org.junit.jupiter.api.Test
    void getHelloWorld() {
        assertEquals(helloWorld.getHelloWorld(), "hello world!");
    }

    @org.junit.jupiter.api.Test
    void setHelloWorld() {
        String espanol = "¡hola mundo!";
        helloWorld.setHelloWorld(espanol);
        assertEquals(helloWorld.getHelloWorld(), espanol);
    }
}