package model;

public class Exam {

    private int examId;
    private String title;
    private boolean active;

    public Exam(int examId, String title, boolean active) {
        this.examId = examId;
        this.title = title;
        this.active = active;
    }

    public int getExamId() {
        return examId;
    }

    public String getTitle() {
        return title;
    }

    public boolean isActive() {
        return active;
    }
}
