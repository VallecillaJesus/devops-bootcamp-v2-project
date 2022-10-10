package processors.procedures;

import helpers.AccessValidator;
import models.Student;
import models.Teacher;
import models.enums.Role;
import repositories.StudentRepository;
import repositories.TeacherRepository;

import java.util.Scanner;

public class LoginProcedure extends Procedure {

    private final AccessValidator<Student> studentAccessValidator = new AccessValidator<>(StudentRepository.getInstance());
    private final AccessValidator<Teacher> teacherAccessValidator = new AccessValidator<>(TeacherRepository.getInstance());
    private final Scanner scanner = new Scanner(System.in);

    private void showDialog(){
        System.out.println("Select your role please: ");
        System.out.println("1. Teacher");
        System.out.println("2. Student");
    }

    private boolean verifyAccess(String option, String code){
        switch (option) {
            case "1":
                if (!this.teacherAccessValidator.verifyAccess(code))
                   return false;
                break;
            case "2":
                if (!this.studentAccessValidator.verifyAccess(code))
                    return false;
        }
        return true;
    }

    private Role getLoggedUserRole(String option){
        if(option.equals("1")){
            return Role.TEACHER;
        }
        return Role.STUDENT;
    }

    @Override
    public void start() throws Exception {

        this.showDialog();
        String option = scanner.nextLine();
        String code = "";

        boolean access = false;
        while (!access) {
            System.out.println("Please enter your code");
            code = scanner.nextLine();
            access = this.verifyAccess(option,code);
        }

        loggedUserRole = this.getLoggedUserRole(option);
        loggedUserCode = code;

        super.passToNextProcedure();
    }
}
