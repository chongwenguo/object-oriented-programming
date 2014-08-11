import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * cs 1331
 * hw 06 driver
 *
 * @author chongwen guo
 * @version 1.0
 */
public class Driver {

    public static void main(String[] args) {

        MetricConverter metricConverter = new MetricConverter();
        boolean notQuit = true;
        System.out.println("Welcome to the convertor!");
        while (notQuit) {
            System.out.println("What would you like to do? \n"
                     + "1. Learn cool facts \n"
                     + "2. Convert to meters \n"
                     + "3. Convert to another unit \n"
                     + "4. Add a temporary unit to converter \n"
                     + "5. Exit the program");
            Scanner keyboard = new Scanner(System.in);
            int n = keyboard.nextInt();

            if (n == 5) {
                 notQuit = false;
            } else {

            System.out.println(metricConverter);
            switch (n) {
            case 1:
                 try {
                     System.out.println("What unit would"
                    + " you like to learn a cool fact about?");
                     Scanner sunit = new Scanner(System.in);
                     String unit = sunit.nextLine();
                     System.out.println(metricConverter.getCoolFact(unit));
                 } catch (InputMismatchException e) {
                   System.out.println("InputMismatchException: invalid input");
                 } catch (UnsupportedUnitException e) {
                  System.out.println(e.getMessage());
                 }
                 break;

            case 2:
             try {
              System.out.println("What unit are you converting to meters?");
              Scanner sunitName = new Scanner(System.in);
              String unitName = sunitName.nextLine();

              System.out.println("How many of these are"
                + " you converting to meters?");
              Scanner snumber = new Scanner(System.in);
              int number = snumber.nextInt();

              System.out.println(unitName + ": " + number);
              System.out.println("The total number of meters is: "
             + metricConverter.convertToMeters(unitName, number));
                } catch (InputMismatchException e) {
                   System.out.println("InputMismatchException: invalid input");
                 } catch (UnsupportedUnitException e) {
                   System.out.println(e.getMessage());
                }
                break;

            case 3:
             try {
               System.out.println("Which unit are you going to convert?");
               Scanner sbaseUnit = new Scanner(System.in);
               String baseUnit = sbaseUnit.nextLine();

               System.out.println("How many of these do you want to convert?");
               Scanner sn = new Scanner(System.in);
               double n1 = sn.nextDouble();

               System.out.println("which unit do you want to convert it to?");
               Scanner stargetUnit = new Scanner(System.in);
               String targetUnit = stargetUnit.nextLine();

               metricConverter.convertToDifferentUnit(baseUnit, targetUnit, n1);
               System.out.println(baseUnit + ": " + n1);
               System.out.println("The total number of " + targetUnit + " is: "
          + metricConverter.convertToDifferentUnit(baseUnit, targetUnit, n1));
               } catch (InputMismatchException e) {
                 System.out.println("InputMismatchException: invalid input");
               } catch (UnsupportedUnitException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 4:

            try {
                 System.out.println("What is the name of the new unit?");
                 Scanner sname = new Scanner(System.in);
                 String name = sname.nextLine();

                 System.out.println("what is a cool fact about the unit?");
                 Scanner sfact = new Scanner(System.in);
                 String fact = sfact.next();

                 System.out.println("How many meters are in 1 of this unit?");
                 Scanner srate = new Scanner(System.in);
                 double rate = srate.nextDouble();

                 metricConverter.addUnit(rate, name, fact);
                } catch (InputMismatchException e) {
                    System.out.println("InputMismatchException: invalid input");
                } catch (DuplicateUnitException e) {
                    System.out.println(e.getMessage());
                } catch (UnsupportedRateException e) {
                    System.out.println(e.getMessage());
                }

                   break;

            default:
                System.out.println("Please enter a correct number.");
                break;
            }

            System.out.println();
            System.out.println("================================");
            System.out.println();
        }
        }
    }
 }
