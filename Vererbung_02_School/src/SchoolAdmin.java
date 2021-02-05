import model.*;

public class SchoolAdmin {
    public static void main(String[] args) {
        SchoolAdmin a = new SchoolAdmin();
        a.test();
    }
    public void test(){
        Human humanHuman = new Human();
        Human humanTeacher = new Teacher();
        Teacher teacherTeacher = new Teacher();
        Human humanStudent = new Student();
        Student studentStudent = new Student();
        
        System.out.println("Human humanHuman = new Human():");
        humanHuman.goHome();

        System.out.println("Human humanTeacher = new Teacher():");
        humanTeacher.goHome();
        System.out.println("Teacher teacherTeacher = new Teacher():");
        teacherTeacher.goHome();

        System.out.println("Human humanStudent = new Student():");
        humanStudent.goHome();
        System.out.println("Student studentStudent = new Student():");
        studentStudent.goHome();

    }
}
