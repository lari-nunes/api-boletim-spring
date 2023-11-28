package com.br.larissa.trabalho.repository;

import com.br.larissa.trabalho.model.AlunoCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoCursoRepository extends JpaRepository<AlunoCurso, Long> {
}
