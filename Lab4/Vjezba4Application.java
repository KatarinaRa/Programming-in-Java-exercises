package vjezba4.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class Vjezba4Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext c = SpringApplication.run(Vjezba4Application.class, args);
	}

}
