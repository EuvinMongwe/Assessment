/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversionassessment;

import java.util.Scanner;

/**
 *
 * @author euvinmongwe
 */
public class ConversionAssessment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conversion conversion = new Conversion();
        testConversions(conversion);
    }
    
    /**
     * This method will test the conversion logic
     *
     * @param conversion
     */
    private static void testConversions(Conversion conversion) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter Miles: ");

        while (!input.hasNextDouble()) {
            String inputString = input.next();
            System.out.printf("\"%s\" is not a valid mile, Please enter a Valid Mile: ", inputString);
        }
        System.out.println("Miles converted to Kilometers equals " + conversion.convertMilesToKilometers(input.nextDouble()));

        System.out.print("Please enter Pounds: ");
        while (!input.hasNextDouble()) {
            String inputString = input.next();
            System.out.printf("\"%s\" is not a valid Pounds, Please enter a Valid Pounds: ", inputString);
        }
        System.out.println("Pounds converted to kilograms equals " + conversion.convertPoundsToKilograms(input.nextDouble()));

        System.out.print("Please enter Kelvins: ");
        while (!input.hasNextDouble()) {
            String inputString = input.next();
            System.out.printf("\"%s\" is not a valid Kelvins, Please enter a Valid Kelvins: ", inputString);
        }
        System.out.println("Kelvin converted to Calculus equals " + conversion.convertKelvinToCalculus(input.nextDouble()));
    }
}
