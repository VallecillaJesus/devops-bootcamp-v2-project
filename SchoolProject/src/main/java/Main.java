import models.School;
import models.Student;
import models.Teacher;
import repositories.StudentRepository;
import helpers.AccessValidator;
import repositories.TeacherRepository;
import services.ReadDataService;
import services.WriteDataService;

import java.util.Scanner;

public class  Main {
    public static void main(String args[]) throws Exception {
        ApplicationManager.start();
    }
}
