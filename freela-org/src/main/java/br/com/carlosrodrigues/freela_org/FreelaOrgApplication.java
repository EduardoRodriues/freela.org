package br.com.carlosrodrigues.freela_org;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "br.com.carlosrodrigues.freela_org")
@ComponentScan(".target")
public class FreelaOrgApplication {

	public static void main(String[] args) {
		SpringApplication.run(FreelaOrgApplication.class, args);
	}

}
