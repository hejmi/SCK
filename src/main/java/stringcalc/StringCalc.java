package stringcalc;

public class StringCalc {
    public int theSum;
    public int add(String numbers) {
        if (numbers.length()<1) {
            return 0;
        }

        numbers = returnReformatedString(numbers);

        numbers = numbers.replace("\n",",");

        String[] splitNumbers = numbers.split(",");
        for (String splitNumber : splitNumbers) {
            theSum += Integer.parseInt(splitNumber);
        }
        return theSum;
    }

    private String returnReformatedString(String numbers) {
        if (numbers.startsWith("//")) {
            String delimiter = numbers.substring(2, 3);
            numbers = numbers.replace(delimiter, ",");
            numbers = numbers.substring(4);
        }
        return numbers;
    }
}
