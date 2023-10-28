/*
 * Интерфейс включает в себя основные методы расчетов,
 * реализованные в программе
 */

public interface Calculable {
    Calculable sum(ComplexNumber arg);

    Calculable multi(ComplexNumber arg);

    Calculable subtract(ComplexNumber arg);

    Calculable division(ComplexNumber arg);

    ComplexNumber getResult();
}
