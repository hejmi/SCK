package stringcalc;

public class StringCalc {
    private int theSum;
    private String negativeNums="";
    private String delimiter="";
    public int add(String numbers) {
        if (numbers.length()<1) {
            return 0;
        }
        numbers = returnReformatedString(numbers);

        String[] splitNumbers = numbers.split(",");
        for (String splitNumber : splitNumbers) {
            if (Integer.parseInt(splitNumber)<0) negativeNums += splitNumber;
            if (Integer.parseInt(splitNumber)>1000) continue;
            theSum += Integer.parseInt(splitNumber);
        }
        if (negativeNums.length()>0) {
            throw new IllegalArgumentException("Negatives not allowed: "+negativeNums);
        }
        return theSum;
    }

    private String returnReformatedString(String numbers) {
        if (numbers.startsWith("//[")) {
            if (numbers.indexOf("]") != numbers.lastIndexOf("]")) {
                while(true) {
                    delimiter = "";
                    for (int i = numbers.indexOf("[")+1; i < numbers.indexOf("]"); i++) {
                        delimiter = delimiter + numbers.charAt(i);
                    }
                    numbers = numbers.replace(delimiter, ",");
                    if (numbers.indexOf("]") == numbers.lastIndexOf("]")) {
                        break;
                    } else {
                        numbers = numbers.replace("[,]", "");
                    }
                }
                numbers = numbers.replace("[,]", "");
                numbers = numbers.substring(2);
                numbers = numbers.replace("\n","");
            } else {
                for (int i = numbers.indexOf("[") + 1; i < numbers.indexOf("]"); i++) {
                    delimiter = delimiter + numbers.charAt(i);
                }
                numbers = numbers.substring(5 + delimiter.length());
                numbers = numbers.replace(delimiter, ",");
            }
        } else if (numbers.startsWith("//")) {
            String delimiter = numbers.substring(2, 3);
            numbers = numbers.replace(delimiter, ",");
            numbers = numbers.substring(4);
        }
        numbers = numbers.replace("\n",",");
        return numbers;
    }
}
