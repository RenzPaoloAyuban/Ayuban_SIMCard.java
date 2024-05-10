import java.util.Scanner;

public class Ayuban_SIMCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Initialization of variables and for the while loop
        String phoneNumber;
        double loadAmount = 0;
        double cashPayment = 0;
        boolean programRunning = true;

        // While programRunning's value is true, the program will loop repeatedly. If it becomes false, then the succeeding codes will not be executed
        while (programRunning) {
            boolean loadSuccessful = true; //Initialization for second while loop
            System.out.println("\n=== SIMPLE SIM CARD LOADING SYSTEM ===");
            System.out.println("[1] - Buy Regular Load");
            System.out.println("[2] - Exit");

            //Asks the user between 1 and 2, otherwise the program will just loop all over again
            System.out.print("Enter your choice: ");
            int userInput = sc.nextInt();

            // If 1 is selected, the program will ask for the user's phone number, load amount, and payment
            if (userInput == 1) {
                sc.nextLine(); //Clears scanner
                System.out.print("\nPlease enter your phone number: "); //Asks the user's phone number
                phoneNumber = sc.nextLine();

                //Evaluates phone number if it starts with '09'. if not, it will throw an error message
                if (!phoneNumber.startsWith("09")) {
                    System.out.println("ERROR: Phone number should start at '09'.");
                    continue;
                }

                //Evaluates phone number's length if it consists of 11 numbers. If not, it will throw an error message
                else if (phoneNumber.length() != 11) {
                    System.out.println("ERROR: Phone number should be 11 numbers.");
                    continue;
                }
                
                //Runs if the phone number requirements are satisfied
                else { 
                    
                    //Slicing phone number in its 3rd and 4th index
                    String prefix = phoneNumber.substring(2, 4);
                    
                    //Checks if prefix are integers. An error will be displayed if not
                    if (!prefix.matches("\\d+")) {
                        System.out.println("ERROR: Phone number should be 11 numbers.");
                    } 

                    //Runs if the phone number is proved to be consisting of number digits only
                    else { 
                        int prefixInt = Integer.parseInt(prefix); //Converting prefix into an integer

                        //Checks if the phone number falls under Globe/TM SIM Card
                        if (prefixInt >= 1 && prefixInt <= 50) {
                            
                            //Another while loop for loading section
                            while (loadSuccessful) {
                                System.out.println("\nAvailable Product for GLOBE/TM");
                                System.out.print("Enter Load Amount: "); //Asks the user about the load amount
                                loadAmount = sc.nextDouble();
                                
                                //An error will be displayed if the load amount does not fall with the given range
                                if (loadAmount < 15 || loadAmount > 150) {
                                    System.out.println("ERROR: Please enter load amount from '15-150'");
                                    continue;
                                }
                                
                                //Runs if the load amount is valid
                                else {
                                    sc.nextLine(); //Clears scanner
                                    System.out.print("Enter your cash payment: "); //Asks for cash payment
                                    cashPayment = sc.nextDouble();
                                    
                                    //Throws an error if payment is lower than the load amount
                                    if (cashPayment < loadAmount) {
                                        System.out.println("Your payment should not be less than in your load amount!");
                                        continue;
                                    } 
                                    
                                    //Runs if cash payment is valid
                                    else {
                                        cashPayment -= loadAmount; 
                                        System.out.println("Payment Successful\nYour change due is " + cashPayment);
                                        loadSuccessful = false; //Breaks the loop for loading section
                                    }
                                }
                            }
                        }
                        
                        //Checks if the phone number falls under Globe/TM SIM Card
                        else if (prefixInt >= 51 && prefixInt <= 99) {
                            
                            //Another while loop for loading section
                            while (loadSuccessful) {
                                System.out.println("\nAvailable Product for SMART/TM");
                                System.out.print("Enter Load Amount: "); //Asks the user about the load amount
                                loadAmount = sc.nextDouble();
        
                                //An error will be displayed if the load amount does not fall with the given range
                                if (loadAmount < 15 || loadAmount > 150) {
                                    System.out.println("ERROR: Please enter load amount from '15-150'");
                                    continue;
                                }
        
                                //Runs if the load amount is valid
                                else {
                                    sc.nextLine(); //Clears scanner
                                    System.out.print("Enter your cash payment: "); //Asks for cash payment
                                    cashPayment = sc.nextDouble();
        
                                     //Throws an error if payment is lower than the load amount
                                    if (cashPayment < loadAmount) {
                                        System.out.println("Your payment should not be less than in your load amount!");
                                        continue;
                                    } 
                                    
                                    //Runs if cash payment is valid
                                    else {
                                        cashPayment -= loadAmount;
                                        System.out.println("Payment Successful\nYour change due is " + cashPayment);
                                        loadSuccessful = false;
                                    }
                                }
                             }
                           } 
                           
                           //Throws an error if the phone number does not fall to any SIM Card criterias
                           else {
                                System.out.println("ERROR: Unknown SIM Card");
                                continue;
                           }
                    }
                    
                }
            }

            //Breaks the programRunning loop, thus ending the program
            else if (userInput == 2) {
                    programRunning = false;
            }
        }
        sc.close(); //Closes the scanner
    }
}