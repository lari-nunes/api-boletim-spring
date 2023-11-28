package com.br.larissa.trabalho.controller;


import com.br.larissa.trabalho.model.Curso;
import com.br.larissa.trabalho.model.Disciplina;
import com.br.larissa.trabalho.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;

    @PostMapping
    public ResponseEntity<Object> gravarDisciplina(@RequestBody Disciplina disciplina) {
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.gravarDisciplina(disciplina));
    }

    @GetMapping
    public ResponseEntity<List<Disciplina>> listarDiciplinas(){
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.listarDisciplinas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> disciplinaId(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarDisciplina(@PathVariable(value = "id") Long id) {

        Optional<Disciplina> disciplina = disciplinaService.buscarPorId(id);
        if (disciplina.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("Não localizado!");
        }

        disciplinaService.deletarDisciplina(disciplina);

        return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso!");
    }
}
