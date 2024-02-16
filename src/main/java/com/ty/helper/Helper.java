package com.ty.helper;

import java.util.Scanner;

public class Helper {
	public static Scanner sc = new Scanner(System.in);
	public static int initials() {
		int choice = 0 ;
		System.out.println("Welecome to User Dashboard!!");
		try {
			System.out.println("Press\n1. Create User\n2. Find User\n3. Update User\n4. Delete User\n5. Fetch all User\n6. Exit");
			choice = sc.nextInt();
			sc.nextLine();
		}
		catch (Exception e) {
//			e.printStackTrace();
			System.out.println("Oh...ho wrong input!!!");
		}
		return choice;
	}
}
