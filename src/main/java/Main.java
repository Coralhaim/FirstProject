import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws Exception {

        ArrayList<Result> Results = new ArrayList<>();
        File file = new File(System.getProperty("user.home") + "/results.txt");
        FileWriter fr = new FileWriter(file, false);
        boolean start = true;
        //First Screen
        System.out.println("Welcome to currency converter");
        while (start) {
            double result = 0;
            System.out.println("Please Choose an option" + "\n" + "1.Dollars to Shekels" + "\n" + "2.Shekels to Dollars");
            int option = 0;
            Scanner optionSca = new Scanner(System.in);
            do {
                try {
                    option = optionSca.nextInt();
                    if (option != 1 && option != 2)
                        System.out.println("Invalid choice Please try again");
                } catch (InputMismatchException e) {
                    System.out.println("Invalid choice Please try again");
                    optionSca.nextLine(); // clears the buffer
                }
            } while (option != 1 && option != 2);

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

            String confirmFlow="";
            switch (option) {
                case 1 -> {
                    Coin ilsValue = CoinFactory.getCoininstance(Coins.USD);
                    result = ilsValue.calculate(input);
                    confirmFlow = "USD to ILS";
                }
                case 2 -> {
                    Coin usdValue = CoinFactory.getCoininstance(Coins.ILS);
                    result = usdValue.calculate(input);
                    confirmFlow = "ILS to USD";
                }
            }
            Result R2 = new Result(result,confirmFlow);
            Results.add(R2);
            System.out.println("the result is:" + result);
            fr.write((result) + "\n");

            Scanner answerSca = new Scanner(System.in);
            System.out.println("start over? Y/N");
            String answer = answerSca.next();
            do{
                if(!answer.equalsIgnoreCase("N") && !answer.equalsIgnoreCase("Y")){
                    System.out.println("Invalid choice Please try again");
                    answer = answerSca.next();
                }
            }while (!answer.equalsIgnoreCase("N") && !answer.equalsIgnoreCase("Y"));

            if (answer.equalsIgnoreCase("N")) {
                start = false;
            }
        }

        // Fourth Screen

        System.out.println("Thanks for using our currency convertor");
        if (Results.size() != 1) {
            System.out.println("your previous result " + Results.get(Results.size() - 2).getResult());
            fr.close();
        }
    }
}