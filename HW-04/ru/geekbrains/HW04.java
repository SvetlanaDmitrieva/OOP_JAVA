// package ru.geekbrains;

import java.util.ArrayList;
import java.util.Arrays;

public class HW04 {
    public static void main(String[] args) {

        // -----------------------------------------------------
        // Задание 3
        // 3)	Написать класс калькулятор, принимающий List
        // целочисленных значений, возвращающий сумму элементов
        // коллекции (метод sum)
        /*
         * 1)расширить класс калькулятор на умножение
        2)расширить класс калькулятор на деление
        3)расширить класс калькулятор на бинарный перевод(принимаемые значения 
        как стринг, так и инт - тут необходимо подумать как наилучшим образом реализовать,
         что будет если будут приниматься округляемые Double/Float (округляемые -> с нулем 
         на конце прим. 3.0 , 4.0 и тд т))
         */

        Calculator calcutalor = new Calculator();
        System.out.println(calcutalor.sum(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8))));
        System.out.println(calcutalor.multipl(new ArrayList<>(Arrays.asList( 3, 4, 5, 6 ))));
        System.out.println(calcutalor.div(new ArrayList<>(Arrays.asList( 120, 2, 3, 4 ))));
        System.out.println(calcutalor.transfBinNum(11L ));
        System.out.println(calcutalor.transfBinNum(11 ));
        System.out.println(calcutalor.transfBinNum(31.25F ));
        System.out.println(calcutalor.transfBinNum("15.87f"));
        System.out.println(calcutalor.transfBinNum(21.25 ));
    }
}