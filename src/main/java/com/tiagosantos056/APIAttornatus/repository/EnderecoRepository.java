package com.tiagosantos056.APIAttornatus.repository;

import com.tiagosantos056.APIAttornatus.models.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    Endereco findAllByIdEndereco(Long idEndereco);
}
