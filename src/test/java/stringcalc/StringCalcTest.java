package stringcalc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringCalcTest {
    StringCalc calc = new StringCalc();
    @Test
    public void checkIfClassExists() {
    }
    @Test
    public void returnsZeroIfStringIsEmpty() {
        assertEquals(0, calc.add(""));
    }
    @Test
    public void returnsTheSumOfInputNumbers() {
        assertEquals(10, calc.add("9,1"));
    }
    @Test
    public void returnsTheSumOfSingleNumber() {
        assertEquals(9, calc.add("9"));
    }
    @Test
    public void returnsTheSumOfMultipleNumbersInput() {
        assertEquals(12, calc.add("2,2,2,2,4"));
    }
    @Test
    public void returnsTheSumAndHandlesNewLinesBetweenNumbers() {
        assertEquals(6, calc.add("1\n2,3"));
    }
    @Test
    public void returnsTheSumAndHandlesNewLinesBetweenNumbersAndComma() {
        assertEquals(1, calc.add("1,\n"));
    }
    @Test
    public void returnsTheSumWithNewDelimiter(){
        assertEquals(12, calc.add("//;\n2;2;2;6"));
    }
    @Test
    public void throwsExeptionWithNegativeNumbers() {
        assertThrows(IllegalArgumentException.class, ()->calc.add("2,-2,2,-6"));
    }
    @Test
    public void numbersBiggerThan1000WillBeIgnored() {
        assertEquals(2, calc.add("2,1001"));
    }
    @Test
    public void acceptsAnyLengthOnDelimiter() {
        assertEquals(6, calc.add("//[***]\n1***2***3"));
    }
    @Test
    public void acceptsMultipleDelimitersWithAnyLength() { assertEquals(10, calc.add("//[g][***][;]\n4g1***2;3"));
    }
}
