package services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import models.Student;
import models.Teacher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadDataServicesTests {

    private ReadDataService readDataService;

    @BeforeEach
    public void initialConfiguration(){
        this.readDataService = new ReadDataService();
    }

    @Test
    public void shouldReadStudentsDataFromJson(){
        List<Student> students = null;

        try {
            Gson gson = new Gson();
            var path = (Paths.get("students.json"));
            System.out.println(path);
            Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/students.json"));

            students = gson.fromJson(reader, new TypeToken<List<Student>>() {}.getType());
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        Assertions.assertEquals(students.size(), this.readDataService.readStudentsDataFromJson().size());
    }

    @Test
    public void shouldReadTeachersDataFromJson(){
        List<Teacher> teachers = null;

        try {
            Gson gson = new Gson();
            var path = (Paths.get("teachers.json"));
            System.out.println(path);
            Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/teachers.json"));

            teachers = gson.fromJson(reader, new TypeToken<List<Teacher>>() {}.getType());
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        Assertions.assertEquals(teachers.size(), this.readDataService.readTeachersDataFromJson().size());
    }

}
