package com.rubenfilipe07.SGE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title="SGE - Sistema de gestao educacional", version = "1", description = "Uma API REST que tem como objetivo gerenciar os alunos matriculados em uma turma."))

public class SgeBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SgeBackendApplication.class, args);
	}

}
