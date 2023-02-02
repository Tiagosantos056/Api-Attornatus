package com.tiagosantos056.APIAttornatus.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "pessoa")
@EqualsAndHashCode
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPessoa;

    @NotEmpty(message = "Campo NOME não pode ser vazio.!")
    @Column(name = "nome", length = 150, nullable = false)
    private String nome;

    @NotNull(message = "Campo DATA DE NASCIMENTO não pode ser vazio.!")
    @Column(name = "data_nascimento", length = 10, nullable = false)
    private LocalDate dataNascimento;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<Endereco> enderecos;

}
