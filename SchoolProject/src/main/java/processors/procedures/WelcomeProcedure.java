package processors.procedures;

import models.School;

public class WelcomeProcedure extends Procedure{
    @Override
    public void start() throws Exception {
        var school = new School("American School");

        System.out.println("=============================");
        System.out.println("Welcome to " + school.getName());
        System.out.println("=============================");

        super.passToNextProcedure();
    }
}
