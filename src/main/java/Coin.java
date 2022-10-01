public abstract class Coin implements  ICalculate {
    //method return the value of the coin
    public abstract double getValue();

    @Override
    public double calculate(double value) {
        return 0;
    }
}
