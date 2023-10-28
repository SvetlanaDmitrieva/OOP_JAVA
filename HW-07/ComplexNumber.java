/*
 * Класс ComplexNumber реализует структуру крмплексного числа,
 * выделяю два компонента, действительную (real) и 
 * мнимую (imaginary) часть числа.
 */
public class ComplexNumber {
    private double real, imaginary;

    public ComplexNumber() {
    }

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getReal() {
        return real;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    public double getImaginary() {
        return imaginary;
    }
}
