package com.br.larissa.trabalho.controller;

import com.br.larissa.trabalho.model.Aluno;
import com.br.larissa.trabalho.model.Curso;
import com.br.larissa.trabalho.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping
    public ResponseEntity<Object> gravarCurso(@RequestBody Curso curso) {
        return ResponseEntity.status(HttpStatus.OK).body(cursoService.gravarCurso(curso));
    }

    @GetMapping
    public ResponseEntity<List<Curso>> listarCursos(){
        return ResponseEntity.status(HttpStatus.OK).body(cursoService.listarCursos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> cursoId(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(cursoService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizaCurso(@PathVariable(value = "id") Long id, @RequestBody Curso curso) {

        Optional<Curso> curso1 = cursoService.atualizaBuscaId(id);

        if(curso1.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Não localizado!");
        }

        Curso curso2 = curso1.get();
        curso2.setNome(curso2.getNome());
        curso2.setDisciplinas(curso2.getDisciplinas());

        return ResponseEntity.status(HttpStatus.OK).body(cursoService.gravarCurso(curso2));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarCurso(@PathVariable(value = "id") Long id) {

        Optional<Curso> curso = cursoService.buscarPorId(id);
        if (curso.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("Não localizado!");
        }

        cursoService.deletarCurso(curso);

        return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso!");
    }
}
