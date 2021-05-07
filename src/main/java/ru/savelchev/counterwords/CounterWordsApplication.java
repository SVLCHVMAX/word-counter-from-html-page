package ru.savelchev.counterwords;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.savelchev.counterwords.service.Application;

@SpringBootApplication
public class CounterWordsApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(CounterWordsApplication.class, args);
		Application application = applicationContext.getBean(Application.class);
		if(args.length<1) {
			System.err.println("Please enter one arg - url address of the web-page.");
			System.exit(1);
		}
		application.getSolution(args[0]);
	}
}
