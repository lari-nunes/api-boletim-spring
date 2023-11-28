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
    public ResponseEntity<Object> alunoId(@PathVariable(value = "matricula") String matricula) {
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.buscarPorId(matricula));
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Object> atu(@PathVariable(value = "id") Long id, @RequestBody Pessoa p1) {
//
//        Optional<Pessoa> p = pessoaService.buscaPessoa(id);
//        if (p.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.OK).body("Não localizado !");
//        }
//
//        Pessoa pessoa = p.get();
//        pessoa.setNome(p1.getNome());
//        pessoa.setCpf(p1.getCpf());
//        //BeanUtils.copyProperties(p1, pessoa);
//        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.gravaPessoa(pessoa));
//
//    }

    @DeleteMapping("/{matricula}")
    public ResponseEntity<Object> deletaAluno(@PathVariable(value = "matricula") String matricula) {

        Optional<Aluno> aluno = alunoService.buscarPorId(matricula);
        if (aluno.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("Não localizado!");
        }

        alunoService.deletarAluno(aluno);

        return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso!");
    }
}
