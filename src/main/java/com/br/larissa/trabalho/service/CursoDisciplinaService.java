package com.br.larissa.trabalho.service;

import com.br.larissa.trabalho.model.CursoDisciplina;
import com.br.larissa.trabalho.repository.CursoDisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoDisciplinaService {

    @Autowired
    private CursoDisciplinaRepository cursoDisciplinaRepository;

    public CursoDisciplina gravarCursoDisciplina(CursoDisciplina cursoDisciplina){
        return cursoDisciplinaRepository.save(cursoDisciplina);
    }

    public List<CursoDisciplina> listarCursoDisciplina(){
        return cursoDisciplinaRepository.findAll();
    }

    public Optional<CursoDisciplina> buscarPorId(Long id){
        return cursoDisciplinaRepository.findById(id);
    }

    public Optional<CursoDisciplina> atualizaBuscaId(Long id){
        return cursoDisciplinaRepository.findById(id);
    }

    public void deletarCursoDisciplina(Optional<CursoDisciplina> cursoDisciplina){
        cursoDisciplinaRepository.delete(cursoDisciplina.get());
    }
}
