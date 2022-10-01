public class CoinFactory {

    public static Coin getCoininstance(Coins coin){
        switch(coin){
            case ILS:
                return new ILS();
            case USD:
                return new USD();
        }
        return null;
    }
}
