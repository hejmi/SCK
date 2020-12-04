package stringcalc;

public class StringCalc {
    private int theSum;
    private String negativeNums="";

    public int add(String numbers) {
        if (numbers.length()<1) {
            return 0;
        }

        numbers = returnReformatedString(numbers);

        numbers = numbers.replace("\n",",");

        String[] splitNumbers = numbers.split(",");
        for (String splitNumber : splitNumbers) {
            if (Integer.parseInt(splitNumber)<0) {
                negativeNums += splitNumber;
            }
            if (Integer.parseInt(splitNumber)>1000) continue;
            theSum += Integer.parseInt(splitNumber);
        }
        if (negativeNums.length()>0) {
            throw new IllegalArgumentException("Negatives not allowed: "+negativeNums);
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
