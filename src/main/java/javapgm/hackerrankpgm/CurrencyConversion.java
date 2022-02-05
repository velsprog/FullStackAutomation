package javapgm.hackerrankpgm;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class CurrencyConversion {
	
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        String us = NumberFormat.getCurrencyInstance(Locale.US).format(payment);
        String france = NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment);
        String china = NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment);
        String india = converttoINR(NumberFormat.getCurrencyInstance(Locale.ENGLISH).format(payment));
        //india.split(0)
        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
    
    public static String converttoINR(String formattedPayment) {
        String[] arr = formattedPayment.split("");
        String INR = "Rs.";
        for(int i=1;i<arr.length;i++) {
            INR = INR+arr[i];
        }
        return INR;
    }

}
