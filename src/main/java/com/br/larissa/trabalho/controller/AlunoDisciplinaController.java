package com.br.larissa.trabalho.controller;

import com.br.larissa.trabalho.model.AlunoCurso;
import com.br.larissa.trabalho.model.AlunoDisciplina;
import com.br.larissa.trabalho.service.AlunoCursoService;
import com.br.larissa.trabalho.service.AlunoDisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunoDisciplina")
public class AlunoDisciplinaController {

    @Autowired
    private AlunoDisciplinaService alunoDisciplinaService;

    @PostMapping
    public ResponseEntity<Object> gravarAlunoDisciplina(@RequestBody AlunoDisciplina alunoDisciplina) {
        return ResponseEntity.status(HttpStatus.OK).body(alunoDisciplinaService.gravarAlunoDisciplina(alunoDisciplina));
    }

    @GetMapping
    public ResponseEntity<List<AlunoDisciplina>> listarAlunoDisciplina(){
        return ResponseEntity.status(HttpStatus.OK).body(alunoDisciplinaService.listarAlunoDisciplina());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> alunoDisciplinaId(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(alunoDisciplinaService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizaAlunoDisciplina(@PathVariable(value = "id") Long id, @RequestBody AlunoDisciplina alunoDisciplina) {

        Optional<AlunoDisciplina> alunoDisciplina1 = alunoDisciplinaService.atualizaBuscaId(id);

        if(alunoDisciplina1.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Não localizado!");
        }

        AlunoDisciplina alunoDisciplina2 = alunoDisciplina1.get();
        alunoDisciplina2.setAluno(alunoDisciplina.getAluno());
        alunoDisciplina2.setDisciplina(alunoDisciplina.getDisciplina());
        alunoDisciplina2.setNota(alunoDisciplina.getNota());

        return ResponseEntity.status(HttpStatus.OK).body(alunoDisciplinaService.gravarAlunoDisciplina(alunoDisciplina2));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarAlunoDisciplina(@PathVariable(value = "id") Long id) {

        Optional<AlunoDisciplina> alunoDisciplina = alunoDisciplinaService.buscarPorId(id);
        if (alunoDisciplina.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("Não localizado!");
        }

        alunoDisciplinaService.deletarAlunoDisciplina(alunoDisciplina);

        return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso!");
    }
}
