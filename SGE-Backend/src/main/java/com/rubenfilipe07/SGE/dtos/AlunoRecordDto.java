package com.rubenfilipe07.SGE.dtos;

import jakarta.validation.constraints.NotBlank;

public record AlunoRecordDto(@NotBlank String nome, @NotBlank String matricula, @NotBlank String turma) {

}
