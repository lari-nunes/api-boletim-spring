package com.br.larissa.trabalho.service;

import com.br.larissa.trabalho.model.Boletim;
import com.br.larissa.trabalho.repository.BoletimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoletimService {

    @Autowired
    private BoletimRepository boletimRepository;

    public Boletim gravarBoletim(Boletim boletim){
        return boletimRepository.save(boletim);
    }

    public List<Boletim> listarBoletim(){
        return boletimRepository.findAll();
    }

    public Optional<Boletim> buscarPorId(Long id){
        return boletimRepository.findById(id);
    }

    public Optional<Boletim> atualizaBuscaId(Long id){
        return boletimRepository.findById(id);
    }

    public void deletarBoletim(Optional<Boletim> boletim){
        boletimRepository.delete(boletim.get());
    }

}
