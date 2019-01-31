package com.tasdigital.cobranca.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.tasdigital.cobranca.model.StatusTitulo;
import com.tasdigital.cobranca.model.Titulo;
import com.tasdigital.cobranca.repository.TitulosRepository;


@Service
public class CadastroTituloService {
   
	@Autowired
	private TitulosRepository titulos;
	
	public void salvar(Titulo titulo) {
		try {
			titulos.save(titulo);
		}catch (DataIntegrityViolationException e){
			throw new IllegalArgumentException("Formato de data inválido");
		}
	 }
	
	public void excluir(Long codigo) {
		titulos.deleteById(codigo);
	}

	public String receber(Long codigo) {
	  Titulo titulo = titulos.findById(codigo).orElse(null);
	  titulo.setStatus(StatusTitulo.RECEBIDO);
	  titulos.save(titulo);
	  return StatusTitulo.RECEBIDO.getDescricao();
	}
	
	
}
