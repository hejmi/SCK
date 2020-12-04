package stringcalc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringCalcTest {

    @Test
    public void checkIfClassExists() {
        StringCalc calc = new StringCalc();
    }
    @Test
    public void returnsZeroIfStringIsEmpty() {
        StringCalc calc = new StringCalc();
        assertEquals(0, calc.add(""));
    }


}
