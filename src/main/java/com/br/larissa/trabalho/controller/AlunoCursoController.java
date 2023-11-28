package com.br.larissa.trabalho.controller;

import com.br.larissa.trabalho.model.AlunoCurso;
import com.br.larissa.trabalho.model.Curso;
import com.br.larissa.trabalho.service.AlunoCursoService;
import com.br.larissa.trabalho.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunoCurso")
public class AlunoCursoController {

    @Autowired
    private AlunoCursoService alunoCursoService;

    @PostMapping
    public ResponseEntity<Object> gravarAlunoCurso(@RequestBody AlunoCurso alunoCurso) {
        return ResponseEntity.status(HttpStatus.OK).body(alunoCursoService.gravarAlunoCurso(alunoCurso));
    }

    @GetMapping
    public ResponseEntity<List<AlunoCurso>> listarCursoAluno(){
        return ResponseEntity.status(HttpStatus.OK).body(alunoCursoService.listarAlunoCurso());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> alunoCursoId(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(alunoCursoService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarAlunoCurso(@PathVariable(value = "id") Long id) {

        Optional<AlunoCurso> alunoCurso = alunoCursoService.buscarPorId(id);
        if (alunoCurso.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("Não localizado!");
        }

        alunoCursoService.deletarAlunoCurso(alunoCurso);

        return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso!");
    }
}
