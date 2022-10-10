package helpers;

import models.Student;
import models.Teacher;
import models.enums.Grade;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repositories.StudentRepository;
import repositories.TeacherRepository;
import services.WriteDataService;

import java.util.List;

public class AccessValidatorTests {

    private WriteDataService writeDataService;
    private StudentRepository studentRepository;
    private TeacherRepository teacherRepository;
    private AccessValidator<Student> studentAccessValidator;
    private AccessValidator<Teacher> teacherAccessValidator;

    @BeforeEach
    public void initialConfiguration(){
        this.studentRepository = new StudentRepository();
        this.teacherRepository = new TeacherRepository();

        this.writeDataService = new WriteDataService(
                this.studentRepository,
                this.teacherRepository
        );

        this.writeDataService.writeTeachersDataToRepository(
                List.of(
                        new Teacher("TE-01-Isac","Isac Ignite"),
                        new Teacher("TE-02-March","March Washington")
                )
        );

        this.writeDataService.writeStudentsDataToRepository(
            List.of(
                    new Student("ST-01-Roberto","Roberto",12, Grade.ELEMENTARY_SCHOOL),
                    new Student("ST-02-Steve","Steve", 10, Grade.HIGH_SCHOOL)
            )
        );

        this.studentAccessValidator = new AccessValidator<>(this.studentRepository);
        this.teacherAccessValidator = new AccessValidator<>(this.teacherRepository);
    }

    @Test
    public void shouldVerifyStudentAccessToTrue(){
        Assertions.assertTrue(this.studentAccessValidator.verifyAccess("ST-01-Roberto"));
    }

    @Test
    public void shouldVerifyStudentAccessToFalse(){
        Assertions.assertFalse(this.studentAccessValidator.verifyAccess("ST-01-Jason"));
    }

    @Test
    public void shouldVerifyTeacherAccessToTrue(){
        Assertions.assertTrue(this.teacherAccessValidator.verifyAccess("TE-01-Isac"));
    }

    @Test
    public void shouldVerifyTeacherAccessToFalse(){
        Assertions.assertFalse(this.teacherAccessValidator.verifyAccess("TE-07-Isac"));
    }

}
