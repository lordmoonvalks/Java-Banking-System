This is banking system program in JAVA

Program provides option to create N number of bank accounts with custom names, balances, billing addresses and account numbers.
Program includes classes, methods, objects, switch statement, passing parameters, arryas and loops, searches, getters,search method ,arraylist , filewriter and bubble sorting.
Methods in the program let us display all the created accounts , search for the specific account using account numbers , transfers money (to any account), deposit & withdraw as well as sorting the accounts by balance or saving them to text file. We can deposit custom ammount of money into accounts, however we can't withdraw more then our actual balance. 

Added:
-exception handling
-arraylist
-bubblesort
-getters and setters 
-file writer
-j.swing


Content:
Menu:
1.Display All Accounts
2.Search by Account
3.Transfer Money
4. Deposit
5. Withdrawal
6. Sort accounts by balance
7. Save accounts to text file
8. Exit.


At the start program asks user to create N ammount of elements (bank accounts) into ArrayList with parameters as balance, Name, Account Number and Billing Address, then displays menu with 8 options:
Ad. 1
Display All Accounts
-	Print all the elements of bank accounts created by user in rows.
-	Comeback to menu.
Ad. 2
Search by Account
-	Ask user to input the account number.
-	Print all the elements of bank account linked to that number in a row.
-	Comeback to menu.

Ad. 3
Transfer Money
-	Ask user to input the account number.
-	Ask user to input the ammount of money.
-	Ask user to input the receiver’s name.
-	Ask user to input the receiver’s account number.
-	Substitute the ammount of money from selected account number and update remaining balance.
-	Print transaction’s confirmation or transaction’s failure if not enough funds on the bank account.
-	Comeback to menu.
Ad. 4
Deposit
-	Ask user to input the account number.
-	Ask user to input ammount of money.
-	Update selected account’s balance by the deposited a ammount.
-	Comeback to menu.
Ad. 5
Withdrawal
-	Ask user to input the account number.
-	Ask user to input ammount of money.
-	Update selected account’s balance by the withdrawer ammount.
-	Comeback to menu.


Ad. 6
Sort accounts by balance
-	Compare all the accounts created in ArrayList by it’s “balance” parameter
-	Sort them descending
-	Comeback to menu.
Ad. 7
Save accounts to the text file
-	Ask user to select destination location on the computer using File Chooser
-	Save elements created in the ArrayList by user into text file.
-	Comeback to menu.
Ad. 8
Exit
-terminates the program.


