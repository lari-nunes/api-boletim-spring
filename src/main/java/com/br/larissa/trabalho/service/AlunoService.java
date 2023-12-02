package com.br.larissa.trabalho.service;

import com.br.larissa.trabalho.model.Aluno;
import com.br.larissa.trabalho.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno gravarAluno(Aluno aluno){
        return alunoRepository.save(aluno);
    }

    public List<Aluno> listarAlunos(){
        return alunoRepository.findAll();
    }

    public Optional<Aluno> buscarPorId(Long matricula){
        return alunoRepository.findById(matricula);
    }

    public Optional<Aluno> atualizaBuscaId(Long matricula){
        return alunoRepository.findById(matricula);
    }

    public void deletarAluno(Optional<Aluno> aluno){
        alunoRepository.delete(aluno.get());
    }

}
