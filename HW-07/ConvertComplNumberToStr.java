/*
 * Класс ConvertComplNumberToStr позволяет конвертировать
 * комплексное число в строку и передает ее для вывода на дисплей
 */

public class ConvertComplNumberToStr {

    ComplexNumber complexNumber;

    public ConvertComplNumberToStr(ComplexNumber complexNumber) {
        this.complexNumber = complexNumber;
    }

    public String convert() {

        double real = complexNumber.getReal(); // Выделяются действительная и
        double imaginary = complexNumber.getImaginary();// мнимая части числа
        String sign;
        String s1 = String.valueOf(real); // Перевод в формат строки
        String s2 = String.valueOf(imaginary); // обеих частей компл. числа
        if (imaginary > 0.0) {
            sign = " +";
        } // Добавляется знак "+"
        else {
            sign = "";
        } // для положительной мнимой части
        if (imaginary == 0.0) { // Если мнимая часть равна нуля
            return s1; // передается только действительная
        } else {
            if (real == 0.0) {
                return (s2 + "i");
            } // Если действительная часть равна
        } // нулю, передается только мнимая часть
        return (s1 + sign + s2 + "i"); // Передается полный формат мнимого числа
    }
}
