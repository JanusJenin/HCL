Day 6 — Exception Handling and Debugging

Objective

Learn Java exception handling, custom exceptions, exception chaining, multi-catch, stack-trace analysis, and AI-assisted debugging.

Concepts Practised

- Checked and unchecked exceptions
- `try`, `catch`, and `finally`
- `throw` and `throws`
- Creating and handling custom exceptions
- Multi-catch using `|`
- Exception chaining using `getCause()`
- Stack-trace analysis using `printStackTrace()`
- Input validation and error handling
- Basic audit messages using `finally`
- AI-assisted debugging and verification

Project Structure

```text
Day6/
├── README.md
└── src/
    └── main/
        └── java/
            ├── app/
            │   ├── OrderApp.java
            │   └── OrderProcessingApp.java
            ├── exception/
            │   ├── InsufficientStockException.java
            │   ├── InvalidOrderException.java
            │   └── InvalidQuantityException.java
            ├── model/
            │   ├── Order.java
            │   └── Product.java
            └── service/
                ├── OrderProcessor.java
                └── OrderService.java
```

Class Responsibilities

- `Product.java` — stores product information, price, and available stock.
- `Order.java` — represents order information.
- `InsufficientStockException.java` — custom checked exception for orders that exceed available stock.
- `InvalidQuantityException.java` — custom unchecked exception for invalid quantity input.
- `InvalidOrderException.java` — custom exception used in the basic order example.
- `OrderProcessor.java` — validates quantities, checks stock, and processes orders.
- `OrderService.java`— handles basic order-processing operations.
- `OrderApp.java`— demonstrates the basic order application.
- `OrderProcessingApp.java` — runs the order-processing and exception-handling test scenarios.

Exception Handling Implementation

The application demonstrates how exceptions can be used to handle invalid input and business-rule violations.

1. Validates that the requested quantity is greater than zero.
2. Checks whether sufficient stock is available.
3. Throws `InvalidQuantityException` when the quantity is invalid.
4. Throws `InsufficientStockException` when the requested quantity exceeds available stock.
5. Uses `try-catch` blocks to handle exceptions and allow the application to continue.
6. Uses `finally` to print audit messages after processing each scenario.
7. Preserves the original parsing exception using exception chaining.

Test Scenarios

1. Valid Order

- **Input:** Order 2 keyboards.
- **Expected result:** The order is processed successfully.
- **Verification:** Available stock decreases by 2.

2. Invalid Quantity

- **Input:** Quantity `0`.
- **Expected result:** `InvalidQuantityException` is thrown.
- **Verification:** The invalid order is rejected and stock remains unchanged.

3. Insufficient Stock

- **Input:** Request 10 keyboards when insufficient stock is available.
- **Expected result:** `InsufficientStockException` is thrown.
- **Verification:** The exception is handled, its stack trace is printed, and stock is not reduced.

4. Invalid Text Input

- **Input:** `"abc"`.
- **Expected result:** The input cannot be parsed as an integer.
- **Original exception:** `NumberFormatException`.
- **Application exception:** `InvalidQuantityException`.
- **Verification:** The original parsing exception is preserved as the cause.

5. Decimal Text Input

- **Input:** `"2.5"`.
- **Expected result:** The input is rejected because the application expects a whole-number quantity.
- **Original exception:** `NumberFormatException`.
- **Verification:** The exception is handled, and the application continues running.

Build and Run

Prerequisites

- Java Development Kit (JDK) installed.
- Java compiler (`javac`) available in the terminal.
- PowerShell or another terminal.

Step 1: Navigate to the Day 6 Directory

From the repository root, run:

```powershell
cd Dailytask\Day6
```

Step 2: Compile the Java Files

```powershell
javac -d out (Get-ChildItem -Recurse src\main\java\*.java).FullName
```

The compiled `.class` files are generated in the `out` directory.

Step 3: Run the Application

```powershell
java -cp out app.OrderProcessingApp
```

Expected Results

- Valid orders are processed successfully.
- Zero and invalid text quantities are rejected.
- Orders exceeding available stock are rejected.
- Stack traces provide details about the exceptions.
- The original `NumberFormatException` is available through `getCause()`.
- Audit messages are printed after the scenarios.
- The application continues to the remaining scenarios after handled exceptions.
- The final stock should be `3` for the current test setup.

AI-Assisted Debugging

AI assistance was used to explain exception stack traces, identify possible error causes, and suggest verification steps. The explanations were checked against the implementation and actual program output.

Stack Trace Analysis 1 — Insufficient Stock

Exception:`InsufficientStockException`

Problem:The requested quantity is greater than the available product stock.

Cause:The order violates the inventory stock limit.

Analysis:The stack trace identifies the exception type and the method calls involved in processing the order. The source line numbers help locate where the exception was thrown.

Verification:The exception is caught by the application, the stack trace is printed, and subsequent scenarios execute.

Prevention:Validate the requested quantity against the available stock before updating inventory.

Stack Trace Analysis 2 — Invalid Quantity Input

Exceptions:`NumberFormatException` and `InvalidQuantityException`

Problem:The input contains non-integer text, such as `"abc"` or `"2.5"`.

Cause:`Integer.parseInt()` cannot convert these values into an integer.

Analysis:The `NumberFormatException` is caught and wrapped in an `InvalidQuantityException`. Exception chaining preserves the original error for investigation.

Verification:Calling `getCause()` on the `InvalidQuantityException` returns the original `NumberFormatException`. The application continues running after handling the invalid input.

Prevention:Validate quantity input and handle parsing errors. Preserve the original exception when throwing a custom exception.

Debugging Verification Checklist

- [x] Compiled the Java source files successfully.
- [x] Ran the order-processing application.
- [x] Tested a valid order.
- [x] Tested a zero quantity.
- [x] Tested insufficient stock.
- [x] Tested invalid text input.
- [x] Tested decimal text input.
- [x] Inspected exception stack traces.
- [x] Verified exception chaining using `getCause()`.
- [x] Verified that the application continues after handled exceptions.
- [x] Verified the final stock value for the current test setup.

Logging Note

The `[AUDIT]` messages are printed to the console from the `finally` block. They are not persisted to a log file or database.

Conclusion

This exercise demonstrates Java exception handling, custom exceptions, exception chaining, input validation, and stack-trace debugging. It also shows how AI-assisted explanations can help investigate errors when the suggested analysis is verified against the actual code and program output.
