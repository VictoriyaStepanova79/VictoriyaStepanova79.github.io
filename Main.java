import java.util.InputMismatchException;
import java.util.Scanner;

class  Calc {
    static Scanner scanner = new Scanner(System.in);
    static String number1, number2;
    static String operation;
    static String result;


    static String convertNumToRoman(int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        return roman[numArabian];
    }

    static String romanToNumber(String roman) {
        if (roman.equals("I")) {
            return "1";
        } else if (roman.equals("II")) {
            return "2";
        } else if (roman.equals("III")) {
            return "3";
        } else if (roman.equals("IV")) {
            return "4";
        } else if (roman.equals("V")) {
            return "5";
        } else if (roman.equals("VI")) {
            return "6";
        } else if (roman.equals("VII")) {
            return "7";
        } else if (roman.equals("VIII")) {
            return "8";
        }else if (roman.equals("IX")) {
            return "9";
        }else if (roman.equals("X")){
            return "10";
        } else {
            throw new InputMismatchException("Неверный формат");
        }
    }



    public static class Main {
        public static String calc(String input) throws Exception {
            int results = 0;
            String results2;
            String[] str = input.split(" ");
            String str1 = str[0];
            String str2 = str[1];
            String str3 = str[2];
            String str01 = str1.trim();
            String str02 = str2.trim();
            String str03 = str3.trim();
            number1 = str01;
            number2 = str03;
            operation = str02;
            int num1 = Integer.parseInt(number1);
            int num2 = Integer.parseInt(number2);
            char operand = operation.charAt(0);
            if (num1 > 0 && num1 <= 10 && num2 > 0 && num2 <= 10) {
                if (operand == '+') {
                    results = num1 + num2;
                } else if (operand == '-') {
                    results = num1 - num2;
                } else if (operand == '*') {
                    results = num1 * num2;
                } else if (operand == '/') {
                    try {
                        results = num1 / num2;
                    }catch (ArithmeticException e)  {
                        System.out.println("Деление на ноль");
                    }
                } else {
                    System.out.println("Неверный операнд");
                }
                results2 = String.valueOf(results);
                return results2;
            } else throw new Exception("Неверный формат данных");
        }

        public static void main(String[] args) throws Exception {
            String[] roman1 = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
            String[] arab = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
            System.out.println("Введите выражение от 1 до 10 арабскими числами в формате[2 + 2] или римскими числами в формате[II + V] + Enter ");
            String inputUser = scanner.nextLine();
            String[] str = inputUser.split(" ");
            String str1 = str[0];
            String str2 = str[1];
            String str3 = str[2];
            String str01 = str1.trim();
            String str02 = str2.trim();
            String str03 = str3.trim();
            for (int i = 0; i<str.length; i++){
                if (str01.equals(roman1[i]) && str03.equals(roman1[i])) {
                    number1 = romanToNumber(str01);
                    number2 = romanToNumber(str02);
                    operation = str02;
                    result = calc(inputUser);
                    String resultArabian = convertNumToRoman(Integer.parseInt(result));
                    System.out.println(resultArabian);
                } else if (str01.equals(arab[i]) && str03.equals(arab[i])) {
                    number1 = str01;
                    number2 = str03;
                    operation = str02;
                    result = calc(inputUser);
                    System.out.println(result);
                }
            }
            scanner.close();
        }
    }
}


