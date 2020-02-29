package com.javarush.task.task34.task3404;

import javafx.util.Pair;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

/*
Рекурсия для мат. выражения
*/
public class Solution {

    public static void main(String[] args) {

        Solution solution = new Solution();

        solution.recursion("sin(45) - cos(45)", 0);

        String s = "10 * sin(90)";
        System.out.print(s + " expected output 10 2 actually ");
        solution.recursion(s, 0);

        s = "sin(2*(-5+1.5*4)+28)";
        System.out.print(s + " expected output 0.5 6 actually ");
        solution.recursion(s, 0);

        s = "1^cos(0)";
        System.out.print(s + " expected output 1 2 actually ");
        solution.recursion(s, 0);

        s = "-2^(-2)";
        System.out.print(s + " expected output -0.25 3 actually ");
        solution.recursion(s, 0);
        s = "-(-2^(-2))+2+(-(-2^(-2)))";
        System.out.print(s + " expected output 2.5 10 actually ");
        solution.recursion(s, 0);
        s = "(-2)*(-2)";
        System.out.print(s + " expected output 4 3 actually ");
        solution.recursion(s, 0);
        s = "(-2)/(-2)";
        System.out.print(s + " expected output 1 3 actually ");
        solution.recursion(s, 0);
        s = "sin(-30)";
        System.out.print(s + " expected output -0.5 2 actually ");
        solution.recursion(s, 0);
        s = "cos(-30)";
        System.out.print(s + " expected output 0.87 2 actually ");
        solution.recursion(s, 0);
        s = "tan(-30)";
        System.out.print(s + " expected output -0.58 2 actually ");
        solution.recursion(s, 0);
        s = "2+8*(9/4-1.5)^(1+1)";
        System.out.print(s + " expected output 6.5 6 actually ");
        solution.recursion(s, 0);
        s = "0.005 ";
        System.out.print(s + " expected output 0.01 0 actually ");
        solution.recursion(s, 0);
        s = "-0.0049 ";
        System.out.print(s + " expected output 0 0 actually ");
        solution.recursion(s, 0);
        s = "0+0.304";
        System.out.print(s + " expected output 0.3 1 actually ");
        solution.recursion(s, 0);
        s = "10-2^(2-1+1)";
        System.out.print(s + " expected output 6 4 actually ");
        solution.recursion(s, 0);
        s = "2^10+2^(5+5)";
        System.out.print(s + " expected output 2048 4 actually ");
        solution.recursion(s, 0);
        s = "1.01+(2.02-1+1/0.5*1.02)/0.1+0.25+41.1";
        System.out.print(s + " expected output 72.96 8 actually ");
        solution.recursion(s, 0);
        s = "0.000025+0.000012";
        System.out.print(s + " expected output 0 1 actually ");
        solution.recursion(s, 0);
        s = "-2-(-2-1-(-2)-(-2)-(-2-2-(-2)-2)-2-2)";
        System.out.print(s + " expected output -3 16 actually ");
        solution.recursion(s, 0);
        s = "cos(3 + 19*3)";
        System.out.print(s + " expected output 0.5 3 actually ");
        solution.recursion(s, 0);
        s = "2*(589+((2454*0.1548/0.01*(-2+9^2))+((25*123.12+45877*25)+25))-547)";
        System.out.print(s + " expected output 8302231.36 14 actually ");
        solution.recursion(s, 0);
        s = "(-1 + (-2))";
        System.out.print(s + " expected output -3 3 actually ");
        solution.recursion(s, 0);
        s = "-sin(2*(-5+1.5*4)+28)";
        System.out.print(s + " expected output -0.5 7 actually ");
        solution.recursion(s, 0);
        s = "sin(100)-sin(100)";
        System.out.print(s + " expected output 0 3 actually ");
        solution.recursion(s, 0);
        s = "sin(2*(-5+1.5*4)+28)";
        System.out.print(s + " expected output 0.5 6 actually ");
        solution.recursion(s, 0);
        s = "tan(45)";
        System.out.print(s + " expected output 1 1 actually ");
        solution.recursion(s, 0);
        s = "tan(-45)";
        System.out.print(s + " expected output -1 2 actually ");
        solution.recursion(s, 0);
        s = "0.305";
        System.out.print(s + " expected output 0.3 0 actually ");
        solution.recursion(s, 0);
        s = "0.3051";
        System.out.print(s + " expected output 0.31 0 actually ");
        solution.recursion(s, 0);
        s = "(0.3051)";
        System.out.print(s + " expected output 0.31 0 actually ");
        solution.recursion(s, 0);
        s = "1+(1+(1+1)*(1+1))*(1+1)+1";
        System.out.print(s + " expected output 12 8 actually ");
        solution.recursion(s, 0);
        s = "tan(44+sin(89-cos(180)^2))";
        System.out.print(s + " expected output 1 6 actually ");
        solution.recursion(s, 0);
        s = "-2+(-2+(-2)-2*(2+2))";
        System.out.print(s + " expected output -14 8 actually ");
        solution.recursion(s, 0);
        s = "sin(80+(2+(1+1))*(1+1)+2)";
        System.out.print(s + " expected output 1 7 actually ");
        solution.recursion(s, 0);
        s = "1+4/2/2+2^2+2*2-2^(2-1+1)";
        System.out.print(s + " expected output 6 11 actually ");
        solution.recursion(s, 0);

    }

    public void recursion(final String expression, int countOperation) {

        if (expression.contains("(")) {

            //разделяем строку с выражением на три строки
            // [0] выражение до самых внутренних скобок
            // [1] выражение внутри внутренних скобок
            // [2] выражение после внутренних скобок
            String[] strings = splitStringByInnerBraces(expression);

            //Рассматриваем все возможныеварианты значений перед скобками
            if (strings[0].endsWith("sin")) {

                countOperation += countOperations(strings[1]) + 1;
                Double d = calculateExpression(strings[1]);
                Double result = Math.sin(Math.toRadians(d));
                if (result < 0)
                    countOperation--;
                String firsArgument = strings[0].substring(0, strings[0].length() - 3);
                recursion(firsArgument + result + strings[2], countOperation);

            } else if (strings[0].endsWith("cos")) {

                countOperation += countOperations(strings[1]) + 1;
                Double d = calculateExpression(strings[1]);
                Double result = Math.cos(Math.toRadians(d));
                if (result < 0)
                    countOperation--;
                String firsArgument = strings[0].substring(0, strings[0].length() - 3);
                recursion(firsArgument + result + strings[2], countOperation);

            } else if (strings[0].endsWith("tan")) {

                countOperation += countOperations(strings[1]) + 1;
                Double d = calculateExpression(strings[1]);
                Double result = Math.tan(Math.toRadians(d));
                if (result < 0)
                    countOperation--;
                String firsArgument = strings[0].substring(0, strings[0].length() - 3);
                recursion(firsArgument + result + strings[2], countOperation);

            } else if (strings[0].endsWith("^")) {

                countOperation += countOperations(strings[1]) + 1;
                Double d = calculateExpression(strings[1]);
                Pair<String, Double> pair = cutLastNumberAndExpression(strings[0]);
                Double result = Math.pow(pair.getValue(), d);
                if (result < 0)
                    countOperation--;
                recursion(pair.getKey() + result + strings[2], countOperation);

            } else {
                countOperation += countOperations(strings[1]);
                Double result = calculateExpression(strings[1]);
                if (result < 0)
                    countOperation--;
                recursion(strings[0] + result + strings[2], countOperation);
            }
        }

        //если выражение уже не содержит скобок
        //то считаем результат и выводим на экран
        else {
            countOperation += countOperations(expression);
            Double d = calculateExpression(expression);
            if (d == -0d) {
                d = 0d;
            }
            NumberFormat nf = new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.ENGLISH));
            String mystr = nf.format(d);
            if(mystr.equals("-0")){
                mystr="0";
            }
            System.out.println(String.format("%s %d", mystr, countOperation));
        }
    }

    public Solution() {
        //don't delete
    }

    /**
     * sin(2*(-5+1.5*4)+28)
     * <p>
     * goes to
     * <p>
     * sin(2*
     * -5+1.5*4
     * +28)
     */
    public String[] splitStringByInnerBraces(String s) {
        String[] strings = new String[3];

        int indexOfClosing = s.indexOf(')');

        String temp = s.substring(0, indexOfClosing);

        int indexOfOpening = temp.lastIndexOf('(') + 1;

        strings[0] = s.substring(0, indexOfOpening - 1);
        strings[1] = s.substring(indexOfOpening, indexOfClosing);
        strings[2] = s.substring(indexOfClosing + 1);

        return strings;
    }

    public int countOperations(String s) {

        int countOperation = 0;

        int sin = s.toLowerCase().split("sin").length - 1;
        int cos = s.toLowerCase().split("cos").length - 1;
        int tan = s.toLowerCase().split("tan").length - 1;
        int pow = s.toLowerCase().split("\\^").length - 1;
        int plus = s.toLowerCase().split("\\+").length - 1;
        int minus = s.toLowerCase().split("-").length - 1;
        int multy = s.toLowerCase().split("\\*").length - 1;
        int division = s.toLowerCase().split("/").length - 1;

        if (sin > 0)
            countOperation += sin;
        if (cos > 0)
            countOperation += cos;
        if (tan > 0)
            countOperation += tan;
        if (pow > 0)
            countOperation += pow;
        if (plus > 0)
            countOperation += plus;
        if (minus > 0)
            countOperation += minus;
        if (multy > 0)
            countOperation += multy;
        if (division > 0)
            countOperation += division;

        return countOperation;
    }

    /**
     * Expression  2+6^
     * <p>
     * goes to
     * <p>
     * String "2+"
     * Double "6.0"
     */
    public Pair<String, Double> cutLastNumberAndExpression(String string) {

        string = string.replaceAll(" ", "");

        StringBuilder number = new StringBuilder();
        StringBuilder notNUmber = new StringBuilder();

        string = new StringBuilder(string).reverse().toString();

        boolean numberIsCollected = false;
        for (int i = 0; i < string.length(); i++) {

            if (((string.charAt(i) >= '0' && string.charAt(i) <= '9')
                    || string.charAt(i) == '.')
                    && !numberIsCollected) {
                number.append(string.charAt(i));
            } else if (number.length() > 0) {
                numberIsCollected = true;
                notNUmber.append(string.charAt(i));
            }
        }

        number = number.reverse();
        notNUmber = notNUmber.reverse();
        Double d = Double.parseDouble(number.toString());

        Pair<String, Double> pair = new Pair<>(notNUmber.toString(), d);

        return pair;
    }

    public String calculateInnerPows(String expression) {

        do {
            int tempI = expression.indexOf('^');

            String firstPart = expression.substring(0, tempI);
            String secondPart = expression.substring(tempI + 1);

            Pair<String, Double> firstPair = cutLastNumberAndExpression(firstPart);

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < secondPart.length(); i++) {
                if ((secondPart.charAt(i) >= '0' && secondPart.charAt(i) <= '9')
                        || secondPart.charAt(i) == '.') {
                    sb.append(secondPart.charAt(i));
                } else break;
            }

            secondPart = expression.substring(sb.toString().length() + firstPart.length() + 1);
            firstPart = firstPair.getKey();

            Double d = Math.pow(firstPair.getValue(), Double.parseDouble(sb.toString()));

            expression = firstPart + d + secondPart;
        }
        while (expression.contains("^"));

        return expression;
    }

    public Double calculateExpression(String expression) {

        expression = expression.replaceAll(" ", "");
        expression = expression.replaceAll("--", "+");
        expression = expression.replaceAll("\\+-", "-");

        if (expression.contains("^")) {
            expression = calculateInnerPows(expression);
        }

        expression = expression.replaceAll("--", "+");

        if (expression.contains("/-")) {
            expression = expression.replaceAll("/-", "!");
            expression = calculateInnerDelMin(expression);
        }

        expression = expression.replaceAll("--", "+");

        if (expression.contains("*-")) {
            expression = expression.replaceAll("\\*-", "!");
            expression = calculateInnerMultMin(expression);
        }

        expression = expression.replaceAll("--", "+");

        return Calculation.calculateExpression(expression);

    }

    private String calculateInnerMultMin(String expression) {

        do {
            int tempI = expression.indexOf('!');

            String firstPart = expression.substring(0, tempI);
            String secondPart = expression.substring(tempI + 1);

            Pair<String, Double> firstPair = cutLastNumberAndExpression(firstPart);

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < secondPart.length(); i++) {
                if ((secondPart.charAt(i) >= '0' && secondPart.charAt(i) <= '9')
                        || secondPart.charAt(i) == '.') {
                    sb.append(secondPart.charAt(i));
                } else break;
            }

            secondPart = expression.substring(sb.toString().length() + firstPart.length() + 1);
            firstPart = firstPair.getKey();

            Double d = firstPair.getValue() * Double.parseDouble(sb.toString());

            expression = firstPart + "-" + d + secondPart;
        }
        while (expression.contains("!"));

        return expression;
    }

    private String calculateInnerDelMin(String expression) {

        do {
            int tempI = expression.indexOf('!');

            String firstPart = expression.substring(0, tempI);
            String secondPart = expression.substring(tempI + 1);

            Pair<String, Double> firstPair = cutLastNumberAndExpression(firstPart);

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < secondPart.length(); i++) {
                if ((secondPart.charAt(i) >= '0' && secondPart.charAt(i) <= '9')
                        || secondPart.charAt(i) == '.') {
                    sb.append(secondPart.charAt(i));
                } else break;
            }

            secondPart = expression.substring(sb.toString().length() + firstPart.length() + 1);
            firstPart = firstPair.getKey();

            Double d = firstPair.getValue() / Double.parseDouble(sb.toString());

            expression = firstPart + "-" + d + secondPart;
        }
        while (expression.contains("!"));

        return expression;
    }
}
