Day 6 — Exception Handling and Debugging

Objective
Learn Java exception handling, custom exceptions, exception chaining, multi-catch, and debugging using stack traces.

Concepts Practised
- Checked and unchecked exceptions
- `try`, `catch`, and `finally`
- `throw` and `throws`
- Custom exceptions
- Multi-catch using `|`
- Exception chaining using `getCause()`
- Stack-trace analysis using `printStackTrace()`
- Basic audit messages in `finally`

Project Structure
- `model/Product.java` — product details and stock management
- `exception/InsufficientStockException.java` — checked exception for insufficient stock
- `exception/InvalidQuantityException.java` — unchecked exception for invalid quantities
- `service/OrderProcessor.java` — validates and processes orders
- `app/OrderProcessingApp.java` — runs the test scenarios

Test Scenarios
1. Valid order — 2 keyboards ordered successfully.
2. Invalid quantity — zero is rejected.
3. Insufficient stock — an order exceeding available stock is rejected.
4. Invalid text — `"abc"` is rejected with the original `NumberFormatException` preserved.
5. Decimal text — `"2.5"` is rejected because the quantity must be a whole number.

Build and Run
From the `Day6` directory, compile the Java files:

```powershell
javac -d out (Get-ChildItem -Recurse src\main\java\*.java).FullName
```

Run the application:

```powershell
java -cp out app.OrderProcessingApp
```
Expected Result
All test scenarios execute, invalid orders are rejected, and the application continues running. The final stock should be 3.

Debugging Notes
Stack traces show exception types, method calls, and source line numbers. Exception chaining preserves the original parsing error for further investigation.

The `[AUDIT]` messages are printed to the console; they are not persisted to a file or database.