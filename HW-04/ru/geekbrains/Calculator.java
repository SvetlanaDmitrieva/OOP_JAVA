
// package org.example;
import java.util.List;

public class Calculator {

    public double sum(List<? extends Number> list) {
        double result = 0;
        for (Number number : list) {
            result += number.doubleValue();
        }
        return result;
    }

    public double multipl(List<? extends Number> list) {
        double result = 1.0;
        for (Number number : list) {
            result *= number.doubleValue();
        }
        return result;
    }

    public double div(List<? extends Number> list) {
        double result = list.get(0).doubleValue();
        list.remove(0);
        for (Number number : list) {
            result /= number.doubleValue();
        }
        return result;
    }

    public <T> String transfBinNum(T something) {
        int counter = 0;
        String res1 = "";
        Object number = something;
        Integer first = 0;
        Double second = 0.;
        if (something instanceof Double) {
            Double numberDou = (Double) number;
            first = numberDou.intValue();
            second = numberDou % 1;
        }
        if (something instanceof Integer) {
            Integer numberInt = (Integer) number;
            first = numberInt.intValue();
        }
        if (something instanceof Float) {
            Float numberFloat = (Float) number;
            first = numberFloat.intValue();
            second = Double.valueOf(numberFloat % 1);
        }
        if (something instanceof String) {
            Double numStr = Double.parseDouble((String) number);
            first = numStr.intValue();
            second = numStr % 1;
        }
        if(first == 0 && second == 0.){return " Число равно 0 или задан невалидный формат";}
        StringBuilder res = new StringBuilder();
        while (first > 0) {
            int remainder = (first % 2);
            res.append(remainder);
            first /= 2;
        }
        res = res.reverse();
        res1 = res.toString();
        StringBuilder res2 = new StringBuilder();
        if (second < 0.00001) {
            return res1;
        } else {
            while (second > 0.0 && counter <= 15) {
                if (second <= 0.00001) {
                    break;
                }
                second *= 2.;
                int remainder = 0;
                if (second.intValue() >= 1) {
                    remainder = 1;
                }
                res2.append(remainder);
                second = second % 1;
                counter++;
            }
        }
        String resAll = res1 + "." + res2.toString();
        return resAll;
    }
}
