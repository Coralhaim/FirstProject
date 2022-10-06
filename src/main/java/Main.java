import java.io.File;
import java.nio.channels.FileLockInterruptionException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;


public class Main {

    public static void main(String[] args) throws Exception {

        ArrayList<Double> Results = new ArrayList<Double>();
        File f = new File(System.getProperty("user.home") +"results.txt");
        String userChoice = "";

        boolean start = true;
        //First Screen
        System.out.println("Welcome to currency converter");
        while (start) {
            double result = 0;
            System.out.println("Please Choose an option");
            System.out.println("1.Dollars to Shekels");
            System.out.println("2.Shekels to Dollars");
            int option = 0;
            Scanner optionSca = new Scanner(System.in);
            do {
                try {
                    // Get input
                    option = optionSca.nextInt();
                    if(option != 1 && option != 2)
                        System.out.println("Invalid choice Please try again");
                } catch (InputMismatchException e) {
                    System.out.println("Invalid choice Please try again");
                    optionSca.nextLine(); // clears the buffer
                }} while (option != 1 && option != 2) ;

                //Second Screen

                System.out.println("Please enter an amount to convert");
                Scanner inputSca = new Scanner(System.in);
                double input = 0;
                boolean flag = true;
                do {
                    try {
                        // Get input
                        input = inputSca.nextDouble();
                        flag = false;
                    } catch (InputMismatchException e) {
                        inputSca.nextLine(); // clears the buffer
                        System.out.println("Invalid choice Please try again");
                    }
                } while (flag);

                //Third Screen

                switch (option) {
                    case 1:
                        Coin ilsValue = CoinFactory.getCoininstance(Coins.USD);
                        result = ilsValue.calculate(input);
                        break;
                    case 2:
                        Coin usdValue = CoinFactory.getCoininstance(Coins.ILS);
                        result = usdValue.calculate(input);
                        break;
                    default:
                        break;
                }

                Results.add(result);
                System.out.println("the result is:" + result);

                Scanner answerSca = new Scanner(System.in);
                System.out.println("start over? Y/N");
                char answer = answerSca.next().charAt(0);
                if (answer == 'N')
                    start = false;
            }
            //        // Fourth Screen
            System.out.println("Thanks for using our currency convertor");
            //התמודדות עם גודל רשימה 1??
//        System.out.println("your previous reault"+ results.get(results.size()-1));


        }
    }



