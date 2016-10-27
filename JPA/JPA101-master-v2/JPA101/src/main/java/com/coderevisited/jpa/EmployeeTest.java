package com.coderevisited.jpa;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class EmployeeTest {


	private static EntityManager em;

	public static void main(String[] args) {

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );

		EntityManager entitymanager = emfactory.createEntityManager( );
		entitymanager.getTransaction( ).begin( );

		Employee employee = new Employee( ); 
		employee.setId( 1201 );
		employee.setfname( "Gopal" );
		employee.setlanme( "Gopal" );
		employee.setdesg( "Technical Manager" );
		entitymanager.persist( employee );
		entitymanager.getTransaction( ).commit( );

		entitymanager.close( );
		emfactory.close( );

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
