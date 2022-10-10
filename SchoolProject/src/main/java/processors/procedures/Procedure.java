package processors.procedures;

import models.Entity;
import models.enums.Role;

import java.util.Objects;

public abstract class Procedure {
    private Procedure nextProcedure;

    protected static String loggedUserCode;
    protected static Role loggedUserRole;

    public void setNextProcedure(Procedure nextProcedure) {
        this.nextProcedure = nextProcedure;
    }

    public void passToNextProcedure() throws Exception {
        if(Objects.nonNull(this.nextProcedure))
            this.nextProcedure.start();
    }

    public abstract void start() throws Exception;
}
