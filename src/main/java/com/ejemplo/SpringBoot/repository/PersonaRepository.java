/*
interfaz con jpa 
repository propio 
 */
package com.ejemplo.SpringBoot.repository;

import com.ejemplo.SpringBoot.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PersonaRepository extends JpaRepository <Persona, Long>{

    public void delete(Long id);
    
    
}
