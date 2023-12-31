package com.br.larissa.trabalho.service;

import com.br.larissa.trabalho.model.Curso;
import com.br.larissa.trabalho.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public Curso gravarCurso(Curso curso){
        return cursoRepository.save(curso);
    }

    public List<Curso> listarCursos(){
        return cursoRepository.findAll();
    }

    public Optional<Curso> buscarPorId(Long id){
        return cursoRepository.findById(id);
    }

    public Optional<Curso> atualizaBuscaId(Long id){
        return cursoRepository.findById(id);
    }

    public void deletarCurso(Optional<Curso> curso){
        cursoRepository.delete(curso.get());
    }
}
