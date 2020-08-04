package com.example.calculatordemo.bean;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@SpringBootTest
public class CalculatorTest {
    @Test
    public void shouldReturnZeroOnEmptyString(){
        assertEquals(0,Calculator.add(""));
    }

    @Test
    public void shouldReturnNumberOnNumber(){
        assertEquals(1,Calculator.add("1"));
    }
}
