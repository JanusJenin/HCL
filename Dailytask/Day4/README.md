Day 4 - Object-Oriented Programming in Java

Project: Bank Account Management System

Concepts Practised
- Classes, objects, fields, and methods
- Encapsulation using private fields and public getters
- Constructor overloading and constructor chaining using `this()`
- Static variables and methods
- Deposit and withdrawal validation
- `equals()` and `hashCode()`
- Separation of model, service, and application layers

Project Structure
- `model/BankAccount.java` - Stores account details and manages balance operations.
- `service/BankAccountService.java` - Handles account display, deposits, and withdrawals.
- `app/BankAccountApp.java` - Runs and tests the application.

Test Results
- Initial balance: Rs. 5000.00
- Deposit Rs. 1000.00: Successful
- Withdraw Rs. 500.00: Successful
- Withdrawal exceeding the balance: Rejected
- Zero-value deposit: Rejected
- Final balance: Rs. 5500.00

How to Compile and Run
Compile the Java files from the HCL project root:

powershell
javac -d Dailytask\Day4\out Dailytask\Day4\src\main\java\model\BankAccount.java Dailytask\Day4\src\main\java\service\BankAccountService.java Dailytask\Day4\src\main\java\app\BankAccountApp.java


Run the application:

powershell
java -cp Dailytask\Day4\out app.BankAccountApp

