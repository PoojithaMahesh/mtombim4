package manytomanybim4.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytomanybim4.dto.Course;
import manytomanybim4.dto.Student;

public class StuCoursesCont {
public static void main(String[] args) {
	
	
	Student student1=new Student();
	student1.setId(1);
	student1.setName("Aanib");
	student1.setAddress("Chennnai");
	
	Student student2=new Student();
	student2.setId(2);
	student2.setName("naveen");
	student2.setAddress("Chennnai");
	
	
	Course course1=new Course();
	course1.setId(1);
	course1.setName("Java");
	course1.setFees(30000);
	
	Course course2=new Course();
	course2.setId(2);
	course2.setName("AdvJava");
	course2.setFees(30000);
	
	List<Course> courses=new ArrayList<Course>();
	courses.add(course1);
	courses.add(course2);
	
	student1.setCourses(courses);
	student2.setCourses(courses);
	
	
	List<Student> students=new ArrayList<Student>();
	students.add(student1);
	students.add(student2);
	
	course1.setStudents(students);
	course2.setStudents(students);
	
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	entityTransaction.begin();
	entityManager.persist(course1);
	entityManager.persist(course2);
	entityManager.persist(student1);
	entityManager.persist(student2);
	entityTransaction.commit();
	
}
}
