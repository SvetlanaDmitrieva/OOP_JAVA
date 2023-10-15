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

    public String transfBin(String something) {
        String res1 = "";

        if (Character.isLetter(something.charAt(something.length() - 1))) {
            something = (something).substring(0, (something.length() - 1));
        }
        StringBuilder res = new StringBuilder();
        Double numAll = Double.parseDouble(something);
        Integer first = numAll.intValue();

        while (first > 0) {
            int remainder = (first % 2);
            res.append(remainder);
            first /= 2;
        }
        res = res.reverse();
        res1 = res.toString();
        StringBuilder res2 = new StringBuilder();
        Double second = numAll%1.;
        //System.out.println(second);
        if ( second < 0.00001 ){return res1;}
        while (second > 0.0) {
            second *= 2.;
            //System.out.println( second);
            int remainder = 0;
            if (second.intValue() >= 1){remainder = 1;}
            res2.append(remainder);
            second = second % 1;
            if(second <= 0.0001){break;}
        }
        String resAll = res1 + "." + res2.toString();
        return resAll;
    }
}
