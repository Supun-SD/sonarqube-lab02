package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void testCalculateAdd() {
        assertEquals(15, calculator.calculate(10, 5, "add"));
    }

    @Test
    void testCalculateAddAgain() {
        assertEquals(15, calculator.calculate(10, 5, "add-again"));
    }

    @Test
    void testCalculateSub() {
        assertEquals(5, calculator.calculate(10, 5, "sub"));
    }

    @Test
    void testCalculateSubAgain() {
        assertEquals(5, calculator.calculate(10, 5, "sub-again"));
    }

    @Test
    void testCalculateMul() {
        assertEquals(50, calculator.calculate(10, 5, "mul"));
    }

    @Test
    void testCalculateDiv() {
        assertEquals(2, calculator.calculate(10, 5, "div"));
    }

    @Test
    void testCalculateDivByZero() {
        assertEquals(0, calculator.calculate(10, 0, "div"));
    }

    @Test
    void testCalculateMod() {
        assertEquals(0, calculator.calculate(10, 5, "mod"));
        assertEquals(1, calculator.calculate(10, 3, "mod"));
    }

    @Test
    void testCalculatePow() {
        assertEquals(1024, calculator.calculate(2, 10, "pow"));
    }

    @Test
    void testCalculateUnknown() {
        assertEquals(0, calculator.calculate(10, 5, "unknown"));
    }

    @Test
    void testAddNumbers() {
        assertEquals(15, calculator.addNumbers(10, 5));
    }

    @Test
    void testSumValues() {
        assertEquals(15, calculator.sumValues(10, 5));
    }

    @Test
    void testAddAgain() {
        assertEquals(15, calculator.addAgain(10, 5));
    }
}
