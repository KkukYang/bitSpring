package day1214.ex3;

public class Sungjuk {
    Student stu;
    String schoolName;

    public Sungjuk(Student stu) {
        this.stu = stu;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public void studentInfo() {
        System.out.println("school name : " + schoolName);
        System.out.println("student name : " + stu.getName());

        System.out.println("kor score : " + stu.getKor());
        System.out.println("eng score : " + stu.getEng());
        System.out.println("mat score : " + stu.getMat());

        System.out.println("total score : " + (stu.getKor() + stu.getEng() + stu.getMat()));
    }
}
