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

    @Test
    public void shouldReturnSumOnTwoNumbersDelimitedByComma(){
        assertEquals(3,Calculator.add("1,2"));
    }

    @Test
    public void shouldReturnSumOnMultipleNumbersDelimitedByComma(){
        assertEquals(6,Calculator.add("1,2,3"));
    }

    @Test
    public void shouldAcceptNewLineAsValidDelimiter(){
        assertEquals(6,Calculator.add("1,2\n3"));
    }

    @Test
    public void shouldAcceptCustomDelimiterSyntax(){
        assertEquals(3,Calculator.add("//;\n1;2"));
    }

    @Test
    public void customDelimiterCouldBeAlsoRegexSpecialChar(){
        assertEquals(3,Calculator.add("//.\n1.2"));
    }

    @Test
    public void shouldRaiseExceptionOnNegation(){
        try {
            Calculator.add("-1,2,3");
            fail("Exception expected.");
        }catch (RuntimeException exception){

        }
    }

    @Test
    public void exceptionMessageShouldContainTheNegativeNumbers(){
        try {
            Calculator.add("-1,-2,3");
            fail("Exception expected.");
        }catch (RuntimeException exception){
            assertEquals("Negatives not allowed: -1, -2",exception.getMessage());
        }
    }
}
