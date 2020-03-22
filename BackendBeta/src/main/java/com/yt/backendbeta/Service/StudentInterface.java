package com.yt.backendbeta.Service;
import java.util.List;
import com.yt.backendbeta.Entity.Student;


public interface StudentInterface {
	
   public void addStudent(Student student);
   public Student getStudentId(String studentId);
   public List<Student> getStudentName(String name);
   public List<Student> getAllStudent();
 
}
