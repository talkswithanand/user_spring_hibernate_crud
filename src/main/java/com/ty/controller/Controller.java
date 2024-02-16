package com.ty.controller;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ty.configuration.MyConfig;
import com.ty.dao.UserDao;
import com.ty.entity.User;
import com.ty.helper.Helper;

public class Controller {
	public static void main(String[] args) {
		boolean flag = true;
		while (flag) {
			int choice = Helper.initials();
			ConfigurableApplicationContext appCont = new AnnotationConfigApplicationContext(MyConfig.class);
			UserDao dao = appCont.getBean(UserDao.class);
			switch (choice) {
			case 1: {
				User user = appCont.getBean(User.class);
				dao.saveUser(user);
			}
				break;
			case 2: {
				dao.findUser();
			}
				break;
			case 3: {
				dao.updateUser();
			}
				break;
			case 4: {
				dao.deleteUser();
			}
				break;
			case 5: {
				dao.fetchAllUser();
			}
				break;
			case 6: {
				flag = false;
			}
				break;
			default:
				System.out.println("Selected wrong choice!!!");
			}
		}
	}

}
