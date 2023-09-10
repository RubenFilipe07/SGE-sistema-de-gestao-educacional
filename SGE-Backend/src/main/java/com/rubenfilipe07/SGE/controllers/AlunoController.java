package com.rubenfilipe07.SGE.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rubenfilipe07.SGE.models.AlunoModel;
import com.rubenfilipe07.SGE.repositories.AlunoRepository;

import jakarta.validation.Valid;

import com.rubenfilipe07.SGE.dtos.AlunoRecordDto;

@RestController
public class AlunoController {

	@Autowired
	AlunoRepository alunoRepository;

	@PostMapping("/alunos")
	public ResponseEntity<AlunoModel> saveProduct(@RequestBody @Valid AlunoRecordDto alunoRecordDto) {
		var alunoModel = new AlunoModel();
		BeanUtils.copyProperties(alunoRecordDto, alunoModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(alunoRepository.save(alunoModel));
	}

	@GetMapping("/alunos")
	public ResponseEntity<List<AlunoModel>> getAllAlunos() {
		return ResponseEntity.status(HttpStatus.OK).body(alunoRepository.findAll());
	}

	@GetMapping("/alunos/{id}")
	public ResponseEntity<Object> getOneAluno(@PathVariable(value = "id") UUID id) {
		Optional<AlunoModel> aluno0 = alunoRepository.findById(id);
		if (aluno0.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado");

		} else {
			return ResponseEntity.status(HttpStatus.OK).body(alunoRepository.findById(id));
		}
	}
	

	@PutMapping("/alunos/{id}")
	public ResponseEntity<Object> setOneAluno(@PathVariable(value = "id") UUID id, @RequestBody @Valid AlunoRecordDto alunoRecordDto) {
		Optional<AlunoModel> aluno0 = alunoRepository.findById(id);
		if (aluno0.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado");

		} else {
			var alunoModel = aluno0.get();
			BeanUtils.copyProperties(alunoRecordDto, alunoModel);
			return ResponseEntity.status(HttpStatus.OK).body(alunoRepository.save(alunoModel));
		}
	}
	
	@DeleteMapping("/alunos/{id}")
	public ResponseEntity<Object> deleteOneAluno(@PathVariable(value = "id") UUID id) {
		Optional<AlunoModel> aluno0 = alunoRepository.findById(id);
		if (aluno0.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado");

		} else {
			alunoRepository.delete(aluno0.get());	
			return ResponseEntity.status(HttpStatus.OK).body("Aluno deletado com sucesso");
		}
	}
	
	
	
}
