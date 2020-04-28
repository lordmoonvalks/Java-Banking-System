package mainfinished1;
//This is banking system program in JAVA
//Program includes classes, methods, objects, switch statement, passing parameters, arryas and loops, searches, getters,search method ,arraylist , filewriter and bubble sorting.
//Program provides option to create N number of bank accounts with custom names, balances, billing addresses and account numbers.
//Methods in the program let us display all the created accounts , search for the specific account using account numbers , transfers money (to any account), 
//deposit & withdraw as well as sorting the accounts by balance or saving them to text file.
//We can deposit custom ammount of money into accounts , however we can't withdraw more then our actual balance.
//by MS2819

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Nadun
 */
public class BankClass {

    public static ArrayList<Bank> C = new ArrayList<Bank>();

    private static void saveToTxtFile() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
 
            // The name of the file to open.
            String fileName = file.getPath();

            try {
                // Assume default encoding.
                FileWriter fileWriter = new FileWriter(fileName);

                // Always wrap FileWriter in BufferedWriter.
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                // Note that write() does not automatically
                // append a newline character.
                // write the topic of the columns
                bufferedWriter.write("ACC.NO, NAME, BALANCE, ADDRESS");
                bufferedWriter.newLine();
                for (Bank b : C) {

                    bufferedWriter.write(b.getAccno() + ", " + b.getName() + ", £" + b.getBalance() + ", " + b.getAddress());
                    bufferedWriter.newLine();// new line
                }

                // Always close files.
                bufferedWriter.close();

            } catch (IOException ex) {
                System.out.println("Error writing to file '" + fileName + "'");
            }
        }
    }

    public static void main(String arg[]) {

        // set the look and feel of the GUI
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //

        boolean b = true;
        while (b) {
            try {
                int n = 1;
                //Specify how many accounts you want to create
                String input = JOptionPane.showInputDialog("How Many Customer U Want to Input : ");
                if (input != null) {
                    try {
                        n = Integer.parseInt(input);
                    } catch (NumberFormatException e) {
                    }
                }
                // if not user give n default value of n is 1

                for (int i = 0; i < n; i++) {
                    Bank bank = new Bank();
                    bank.openAccount();
                    // add this acc to list
                    C.add(bank);
                    System.out.println("Succesfully created an account.");
                }

                //run loop until menu 5 is not pressed
                int ch = 0;
                do {
                    System.out.println("Main Menu\n"
                            + "1.Display All Accounts\n"
                            + "2.Search By Account\n"
                            + "3.Transfer Money \n"
                            + "4.Deposit\n"
                            + "5.Withdrawal\n"
                            + "6.Sort accounts by balance\n"
                            + "7.Save acoounts to text file\n"
                            + "8.Exit  ");

                    String menuOption = JOptionPane.showInputDialog("Ur Choice :");

                    if (menuOption != null) {
                        ch = Integer.parseInt(menuOption);
                    }
                    switch (ch) {
                        case 1:
                            for (int i = 0; i < n; i++) {
                                C.get(i).showAccount();
                            }
                            break;

                        case 2:
                            String acn = JOptionPane.showInputDialog("Enter Account No U Want to Search...: ");
                            boolean found = false;
                            for (int i = 0; i < n; i++) {
                                found = C.get(i).search(acn);
                                if (found) {
                                    break;
                                }
                            }
                            if (!found) {
                                System.out.println("Search Failed..Account Not Exist..");
                            }
                            break;

                        case 3:

                            acn = JOptionPane.showInputDialog("Enter Account No : ");
                            found = false;
                            for (int i = 0; i < n; i++) {
                                found = C.get(i).search(acn);
                                if (found) {
                                    C.get(i).transfermoney();
                                    break;
                                }
                            }
                            if (!found) {
                                System.out.println("Search Failed..Account Not Exist..");
                            }
                            break;

                        case 4:
                            acn = JOptionPane.showInputDialog("Enter Account No : ");
                            found = false;
                            for (int i = 0; i < n; i++) {
                                found = C.get(i).search(acn);
                                if (found) {
                                    C.get(i).deposit();
                                    break;
                                }
                            }
                            if (!found) {
                                System.out.println("Search Failed..Account Not Exist..");
                            }
                            break;

                        case 5:
                            acn = JOptionPane.showInputDialog("Enter Account No : ");
                            found = false;
                            for (int i = 0; i < n; i++) {
                                found = C.get(i).search(acn);
                                if (found) {
                                    C.get(i).withdrawal();
                                    break;
                                }
                            }
                            if (!found) {
                                System.out.println("Search Failed..Account Not Exist..");
                            }
                            break;

                        case 6:
                            System.out.println("Sort the accounts by it's balance");
                            for (int i = 0; i < n; i++) {
                                C.get(i).bubble_sort(C, n);
                            }
                            break;

                        case 7:
                            saveToTxtFile();
                            break;

                        case 8:
                            System.out.println("Good Bye..");
                            break;

                        default:
                            break;

                    }
                } while (ch != 8);
                b = false;
            } // try
            catch (InputMismatchException ime) {

                System.out.println("Not an integer, try again");
                break;
            }// catch
        }

    }
}
