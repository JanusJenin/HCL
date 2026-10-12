package service;

import java.util.List;

import exception.ExamNotAvailableException;
import model.Exam;
import repository.ExamRepository;

public class ExamService {

    private ExamRepository examRepository;

    public ExamService(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    public List<Exam> getAllExams() {
        return examRepository.getAllExams();
    }

    public Exam startExam(int examId)
            throws ExamNotAvailableException {

        Exam exam = examRepository.findById(examId);

        if (exam == null) {
            throw new IllegalArgumentException(
                "Exam ID " + examId + " not found."
            );
        }

        if (!exam.isActive()) {
            throw new ExamNotAvailableException(
                "This exam is currently inactive."
            );
        }

        return exam;
    }
}
