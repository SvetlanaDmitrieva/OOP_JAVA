
public class LogCalculator implements Calculable {
    private Logable logger;
    private Calculable calculator;

    public LogCalculator(Calculable calculator, Logable logger) {
        this.logger = logger;
        this.calculator = calculator;
    }

    @Override
    public Calculable sum(ComplexNumber arg) {   
        String[] str = strings(calculator.getResult(), arg);
        logger.log(String.format("Сложение старого значения %s с новым %s", 
                str[0], str[1]));  
        return calculator.sum(arg); 
    }

    @Override
    public Calculable multi(ComplexNumber arg) {     
        String[] str = strings(calculator.getResult(), arg);
        logger.log(String.format("Умножение старого значения %s на новое %s",
                str[0], str[1]));        
        return calculator.multi(arg);     
    }

    @Override
    public Calculable subtract(ComplexNumber arg) {     
        String[] str = strings(calculator.getResult(), arg);
        logger.log(String.format("Вычитание из старого значения %s нового %s", 
                str[0], str[1]));      
        return calculator.subtract(arg);   
    }
@Override
    public Calculable division(ComplexNumber arg) {    
        String[] str = strings(calculator.getResult(), arg);
        logger.log(String.format("Деление старого значения %s на новое %s",
                str[0], str[1]));       
        return calculator.division(arg);     
    }

    @Override
    public ComplexNumber getResult() {      
        String s = new ConvertComplNumberToStr(calculator.getResult()).convert();
        logger.log(String.format("Результат действия : %s ", s)); 
        return calculator.getResult(); 
    }
/*
 * Метод 2 комплексных числа в 2 строки
 */
    public String [] strings(ComplexNumber n1, ComplexNumber n2){
        String [] str = new String[2];
        ConvertComplNumberToStr str1 = new ConvertComplNumberToStr(n1);
        str[0] = str1.convert();
        ConvertComplNumberToStr str2 = new ConvertComplNumberToStr(n2);
        str[1] = str2.convert();
        return str;
    }
}
