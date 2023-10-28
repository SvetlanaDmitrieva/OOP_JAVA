/*
 * Класс ConvertStrToComplNumber предназначен для 
 * конвертирования введенного на консоли комплексного числа
 * в виде строки в косплексное число  
 */
public class ConvertStrToComplNumber {
    String compNumberInString;
    ComplexNumber complexNumber;

    public ConvertStrToComplNumber(String compNumberInString) {
        this.compNumberInString = compNumberInString;
    }

    public ComplexNumber convert() {
        int lengthStr = 0;
        double real = 0.0, imaginary = 0.0;
        String subString;
        String subString0 = compNumberInString.replaceAll("\\s", "")
                .replace("+", " +") // введенная строка комплексного
                .replace("-", " -").trim().toLowerCase(); // числа
        if (Character.isDigit(subString0.charAt(0)) // видоизменяется
                || subString0.startsWith("i")) { // Добавляется знак плюс в начало строки
            subString = "+" + subString0; // если она начинается с цифры или буквы "i"
        } else {
            subString = subString0;
        }
        String arrStrings[] = subString.split(" "); // строка превращается в массив
        for (String str : arrStrings) { // подстрок мнимой и действительных частей
            if (!str.contains("i")) { // если нет симвода "i" - это действ. часть
                real = Double.parseDouble(str); // превращается в действ. число
            } else {
                lengthStr = str.length(); // есди есть симвод "i" - мнимая часть
                if (lengthStr == 2) { // есди длина 2 символа -> формат "знак+I" - добавляем коэффициент 1
                    imaginary = Double.parseDouble(str.substring(0, 0) + "1");
                } else { // если строка больше 2 символов, тогда выделяем мнимую часть,если
                    imaginary = Double.parseDouble(str.endsWith("i") ? // "i" стоит в конце строки
                            (str.substring(0, (lengthStr - 1))) : // Формируем число, если "i" в любом
                            (str.substring(0, str.indexOf("i")) + // другом месте
                                    str.substring(str.indexOf("i") + 1, lengthStr)));
                }
            }
        }
        return new ComplexNumber(real, imaginary);
    }
}
