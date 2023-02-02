package com.tiagosantos056.APIAttornatus.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "endereco")
@EqualsAndHashCode
public class Endereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long idEndereco;

    @Column(name = "logradouro", length = 150, nullable = false)
    private String logradouro;

    @Column(name = "cep", length = 9, nullable = false)
    private String cep;

    @Column(name = "numero", length = 5, nullable = false)
    private Integer numero;

    @Column(name = "cidade", length = 150, nullable = false)
    private String cidade;

    @Column(name = "isPrincipal")
    private Boolean isPrincipal;

    @ManyToOne
    private Pessoa pessoa;

}
