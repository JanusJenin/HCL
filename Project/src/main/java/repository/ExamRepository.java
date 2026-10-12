package repository;

import java.util.ArrayList;
import java.util.List;
import model.Exam;

public class ExamRepository {

    private List<Exam> exams = new ArrayList<>();

    public ExamRepository() {
        exams.add(new Exam(1, "Java Basics", true));
        exams.add(new Exam(2, "SQL Basics", false));
    }

    public List<Exam> getAllExams() {
        return new ArrayList<>(exams);
    }

    public Exam findById(int examId) {
        for (Exam exam : exams) {
            if (exam.getExamId() == examId) {
                return exam;
            }
        }

        return null;
    }
}

