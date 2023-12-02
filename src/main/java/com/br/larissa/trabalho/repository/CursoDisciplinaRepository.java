package com.br.larissa.trabalho.repository;

import com.br.larissa.trabalho.model.CursoDisciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoDisciplinaRepository extends JpaRepository<CursoDisciplina, Long> {
}
