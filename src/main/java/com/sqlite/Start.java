package com.sqlite;

import com.sqlite.config.AppConfig;
import com.sqlite.model.User;
import com.sqlite.repository.Repository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Start {

	public static void main(String[] args) {

		User user1 = new User();
		user1.setFirstName("Илья");
		user1.setLastName("Лагутенко");

		User user2 = new User();
		user2.setFirstName("Майкд");
		user2.setLastName("Джексон");

		List<User> list = new ArrayList<>();
		list.add(user1);
		list.add(user2);


		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Repository repository = context.getBean(Repository.class);

		repository.insertList(list);
	}
}
