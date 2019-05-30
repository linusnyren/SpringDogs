package linus.com.Dogs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class DogsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DogsApplication.class, args);
	}

}
