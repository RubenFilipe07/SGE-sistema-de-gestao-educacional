package com.rubenfilipe07.SGE.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rubenfilipe07.SGE.models.AlunoModel;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoModel, UUID>{

	 
}
