import models.Teacher;
import repositories.StudentRepository;
import repositories.TeacherRepository;
import services.ReadDataService;
import services.WriteDataService;
import processors.ApplicationProcessor;

public class ApplicationManager {
    public static void start() throws Exception {

        StudentRepository studentRepository = StudentRepository.getInstance();
        TeacherRepository teacherRepository = TeacherRepository.getInstance();

        ReadDataService readDataService = new ReadDataService();
        var students = readDataService.readStudentsDataFromJson();
        var teachers = readDataService.readTeachersDataFromJson();

        WriteDataService writeDataService = new WriteDataService(studentRepository, teacherRepository);

        writeDataService.writeStudentsDataToRepository(students);
        writeDataService.writeTeachersDataToRepository(teachers);

        ApplicationProcessor.start();
    }
}
