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
