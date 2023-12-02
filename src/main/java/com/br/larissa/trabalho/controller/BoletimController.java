package com.br.larissa.trabalho.controller;

import com.br.larissa.trabalho.model.Boletim;
import com.br.larissa.trabalho.service.BoletimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/boletim")
public class BoletimController {

    @Autowired
    private BoletimService boletimService;

    @PostMapping
    public ResponseEntity<Object> gravarBoletim(@RequestBody Boletim boletim) {
        return ResponseEntity.status(HttpStatus.OK).body(boletimService.gravarBoletim(boletim));
    }

    @GetMapping
    public ResponseEntity<List<Boletim>> listarBoletim(){
        return ResponseEntity.status(HttpStatus.OK).body(boletimService.listarBoletim());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> boletimId(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(boletimService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizaBoletim(@PathVariable(value = "id") Long id, @RequestBody Boletim boletim) {

        Optional<Boletim> boletim1 = boletimService.buscarPorId(id);

        if(boletim1.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Boletim não localizado!");
        }

        Boletim boletim2 = boletim1.get();
        boletim2.setAluno(boletim.getAluno());
        boletim2.setDisciplina(boletim.getDisciplina());

        return ResponseEntity.status(HttpStatus.OK).body(boletimService.gravarBoletim(boletim2));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarBoletim(@PathVariable(value = "id") Long id) {

        Optional<Boletim> boletim = boletimService.buscarPorId(id);
        if (boletim.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("Não localizado!");
        }

        boletimService.deletarBoletim(boletim);

        return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso!");
    }
}
