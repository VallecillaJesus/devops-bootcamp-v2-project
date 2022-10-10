package services;

import models.Student;
import models.Teacher;
import repositories.StudentRepository;
import repositories.TeacherRepository;

import java.util.List;

public class WriteDataService {
    private StudentRepository studentRepository;
    private TeacherRepository teacherRepository;

    public WriteDataService(StudentRepository studentRepository, TeacherRepository teacherRepository) {
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }

    public void writeStudentsDataToRepository(List<Student> students) {
        students.forEach(student -> this.studentRepository.save(student));
    }

    public void writeTeachersDataToRepository(List<Teacher> teachers) {
        teachers.forEach(teacher -> this.teacherRepository.save(teacher));
    }
}
