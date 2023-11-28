package com.br.larissa.trabalho.repository;

import com.br.larissa.trabalho.model.Boletim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoletimRepository extends JpaRepository<Boletim, Long> {
}
