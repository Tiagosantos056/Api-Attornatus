package com.tiagosantos056.APIAttornatus.repository;

import com.tiagosantos056.APIAttornatus.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
