import java.io.File;
import java.nio.channels.FileLockInterruptionException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws Exception {

        ArrayList<Double> results = new ArrayList<Double>();
        File f = new File("results.txt");
        String userChoice="";
        double result=0;
        boolean start=true;
        //First Screen
        System.out.println("Welcome to currency converter");
        while(start){
            System.out.println("Please Choose an option");
            System.out.println("1.Dollars to Shekels");
            System.out.println("2.Shekels to Dollars");
            Scanner scanner = new Scanner(System.in);
            int option = 0;
            do {
                try {
                    // Get input
                    option = scanner.nextInt();
                } catch (InputMismatchException e) {
                    scanner.nextLine(); // clears the buffer
                    System.out.println("Invalid choice Please try again");
                }
            } while (option != 1 && option != 2);
            switch (option){
                case 1:
                    userChoice="USD";
                case 2:
                    userChoice="ILS";
            }

            //Second Screen
            System.out.println("Please enter an amount to convert");
            double input = 0;
            boolean flag = true;
            do {
                try {
                    // Get input
                    input = scanner.nextDouble();
                    flag = false;
                } catch (InputMismatchException e) {
                    scanner.nextLine(); // clears the buffer
                    System.out.println("Invalid choice Please try again");
                }
            } while (flag);

            //Third Screen
            try{
                Coins coins=Coins.valueOf(userChoice);
                switch (coins) {
                    case USD:
                        Coin ilsValue = CoinFactory.getCoininstance(Coins.USD);
                        result = ilsValue.calculate(input);

                    case ILS:
                        Coin usdValue = CoinFactory.getCoininstance(Coins.ILS);
                        result = usdValue.calculate(input);
                }

            }catch(IllegalArgumentException e){
                System.out.println("invalid choice");
            }
            results.add(result);
            System.out.println("the result is:"+ result);

            Scanner myObj = new Scanner(System.in);
            System.out.println("start over? Y/N");
            String answer = myObj.nextLine();
            if(answer=="N")
                start=false;
        }
        //        // Fourth Screen
        System.out.println("Thanks for using our currency convertor");
        //התמודדות עם גודל רשימה 1??
//        System.out.println("your previous reault"+ results.get(results.size()-1));


    }
}


