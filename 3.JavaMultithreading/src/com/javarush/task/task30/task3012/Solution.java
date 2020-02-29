package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(999999991);
    }

    public void createExpression(int number) {
        //напишите тут ваш код
        String trim = Integer.toString(number, 3);
        String simTrim = trimToSimTrim(trim);
        printNumber(number, simTrim);

    }

    private void printNumber(int number, String simTrim) {
        String string = Integer.toString(number);
        string += " =";
        char chars[] = simTrim.toCharArray();
        for (int i = chars.length-1; i >=0 ; i--) {
            switch (chars[i]){
                case '1':
                    string+=" + " + (int) Math.pow(3, chars.length-i-1);
                    break;
                case 'L':
                    string+=" - " + (int) Math.pow(3, chars.length-i-1);
                    break;
            }
        }
        System.out.println(string);
    }

    private String trimToSimTrim(String trim) {
        if (trim.startsWith("2")) {
            trim = "0" + trim;
        }
        char[] chars = trim.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '2') {
                chars[i] = 'L';
                switch (chars[i - 1]) {
                    case '1':
                        chars[i - 1] = '2';
                        break;
                    case '0':
                        chars[i - 1] = '1';
                        break;
                    case 'L':
                        chars[i - 1] = '0';
                        break;
                }
            }
        }
        trim = new String(chars);
        if (trim.contains("2")) {
            trim = trimToSimTrim(trim);
        }

        return trim;
    }
}