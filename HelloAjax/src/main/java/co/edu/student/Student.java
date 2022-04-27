package co.edu.student;

public class Student {
    private int studentNo;
    private String studentName;
    private int engScore;
    private int korScore;
    
    public Student(int studentNo, String studentName, int engScore, int koreScore) {
	super();
	this.studentNo = studentNo;
	this.studentName = studentName;
	this.engScore = engScore;
	this.korScore = koreScore;
    }
    
    public Student() {
    }

    public int getStudentNo() {
        return studentNo;
    }
    public void setStudentNo(int studentNo) {
        this.studentNo = studentNo;
    }
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public int getEngScore() {
        return engScore;
    }
    public void setEngScore(int engScore) {
        this.engScore = engScore;
    }
    public int getKorScore() {
        return korScore;
    }
    public void setKorScore(int koreScore) {
        this.korScore = koreScore;
    }
    
    @Override
    public String toString() {
	return "Student [studentNo=" + studentNo + ", studentName=" + studentName + ", engScore=" + engScore
		+ ", korScore=" + korScore + "]";
    }
    
    
}
