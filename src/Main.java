import java.util.Scanner;
import java.util.Arrays;
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class Main {
    static String convRomeToArabic(String rome_number) {
        String[] rome_numbers = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX",
            "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX",
            "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX",
            "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX",
            "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX",
            "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX",
            "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX",
            "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX",
            "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX",
            "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX",
            "C"
        };
        int index = Arrays.asList(rome_numbers).indexOf(rome_number);
        try {
            if (index <= 0) {
                throw new Exception("throws Exception //т.к. некорректное число в римской системе");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
    }
        return Integer.toString(index);
}          // конвертирование римских цифр в арабские (от 1 до 100)
    static String convArabicToRome(String arabic_number) {
        String[] rome_numbers = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX",
                "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX",
                "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX",
                "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX",
                "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX",
                "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX",
                "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX",
                "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX",
                "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX",
                "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX",
                "C"
        };

        int intArabicNumber = 0;
        try {
            intArabicNumber = Integer.parseInt(arabic_number);
            if (intArabicNumber >= rome_numbers.length) {
                throw new ArrayIndexOutOfBoundsException("throws Exception //т.к. результат не может быть > 100");
            }
            if (intArabicNumber <= 0) {
                throw new Exception("throws Exception //т.к. в римской системе нет отрицательных чисел");
            }
        }
        catch (NumberFormatException e) {
            System.out.println("throws Exception //т.к. ошибочный формат целого числа '" + arabic_number + "'");
            System.exit(1);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        return rome_numbers[intArabicNumber];
    }        // конвертирование арабских цифр в римские (от 1 до 100)
    static Boolean isRomeNumber(String s_number) {
        if (s_number.length() == 0) {
            return false;
        }
        char[] charArray = s_number.toCharArray();
        for (char c: charArray) {
            if (!"IVXLCDM".contains(Character.toString(c))) {
                return false;
            }
        }
        return true;
    }                // проверка, является ли строка римским числом
    static Boolean isArabicNumber(String a_number) {
        try {
            int number = Integer.parseInt(a_number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }              // проверка, является ли строка арабским числом
    static Boolean isAllowOperator(String str_operator) {
        if (str_operator.length() == 1 && "+-*/".contains(str_operator)) {
            return true;
        }
        return false;
    }         // проверка, является ли оператор допустимым (+-*/)
    static String[] fixInputStr(String str_input) {
        str_input = str_input.trim();
        String[] params = str_input.split("\\s+");
        try {                               // проверяем операцию
            if (params.length > 3) {
                throw new Exception("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }
            else if (params.length == 1) {
                for (char c: "+-*/".toCharArray()) {
                    String split_par = Character.toString(c);
                    if (str_input.contains(split_par)) {

                        // корректируем строку-разделитель в зависимости от операции
                        if (split_par.equals("+")) {
                            split_par = "\\+";
                        } else if (split_par.equals("*")) {
                            split_par = "\\*";
                        }

                        // проверяем корректность разбиения строки по операции, должно быть 2 операнда
                        String[] params_temp = str_input.split(split_par);
                        if (params_temp.length != 2) {
                            throw new Exception("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                        }

                        // восстанавливаем строку с операцией для корректного результата
                        if (split_par.equals("\\+")) {
                            split_par = "+";
                        } else if (split_par.equals("\\*")) {
                            split_par = "*";
                        }

                        // формируем результат
                        String[] params_res = {params_temp[0], split_par, params_temp[1]};
                        return params_res;
                    }
                }
                throw new Exception("throws Exception //т.к. строка не является математической операцией");
            }
            else if (params.length < 3 || !isAllowOperator(params[1])) {
                throw new Exception("throws Exception //т.к. строка не является математической операцией");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        //
        return params;
    }               // проверяем и фиксим строку входных параметров на корректность
    static Boolean checkParam(String param) {
        int number = 0;
        if (isRomeNumber(param)) {
            number = Integer.parseInt(convRomeToArabic(param));
        } else if (isArabicNumber(param)) {
            number = Integer.parseInt(param);
        }
        else {
            try {
                throw new Exception("throws Exception //операнд '" + param + "' не является ни римским, ни арабским числом");
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }
        }
        try {
            if (number <= 0 || number > 10) {
                throw new Exception("throws Exception //операнд '" + param + "' должен быть в диапазоне от 1 до 10");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
                System.exit(1);
        }
        return true;
    }                     // проверяем параметр (операнд) на корректность
    static int doCalc(int par_1, String str_operator, int par_2) {
        int res = 0;
        switch(str_operator) {
            case "+":
                res = par_1 + par_2;
                break;
            case "-":
                res = par_1 - par_2;
                break;
            case "*":
                res = par_1 * par_2;
                break;
            case "/":
                try {
                    res = par_1 / par_2;
                } catch (ArithmeticException e) {
                    System.out.println("throws Exception // ошибка деления на 0");
                    System.exit(1);
                }
        }
        return res;
    }// производим вычисления (+-*/)
    public static String calc(String input) {
        //////////////////////////////////////////////////////////////////////
        // разбиваем входную строку на параметры
        // ЕСЛИ число параметров != 3 - выброс исключения
        // ЕСЛИ операция (2-й параметр) != "+-*/" - выброс исключения
        // определение типа операндов (арабские или римские цифры)
        // ЕСЛИ цифры и не арабские и не римские - выброс исключения
        // ЕСЛИ арабская-римская или римская-арабская - выброс исключения
        // ЕСЛИ цифры арабские  - выполняем операцию
        //                      - возвращаем результат
        // ЕСЛИ цифры римские   - переводим в арабские
        //                      - выполняем операцию
        //                      - ЕСЛИ результат > 0, то:
        //                              - переводим в римские
        //                              - возвращаем результат
        //                        ИНАЧЕ - выброс исключения
        // ИНАЧЕ - выброс исключения
        //////////////////////////////////////////////////////////////////////
        int result = 0;
        String[] params = fixInputStr(input);
        if (isAllowOperator(params[1]) && checkParam(params[0]) && checkParam(params[2])) {
            // оба операнда - арабские
            if (isArabicNumber(params[0]) && isArabicNumber(params[2])) {
                result = doCalc(Integer.parseInt(params[0]), params[1], Integer.parseInt(params[2]));

            }
            // оба операнда - римские
            else if (isRomeNumber(params[0]) && isRomeNumber(params[2])) {
                result = doCalc(Integer.parseInt(convRomeToArabic(params[0])),
                        params[1],
                        Integer.parseInt(convRomeToArabic(params[2])));
                return convArabicToRome(Integer.toString(result));
            }
            // смешанные операнды - генерируем исключение
            else {
                try {
                    throw new Exception("throws Exception //т.к. используются одновременно разные системы счисления");
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.exit(1);
                }
            }
        }
        return Integer.toString(result);
    }                     // результирующая функция, производящая вычисления
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String input = scanner.nextLine();
        String result = calc(input);
        System.out.println(result);
    }
}