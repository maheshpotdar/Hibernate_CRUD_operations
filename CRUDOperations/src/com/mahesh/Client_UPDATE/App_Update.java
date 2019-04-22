package com.mahesh.Client_UPDATE;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App_Update {

	public static void main(String[] args) {

		Employee employee = new Employee();
		employee.setId(1);
		employee.setEname("John Cina");

		Employee employee2 = new Employee();
		employee2.setId(2);
		employee2.setAddress("Uk");

		Employee employee3 = new Employee();
		employee3.setId(3);
		employee3.setEname("Great Khali");

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		org.hibernate.Transaction tr = session.beginTransaction();
//
//		session.update(employee);
//		session.update(employee2);
//		session.update(employee3);
//
//		session.getTransaction().commit();
//
//		System.out.println("update successfully.");
//	
		// ***************Problem in
		// Update**********************************************
		// samaja session madhe 1 id cha object ahe
		// ani mi session cha use karun 1 id cha update data update karayala gelo tar
		// uniqueObject Exception.

		session.get(Employee.class, 1);

		Employee employee4 = new Employee();
		employee4.setId(1);
		employee4.setEname("Mamu jan");
		employee4.setAddress("Afrika");

		session.update(employee4);
		System.out.println("update successfully.");
	}
}
