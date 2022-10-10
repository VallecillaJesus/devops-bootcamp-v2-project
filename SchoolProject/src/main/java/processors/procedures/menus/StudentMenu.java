package processors.procedures.menus;

import processors.procedures.MenuProcedure;
import repositories.StudentRepository;

public class StudentMenu extends MenuProcedure implements Menu{

    StudentRepository studentRepository = StudentRepository.getInstance();

    @Override
    public void start() {
        System.out.println("\n------------- RESULTS --------------");
        System.out.println(studentRepository.getByCode(loggedUserCode).get());
    }
}
