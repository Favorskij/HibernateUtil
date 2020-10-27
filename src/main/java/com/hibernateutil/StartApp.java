package com.hibernateutil;

import com.hibernateutil.config.Config;
import com.hibernateutil.controller.InitSql;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StartApp {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		InitSql initSql = context.getBean(InitSql.class);

		System.out.println(initSql.init());
	}
}
