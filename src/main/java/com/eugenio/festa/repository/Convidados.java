package com.eugenio.festa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.eugenio.festa.model.Convidado;

public interface Convidados extends JpaRepository<Convidado, Long> {
	
	
}
