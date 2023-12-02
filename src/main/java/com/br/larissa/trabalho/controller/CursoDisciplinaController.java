package com.br.larissa.trabalho.controller;

import com.br.larissa.trabalho.model.AlunoDisciplina;
import com.br.larissa.trabalho.model.CursoDisciplina;
import com.br.larissa.trabalho.service.AlunoDisciplinaService;
import com.br.larissa.trabalho.service.CursoDisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cursoDisciplina")
public class CursoDisciplinaController {

    @Autowired
    private CursoDisciplinaService cursoDisciplinaService;

    @PostMapping
    public ResponseEntity<Object> gravarCursoDisciplina(@RequestBody CursoDisciplina cursoDisciplina) {
        return ResponseEntity.status(HttpStatus.OK).body(cursoDisciplinaService.gravarCursoDisciplina(cursoDisciplina));
    }

    @GetMapping
    public ResponseEntity<List<CursoDisciplina>> listarCursoDisciplina(){
        return ResponseEntity.status(HttpStatus.OK).body(cursoDisciplinaService.listarCursoDisciplina());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> cursoDisciplinaId(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(cursoDisciplinaService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarCursoDisciplina(@PathVariable(value = "id") Long id, @RequestBody CursoDisciplina cursoDisciplina) {

        Optional<CursoDisciplina> cursoDisciplina1 = cursoDisciplinaService.atualizaBuscaId(id);

        if(cursoDisciplina1.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Não localizado!");
        }

        CursoDisciplina cursoDisciplina2 = cursoDisciplina1.get();
        cursoDisciplina2.setCurso(cursoDisciplina.getCurso());
        cursoDisciplina2.setDisciplina(cursoDisciplina.getDisciplina());

        return ResponseEntity.status(HttpStatus.OK).body(cursoDisciplinaService.gravarCursoDisciplina(cursoDisciplina2));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarCursoDisciplina(@PathVariable(value = "id") Long id) {

        Optional<CursoDisciplina> cursoDisciplina = cursoDisciplinaService.buscarPorId(id);
        if (cursoDisciplina.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("Não localizado!");
        }

        cursoDisciplinaService.deletarCursoDisciplina(cursoDisciplina);

        return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso!");
    }
}
