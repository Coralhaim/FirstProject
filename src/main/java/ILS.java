public class ILS extends Coin{

    private  final double value= 0.28;
    @Override
    public double getValue() {
        return this.value;
    }

    @Override
    public double calculate(double value) {
        return getValue()*value;
    }
}
