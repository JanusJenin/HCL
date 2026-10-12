package service;

import exception.InvalidAnswerException;
import model.Question;

public class AttemptService {

    public boolean submitAnswer(Question question, String answer) {

        if (question == null) {
            throw new IllegalArgumentException(
                "Question cannot be null."
            );
        }

        if (answer == null || answer.trim().isEmpty()) {
            throw new InvalidAnswerException(
                "Answer cannot be empty."
            );
        }

        return question.isCorrectAnswer(answer.trim());
    }
}

