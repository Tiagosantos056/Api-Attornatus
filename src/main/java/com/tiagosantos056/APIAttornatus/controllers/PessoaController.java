package com.tiagosantos056.APIAttornatus.controllers;

import com.tiagosantos056.APIAttornatus.models.Pessoa;
import com.tiagosantos056.APIAttornatus.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/pessoas"})
@AllArgsConstructor
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    public @ResponseBody List<Pessoa> list(){
        return pessoaRepository.findAll();
    }

    @PostMapping
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
}
