package mainfinished1;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Nadun
 */
class Bank {

    private String accno = null;
    private String name = null;
    private double balance = 0d;
    private String address = null;

    public String getAccno() {
        return accno;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public String getAddress() {
        return address;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    //method to open an account
    void openAccount() {
        
        while (true) {            
            accno = JOptionPane.showInputDialog("Enter Account Number or name your new account: ");
            
            if(accno!=null) break;
            errMessage();
        }
        
        while (true) {            
            name = JOptionPane.showInputDialog("Enter Your Name:");
            if(!name.isEmpty() || name!=null) break;
            errMessage();
        }
        
        while (true) {            
            String strBalance = JOptionPane.showInputDialog("Enter Balance: £");
            if(strBalance!=null){
                try{
                    balance = Double.parseDouble(strBalance);
                }catch(NumberFormatException ex){
                    System.out.println("Enter valid balance");
                }
                break;
            }
            errMessage();
        }
        
        boolean x = true;
        
        while (x) {            
            address = JOptionPane.showInputDialog("Enter The Billing Address: ");
            if(address!=null)
                x = false;
            errMessage();
        }
    }
    
    private void errMessage(){
        System.out.println("You can't skip.Enter the details.");
    }

    //method to display account details
    void showAccount() {
        System.out.println(accno + ", " + name + ", £" + balance + ", " + address);
        
    }

    //method to transfer money
    void transfermoney() {
        double amt = 0d;
        while (true) {            
            String strAmt = JOptionPane.showInputDialog("Enter Amount You want to transfer: £");
            if(strAmt!=null){
                try{
                    amt = Double.parseDouble(strAmt);
                }catch(NumberFormatException ex){
                    System.out.println("Enter valid amount");
                }
                break;
            }
            errMessage();
        }

        String receiver;
        
        while (true) {            
            receiver = JOptionPane.showInputDialog("Enter name of the receiver");
            if(receiver!=null) break;
            errMessage();
        }

        String acc;
        
        while (true) {            
            acc = JOptionPane.showInputDialog("Enter receiver's account number:");
            if(acc!=null) break;
            errMessage();
        }

        if (balance >= amt) {
            balance = balance - amt;
            
            System.out.println("Transfer Executed Succesfully! Your remaining balance is " + balance);
        } else if (balance < amt) {
            System.out.println("Transfer Unsuccesfull! Not enaugh founds.");
        }
    }

    //method to deposit money
    void deposit() {
        double amt = 0d;
        
        while (true) {            
            String strAmt = JOptionPane.showInputDialog("Enter Amount U Want to Deposit : ");
            if(strAmt!=null){
                try{
                    amt = Double.parseDouble(strAmt);
                }catch(NumberFormatException ex){
                    System.out.println("Enter valid amount");
                }
                break;
            }
            errMessage();
        }
        balance = balance + amt;
        System.out.println("Deposit Succesfull! Your New Balance is: £" + balance);
    }

    //method to withdraw money
    void withdrawal() {
        double amt = 0d;
        while (true) {            
            String strAmt = JOptionPane.showInputDialog("Enter Amount You Want to withdraw : ");
            if(strAmt!=null){
                try{
                    amt = Double.parseDouble(strAmt);
                }catch(NumberFormatException ex){
                    System.out.println("Enter valid amount");
                }
                break;
            }
            errMessage();
        }
        if (balance >= amt) {
            balance = balance - amt;
            
            System.out.println("Withdrawal Succesfull! Your New Balance is: £" + balance);
        } else {
            System.out.println("Less Balance..Transaction Failed..");
        }
    }

    //method to search an account number
    boolean search(String acn) {
        if (accno.equals(acn)) {
            showAccount();
            return (true);
        }
        return (false);
    }

    // Sort an array of integers using (an inefficient) variant of 
    // bubblesort
    void bubble_sort(ArrayList<Bank> banks, int arraySize) {
        int total = 0;
        int x = 1;
        for (int pass = 0; pass < arraySize - 1; pass++) {
            for (int counter = 0; counter < arraySize - x; counter++) {
                if (banks.get(counter).balance > banks.get((counter + 1)).balance) {
                    swap(banks, counter, counter + 1);
                }

                total++;
                showAccount(); // print intermediate states as is sorted
            }
            x++;
        }
        System.out.println();
    }

    // Exchange a given pair of values given by their positions in an array
    public static void swap(ArrayList<Bank> list, int p1, int p2) {
        
        Bank b1 = list.get(p1);
        Bank b2 = list.get(p2);
        list.set(p2, b1);
        list.set(p1, b2);
    }
} 
