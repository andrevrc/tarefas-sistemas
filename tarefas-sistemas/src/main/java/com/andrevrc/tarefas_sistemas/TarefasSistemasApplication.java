package com.andrevrc.tarefas_sistemas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.andrevrc")
@EntityScan("com.andrevrc")
@EnableJpaRepositories("com.andrevrc")
public class TarefasSistemasApplication {

	public static void main(String[] args) {
		SpringApplication.run(TarefasSistemasApplication.class, args);
	}

}
