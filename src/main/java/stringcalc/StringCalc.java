package stringcalc;

public class StringCalc {
    public int theSum;
    public int add(String numbers) {
        if (numbers.length()<1) {
            return 0;
        }
        String[] splitNumbers = numbers.split(",");
        for (String splitNumber : splitNumbers) {
            theSum += Integer.parseInt(splitNumber);
        }
        return theSum;
    }
}
