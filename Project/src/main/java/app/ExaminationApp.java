package app;

import java.util.List;
import java.util.Scanner;

import exception.ExamNotAvailableException;
import model.Exam;
import model.Question;
import repository.ExamRepository;
import service.ExamService;
import service.AttemptService;

public class ExaminationApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ExamRepository repository = new ExamRepository();
        ExamService examService = new ExamService(repository);
        AttemptService attemptService = new AttemptService();

        Question question = new Question(
            1,
            "Which language are we learning?",
            "Java"
        );

        boolean running = true;

        while (running) {
            System.out.println("\n=== Online Examination Platform ===");
            System.out.println("1. View Exams");
            System.out.println("2. Start Exam");
            System.out.println("3. Answer Sample Question");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            try {
                switch (choice) {

                    case "1":
                        List<Exam> exams = examService.getAllExams();

                        for (Exam exam : exams) {
                            System.out.println(
                                exam.getExamId() + ". "
                                + exam.getTitle() + " - "
                                + (exam.isActive()
                                    ? "Active" : "Inactive")
                            );
                        }
                        break;

                    case "2":
                        System.out.print("Enter Exam ID: ");
                        int examId = Integer.parseInt(
                            scanner.nextLine()
                        );

                        Exam exam = examService.startExam(examId);

                        System.out.println(
                            "Exam started successfully: "
                            + exam.getTitle()
                        );
                        break;

                    case "3":
                        System.out.print("Your answer: ");
                        String answer = scanner.nextLine();

                        boolean correct =
                            attemptService.submitAnswer(
                                question, answer
                            );

                        System.out.println(
                            correct
                                ? "Correct answer!"
                                : "Wrong answer!"
                        );
                        break;

                    case "4":
                        running = false;
                        System.out.println("Thank you!");
                        break;

                    default:
                        System.out.println(
                            "Invalid menu choice. Try again."
                        );
                }

            } catch (NumberFormatException e) {
                System.out.println(
                    "Please enter a valid number."
                );

            } catch (ExamNotAvailableException e) {
                System.out.println(
                    "Exam error: " + e.getMessage()
                );

            } catch (IllegalArgumentException e) {
                System.out.println(
                    "Error: " + e.getMessage()
                );

            } catch (RuntimeException e) {
                System.out.println(
                    "Unexpected error: " + e.getMessage()
                );
            }
        }

        scanner.close();
    }
}
