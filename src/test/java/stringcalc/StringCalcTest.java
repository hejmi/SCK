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

}
