package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdditionExampleTest {
    private final AdditionExample additionExample = new AdditionExample();

    @Test
    void add() {
        assertEquals(10, additionExample.add(5, 5));
    }

    @Test
    void sub() {
        assertEquals(10, additionExample.sub(5, 5));
    }

    @Test
    void mul() {
        assertEquals(25, additionExample.mul(5, 5));
    }

    @Test
    void div() {
        assertEquals(1, additionExample.div(5, 5));
        assertThrows(ArithmeticException.class, () -> additionExample.div(5, 0));
    }
}