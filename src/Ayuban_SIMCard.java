import java.util.Scanner;

public class Ayuban_SIMCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String phoneNumber;
        double loadAmount = 0;
        double cashPayment = 0;
        boolean loadSuccessful = false;

        while (!loadSuccessful) {
            
            System.out.println("\n=== SIMPLE SIM CARD LOADING SYSTEM ===");
            System.out.println("[1] - Buy Regular Load");
            System.out.println("[2] - Exit");
            System.out.print("Enter your choice: ");
            int userInput = sc.nextInt();

            if (userInput == 1) {
                sc.nextLine();
                System.out.print("\nPlease enter your phone number: ");
                phoneNumber = sc.nextLine();

                if (!phoneNumber.startsWith("09")) {
                    System.out.println("ERROR: Phone number should start at '09'.");
                    continue;
                }

                if (phoneNumber.length() != 11) {
                    System.out.println("ERROR: Phone number should be 11 numbers.");
                    continue;
                }

                String phoneNumberSIM = phoneNumber.substring(2, 4);

                if ("00".contentEquals(phoneNumberSIM)) {
                    System.out.println("ERROR: Unknown SIM Card");
                    continue;
                }

                int prefix = Integer.parseInt(phoneNumber.substring(2, 4));
                
                if (prefix >= 1 && prefix <= 50) {
                    
                    while (!loadSuccessful) {
                        System.out.println("\nAvailable Product for GLOBE/TM");
                        System.out.print("Enter Load Amount: ");
                        loadAmount = sc.nextDouble();

                        if (loadAmount < 15 && loadAmount > 150) {
                            System.out.println("ERROR: Please enter load amount from '15-150'");
                            continue;
                        }

                        else {
                            sc.nextLine();
                            System.out.print("Enter your cash payment: ");
                            cashPayment = sc.nextDouble();

                            if (cashPayment < loadAmount) {
                                System.out.println("Your payment should not be less than in your load amount!");
                                continue;
                            } else {
                                cashPayment -= loadAmount;
                                System.out.println("Payment Successful\nYour change due is " + cashPayment);
                                continue;
                            }
                        }
                    }
                }
                
                if (prefix >= 51 && prefix <= 99) {
                    
                    while (!loadSuccessful) {
                        System.out.println("\nAvailable Product for SMART/TM");
                        System.out.print("Enter Load Amount: ");
                        loadAmount = sc.nextDouble();

                        if (loadAmount < 15 && loadAmount > 150) {
                            System.out.println("ERROR: Please enter load amount from '15-150'");
                            continue;
                        }

                        else {
                            sc.nextLine();
                            System.out.print("Enter your cash payment: ");
                            cashPayment = sc.nextDouble();

                            if (cashPayment < loadAmount) {
                                System.out.println("Your payment should not be less than in your load amount!");
                                continue;
                            } else {
                                cashPayment -= loadAmount;
                                System.out.println("Payment Successful\nYour change due is " + cashPayment);
                                continue;
                            }
                        }
                     }
                   }
               }

               else if (userInput == 2) {
                    loadSuccessful = true;
               }
        }

        sc.close();
    }
}
    

