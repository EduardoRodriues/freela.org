package br.com.carlosrodrigues.freela_org;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "br.com.carlosrodrigues.freela_org")
public class FreelaOrgApplication {

	public static void main(String[] args) {
		SpringApplication.run(FreelaOrgApplication.class, args);
	}

}
