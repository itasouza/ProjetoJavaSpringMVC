package com.tasdigital.cobranca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tasdigital.cobranca.model.Titulo;

public interface TitulosRepository extends JpaRepository<Titulo,Long> {

}
