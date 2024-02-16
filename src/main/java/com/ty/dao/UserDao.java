package com.ty.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.entity.User;

@Component
public class UserDao {

	@Autowired
	EntityManager entityManager;

	@Autowired
	Scanner scanner;

	public void saveUser(User user) {
		System.out.println("Enter name");
		user.setName(scanner.nextLine());
		System.out.println("Enter email");
		user.setEmail(scanner.nextLine());
		System.out.println("Enter password");
		user.setPassword(scanner.nextLine());

		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
	}

	public User findUser() {
		System.out.println("Enter email");
		String email = scanner.nextLine();
		System.out.println("Enter password");
		String password = scanner.nextLine();
		Query query = entityManager.createQuery("Select u from User u where u.email=?1 and u.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		User user = null;
		try {
			user = (User) query.getSingleResult();
			System.out.println(user);
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("User does not exist with email " + email + " and password " + password);
		}
		return user;
	}

	public void updateUser() {
		System.out.println("Finding user !!!!");
		User user = findUser();
		if (user != null) {
			System.out.println("Press\n1. Update name\n2. Update Email\n3. Update password");
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1: {
				System.out.println("Enter new name");
				user.setName(scanner.nextLine());
				System.out.println("Name updated Successfully!!!");
				System.out.println(user);
			}
				break;
			case 2: {
				System.out.println("Enter new email");
				user.setEmail(scanner.nextLine());
				System.out.println("Email updated Successfully!!!");
				System.out.println(user);
			}
				break;
			case 3: {
				System.out.println("Enter new password");
				user.setPassword(scanner.nextLine());
				System.out.println("Password updated Successfully!!!");
			}
			break;
			default:
				System.out.println("Wrong choice!!");
			}
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(user);
			entityTransaction.commit();
		}
	}
	
	public void deleteUser() {
		System.out.println("Finding user !!!!");
		User user = findUser();
		if (user != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(user);
			entityTransaction.commit();
			System.out.println("Deleted Successfully!!!");
		}
		else {
			System.out.println("No user present!!!");
		}
	}
	
	public void fetchAllUser() {
		Query query = entityManager.createQuery("Select u from User u");
		List<User> users = query.getResultList();
		if(users != null && users.size() != 0) {
			for(User user: users) {
				System.out.println(user);
			}
		}
	}
}
