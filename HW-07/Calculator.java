/* Класс Calculator реализует методы, представленные
 * интерфейсом Calculablt, позволяющие производить простейшие
 *  математические действия (сложение, вычитание, умножение и деление)
 * с комплексными числами
 * Расчеты производятся с выделением действительной(real) и 
 * мнимой части (imaginsry) комплексного числа.
 */

public final class Calculator implements Calculable {

    private ComplexNumber primaryArg;

    public Calculator(ComplexNumber primaryArg) {
        this.primaryArg = primaryArg;
    }

    @Override
    public Calculable sum(ComplexNumber arg) {
        primaryArg.setReal(primaryArg.getReal() + arg.getReal());
        primaryArg.setImaginary(primaryArg.getImaginary() + arg.getImaginary());
        return this;
    }

    @Override
    public Calculable multi(ComplexNumber arg) {
        double primArgReal = primaryArg.getReal();
        double primaArgImaginary = primaryArg.getImaginary();
        double argReal = arg.getReal();
        double argImaginary = arg.getImaginary();
        primaryArg.setReal(primArgReal * argReal - primaArgImaginary * argImaginary);
        primaryArg.setImaginary(primArgReal * argImaginary +
                primaArgImaginary * argReal);
        return this;
    }

    @Override
    public Calculable subtract(ComplexNumber arg) {
        primaryArg.setReal(primaryArg.getReal() - arg.getReal());
        primaryArg.setImaginary(primaryArg.getImaginary() - arg.getImaginary());
        return this;
    }

    @Override
    public Calculable division(ComplexNumber arg) {
        double primArgReal = primaryArg.getReal();
        double primaArgImaginary = primaryArg.getImaginary();
        double argReal = arg.getReal();
        double argImaginary = arg.getImaginary();
        double denominator = argReal * argReal + argImaginary * argImaginary;
        primaryArg.setReal((primArgReal * argReal + primaArgImaginary * argImaginary)
                / denominator);
        primaryArg.setImaginary((primaArgImaginary * argReal - primArgReal * argImaginary)
                / denominator);
        return this;
    }

    @Override
    public ComplexNumber getResult() {
        return primaryArg;
    }
}
