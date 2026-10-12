Online Examination and Assessment Platform

Project Overview

A Java-based application that manages exams, questions, and answer validation. It demonstrates basic exam management, business rule validation, and exception handling.

Features

- View available exams.
- Start active exams.
- Prevent users from starting inactive exams.
- Handle invalid exam IDs.
- Validate submitted answers.
- Reject empty answers.
- Accept answers regardless of uppercase or lowercase letters.
- Recover from invalid menu inputs without terminating the application.

Technologies Used

- Java
- Java Collections Framework
- Exception Handling
- VS Code

Project Structure

```text
src/main/java/
├── app/
│   └── ExaminationApp.java
├── exception/
│   ├── ExamNotAvailableException.java
│   └── InvalidAnswerException.java
├── model/
│   ├── Exam.java
│   └── Question.java
├── repository/
│   └── ExamRepository.java
└── service/
    ├── ExamService.java
    └── AttemptService.java
```

Exception Handling

- `ExamNotAvailableException`: Checked exception used when an inactive exam is requested.
- `InvalidAnswerException`: Unchecked exception used when an empty answer is submitted.
- `NumberFormatException`: Handles non-numeric exam ID input.
- `IllegalArgumentException`: Handles an exam ID that does not exist.
- `RuntimeException`: Handles other runtime errors in the menu flow.

How to Run

Open the terminal in the project root directory and run:

```powershell
javac -d out (Get-ChildItem -Recurse src\main\java -Filter *.java).FullName
java -cp out app.ExaminationApp
```

Test Cases

| Test | Expected Result |
|---|---|
| View exams | Display all exams |
| Start active exam | Exam starts successfully |
| Start inactive exam | Display an exam error |
| Enter an unknown exam ID | Display an error message |
| Submit the correct answer | Display `Correct answer!` |
| Submit a wrong answer | Display `Wrong answer!` |
| Submit an empty answer | Display an answer error |
| Enter an invalid menu choice | Display a message and show the menu again |
| Enter text instead of an exam ID | Ask for a valid number |
| Submit `java` instead of `Java` | Accept the answer |

Current Scope

This is an initial console-based version. Persistent database storage, candidate login, exam scheduling, scoring, and a graphical user interface can be added in future development.
AI-Assisted Debugging Analysis — Test 1

Tool used: GitHub Copilot Chat

Exception:`NumberFormatException`

Problem: The program attempts to convert the text `"abc"` into an integer using `Integer.parseInt()`. Since the text is not a valid integer, Java throws a `NumberFormatException`.

Copilot explanation verification:
- Correctly identified the invalid numeric conversion as the cause.
- Correctly recommended catching `NumberFormatException`.
- Correctly explained that a loop can redisplay the menu after invalid input.
- The reported line number must be checked against the actual source code because the stack trace was provided as a sample.

Correctness assessment: The explanation is technically correct. The line number is not independently verified against an actual runtime stack trace.

Project verification: The application's exam-ID input uses `Integer.parseInt()` and catches `NumberFormatException`. Testing with `abc` displayed `Please enter a valid number.` and returned to the menu without terminating the application.
AI-Assisted Debugging Analysis — Test 2

Tool used: GitHub Copilot Chat

Exception:`NullPointerException`

Problem:The program tries to call `getTitle()` on an `Exam` reference that is `null`. Since no object is available, Java cannot execute the method call.

Copilot explanation verification:
- Correctly explained what a `null` reference means.
- Correctly identified why calling a method on a null reference causes a `NullPointerException`.
- Correctly recommended checking for `null` before accessing the object.
- Correctly stated that catching `NullPointerException` is possible, but preventing it with proper validation is preferable.
- The reported line number must be checked against the actual source code because the stack trace was provided as a sample.

Correctness assessment:The explanation is technically correct. The line number is not independently verified against an actual runtime stack trace.

Project verification: `ExamRepository.findById()` returns `null` when an exam is not found. `ExamService.startExam()` checks whether the exam is `null` before accessing its details and throws an `IllegalArgumentException` if the exam does not exist. This prevents the described null-reference error in that flow.

