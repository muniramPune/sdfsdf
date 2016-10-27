package com.coderevisited.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeeTest {

    private static EntityManager em;

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeeService");
        em = emf.createEntityManager();

        
        
      //  createEmployee(101, "John", "Peter", "JAVA Developer");
      //  updateEmployee(101, "Manager");
        
     //   createEmployee(5, "Jack", " Dorsey", "Imaginea");
     //   createEmployee(6, "Sam", "Fox", "Imaginea");

        
     //   updateEmployee(5,"Manager");
    
        
        deleteEmployee(6);   
        emf.close();

    }

    //create new Employee
    private static void createEmployee(int id, String firstName, String lastName, String dept) {
        em.getTransaction().begin();
        Employee emp = new Employee(id, firstName, lastName, dept);
        em.persist(emp);
        em.getTransaction().commit();
        
    }
        
        //update existing
        private static void updateEmployee(int id,String newdesg) {
        em.getTransaction().begin( );
        Employee employee = em.find( Employee.class, id );
     //   System.out.println("Found");
        //display record before update
        System.out.println("employee ID = " + employee.getId());
        System.out.println("employee NAME = " + employee.getfname());
        System.out.println("employee Last Name = " + employee.getlanme());
        System.out.println("employee DESIGNATION = " + employee.getdesg());
        
        
        //before update
        System.out.println( employee );
        employee.setdesg(newdesg);
        em.getTransaction( ).commit( );
        
        //after update
        System.out.println( employee );
        em.close();
        
        
    }
        
        
        //delete
       private static void deleteEmployee(int id) {
        em.getTransaction().begin( );
        Employee employee = em.find( Employee.class, id );
        //display record before update
        System.out.println("employee ID = " + employee.getId());
        System.out.println("employee NAME = " + employee.getfname());
        System.out.println("employee Last Name = " + employee.getlanme());
        System.out.println("employee DESIGNATION = " + employee.getdesg());
        
        em.remove(employee);
        em.getTransaction().commit();
        em.close();
        
        
    }
       
       
       
}
