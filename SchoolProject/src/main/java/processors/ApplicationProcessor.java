package processors;

import processors.procedures.FinishProcedure;
import processors.procedures.LoginProcedure;
import processors.procedures.MenuProcedure;
import processors.procedures.WelcomeProcedure;


public class ApplicationProcessor {
    public static void start() throws Exception {
        WelcomeProcedure welcomeProcedure = new WelcomeProcedure();
        LoginProcedure loginProcedure = new LoginProcedure();
        MenuProcedure menuProcedure = new MenuProcedure();
        FinishProcedure finishProcedure = new FinishProcedure();

        welcomeProcedure.setNextProcedure(loginProcedure);
        loginProcedure.setNextProcedure(menuProcedure);
        menuProcedure.setNextProcedure(finishProcedure);

        welcomeProcedure.start();
    }
}
