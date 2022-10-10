package repositories;

import models.Student;
import models.Teacher;
import models.enums.Grade;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repositories.StudentRepository;
import repositories.TeacherRepository;

import java.util.Optional;

public class TeacherRepositoryTests {
    private TeacherRepository teacherRepository;

    @BeforeEach
    public void initialConfiguration(){
        this.teacherRepository= new TeacherRepository();
        Teacher teacherA = new Teacher("TE-01-Isac","Isac Ignite");
        Teacher teacherB = new Teacher("TE-02-March","March Washington");

        this.teacherRepository.save(teacherA);
        this.teacherRepository.save(teacherB);
    }

    @Test
    public void shouldGetAllStudentsData(){
        Assertions.assertEquals(2, this.teacherRepository.getAll().size());
    }

    @Test
    public void shouldGetTeacherByCode(){
        Optional<Teacher> foundTeacher = this.teacherRepository.getByCode("TE-02-March");
        Assertions.assertTrue(foundTeacher.isPresent());
        Assertions.assertEquals("March Washington",foundTeacher.get().getName());
    }

}
