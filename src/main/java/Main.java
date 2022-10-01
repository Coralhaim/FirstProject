import java.io.File;
import java.nio.channels.FileLockInterruptionException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws Exception {

        ArrayList<Double>results=new ArrayList<Double>();
        File f=new File("results.txt");
        //First Screen

        System.out.println("Welcome to currency converter");
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

        //Second Screen
        System.out.println("Please enter an amount to convert");
        double input=0;
        boolean flag=true;
        do {
            try {
                // Get input
                input = scanner.nextDouble();
                flag=false;
            } catch (InputMismatchException e) {
                scanner.nextLine(); // clears the buffer
                System.out.println("Invalid choice Please try again");
            }
        }while(flag);

        //Third Screen

//        // Fourth Screen
//        System.out.println("Thanks for using our currency convertor");

    }
}