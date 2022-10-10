package processors.procedures;

import processors.procedures.menus.Menu;
import processors.procedures.menus.StudentMenu;
import processors.procedures.menus.TeacherMenu;

import java.rmi.UnexpectedException;

public class MenuProcedure extends Procedure{

    private Menu getUserMenu() throws Exception {
        switch (loggedUserRole) {
            case STUDENT: return new StudentMenu();
            case TEACHER: return new TeacherMenu();
            default: throw new Exception("Unexpected user role");
        }
    }
    @Override
    public void start() throws Exception {
        Menu menu = this.getUserMenu();
        menu.start();
        super.passToNextProcedure();
    }
}
