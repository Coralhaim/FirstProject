import java.util.Scanner;


public class Main {

    public static void main(String[]args) throws Exception {

        //First Screen

        System.out.println("Welcome to currency converter");
        System.out.println("Please Choose an option");
        System.out.println("1.Dollars to Shekels");
        System.out.println("2.Shekels to Dollars");
        Scanner scanner1=new Scanner(System.in);
        int option =scanner1.nextInt();
        while (option !=1 && option!= 2) {
            throw new Exception("wrong input");
        }


        //Second Screen
        System.out.println("Please enter an amount to convert");
        Scanner scanner2=new Scanner(System.in);
        double amount =scanner2.nextDouble();




//    Coin ilsValue=CoinFactory.getCoininstance(Coin.USD);
//
//    double value=usd.calculate(input);

    }

}