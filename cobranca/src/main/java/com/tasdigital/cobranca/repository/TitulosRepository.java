package com.tasdigital.cobranca.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tasdigital.cobranca.model.Titulo;

public interface TitulosRepository extends JpaRepository<Titulo,Long> {

	public List<Titulo> findByDescricaoContaining(String descricao);
}
