package com.tiagosantos056.APIAttornatus.controllers;

import com.tiagosantos056.APIAttornatus.models.Pessoa;
import com.tiagosantos056.APIAttornatus.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/pessoas"})
@AllArgsConstructor
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> findById(@PathVariable Long id) {
        return pessoaRepository.findById(id)
                .map(recordFound -> ResponseEntity.ok()
                        .body(recordFound))
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping
    public @ResponseBody List<Pessoa> list(){
        return pessoaRepository.findAll();
    }

    @PostMapping("/inserir")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Pessoa create(@RequestBody Pessoa pessoa) throws Exception {

        if (pessoa.getNome() == null) {
            throw new Exception("Nome PRECISA ser preenchido.!");
        }

        if (pessoa.getDataNascimento() == null) {
            throw new Exception("Data de Nascimento PRECISA ser preenchido.!");
        }

        if (pessoa.getEnderecos() == null) {
            throw new Exception("Endereço PRECISA ser preenchido.!");
        }

        return pessoaRepository.save(pessoa);
    }

    @PutMapping("alterar/{id}")
    public ResponseEntity<Pessoa> update(@PathVariable Long id,
                                         @RequestBody Pessoa pessoa) throws Exception {

        return pessoaRepository.findById(id)
                .map(recordFound -> {
                    recordFound.setNome(pessoa.getNome());
                    recordFound.setDataNascimento(pessoa.getDataNascimento());
                    recordFound.setEnderecos(pessoa.getEnderecos());
                    Pessoa updated = pessoaRepository.save(recordFound);

                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return pessoaRepository.findById(id)
                .map(recordFound -> {
                    pessoaRepository.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
