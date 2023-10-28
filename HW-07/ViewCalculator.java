
import java.util.Scanner;

public class ViewCalculator {

    private ICalculableFactory calculableFactory;

    public ViewCalculator(ICalculableFactory calculableFactory) {
        this.calculableFactory = calculableFactory;
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        boolean fl = true;
        String cmd;
        while (fl) {
            String firstStr = prompt("Введите первое комплексное число: ", in);
            ConvertStrToComplNumber conStr01 = new ConvertStrToComplNumber(firstStr);
            ComplexNumber firstComp = conStr01.convert();
            Calculable calculator = calculableFactory.create(firstComp);  
            while (true) {
                cmd = prompt("Введите команду (*, +, -, /, =) : ", in); 
                if ( !cmd.equals("=")){
                    String secondStr = prompt("Введите следующее комплексное число: ", in);
                    ConvertStrToComplNumber conStr02 = new ConvertStrToComplNumber(secondStr);
                    ComplexNumber secondComp = conStr02.convert();
                    switch (cmd){
                        case "+" : calculator.sum(secondComp);
                            break;
                        case "-" : calculator.subtract(secondComp);
                            break;
                        case "*" : calculator.multi(secondComp);
                            break;
                        case "/" : calculator.division(secondComp);
                            break;
                        default :
                             calculator.getResult();
                    } 
                }
                if(cmd.equals("=")){
                    calculator.getResult();
                    cmd = prompt("Продолжить ? (Y/N)?",in).toLowerCase(); 
                    if(!cmd.equals("y")&& !cmd.equals("н")){
                        break;}
                }
            }
            cmd = prompt("Еще посчитать (Y/N)?",in).toLowerCase();  
            if (!cmd.equals("y") && !cmd.equals("н")) {                    fl = false;
                calculator.getResult();
                break;
            }
        }
        in.close();
    }

    private String prompt(String message,Scanner in ) {
        System.out.print(message);
        return in.nextLine();
    }
}
