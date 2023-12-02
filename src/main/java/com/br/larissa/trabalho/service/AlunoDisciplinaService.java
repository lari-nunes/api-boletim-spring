package com.br.larissa.trabalho.service;

import com.br.larissa.trabalho.model.AlunoDisciplina;
import com.br.larissa.trabalho.repository.AlunoDisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoDisciplinaService {

    @Autowired
    private AlunoDisciplinaRepository alunoDisciplinaRepository;

    public AlunoDisciplina gravarAlunoDisciplina(AlunoDisciplina alunoDisciplina){

        if (alunoDisciplina.getNota() < 0 || alunoDisciplina.getNota() > 10) {
            throw new IllegalArgumentException("A nota do aluno deve estar entre 0 e 100.");
        }

        return alunoDisciplinaRepository.save(alunoDisciplina);
    }

    public List<AlunoDisciplina> listarAlunoDisciplina(){
        return alunoDisciplinaRepository.findAll();
    }

    public Optional<AlunoDisciplina> buscarPorId(Long id){
        return alunoDisciplinaRepository.findById(id);
    }

    public Optional<AlunoDisciplina> atualizaBuscaId(Long id){
        return alunoDisciplinaRepository.findById(id);
    }

    public void deletarAlunoDisciplina(Optional<AlunoDisciplina> alunoDisciplina){
        alunoDisciplinaRepository.delete(alunoDisciplina.get());
    }
}
