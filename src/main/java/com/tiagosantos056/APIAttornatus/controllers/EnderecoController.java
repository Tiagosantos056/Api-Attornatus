package com.tiagosantos056.APIAttornatus.controllers;

import com.tiagosantos056.APIAttornatus.models.Endereco;
import com.tiagosantos056.APIAttornatus.repository.EnderecoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/endereco")
@AllArgsConstructor
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping
    public @ResponseBody List<Endereco> list(){
        return enderecoRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Endereco create(@RequestBody Endereco endereco) throws Exception {

        if (endereco.getPessoa() == null) {
            throw new Exception("Pessoa PRECISA ser preenchido.!");
        }

        if (endereco.getCidade() == null) {
            throw new Exception("Cidade PRECISA ser preenchido.!");
        }

        if (endereco.getLogradouro() == null) {
            throw new Exception("Logradouro PRECISA ser preenchido.!");
        }

        if (endereco.getNumero() == null) {
            throw new Exception("Número PRECISA ser preenchido.!");
        }

        return enderecoRepository.save(endereco);
    }

    @PostMapping("/definir-endereco-principal")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Endereco definirEnderecoPrincipal(@RequestBody Endereco endereco) throws Exception {

        Optional<Endereco> enderecoExistente = Optional.ofNullable(
                enderecoRepository.findAllByIdEndereco(endereco.getIdEndereco()));

        if (!enderecoExistente.isPresent()) {
            throw new Exception("Endereço não encontrado.!");
        }

        enderecoExistente.get().setIsPrincipal(endereco.getIsPrincipal());
        return enderecoRepository.save(enderecoExistente.get());
    }
}
