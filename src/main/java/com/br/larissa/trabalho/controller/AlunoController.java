package com.br.larissa.trabalho.controller;


import com.br.larissa.trabalho.model.Aluno;
import com.br.larissa.trabalho.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public ResponseEntity<Object> gravaAluno(@RequestBody Aluno aluno) {
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.gravarAluno(aluno));
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> listaAlunos(){
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.listarAlunos());
    }
    @GetMapping("/{matricula}")
    public ResponseEntity<Object> alunoId(@PathVariable(value = "matricula") Long matricula) {
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.buscarPorId(matricula));
    }

    @PutMapping("/{matricula}")
    public ResponseEntity<Object> atualizaAluno(@PathVariable(value = "matricula") Long matricula, @RequestBody Aluno aluno) {

        Optional<Aluno> aluno1 = alunoService.atualizaBuscaId(matricula);

        if(aluno1.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Aluno não encontrado!");
        }

        Aluno aluno2 = aluno1.get();
        aluno2.setMatricula(aluno.getMatricula());
        aluno2.setNomeAluno(aluno.getNomeAluno());
        aluno2.setIdade(aluno.getIdade());
        aluno2.setEmail(aluno.getEmail());
        aluno2.setTelefone(aluno.getTelefone());
        aluno2.setSexo(aluno.getSexo());
        aluno2.setData_nascimento(aluno.getData_nascimento());

        return ResponseEntity.status(HttpStatus.OK).body(alunoService.gravarAluno(aluno2));
    }

    @DeleteMapping("/{matricula}")
    public ResponseEntity<Object> deletaAluno(@PathVariable(value = "matricula") Long matricula) {

        Optional<Aluno> aluno = alunoService.buscarPorId(matricula);
        if (aluno.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("Não localizado!");
        }

        alunoService.deletarAluno(aluno);

        return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso!");
    }
}
