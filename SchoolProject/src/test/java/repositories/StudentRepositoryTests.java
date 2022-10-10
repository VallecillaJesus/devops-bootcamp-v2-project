package repositories;

import models.Student;
import models.enums.Grade;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repositories.Repository;
import repositories.StudentRepository;

import java.util.Optional;

public class StudentRepositoryTests {

    private StudentRepository studentRepository;

    @BeforeEach
    public void initialConfiguration(){
        this.studentRepository = new StudentRepository();
        Student studentA = new Student("ST-01-Roberto","Roberto",12, Grade.ELEMENTARY_SCHOOL);
        Student studentB = new Student("ST-02-Steve","Steve", 10, Grade.HIGH_SCHOOL);

        this.studentRepository.save(studentA);
        this.studentRepository.save(studentB);
    }

    @Test
    public void shouldGetAllStudentsData(){
        Assertions.assertEquals(2, this.studentRepository.getAll().size());
    }

    @Test
    public void shouldGetStudentsByGrade(){
        Assertions.assertEquals(1,this.studentRepository.getByGrade(Grade.ELEMENTARY_SCHOOL).size());
    }

    @Test
    public void shouldGetStudentByCode(){
        Optional<Student> foundStudent = this.studentRepository.getByCode("ST-02-Steve");
        Assertions.assertTrue(foundStudent.isPresent());
        Assertions.assertEquals(Grade.HIGH_SCHOOL,foundStudent.get().getGrade());
    }

    @Test
    public void shouldUpdateStudentGradeByCode(){
        Optional<Student> foundStudent = this.studentRepository.getByCode("ST-02-Steve");
        Assertions.assertTrue(foundStudent.isPresent());
        foundStudent.get().setGrade(Grade.ELEMENTARY_SCHOOL);
        this.studentRepository.save(foundStudent.get());

        Optional<Student> modifiedStudent = this.studentRepository.getByCode("ST-02-Steve");
        Assertions.assertTrue(modifiedStudent.isPresent());
        Assertions.assertEquals(Grade.ELEMENTARY_SCHOOL, modifiedStudent.get().getGrade());

    }

}
