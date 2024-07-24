package Dao;

import java.util.List;

import Dto.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;


public class StudentDao {
	
	public void saveStudent(Student student) {
		
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		   try {
		        et.begin();
		        em.persist(student);
		        et.commit();
		    } catch (Exception e) {
		        if (et.isActive()) {
		            et.rollback();
		        }
		        throw e;
		    } finally {
		        em.close();
		    }
	} 
public List<Student> viewAll() {
		
		EntityManager em = JpaUtil.getEntityManager();
		List<Student> students = em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
		em.close();
		return students;
	}

public Student getStudentById(long id) {
    EntityManager em = JpaUtil.getEntityManager();
    try {
        return em.find(Student.class, id);
    } finally {
        em.close();
    }
}

public void updateStudent(long id, Student updatedStudent) {
	
	EntityManager em = JpaUtil.getEntityManager();
	EntityTransaction et =em.getTransaction();
	try {
        et.begin();
        Student student = em.find(Student.class, id);
        if (student != null) {
            student.setName(updatedStudent.getName());
            student.setDob(updatedStudent.getDob());
            student.setStd(updatedStudent.getStd());
            em.merge(student);
        }
        et.commit();
    } catch (Exception e) {
        if (et.isActive()) {
            et.rollback();
        }
        throw e;
    } finally {
        em.close();
    }
}

	
public void deleteStudent(long id) {
	
	EntityManager em = JpaUtil.getEntityManager();
	EntityTransaction et =em.getTransaction();
    try {
        et.begin();
        Student student = em.find(Student.class, id);
        if (student != null) {
            em.remove(student);
        }
        et.commit();
    } catch (Exception e) {
        if (et.isActive()) {
            et.rollback();
        }
        throw e;
    } finally {
        em.close();
    }
}
}

