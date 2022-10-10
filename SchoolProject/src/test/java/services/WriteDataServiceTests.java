package services;

import models.Student;
import models.Teacher;
import models.enums.Grade;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repositories.StudentRepository;
import repositories.TeacherRepository;

import java.util.List;

public class WriteDataServiceTests {

    private WriteDataService writeDataService;
    private StudentRepository studentRepository;
    private TeacherRepository teacherRepository;

    @BeforeEach
    public void initialConfiguration(){
        this.studentRepository = new StudentRepository();
        this.teacherRepository = new TeacherRepository();

        this.writeDataService = new WriteDataService(
                this.studentRepository,
                this.teacherRepository
        );
    }

    @Test
    public void shouldWriteStudentsDataToRepository(){
        List<Student> students = List.of(
                new Student("ST-01-Roberto","Roberto",12, Grade.ELEMENTARY_SCHOOL),
                new Student("ST-02-Steve","Steve", 10, Grade.HIGH_SCHOOL)
        );
        this.writeDataService.writeStudentsDataToRepository(students);
        Assertions.assertEquals(students.size(), this.studentRepository.getAll().size());
    }

    @Test
    public void shouldWriteTeachersDataToRepository(){
        List<Teacher> teachers = List.of(
                new Teacher("TE-01-Isac","Isac Ignite"),
                new Teacher("TE-02-March","March Washington")
        );
        this.writeDataService.writeTeachersDataToRepository(teachers);
        Assertions.assertEquals(teachers.size(), this.teacherRepository.getAll().size());
    }

}
