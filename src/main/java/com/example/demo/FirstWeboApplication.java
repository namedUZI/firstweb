package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FirstWeboApplication {
	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(FirstWeboApplication.class, args);
        
	}
	@Autowired
	ApplicationContext context;
	
	@Bean
	ApplicationRunner run() {
		return new ApplicationRunner() {
			@Override
			public void run(ApplicationArguments args) {
				
				int count = context.getBeanDefinitionCount();
		        System.out.println("Beans的个数：" + count);
		        String[] names = context.getBeanDefinitionNames();
		        for (String name : names) {
		               System.out.print(name);
		               System.out.print("->");
		               Object bean = context.getBean(name);
		               System.out.println(bean.getClass().getName());
		        }
			}
		};
	}
}
