package processors.procedures.menus;

import models.Student;
import models.enums.Grade;
import repositories.StudentRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class TeacherMenu implements Menu{

    private final StudentRepository studentRepository = StudentRepository.getInstance();
    private final Scanner scanner = new Scanner(System.in);

    private void showDialog(){
        System.out.println("select an option: ");
        System.out.println("1. List the students of \"ELEMENTARY_SCHOOL\" grade");
        System.out.println("2. Enter a grade for a student");
        System.out.println("3. Exit");
    }

    private void updateStudentGrade(String studentCode, Grade grade) throws Exception {
        Optional<Student> student = this.studentRepository.getByCode(studentCode);
        if(student.isPresent()){
            System.out.println("Selected: " + student.get());
            student.get().setGrade(grade);
            this.studentRepository.save(student.get());
            System.out.println("Modified: " + student.get());
            return;
        }
        throw new Exception("No student with code: " + studentCode);
    }

    private void showStudentList(List<Student> students){
        students.forEach(System.out::println);
    }

    @Override
    public void start(){

        this.showDialog();

        String option = scanner.nextLine();
        switch (option){
            case "1": showStudentList(studentRepository.getByGrade(Grade.ELEMENTARY_SCHOOL));
                break;
            case "2":
                System.out.println("Enter students code: ");
                String studentCode = scanner.nextLine();
                System.out.println("Enter new student grade: ");
                System.out.println("1. ELEMENTARY SCHOOL");
                System.out.println("2. MIDDLE SCHOOL");
                System.out.println("3. HIGH SCHOOL");
                Grade studentGrade = switch (scanner.nextLine()){
                    case "1" -> Grade.ELEMENTARY_SCHOOL;
                    case "2" -> Grade.MIDDLE_SCHOOL;
                    default -> Grade.HIGH_SCHOOL;
                };

                try {
                    updateStudentGrade(studentCode, studentGrade);
                } catch (Exception e) {
                    System.out.println(e.getMessage());;
                }

                break;
        }

    }

}
