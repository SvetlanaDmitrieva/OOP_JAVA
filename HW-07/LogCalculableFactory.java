public class LogCalculableFactory implements ICalculableFactory {

    private Logable logger;

    public LogCalculableFactory(Logable logger) {
        this.logger = logger;
    }

    @Override
    public Calculable create(ComplexNumber primaryArg) {   
        return new LogCalculator(new Calculator(primaryArg), logger);
    }
}
