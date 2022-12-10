package JavaFinalTest2020;

public class StudentStatus {
    private String name;
    private String grade;
    private String sex;
    private int mathScore;
    private int scienceScore;
    private String content;

    StudentStatus(String name, String grade, String sex, int mathScore , int scienceScore) {
        this.name = name;
        this.grade = grade;
        this.sex = sex;
        this.mathScore = mathScore;
        this.scienceScore = scienceScore;
        this.content = name + "(" + grade + "," + sex + ")" + "수학=" + mathScore + ",과학=" + scienceScore;
    }

    public String getName() {
        return name;
    }
    public String getGrade() {
        return grade;
    }
    public String getSex() {
        return sex;
    }
    public int getMathScore() {
        return mathScore;
    }
    public int getScienceScore() {
        return scienceScore;
    }
    public String getContent() { return content; }
}
